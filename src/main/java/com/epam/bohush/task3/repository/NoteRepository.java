package com.epam.bohush.task3.repository;

import com.epam.bohush.task3.model.Note;

import java.util.List;

public interface NoteRepository {
    public Note getById(Integer id);

    public void create(Note note);

    public void removeById(Integer id);

    public List<Note> getAll(String status);

    public void complete(Integer noteId);
}
