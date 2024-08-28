package com.mysite.todo;
import org.springframework.data.jpa.repository.JpaRepository;
public interface toDoListRepository extends JpaRepository<toDoList, Integer> {

}
