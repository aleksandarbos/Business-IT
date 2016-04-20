package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.Constraint;

import play.data.validation.*;
import play.db.jpa.Model;

@Entity
public class City extends Model {

	public String name;
	public String sifra; 
	public String zipCode;
	
	@ManyToOne
	public Country country;
	
	public City(String name, String sifra, String zipCode, Country country) {
		super();
		this.name = name;
		this.sifra = sifra;
		this.zipCode = zipCode;
		this.country = country;
	}
	
	
	
}
