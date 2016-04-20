package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.mysql.fabric.xmlrpc.base.Array;

import play.db.jpa.Model;

@Entity
public class Country extends Model {

	public String name;
	public String sifra;
	
	@OneToMany(mappedBy = "country")
	public List<City> cities;
	
	
	public Country(String name, String sifra) {
		super();
		this.name = name;
		this.sifra = sifra;
		cities = new ArrayList<City>();
	}
	
	
}
