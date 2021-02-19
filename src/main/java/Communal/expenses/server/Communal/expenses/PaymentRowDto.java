package Communal.expenses.server.Communal.expenses;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class PaymentRowDto {

    private Long id;
    private int clientId;
    private String name;
    private String address;
    private Date period;
    private Long amount;
}
