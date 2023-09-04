package bt.model.service;



import bt.model.dto.FeedbackDto;
import bt.model.entity.Feedback;

import java.util.List;

public interface IFeedbackService {
    List<Feedback> findAll();
    Feedback findById(Long id);
    void save(FeedbackDto feedbackDto);
    void delete(Long id);
    void like(Long id);
}
