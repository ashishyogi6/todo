package com.learnyogi.springboot.myfirstwebapp.todo;

import jakarta.validation.Valid;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Controller
@SessionAttributes("name")
public class TodoControllerJpa {
    private TodoService todoService;
    private TodoRepository todoRepository;

    public TodoControllerJpa(TodoService todoService, TodoRepository todoRepository) {
        this.todoService = todoService;
        this.todoRepository = todoRepository;
    }

    @RequestMapping("todos")
    public String listTodos(ModelMap modelMap){
        String username= getOurUsername();
        List<Todo> todos=todoRepository.findByUsername(username);
        modelMap.addAttribute("todos",todos);
        return "listTodos";
    }

    private String getOurUsername() {
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }

    @RequestMapping("delete-todo")
    public String deleteTodo(@RequestParam int id){
        todoRepository.deleteById(id);
        //todoService.deleteById(id);
        return "redirect:todos";
    }

    @RequestMapping(value = "update-todo",method = RequestMethod.GET)
    public String updateTodo(@RequestParam int id, ModelMap modelMap){
        //Todo uptodo=todoService.findById(id);
        Todo uptodo=todoRepository.findById(id).get();
        modelMap.addAttribute("todo",uptodo);
        return "todo";
    }

    @RequestMapping(value = "update-todo",method = RequestMethod.POST)
    public String updateMoveToTodo(ModelMap modelMap,@Valid Todo todo,BindingResult result){
        if(result.hasErrors()) return "todo";
        String username=getOurUsername();
        todo.setUsername(username);
        //todoService.updateTodo(todo);
        todoRepository.save(todo);
        return "redirect:todos";
    }

    @RequestMapping(value = "add-todos",method = RequestMethod.GET)
    public String getNewTodoPage(ModelMap modelMap){
        Todo todo= new Todo(0,(String) modelMap.get("name"),"",LocalDate.now(),false,
                LocalTime.now());
        modelMap.put("todo",todo);
        return "todo";
    }

    @RequestMapping(value = "add-todos",method = RequestMethod.POST)
    public String postNewTodoPage(ModelMap modelMap, @Valid Todo todo, BindingResult result){
        if(result.hasErrors()){
            return "todo";
        }
        todo.setUsername(getOurUsername());
        todoRepository.save(todo);
//        todoService.addTodo((String)modelMap.get("name"),todo.getDescription(), todo.getTargetDate(),
//                    false, todo.getRemainingTime());
        return "redirect:todos";
    }
}
