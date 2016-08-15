package pl.policht.smws.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Entity
@Table(name="person")
public class Person {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(name="first_name", nullable=false)
	private String firstName;
	
	@Column(name="last_name", nullable=false)
	private String lastName;
	
	@Column(unique=true)
	private String login;
	
	private String password;
	
	@Column(name="phone_number")
	private String phoneNumber;
	
	private String email;
	
	@Column(name="person_status_id")
	private int personStatusId;
	
	private String nip;
	
	private String regon;
	
	@Column(name="address_id")
	private int addressId;
}
