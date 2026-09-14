package eleyond.mongoDB.utils;
import eleyond.mongoDB.model.*;
import eleyond.mongoDB.repo.*;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DocumentsGenerator {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private AttachmentRepository attachmentRepository;

    @PostConstruct
    public void generateDocuments() {
        generateUsers();
        generateProjects();
        generateTasks();
        generateComments();
        generateAttachments();
    }

    private void generateUsers() {
        List<User> users = new ArrayList<>();
        users.add(new User("user1", "eleyond", "eleyond@gmail.com"));
        users.add(new User("user2", "taisly", "taisly@gmail.com"));
        users.add(new User("user3", "kidgamers11", "kidgamers11@gmail.com"));
        users.add(new User("user4", "alesico", "alesico@gmail.com"));
        users.add(new User("user5", "lautusa", "lautusa@gmail.com"));
        userRepository.saveAll(users);
    }

    private void generateProjects() {
        List<Project> projects = new ArrayList<>();
        projects.add(new Project("Project1", "Smoke Test Detector", "Description of Project1"));
        projects.add(new Project("Project2", "Lego Project", "Description of Project2"));
        projects.add(new Project("Project3", "MongoDB Project", "Description of Project3"));
        projects.add(new Project("Project4", "Web Sockets Project", "Description of Project4"));
        projects.add(new Project("Project5", "Nice Project", "Description of Project5"));
        projectRepository.saveAll(projects);
    }

    private void generateTasks() {
        List<Task> tasks = new ArrayList<>();
        tasks.add(new Task("Task1", "Smoke Test Detector Task1", "Description of Task"));
        tasks.add(new Task("Task2", "Smoke Test Detector Task2", "Description of Task"));
        tasks.add(new Task("Task3", "Lego Project Task1", "Description of Task"));
        tasks.add(new Task("Task4", "Web Sockets Project Task1", "Description of Task"));
        tasks.add(new Task("Task5", "MongoDB Task15", "Description of Task"));
        taskRepository.saveAll(tasks);
    }

    private void generateComments() {
        List<Comment> comments = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            comments.add(new Comment("Comment" + i, "Content of Comment" + i, "user" + i));
        }
        commentRepository.saveAll(comments);
    }

    private void generateAttachments() {
        List<Attachment> attachments = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            attachments.add(new Attachment("Attachment" + i, "Attachment" + i + ".txt", "Task" + i));
        }
        attachmentRepository.saveAll(attachments);
    }
}
