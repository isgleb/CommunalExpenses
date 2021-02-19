package Communal.expenses.server.Communal.expenses.Repositories;

import Communal.expenses.server.Communal.expenses.pojos.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//excerptProjection = ExpenseProjection.class
@RepositoryRestResource(path = "payments", excerptProjection = PaymentProjection.class)
public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
