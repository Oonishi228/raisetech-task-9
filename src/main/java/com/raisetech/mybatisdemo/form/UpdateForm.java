package com.raisetech.mybatisdemo.form;

import lombok.Getter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

@Getter
public class UpdateForm {

    private int id;

    @NotBlank
    @Length(max = 20)
    private String name;

    @NotBlank
    private String residence;

    public UpdateForm(int id, String name, String residence) {
        this.id = id;
        this.name = name;
        this.residence = residence;
    }
}
