package pl.policht.smws.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Entity
public class Service {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(name="client_id", nullable=false)
	private int clientId;
	
	@Column(name="service_name", nullable=false)
	private String serviceName;
	
	private String info;
	
	@Column(name="date_of_order", nullable=false)
	private LocalDate dateOfOrder;
	
	@Column(name="date_of_receipt")
	private LocalDate dateOfReceipt;
	
	@Column(name="service_status_id", nullable=false)
	private int serviceStatusId;
	
	@Column(name="facture_id")
	private int factureId;
}
