package bt.model.service;



import bt.model.dto.FeedbackDto;
import bt.model.entity.Feedback;
import bt.model.repository.IFeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedbackService implements IFeedbackService {
    @Autowired
    private IFeedbackRepository feedbackRepository;
    @Override
    public List<Feedback> findAll() {
        return feedbackRepository.findAll();
    }

    @Override
    public Feedback findById(Long id) {
        return feedbackRepository.findById(id);
    }

    @Override
    public void save(FeedbackDto feedbackDto) {
        Feedback feedback = new Feedback(feedbackDto.getId(),
                feedbackDto.getRate(),feedbackDto.getAuthor(),
                feedbackDto.getContent(),feedbackDto.getCreationDate(), feedbackDto.getLikes());
        feedbackRepository.save(feedback);
    }

    @Override
    public void delete(Long id) {
        feedbackRepository.delete(id);
    }

    public void like(Long id){
        Feedback feedback = feedbackRepository.findById(id);
        feedback.setLikes(feedback.getLikes()+1);
        feedbackRepository.save(feedback);
    }
}
