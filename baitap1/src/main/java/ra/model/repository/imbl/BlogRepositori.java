package ra.model.repository.imbl;

import org.springframework.stereotype.Repository;
import ra.model.entity.Blog;
import ra.model.repository.IBlogRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class BlogRepositori implements IBlogRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Blog> findAll() {
        TypedQuery<Blog> query = entityManager.createQuery("SELECT b FROM Blog AS b", Blog.class);
        return query.getResultList();
    }

    @Override
    public Blog findByID(Long id) {
        return entityManager.createQuery("SELECT b FROM Blog AS b WHERE b.id =:id", Blog.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    @Override
    public void save(Blog blog) {
        if (blog.getId() == null) {
            // tHÊM mỚI
            entityManager.persist(blog);
        } else {
            // Cập Nhật
            entityManager.merge(blog);
        }
    }

    @Override
    public void delete(Long id) {
        entityManager.refresh(findByID(id));
    }
}
