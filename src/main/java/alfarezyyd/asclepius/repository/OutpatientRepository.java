package alfarezyyd.asclepius.repository;

import alfarezyyd.asclepius.model.entity.Outpatient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OutpatientRepository extends JpaRepository<Outpatient, String> {
}
