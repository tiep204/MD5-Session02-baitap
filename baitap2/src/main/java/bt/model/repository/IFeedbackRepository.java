package bt.model.repository;





import bt.model.entity.Feedback;

import java.util.List;

public interface IFeedbackRepository {
    List<Feedback> findAll();
    Feedback findById(Long id);
    void save(Feedback feedback);
    void delete(Long id);
}
