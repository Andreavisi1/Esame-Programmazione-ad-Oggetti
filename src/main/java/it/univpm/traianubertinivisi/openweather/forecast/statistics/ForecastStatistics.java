package it.univpm.traianubertinivisi.openweather.forecast.statistics;

import java.math.BigDecimal;
import java.math.BigInteger;

import javax.persistence.Entity;
import javax.persistence.Id;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;

//@Table(name="forecasts")
@Data
@AllArgsConstructor
@Entity
@JsonIgnoreProperties(ignoreUnknown=true)
public class ForecastStatistics {
	
		
//	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Integer id;
	private BigInteger row_n;
	private String country;
	private String city_id;
	private String name;
	
//	@Column(name="start", columnDefinition="DATETIME")
//	@Temporal(TemporalType.TIMESTAMP)
	private String start;
	
//	@Column(name="end", columnDefinition="DATETIME")
//	@Temporal(TemporalType.TIMESTAMP)
	private String end;
	
	private Integer min_visibility;
	private Integer max_visibility;
	private BigDecimal avg_visibility;
	private BigInteger var_visibility;
	private Integer min_pressure;
	private Integer max_pressure;
	private BigDecimal avg_pressure;
	private BigInteger var_pressure;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public BigInteger getRow_n() {
		return row_n;
	}
	public void setRow_n(BigInteger row_n) {
		this.row_n = row_n;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getCity_id() {
		return city_id;
	}
	public void setCity_id(String city_id) {
		this.city_id = city_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStart() {
		return start;
	}
	public void setStart(String start) {
		this.start = start;
	}
	public String getEnd() {
		return end;
	}
	public void setEnd(String end) {
		this.end = end;
	}
	public Integer getMin_visibility() {
		return min_visibility;
	}
	public void setMin_visibility(Integer min_visibility) {
		this.min_visibility = min_visibility;
	}
	public Integer getMax_visibility() {
		return max_visibility;
	}
	public void setMax_visibility(Integer max_visibility) {
		this.max_visibility = max_visibility;
	}
	public BigDecimal getAvg_visibility() {
		return avg_visibility;
	}
	public void setAvg_visibility(BigDecimal avg_visibility) {
		this.avg_visibility = avg_visibility;
	}
	public BigInteger getVar_visibility() {
		return var_visibility;
	}
	public void setVar_visibility(BigInteger var_visibility) {
		this.var_visibility = var_visibility;
	}
	public Integer getMin_pressure() {
		return min_pressure;
	}
	public void setMin_pressure(Integer min_pressure) {
		this.min_pressure = min_pressure;
	}
	public Integer getMax_pressure() {
		return max_pressure;
	}
	public void setMax_pressure(Integer max_pressure) {
		this.max_pressure = max_pressure;
	}
	public BigDecimal getAvg_pressure() {
		return avg_pressure;
	}
	public void setAvg_pressure(BigDecimal avg_pressure) {
		this.avg_pressure = avg_pressure;
	}
	public BigInteger getVar_pressure() {
		return var_pressure;
	}
	public void setVar_pressure(BigInteger var_pressure) {
		this.var_pressure = var_pressure;
	}

	
	
	
	
	
}
