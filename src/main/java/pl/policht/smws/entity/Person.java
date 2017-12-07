package pl.policht.smws.entity;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
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
	
	@OneToOne(fetch = FetchType.LAZY)
	private PersonStatus personStatus;
	
	private String nip;
	
	private String regon;
	
	@OneToOne(fetch = FetchType.LAZY)
	private Address address;
}
