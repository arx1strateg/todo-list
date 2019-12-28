package com.bohush.dto;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Date 07/16/2019.
 *
 * @author Raman_Bohush
 */
public class NoteDto {
    private Integer id;
    @Size(max=30)
    @NotNull
    @NotEmpty
    private String description;
    @NotNull
    private String status;

    public NoteDto() {
    }

    public NoteDto(Integer id, String description, String status) {
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
