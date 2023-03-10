package Hospital.Management.repository;

import Hospital.Management.domain.Hospital;
import Hospital.Management.domain.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class HospitalRepository {
    @PersistenceContext
    EntityManager em;

    @Transactional
    public Long save(Hospital hospital) {
        em.persist(hospital);
        return hospital.getId();
    }
    public Patient findById(Long id) {
        return em.find(Patient.class, id);
    }
}