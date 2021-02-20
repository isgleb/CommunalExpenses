package Communal.expenses.server.Communal.expenses;

import Communal.expenses.server.Communal.expenses.Expense;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private int clientId;
    private String ownerName;

    @OneToMany(cascade=CascadeType.ALL, mappedBy = "payment")
//    @JsonIgnore
    private List<Expense> expenses;

    private String address;
    private Date period;

    public Payment(long id, int clientId, String ownerName, String address, Date period) {
    }
}
