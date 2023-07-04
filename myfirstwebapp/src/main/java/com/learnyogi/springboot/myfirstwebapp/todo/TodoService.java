package com.learnyogi.springboot.myfirstwebapp.todo;

import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
public class TodoService {

    private static List<Todo> todos = new ArrayList<>();
    private static int count=0;

    static{
        todos.add(new Todo(++count,"yogiji","learn AWS 1", LocalDate.now().plusMonths(3),
                false, LocalTime.now().plusMinutes(60))) ;
        todos.add(new Todo(++count,"yogiji","learn ML 1", LocalDate.now().plusMonths(6),
                false, LocalTime.now().plusMinutes(60))) ;
        todos.add(new Todo(++count,"yogiji","learn Devops 1", LocalDate.now().plusMonths(9),
                false, LocalTime.now().plusMinutes(60))) ;
    }

    public void addTodo(String username,String description,LocalDate targetDate,boolean done,LocalTime targetTime){
        Todo todo = new Todo(++count,username,description,targetDate,done,targetTime);
        todos.add(todo);
    }

    public Todo findById(int id){
        Predicate<? super Todo> predicate=todo -> todo.getId()==id;
        Todo todo= todos.stream().filter(predicate).findFirst().get();
        return todo;
    }

    public void deleteById(int id){
        Predicate<? super Todo> predicate=todo->todo.getId()==id;
        todos.removeIf(predicate);
        --count;
    }

    public void updateTodo(@Valid Todo todo){
        deleteById(todo.getId());
        todos.add(todo);
    }

    public List<Todo> findByUsername(String username){
        Predicate<? super Todo> predicate=todo->todo.getUsername().equalsIgnoreCase(username);
        return todos.stream().filter(predicate).toList();
    }
}

