package com.bohush.service;

import com.bohush.model.Note;
import com.bohush.repository.NoteRepository;
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
    private NoteRepository noteRepository;

    public Note getById(Integer id) {
        return noteRepository.getById(id);
    }

    public void create(Note note) {
        noteRepository.create(note);
    }

    public void removeById(Integer id) {
        noteRepository.removeById(id);
    }

    public List<Note> getAll(String status) {
        return noteRepository.getAll(status);
    }

    public void complete(Integer noteId) {
        noteRepository.complete(noteId);
    }
}
