package Communal.expenses.server.Communal.expenses.pojos;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
import java.util.List;

@Data
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private Client client;
    private List<Expense> expenses;
    private Property property;
    private Date period;
}
