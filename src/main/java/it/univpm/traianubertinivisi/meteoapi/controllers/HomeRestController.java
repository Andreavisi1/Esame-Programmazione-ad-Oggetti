package it.univpm.traianubertinivisi.meteoapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.univpm.traianubertinivisi.meteoapi.services.CityService;
import it.univpm.traianubertinivisi.openweather.city.DbCity;

@RestController
public class HomeRestController {
	
	@Autowired
	private CityService cityService;
	
	@Value("${meteoapi.pwd}")
	private String pwd;
	
	@GetMapping("/")
	public String home() {
		return "<h1>Meteo Api Homepage</h1> <br/> \n <p> " + this.cityService.getCityCount() + "</p>";
	}
	
	@GetMapping("/cities")
	public List<DbCity> cities(
			@RequestParam(name="city", required=false) String cityOrNull,
			@RequestParam(name="country", required=false) String country) throws Exception {
				
		return this.cityService.getCityList(cityOrNull, country);
	}
	
	@GetMapping("/cities/load/{pwd}")
	public String citiesLoad(
			@PathVariable(name = "pwd", required = true) String pwd
			) {
		if (!this.pwd.equals(pwd)) return "Cannot load the cities!";
		this.cityService.startLoadingCities();
		return "Started to load cities...";
	}
	
	@GetMapping("/cities/stop/{pwd}")
	public String citiesStopLoad(
			@PathVariable(name = "pwd", required = true) String pwd
			) {
		if (!this.pwd.equals(pwd)) return "Cannot stop loading the cities!";
		this.cityService.stopLoadingCities();
		return "Stop loading cities...";
	}
	
	
	
	
	
}
