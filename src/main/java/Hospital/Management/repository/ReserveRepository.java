package Hospital.Management.repository;

import Hospital.Management.domain.Reserve;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Repository
public class ReserveRepository{

    @PersistenceContext
    EntityManager em;

    @Transactional
    public Long save(Reserve reserve) {
        em.persist(reserve);
        return reserve.getId();
    }
    public Reserve findById(Long id) {
        return em.find(Reserve.class, id);
    }

}
