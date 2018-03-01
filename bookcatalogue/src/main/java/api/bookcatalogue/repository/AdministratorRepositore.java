package api.bookcatalogue.repository;

import api.bookcatalogue.model.Administrator;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdministratorRepositore extends JpaRepository<Administrator,Integer> {
    public Administrator findByEmail(String email);
}
