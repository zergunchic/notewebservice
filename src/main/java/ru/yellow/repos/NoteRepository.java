package ru.yellow.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ru.yellow.entitys.SingleNote;

public interface NoteRepository extends JpaRepository<SingleNote, Integer> {
	public List<SingleNote> findByTitleLike(String title);
	
	@Query("SELECT note FROM SingleNote note WHERE LOWER(note.title) LIKE CONCAT('%',LOWER(:text),'%') OR LOWER(note.text) LIKE CONCAT('%',LOWER(:text),'%')")
	public List<SingleNote> findByTitleLikeOrfindByTextLike(@Param(value = "text") String textToFind);
}
