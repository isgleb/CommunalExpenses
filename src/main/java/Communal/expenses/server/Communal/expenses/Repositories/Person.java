package Communal.expenses.server.Communal.expenses.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "person")
public interface Person extends JpaRepository<Person, Long> {
}
