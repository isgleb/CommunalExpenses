package Communal.expenses.server.Communal.expenses.Repositories;//package Communal.expenses.server.Communal.expenses.Repositories;
//
import Communal.expenses.server.Communal.expenses.pojos.Expense;
import Communal.expenses.server.Communal.expenses.pojos.Payment;
import org.springframework.data.rest.core.config.Projection;

import java.util.Set;

@Projection(name = "inlineData", types= Payment.class)
public interface PaymentProjection {

    Long getId();
    String getClientName();
    String getAddress();
    String getPeriod();
//    Set<Expense> getExpenses();
}
