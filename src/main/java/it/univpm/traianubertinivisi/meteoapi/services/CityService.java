package it.univpm.traianubertinivisi.meteoapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.univpm.traianubertinivisi.openweather.city.CityLoader;
import it.univpm.traianubertinivisi.openweather.city.CityLoaderThread;
import it.univpm.traianubertinivisi.openweather.city.DbCity;
import it.univpm.traianubertinivisi.openweather.city.JpaCityRepository;

@Service
public class CityService {
	
	@Autowired
	JpaCityRepository jpaCityRepository;
	
	private CityLoaderThread cityLoaderThread;
	
	@Autowired
	private CityLoader cityLoader;
	
	public Long getCityCount() {
		return this.cityLoader.getCityRepository().count();
	}
	
	public List<DbCity> getCityList(String cityOrNull, String country) throws Exception {
		try {
			if(null == cityOrNull) throw new Exception("Must give at least a city name.");
			
			String[] criteria = {cityOrNull, country};
			
			return this.jpaCityRepository.findByName(criteria);	
		} catch(Exception e) {
			return null;
		}
	}
	
	public void startLoadingCities() {
		this.cityLoaderThread = new CityLoaderThread(this.cityLoader);
		
		Thread t = new Thread(this.cityLoaderThread);
		t.start();
		System.out.println("Loading cities...");
		
	}
	
	public void stopLoadingCities() {
		try {
			this.cityLoaderThread.doStop();
			System.out.println("Stop loading cities...");	
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
