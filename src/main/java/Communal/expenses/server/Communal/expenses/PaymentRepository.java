package Communal.expenses.server.Communal.expenses;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

    @Query(value = "SELECT new Communal.expenses.server.Communal.expenses.PaymentRowDto" +
            "(p.id, p.clientName, p.address, p.period, SUM(e.amount) AS amount) FROM Payment p " +
            "LEFT JOIN Expense e ON p.id = e.payment" +
            " GROUP BY p.id")
    List<PaymentRowDto> getPaymentRowDtos();
}
