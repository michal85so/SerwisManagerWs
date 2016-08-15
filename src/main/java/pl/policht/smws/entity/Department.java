package pl.policht.smws.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Department {
	
	@Id
	private int id;
	
	@Column(name="address_id")
	private int addressId;
}
