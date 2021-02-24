package Communal.expenses.server.Communal.expenses;

import Communal.expenses.server.Communal.expenses.Expense;
import com.fasterxml.jackson.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.time.LocalDate;
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

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm a z")
    private Date period;

    @OneToMany(cascade=CascadeType.ALL, mappedBy = "payment")
    private List<Expense> expenses;
}
