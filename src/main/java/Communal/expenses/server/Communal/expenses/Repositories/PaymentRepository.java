package Communal.expenses.server.Communal.expenses.Repositories;

import Communal.expenses.server.Communal.expenses.pojos.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

//excerptProjection = ExpenseProjection.class
//@RepositoryRestResource(path = "payments", excerptProjection = PaymentProjection.class)
public interface PaymentRepository extends JpaRepository<Payment, Long> {


//    SELECT RES.[CUSTOMER ID], RES,NAME, SUM(INV.AMOUNT) AS [TOTAL AMOUNT]
//FROM RES_DATA RES
//JOIN INV_DATA INV ON RES.[CUSTOMER ID] INV.[CUSTOMER ID]
//GROUP BY RES.[CUSTOMER ID], RES,NAME

    @Query(value = "SELECT u FROM Payment u")
    List<Payment> method();

//    @Query(value = "SELECT new Communal.expenses.server.Communal.expenses.Repositories.PaymentRowDto" +
//            "(p.id, p.clientName, p.address, p.period, e.amount AS amount) FROM Payment p " +
//            "INNER JOIN Expense e ON p.id = e.payment")
//    List<PaymentRowDto> method2();


    @Query(value = "SELECT new Communal.expenses.server.Communal.expenses.Repositories.PaymentRowDto" +
            "(p.id, p.clientName, p.address, p.period, SUM(e.amount) AS amount) FROM Payment p " +
            "LEFT JOIN Expense e ON p.id = e.payment" +
            " GROUP BY p.id")
    List<PaymentRowDto> method2();
}
