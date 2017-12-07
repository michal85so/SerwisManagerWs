package pl.policht.smws.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Data
@Entity
public class Department {

    @Id
    private int id;

    @OneToOne
    private Address address;
}
