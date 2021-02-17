package Communal.expenses.server.Communal.expenses.pojos;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy= "client")
    private Set<Payment> payments;


}
