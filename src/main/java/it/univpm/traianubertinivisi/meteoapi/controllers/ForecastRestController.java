package it.univpm.traianubertinivisi.meteoapi.controllers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import it.univpm.traianubertinivisi.meteoapi.services.ForecastService;
import it.univpm.traianubertinivisi.openweather.forecast.DbForecast;
import it.univpm.traianubertinivisi.openweather.forecast.statistics.ForecastStatistics;

@RestController
@RequestMapping("/forecast")
public class ForecastRestController {
	
	@Value("${meteoapi.pwd}")
	private String pwd;
	
	@Autowired
	ForecastService forecastService; 
	
	@GetMapping("")
	public List<DbForecast> getForecastFor(
			@RequestParam(name="city", required=false) String cityOrNull,
			@RequestParam(name="country", required=false, defaultValue="*") String country
			) throws Exception {
		return this.forecastService.getForecastFor(cityOrNull, country);
	}
	
	@GetMapping("/statistics")
	public List<ForecastStatistics> getStatisticsFor(
			@RequestParam(name="city", required=false) String cityOrNull,
			@RequestParam(name="country", required=false, defaultValue="*") String country,
			@RequestParam(name="start", required=false) String start_date,
			@RequestParam(name="end", required=false) String end_date
			) throws Exception {
		
		if (null == start_date) start_date = this.GetNowString("start");
		if (null == end_date) end_date = this.GetNowString("end");
		
		return this.forecastService.getStatisticsFor(cityOrNull, country,start_date, end_date);
	}

	private String GetNowString(String timeSpan) {
		DateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
        return formatter.format(new Date()) + (timeSpan.equals("start") ? " 00:00:00":" 23:59:59");
	}
	
	@GetMapping("/lookup/{pwd}")
	public String startForecastAutoLookup(
			@PathVariable(name = "pwd", required = true) String pwd,
			@RequestParam(name="city", required=false) String cityOrNull,
			@RequestParam(name="country", required=false, defaultValue="*") String country,
			@RequestParam(name="sleep", required=false, defaultValue="5") Integer sleepInterval,
			// possible values for type: milliseconds, seconds, minutes, hours, days
			@RequestParam(name="type", required=false, defaultValue="hours") String sleepIntervalType 
			) {
		// cityOrNull, country, sleepInterval, sleepIntervalType
		if (null == this.pwd || !this.pwd.equals(pwd)) return "Cannot load the forecast!";
		this.forecastService.startAutolookupForecastFor(cityOrNull, country, sleepInterval, sleepIntervalType);
		return "Forecast autolookup started...";
	}
	
	
	@GetMapping("/lookup/{pwd}/stop")
	public String stopForecastAutoLookup(
			@PathVariable(name = "pwd", required = true) String pwd
			) {
		if (null == this.pwd || !this.pwd.equals(pwd)) return "Cannot stop loading the forecast!";
		this.forecastService.stopAutolookupForecastFor();
		return "Forecast autolookup stopped...";
	}
	
	
	@GetMapping("/seed/{pwd}")
	public String startForecastSeeding(
			@PathVariable(name = "pwd", required = true) String pwd,
			@RequestParam(name="city", required=false) String cityOrNull,
			@RequestParam(name="country", required=false, defaultValue="*") String country,
			@RequestParam(name="sleep", required=false, defaultValue="5") Integer sleepInterval,
			// possible values for type: milliseconds, seconds, minutes, hours, days
			@RequestParam(name="type", required=false, defaultValue="hours") String sleepIntervalType 
			) {
		// cityOrNull, country, sleepInterval, sleepIntervalType
		if (null == this.pwd || !this.pwd.equals(pwd)) return "Cannot seed the forecasts table!";
		this.forecastService.startSeedingForecastFor(cityOrNull, country, sleepInterval, sleepIntervalType);
		return "Forecast seeding started...";
	}
	
	@GetMapping("/seed/{pwd}/stop")
	public String stopForecastSeeding(
			@PathVariable(name = "pwd", required = true) String pwd
			) {
		if (null == this.pwd || !this.pwd.equals(pwd)) return "Cannot stop seeding the forecasts table!";
		this.forecastService.stopSeedingForecastFor();
		return "Forecast seeding stopped...";
	}
}
