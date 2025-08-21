package com.jpa.test.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)	
private int id;
private String name;
private String city;
private String profile;
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
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
public String getProfile() {
	return profile;
}
public void setProfile(String profile) {
	this.profile = profile;
}
@Override
public String toString() {
	return "User [id=" + id + ", name=" + name + ", city=" + city + ", profile=" + profile + "]";
}



}
