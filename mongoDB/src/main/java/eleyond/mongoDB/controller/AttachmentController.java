package eleyond.mongoDB.controller;
import eleyond.mongoDB.model.Attachment;
import eleyond.mongoDB.repo.AttachmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/attachments")
public class AttachmentController {

    @Autowired
    private AttachmentRepository attachmentRepository;

    @GetMapping
    public List<Attachment> getAllAttachments() {
        return attachmentRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Attachment> getAttachmentById(@PathVariable String id) {
        return attachmentRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Attachment createAttachment(@RequestBody Attachment attachment) {
        return attachmentRepository.save(attachment);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Attachment> updateAttachment(@PathVariable String id, @RequestBody Attachment updatedAttachment) {
        return attachmentRepository.findById(id)
                .map(existingAttachment -> {
                    existingAttachment.setFilename(updatedAttachment.getFilename());
                    existingAttachment.setTaskId(updatedAttachment.getTaskId());
                    return ResponseEntity.ok(attachmentRepository.save(existingAttachment));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAttachment(@PathVariable String id) {
        attachmentRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

