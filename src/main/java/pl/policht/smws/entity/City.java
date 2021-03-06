package pl.policht.smws.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="dictionary_of_city")
public class City {
	
	@Id
	private int id;
	
	private String name;
}
