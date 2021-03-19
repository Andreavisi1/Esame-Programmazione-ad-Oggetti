package it.univpm.traianubertinivisi.openweather.city;

import javax.persistence.Embeddable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Embeddable
@JsonIgnoreProperties(ignoreUnknown=true)
public class Coord {

	private float lon;
	
	private float lat;

	public float getLon() {
		return lon;
	}

	public void setLon(float lon) {
		this.lon = lon;
	}

	public float getLat() {
		return lat;
	}

	public void setLat(float lat) {
		this.lat = lat;
	}
	
	
	
}
