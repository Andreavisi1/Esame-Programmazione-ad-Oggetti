package it.univpm.traianubertinivisi.openweather.forecast;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Entity
@Table(name="forecasts")
@JsonIgnoreProperties(ignoreUnknown=true)
public class Forecast {
	
	@Id
	Long id;
	String name;
	Integer visibility;
	@Embedded
	ForecastMain main;
	@Embedded
	ForecastSys sys;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getVisibility() {
		return visibility;
	}
	public void setVisibility(Integer visibility) {
		this.visibility = visibility;
	}
	public ForecastMain getMain() {
		return main;
	}
	public void setMain(ForecastMain main) {
		this.main = main;
	}
	public ForecastSys getSys() {
		return sys;
	}
	public void setSys(ForecastSys sys) {
		this.sys = sys;
	}
	
}
