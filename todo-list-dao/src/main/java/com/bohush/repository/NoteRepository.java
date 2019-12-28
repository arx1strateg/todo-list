package com.bohush.repository;

import com.bohush.model.Note;
import com.bohush.repository.mapper.NoteRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Date 07/22/2019.
 *
 * @author Raman_Bohush
 */
@Repository
public class NoteRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private NoteRowMapper noteRowMapper;

    public Note getById(Integer id) {
        return jdbcTemplate.queryForObject("SELECT * FROM NOTES WHERE ID = ?", new Object[] {id}, noteRowMapper);
    }

    public void create(Note note) {
        jdbcTemplate.update("INSERT INTO NOTES(DESCRIPTION, STATUS) VALUES (?, ?)", note.getDescription(), note.getStatus().toString());
    }

    public void removeById(Integer id) {
        jdbcTemplate.update("DELETE FROM NOTES WHERE ID = ?", id);
    }

    public List<Note> getAll(String status) {
        return jdbcTemplate.query("SELECT * FROM NOTES WHERE STATUS = ?", new Object[] {status}, noteRowMapper);
    }

    public void complete(Integer noteId) {
        jdbcTemplate.update("UPDATE NOTES SET STATUS = 'COMPLETED' WHERE ID = ?", noteId);
    }
}
