package Communal.expenses.server.Communal.expenses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentDto {

    private long id;
    private int clientId;
    private String ownerName;
    private String address;
//    private Date period;
    private List<ExpensesDto> expenses;

    public PaymentDto(long id, int clientId, String ownerName, String address, Date period) {
    }
}
