package com.crud.tasks.controller;

import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import com.crud.tasks.mapper.TaskMapper;
import com.crud.tasks.service.DbService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController()
@RequestMapping("/v1/tasks")
@RequiredArgsConstructor
public class TaskController {

    private final DbService service;
    private final TaskMapper taskMapper;


    @GetMapping
    public List<TaskDto> getTasks() {
        List<Task> tasks = service.getAllTasks();
        return taskMapper.mapToTaskDtoList(tasks);
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

    @GetMapping("/{taskId}")
    public TaskDto getTaskById(@PathVariable Long taskId){
        Task task = service.getTaskById(taskId);
        return taskMapper.mapToTaskDto(task);
    }
}
