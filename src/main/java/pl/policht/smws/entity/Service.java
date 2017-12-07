package pl.policht.smws.entity;

import java.time.LocalDate;

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
public class Service {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@OneToOne
	private Person client;
	
	@Column(name="service_name", nullable=false)
	private String serviceName;
	
	private String info;
	
	@Column(name="date_of_order", nullable=false)
	private LocalDate dateOfOrder;
	
	@Column(name="date_of_receipt")
	private LocalDate dateOfReceipt;
	
	@OneToOne
	private ServiceStatus serviceStatus;
	
	@Column(name="facture_id")
	private int factureId;
}
