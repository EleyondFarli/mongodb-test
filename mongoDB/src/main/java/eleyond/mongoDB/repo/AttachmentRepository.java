package eleyond.mongoDB.repo;

import eleyond.mongoDB.model.Attachment;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AttachmentRepository extends MongoRepository<Attachment, String> {
    // Additional custom queries can be added here if needed
}

