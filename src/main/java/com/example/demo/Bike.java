package com.example.demo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Bike {
	@JsonProperty("name")
	private String name;
	@JsonProperty("models")
	private List<String> models = null;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("name")
	public String getName() {
		return name;
	}

	@JsonProperty("name")
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Bike [name=" + name + ", models=" + models + "]";
	}

	@JsonProperty("models")
	public List<String> getModels() {
		return models;
	}

	@JsonProperty("models")
	public void setModels(List<String> models) {
		this.models = models;
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