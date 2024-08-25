package com.aniket.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity 
@Table(name="rawMaterial") 
@Component
public class RawMaterial {

	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getQuantity() {
		return quantity;
	}
	public void setQuantity(float quantity) {
		this.quantity = quantity;
	}
	public float getUnit() {
		return unit;
	}
	public void setUnit(float unit) {
		this.unit = unit;
	}
	public float getCostPerUnit() {
		return costPerUnit;
	}
	public void setCostPerUnit(float costPerUnit) {
		this.costPerUnit = costPerUnit;
	}
	@Override
	public String toString() {
		return "RawMaterial [id=" + id + ", name=" + name + ", quantity=" + quantity + ", unit=" + unit
				+ ", costPerUnit=" + costPerUnit + "]";
	}
	public RawMaterial(int id, String name, float quantity, float unit, float costPerUnit) {
		super();
		this.id = id;
		this.name = name;
		this.quantity = quantity;
		this.unit = unit;
		this.costPerUnit = costPerUnit;
	}
	public RawMaterial() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Id
	private int id;
	private String name;
	private float quantity;
	private float unit;
	private float costPerUnit;
	
}
