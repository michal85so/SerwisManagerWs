package pl.policht.smws.entity;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="dictionary_of_service_status")
public class ServiceStatus {
	
	@Id
	private int id;
	private String name;
	
	@SuppressWarnings("serial")
	public static Map<Integer, String> listOfStatus = new HashMap<Integer, String>() {{ 
		put(2, "serviceman");
		put(3, "seller");
		put(4, "client");
	}};
	
	public static int getKeyByValue(String value) {
		for (java.util.Map.Entry<Integer, String> entry : listOfStatus.entrySet()) {
			if (entry.getValue().equals(value))
				return entry.getKey();
		}
		return 0;
	}
}
