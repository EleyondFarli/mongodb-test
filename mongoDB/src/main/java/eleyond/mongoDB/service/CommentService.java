package eleyond.mongoDB.service;
import eleyond.mongoDB.model.Comment;
import eleyond.mongoDB.repo.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    // existing methods...

    // New method to retrieve comments by userId
    public List<Comment> getCommentsByUserId(String userId) {
        return commentRepository.findByUserId(userId);
    }
}
