package com.example.desafio_todolist.to_do_list.controller;

import com.example.desafio_todolist.to_do_list.dto.TodosDto;
import com.example.desafio_todolist.to_do_list.model.Todos;
import com.example.desafio_todolist.to_do_list.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
public class TodoController {

    @Autowired
    private TodoService service;

    @PostMapping
    public List<Todos> createTodo(@RequestBody TodosDto dto){
        return service.salvar(dto);
    }

    @GetMapping
    public List<Todos> listTodos(){
        return service.list();
    }

    @GetMapping("/{id}")
    public List<Todos> listId(@PathVariable Long id){
        return service.listarPorId(id);
    }

    @PutMapping("/{id}")
    public List<Todos> updateTodo(@PathVariable Long id, @RequestBody TodosDto dto){
        return  service.atualizar(id,dto);
    }

    @DeleteMapping("/{id}")
    public void deleteTodo(@PathVariable Long id){
        service.deletar(id);
    }


    @DeleteMapping
    public void deleteAll(){
        service.deletarTodas();
    }






}
