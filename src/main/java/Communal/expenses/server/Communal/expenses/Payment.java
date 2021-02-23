package Communal.expenses.server.Communal.expenses;

import Communal.expenses.server.Communal.expenses.Expense;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private int clientId;
    private String ownerName;


    private String address;
//    private Date period;

    @OneToMany(cascade=CascadeType.ALL, mappedBy = "payment")
    private List<Expense> expenses;

    public Payment(long id, int clientId, String ownerName, String address, Date period) {
    }
}
