package br.com.fabricioviana.desafiotodolist.repository;

import br.com.fabricioviana.desafiotodolist.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long> {

}
