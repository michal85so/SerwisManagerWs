package pl.policht.smws.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "state")
public class State {

    @Id
    private int id;

    private String name;
}
