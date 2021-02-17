package Communal.expenses.server.Communal.expenses.pojos;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Property {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String address;

    @ManyToOne
    @JoinColumn(name = "owner_id", nullable=false)
    private Owner owner;
}
