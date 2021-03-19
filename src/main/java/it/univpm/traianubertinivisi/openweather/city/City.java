package it.univpm.traianubertinivisi.openweather.city;


import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Entity
@Table(name="cities")
@JsonIgnoreProperties(ignoreUnknown=true)
public class City {
	
	@Id
	private Integer id;
	
	private String name;
	private String state;
	private String country;
	
	@Embedded
	private Coord coord;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public Coord getCoord() {
		return coord;
	}
	public void setCoord(Coord coord) {
		this.coord = coord;
	}
	
	public String toString() {
		return "" + this.name;
	}
}
