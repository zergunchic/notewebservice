package ru.yellow.notewebservice;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ru.yellow.entitys.SingleNote;
import ru.yellow.repos.NoteRepository;

@Controller
public class NoteController {
	@Autowired
	NoteRepository noteRepo;
	
	@GetMapping(value="/")
	public String getAllNotes(@ModelAttribute("model") ModelMap model) {
		Iterable<SingleNote> listOfNotes = noteRepo.findAll();
		model.put("notes", listOfNotes);
	    return "notepage";
	}
	
	@PostMapping(value="/")
	public String saveNote(@RequestParam(name="title", required = false)String title,
			@RequestParam(name="text")String text, 
			@ModelAttribute("model") ModelMap model) {
		SingleNote note = new SingleNote();
		if(Objects.isNull(title) || title.isEmpty()) note.setTitle(null);
		else note.setTitle(title);
		note.setText(text);
		noteRepo.save(note);
	    return "redirect:/";
	}
	
	@PostMapping("filter")
	public String filterNotes(@RequestParam(name="filter_text")String filter_text,
			@ModelAttribute("model") ModelMap model) {
		if(Objects.isNull(filter_text) || filter_text.isEmpty()) return "redirect:/";
		Iterable<SingleNote> listOfNotes = noteRepo.findByTitleLikeOrfindByTextLike(filter_text);
		model.put("notes", listOfNotes);
		model.put("filter_text", filter_text);
	    return "notepage";
	}
	
	@PostMapping("delete")
	public String deleteNote(@RequestParam(name="delete_id")int id,
			@ModelAttribute("model") ModelMap model) {
		noteRepo.deleteById(id);
	    return "redirect:/";
	}
}
