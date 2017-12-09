package pl.policht.smws.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
@Entity
@Table(name = "person_status")
public class PersonStatus {

    @Id
    private int id;

    private String name;

    @SuppressWarnings("serial")
    public static Map<Integer, String> listOfStatus = new HashMap<Integer, String>() {{
        put(0, "default");
        put(2, "serviceman");
        put(3, "seller");
        put(4, "client");
    }};

    public static int getKeyByValue(String value) {
        Map.Entry<Integer, String> entry = listOfStatus.entrySet().stream()
                .filter(i -> i.getValue().equals(value))
                .findFirst()
                .orElse(listOfStatus.entrySet().iterator().next());
        return entry.getKey();
    }
}
