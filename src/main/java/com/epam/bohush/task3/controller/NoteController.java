package com.epam.bohush.task3.controller;

import com.epam.bohush.task3.model.Note;
import com.epam.bohush.task3.model.Status;
import com.epam.bohush.task3.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.List;

/**
 * Date 07/16/2019.
 *
 * @author Raman_Bohush
 */
@Controller
public class NoteController {
    @Autowired
    private NoteService noteService;

    @RequestMapping(path = "/notes/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Note getById(@PathVariable("id") Integer id) {
        return noteService.getById(id);
    }

    @RequestMapping(path = "/notes", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity create(@Valid @RequestBody Note note, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new IllegalArgumentException("Validation error occurred");
        }

        noteService.create(note);

        return new ResponseEntity<>("Task was created", HttpStatus.CREATED);
    }

    @RequestMapping(path = "/notes/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity delete(@PathVariable("id") Integer id) {
        noteService.removeById(id);

        return new ResponseEntity<>("Task was successfully deleted", HttpStatus.NO_CONTENT);
    }

    @RequestMapping(path = "/notes", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<Note> getAll(@RequestParam("status") String status) {
        return noteService.getAll(status);
    }

    @RequestMapping(path = "/notes/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity complete(@PathVariable("id") Integer id) {
        noteService.complete(id);

        return new ResponseEntity<>("Task was successfully completed", HttpStatus.OK);
    }

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String getPage(Model model) {
        model.addAttribute("notCompletedList", noteService.getAll(Status.OPEN.name()));
        model.addAttribute("completedList", noteService.getAll(Status.COMPLETED.name()));

        return "index.html";
    }
}