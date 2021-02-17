package Communal.expenses.server.Communal.expenses.pojos;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
public class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    String name;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy= "owner")
    private Set<Property> properties;
}
