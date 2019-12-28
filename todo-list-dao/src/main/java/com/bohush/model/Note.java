package com.bohush.model;

/**
 * Date 07/16/2019.
 *
 * @author Raman_Bohush
 */
public class Note {
    private Integer id;
    private String description;
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
