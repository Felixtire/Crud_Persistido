package com.example.desafio_todolist.to_do_list.service;

import com.example.desafio_todolist.to_do_list.dto.TodosDto;
import com.example.desafio_todolist.to_do_list.model.Todos;
import com.example.desafio_todolist.to_do_list.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    @Autowired
    private TodoRepository repository;


    public List<Todos> list(){
        Sort sort =Sort.by("prioridade").descending().and(Sort.by("realizado").ascending());
        return repository.findAll(sort);

    }

    public List<Todos> salvar(TodosDto dto){
        Todos todoCriada = new Todos();

        todoCriada.setDescricao(dto.getDescricao());
        todoCriada.setNome(dto.getNome());
        todoCriada.setPrioridade(dto.getPrioridade());
        todoCriada.setDescricao(dto.getDescricao());

        repository.save(todoCriada);
        return list();
    }

    public List<Todos> listarPorId(Long id){
        if (repository.existsById(id)){
            repository.findById(id);
            return list();
        }else {
            throw new RuntimeException("Tarefa não encontrada");
        }
    }

    public List<Todos> atualizar(Long id, TodosDto dto){
        if (repository.existsById(id)){
            Todos todoExistente = repository.findById(id).get();
            todoExistente.setDescricao(dto.getDescricao());
            todoExistente.setNome(dto.getNome());
            todoExistente.setPrioridade(dto.getPrioridade());

            repository.save(todoExistente);
            return list();

        }else {
            throw new RuntimeException("Tarefa não encontrada");
        }

    }

    public void deletar(Long id){
        if (repository.existsById(id)){
            repository.deleteById(id);

        }else {
            throw new RuntimeException("Tarefa não encontrada");
        }

    }

    public void deletarTodas(){
        repository.deleteAll();

    }




}
