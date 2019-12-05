package com.epam.bohush.task3.repository.mybatis;

import com.epam.bohush.task3.model.Note;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface NoteMapper {
    @Select("SELECT * FROM NOTES WHERE ID = #{id}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "description", column = "description"),
            @Result(property = "status", column = "status")
    })
    Note getById(Integer id);

    @Insert()
    void create(Note note);

    void removeById(Integer id);

    List<Note> getAll(String status);

    void complete(Integer noteId);
}
