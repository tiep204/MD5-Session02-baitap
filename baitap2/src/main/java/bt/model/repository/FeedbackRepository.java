package bt.model.repository;


import bt.model.entity.Feedback;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class FeedbackRepository implements IFeedbackRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Feedback> findAll() {
        TypedQuery<Feedback> query = entityManager.createQuery("select f from Feedback as f where f.creationDate = current_date() order by f.creationDate desc", Feedback.class);
        return query.getResultList();
    }

    @Override
    public Feedback findById(Long id) {
        TypedQuery<Feedback> query = entityManager.createQuery("select f from Feedback as f where f.id =:id", Feedback.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public void save(Feedback feedback) {
        if(feedback.getId()==null){
            entityManager.persist(feedback);
        } else {
            entityManager.merge(feedback);
        }
    }

    @Override
    public void delete(Long id) {
        entityManager.remove(findById(id));
    }
}

