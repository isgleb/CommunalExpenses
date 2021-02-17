package Communal.expenses.server.Communal.expenses.Repositories;

import Communal.expenses.server.Communal.expenses.pojos.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "owners")
public interface OwnerRepository extends JpaRepository<Owner, Long> {
}
