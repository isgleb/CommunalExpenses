package Communal.expenses.server.Communal.expenses.pojos;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Data
@Entity
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable=false)
    private Client client;

    @OneToMany(mappedBy = "payment", cascade = CascadeType.ALL)
    private Set<Expense> expenses;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "property_id", referencedColumnName = "id")
    private Property property;
    private Date period;
}
