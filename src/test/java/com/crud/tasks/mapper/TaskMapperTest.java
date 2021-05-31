package com.crud.tasks.mapper;

import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TaskMapperTest {

    @Autowired
    TaskMapper taskMapper;

    @Test
    void mapToTask() {
        //Given
        TaskDto taskDto = new TaskDto(1L, "testTitle", "TestContent");

        //When
        Task result = taskMapper.mapToTask(taskDto);

        //Then
        assertEquals(1L, result.getId());
        assertEquals("testTitle", result.getTitle());
    }

    @Test
    void mapToTaskDto() {
        //Given
        Task task = new Task(1L, "Title", "Content");

        //When
        TaskDto result = taskMapper.mapToTaskDto(task);

        //Then
        assertEquals(1L, result.getId());
        assertEquals("Title", result.getTitle());
    }

    @Test
    void mapToTaskDtoList() {
        //Given
        Task task = new Task(1L, "Title", "Content");
        Task task2 = new Task(2L, "Title2", "Content2");
        List<Task> list = new ArrayList<>();
        list.add(task);
        list.add(task2);
        //When
        List<TaskDto> resultList = taskMapper.mapToTaskDtoList(list);

        //Then
        assertEquals(2, resultList.size());
    }
}