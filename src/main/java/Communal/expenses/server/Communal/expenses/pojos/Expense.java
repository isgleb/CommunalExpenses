package Communal.expenses.server.Communal.expenses.pojos;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    String name;
    int amount;

    @ManyToOne
    @JoinColumn(name="payment_id", nullable=false)
    private Payment payment;
}
