package com.example.desafio_todolist.to_do_list.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TodosDto {
    private String nome;
    private String descricao;
    private boolean status;
    private int prioridade;





}
