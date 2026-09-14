package eleyond.mongoDB.repo;

import eleyond.mongoDB.model.Task;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TaskRepository extends MongoRepository<Task, String> {
    // Additional custom queries can be added here if needed
}

