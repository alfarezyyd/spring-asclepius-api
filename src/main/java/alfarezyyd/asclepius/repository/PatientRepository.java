package alfarezyyd.asclepius.repository;

import alfarezyyd.asclepius.model.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}
