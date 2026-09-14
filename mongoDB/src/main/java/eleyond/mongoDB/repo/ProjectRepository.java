package eleyond.mongoDB.repo;

import eleyond.mongoDB.model.Project;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProjectRepository extends MongoRepository<Project, String> {
    // Additional custom queries can be added here if needed
}

