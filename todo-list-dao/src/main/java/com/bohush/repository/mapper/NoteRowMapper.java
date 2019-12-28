package com.bohush.repository.mapper;

import com.bohush.model.Note;
import com.bohush.model.Status;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Date 07/22/2019.
 *
 * @author Raman_Bohush
 */
@Component
public class NoteRowMapper implements RowMapper<Note> {
    @Override
    public Note mapRow(ResultSet resultSet, int i) throws SQLException {
        Note note = new Note();
        note.setId(resultSet.getInt("ID"));
        note.setDescription(resultSet.getString("DESCRIPTION"));
        note.setStatus(Status.valueOf(resultSet.getString("STATUS")));

        return note;
    }
}
