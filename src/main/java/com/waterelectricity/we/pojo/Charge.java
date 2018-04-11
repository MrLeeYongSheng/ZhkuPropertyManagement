package com.waterelectricity.we.pojo;

import java.io.Serializable;

public class Charge implements Serializable {

	/**
	 * 自动生成
	 */
	private static final long serialVersionUID = -9124004025925242623L;

	/**
	 * 单位：立方米
	 */
	private Double water;
	/**
	 * 单位：千瓦.时(度)
	 */
	private Double eletricity;
	public Double getWater() {
		return water;
	}
	public void setWater(Double water) {
		this.water = water;
	}
	public Double getEletricity() {
		return eletricity;
	}
	public void setEletricity(Double eletricity) {
		this.eletricity = eletricity;
	}
	public Charge(Double water, Double eletricity) {
		super();
		this.water = water;
		this.eletricity = eletricity;
	}
	public Charge() {
		super();
	}
	@Override
	public String toString() {
		return "Charge [water=" + water + ", eletricity=" + eletricity + "]";
	}
}
