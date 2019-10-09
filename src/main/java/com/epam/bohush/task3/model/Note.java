package com.epam.bohush.task3.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Date 07/16/2019.
 *
 * @author Raman_Bohush
 */
public class Note {
    private Integer id;
    @Size(max=30)
    @NotNull
    @NotEmpty
    private String description;
    @NotNull
    private Status status;

    public Note() {
    }

    public Note(Integer id, String description, Status status) {
        this.id = id;
        this.description = description;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
