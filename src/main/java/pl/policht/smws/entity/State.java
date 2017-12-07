package pl.policht.smws.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="state")
public class State {
	
	@Id
	private int id;

	private String name;
	
}
