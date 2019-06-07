package pl.kmachura.simplenotes.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pl.kmachura.simplenotes.exception.ResourceNotFoundException;
import pl.kmachura.simplenotes.model.SimpleNote;
import pl.kmachura.simplenotes.repository.SimpleNoteRepository;

@RestController
@RequestMapping("/api")
public class SimpleNotesController {

    @Autowired
    SimpleNoteRepository simpleNoteRepository;

    // Get All Notes
    @GetMapping("/simplenotes")
    public List<SimpleNote> getAllNotes() {
        return simpleNoteRepository.findAll();
    }

    // Create a new Note
    @RequestMapping(value = "/simplenotes", method = RequestMethod.POST)
    public ResponseEntity create(@Valid @RequestBody SimpleNote simpleNote) {
        return ResponseEntity.ok(simpleNoteRepository.save(simpleNote));
    }
  //  public SimpleNote createSimpleNote(@Valid @RequestBody SimpleNote simpleNote) {
   //     return simpleNoteRepository.save(simpleNote);
   // }

    // Get a Single Note
    @GetMapping("/simplenotes/{id}")
    public SimpleNote getSimpleNoteById(@PathVariable(value = "id") Integer simpleNoteId) {
        return simpleNoteRepository.findById(simpleNoteId)
                .orElseThrow(() -> new ResourceNotFoundException("Note", "id", simpleNoteId));
    }
    
    // Update a Note
    @PutMapping("/simplenotes/{id}")
    public SimpleNote updateNote(@PathVariable(value = "id") Integer simpleNoteId,
                                            @Valid @RequestBody SimpleNote simpleNoteDetails) {

        SimpleNote simpleNote = simpleNoteRepository.findById(simpleNoteId)
                .orElseThrow(() -> new ResourceNotFoundException("SimpleNote", "id", simpleNoteId));

        simpleNote.setTitle(simpleNoteDetails.getTitle());
        simpleNote.setContent(simpleNoteDetails.getContent());

        SimpleNote updatedSimpleNote = simpleNoteRepository.save(simpleNote);
        return updatedSimpleNote;
    }
    
    // Delete a Note
    @DeleteMapping("/simplenotes/{id}")
    public ResponseEntity<?> deleteNote(@PathVariable(value = "id") Integer simpleNoteId) {
        SimpleNote simpleNote = simpleNoteRepository.findById(simpleNoteId)
                .orElseThrow(() -> new ResourceNotFoundException("Note", "id", simpleNoteId));

        simpleNoteRepository.delete(simpleNote);

        return ResponseEntity.ok().build();
    }
    
}