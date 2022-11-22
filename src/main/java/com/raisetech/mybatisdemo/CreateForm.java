package com.raisetech.mybatisdemo;

import lombok.Getter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

@Getter
public class CreateForm {

    @NotBlank
    @Length(max = 20)
    private String name;

    @NotBlank
    private String residence;

    public CreateForm(String name, String residence) {
        this.name = name;
        this.residence = residence;
    }
}
