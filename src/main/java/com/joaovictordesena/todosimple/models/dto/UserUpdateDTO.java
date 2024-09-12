package com.joaovictordesena.todosimple.models.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class UserUpdateDTO {
    
    private Long id;

    @NotBlank
    @Size(min = 8, max = 60)
    private String password;
}
