package ra.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.model.entity.Blog;
import ra.model.repository.IBlogRepository;

import java.util.List;

@Service
public class BlogService implements IBlogService{
    @Autowired
    private IBlogRepository repository;
    @Override
    public List<Blog> findAll() {
        return repository.findAll();
    }

    @Override
    public Blog findByID(Long id) {
        return repository.findByID(id);
    }

    @Override
    public void save(Blog p) {
        repository.save(p);
    }

    @Override
    public void delete(Long id) {
        repository.delete(id);
    }
}
