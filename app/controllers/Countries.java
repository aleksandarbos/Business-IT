package controllers;

import java.util.List;

import models.Country;
import play.mvc.Controller;

public class Countries extends Controller {
	
	public static void show(){
		List<Country> countries = Country.findAll();
		render(countries);
	}
	
	public static void create(Country country) {
		country.save();
		show();
	}
	
	public static void edit(Long countryId) {
		Country country = Country.findById(countryId);
		render(country);
	}
	
	public static void update(Country country) {
		Country oldCountry = Country.findById(country.id);
		oldCountry = country;
		oldCountry.save();
		show();
	}
	
	public static void delete(Long countryId) {
		Country country = Country.findById(countryId);
		country.delete();
		System.out.println("Deleted country with id: " + countryId);		
		show();
	}
	
}
