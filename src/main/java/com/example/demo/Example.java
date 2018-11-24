package com.example.demo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Example {

	@JsonProperty("name")
	private String name;
	@JsonProperty("age")
	private Integer age;
	@JsonProperty("bikes")
	private List<Bike> bikes = null;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("name")
	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Example [name=" + name + ", age=" + age + ", bikes=" + bikes + "]";
	}

	@JsonProperty("name")
	public void setName(String name) {
		this.name = name;
	}

	@JsonProperty("age")
	public Integer getAge() {
		return age;
	}

	@JsonProperty("age")
	public void setAge(Integer age) {
		this.age = age;
	}

	@JsonProperty("bikes")
	public List<Bike> getBikes() {
		return bikes;
	}

	@JsonProperty("bikes")
	public void setBikes(List<Bike> bikes) {
		this.bikes = bikes;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

}