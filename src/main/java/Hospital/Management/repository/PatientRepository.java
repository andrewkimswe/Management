package Hospital.Management.repository;

import Hospital.Management.domain.Patient;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Repository
public class PatientRepository {
    @PersistenceContext
    EntityManager em;

    @Transactional
    public Long save(Patient patient) {
        em.persist(patient);
        return patient.getId();
    }
    public Patient findById(Long id) {
        return em.find(Patient.class, id);
    }

    public List<Patient> findByName(String name){
        return em.createQuery("select p from Patient p where p.username=:name")
                .setParameter("name",name)
                .getResultList();
    }

}