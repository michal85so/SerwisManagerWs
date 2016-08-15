package pl.policht.smws.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="dictionary_of_state")
public class State {
	
	@Id
	private int id;
	
	@Column(name="address_id")
	private int addressId;
}
