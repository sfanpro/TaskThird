package ua.com.fan.salarycalc.driver;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class EmployeePojo {

	private Integer id;

	private Double rate;

	private Double hoursInMounth;

	private Double workedHour;

	private String position;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getRate() {
		return rate;
	}

	public void setRate(Double rate) {
		this.rate = rate;
	}

	public Double getHoursInMounth() {
		return hoursInMounth;
	}

	public void setHoursInMounth(Double hoursInMounth) {
		this.hoursInMounth = hoursInMounth;
	}

	public Double getWorkedHour() {
		return workedHour;
	}

	public void setWorkedHour(Double workedHour) {
		this.workedHour = workedHour;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

}
