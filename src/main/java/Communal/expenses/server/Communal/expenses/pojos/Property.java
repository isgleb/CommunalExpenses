package Communal.expenses.server.Communal.expenses.pojos;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
public class Property {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String address;
    private Owner owner;

}
