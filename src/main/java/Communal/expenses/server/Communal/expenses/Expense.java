package Communal.expenses.server.Communal.expenses;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;
    private int amount;

    @ManyToOne
    @JoinColumn(name="payment_id", nullable=false)
    @JsonIgnore
    private Payment payment;

    public Expense(String name, Integer amount, Payment payment) {

        this.name = name;
        this.amount = amount;
        this.payment = payment;
    }
}
