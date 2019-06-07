package pl.kmachura.simplenotes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pl.kmachura.simplenotes.model.SimpleNote;

@Repository
public interface SimpleNoteRepository extends JpaRepository<SimpleNote, Integer> {

}