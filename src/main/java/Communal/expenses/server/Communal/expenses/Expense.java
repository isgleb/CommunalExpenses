package Communal.expenses.server.Communal.expenses;

//import org.codehaus.jackson.annotate.JsonIgnore;
import lombok.Data;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;

@Data
@Entity
//@JsonIgnoreProperties(value = { "payment_id" })
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    String name;
    int amount;

    @ManyToOne
    @JoinColumn(name="payment_id", nullable=false)
    @JsonIgnore
    private Payment payment;
}
