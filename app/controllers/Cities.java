package controllers;

import java.util.List;

import models.City;
import models.City;
import models.Country;
import play.mvc.Controller;

public class Cities extends Controller {

	public static void show() {
		List<City> cities = City.findAll();
		List<Country> countries = Country.findAll();
		render(cities, countries);
	}
	
	public static void create(City city, Long countryId) {
		System.out.println("Creating city: " + city.name + ", " + city.zipCode + ", " + city.sifra);
		Country country = Country.findById(countryId);
		city.country = country;
		city.save();
		show();
	}
	
	public static void edit(Long cityId) {
		City city = City.findById(cityId);
		List<Country> countries = Country.findAll();
		render(city, countries);
	}
	
	public static void update(City city) {
		City oldCity = City.findById(city.id);
		oldCity = city;
		oldCity.save();
		show();
	}
	
	public static void delete(Long cityId) {
		City city = City.findById(cityId);
		city.delete();
		System.out.println("Deleted City with id: " + cityId);		
		show();
	}
	
	public static void filter(City city) {
		List<City> cities = City.find("bySifraLikeAndNameLikeAndCountry_ID", 
							"%"+city.sifra + "%", "%" + city.name + "%", city.country.id
							).fetch();
		List<Country> countries = Country.findAll();
		
		renderTemplate("Cities/show.html", cities, countries);
	}
	
}
