package eleyond.mongoDB.repo;

import eleyond.mongoDB.model.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CommentRepository extends MongoRepository<Comment, String> {
    // Additional custom queries can be added here if needed
    List<Comment> findByUserId(String userId);
}
