package com.example.desafio_todolist.to_do_list.repository;

import com.example.desafio_todolist.to_do_list.model.Todos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todos,Long> {
}
