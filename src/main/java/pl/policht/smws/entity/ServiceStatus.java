package pl.policht.smws.entity;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="service_status")
public class ServiceStatus {
	
	@Id
	private int id;

	private String name;
	
}
