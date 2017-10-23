package com.example.demo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "car")
public class SampleEntity implements Serializable {
	@Id
	@GeneratedValue
	private Integer id;

	@Column(name = "carName")
	private String carName;
	@Column(name = "exhaustGas")
	private String exhaustGas;
	@Column(name = "cylinderNumber")
	private String cylinderNumber;
	@Column(name = "maxSpeed")
	private String maxSpeed;
	@Column(name = "horsePower")
	private String horsePower;
	@Column(name = "carWeight")
	private String carWeight;
	@Column(name = "pictureUrl")
	private String pictureUrl;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCarName() {
		return carName;
	}

	public void setCarName(String carName) {
		this.carName = carName;
	}

	public String getExhaustGas() {
		return exhaustGas;
	}

	public void setExhaustGas(String exhaustGas) {
		this.exhaustGas = exhaustGas;
	}

	public String getCylinderNumber() {
		return cylinderNumber;
	}

	public void setCylinderNumber(String cylinderNumber) {
		this.cylinderNumber = cylinderNumber;
	}

	public String getMaxSpeed() {
		return maxSpeed;
	}

	public void setMaxSpeed(String maxSpeed) {
		this.maxSpeed = maxSpeed;
	}

	public String getHorsePower() {
		return horsePower;
	}

	public void setHorsePower(String horsePower) {
		this.horsePower = horsePower;
	}

	public String getCarWeight() {
		return carWeight;
	}

	public void setCarWeight(String carWeight) {
		this.carWeight = carWeight;
	}

	public String getPictureUrl() {
		return pictureUrl;
	}

	public void setPictureUrl(String pictureUrl) {
		this.pictureUrl = pictureUrl;
	}

}
