package com.mysite.todo;

import java.time.LocalTime;
import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class toDoListService {

    private final toDoListRepository toDoListRepository;

    public List<toDoList> getList() {
        return this.toDoListRepository.findAll();
    }
    public void create(String content) {
        toDoList q = new toDoList();
        q.setComplete(false);
        q.setContent(content);
        q.setCreateDate(LocalTime.now());
        this.toDoListRepository.save(q);
    }
    public void delete(Integer id) {
        this.toDoListRepository.deleteById(id);
    }
}