package com.epam.bohush.task3.service;

import com.epam.bohush.task3.model.Note;
import com.epam.bohush.task3.repository.jdbc.JdbcNoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Date 07/22/2019.
 *
 * @author Raman_Bohush
 */
@Service
public class NoteService {
    @Autowired
    private JdbcNoteRepository jdbcNoteRepository;

    public Note getById(Integer id) {
        return jdbcNoteRepository.getById(id);
    }

    public void create(Note note) {
        jdbcNoteRepository.create(note);
    }

    public void removeById(Integer id) {
        jdbcNoteRepository.removeById(id);
    }

    public List<Note> getAll(String status) {
        return jdbcNoteRepository.getAll(status);
    }

    public void complete(Integer noteId) {
        jdbcNoteRepository.complete(noteId);
    }
}
