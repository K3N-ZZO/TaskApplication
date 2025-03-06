package com.crud.tasks.controller;

import com.crud.tasks.domain.TaskDto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController()
@RequestMapping("/v1/tasks")
public class TaskController {

    @GetMapping
    public List<TaskDto> getTasks(){
        return new ArrayList<>();
    }

    @GetMapping
    public TaskDto getTask(Long taskId){
        return new TaskDto(1L,"TEST TITLE","Test_concent");
    }

    @DeleteMapping
    public void deleteTask(Long taskId){

    }

    @PutMapping
    public TaskDto updateTask(TaskDto taskDto){
        return new TaskDto(1L,"EDITED TEST TITLE","Test_concent");
    }

    @PostMapping
    public void createTask(TaskDto taskDto){

    }
}
