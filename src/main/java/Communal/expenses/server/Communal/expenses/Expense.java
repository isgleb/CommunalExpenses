package Communal.expenses.server.Communal.expenses;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;


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
    @JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
    @JsonIdentityReference(alwaysAsId=true)
    @JsonProperty("paymentId")
    private Payment payment;
}
