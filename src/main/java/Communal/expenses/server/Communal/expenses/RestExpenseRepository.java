package Communal.expenses.server.Communal.expenses;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "expenses")
public interface RestExpenseRepository extends JpaRepository<Expense, Long> {
}
