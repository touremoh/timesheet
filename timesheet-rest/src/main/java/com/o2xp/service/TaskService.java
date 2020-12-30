package com.o2xp.service;

import com.o2xp.model.Task;
import com.o2xp.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TaskService implements TimesheetService<Task> {

    private final TaskRepository taskRepository;

    @Override
    public List<Task> findAll() {
        return this.taskRepository.findAll();
    }

    @Override
    public Optional<Task> findById(Long id) {
        return this.taskRepository.findById(id);
    }

    @Override
    public Task save(Task task) {
        return this.taskRepository.save(task);
    }

    @Override
    public void delete(Long id) {
        this.taskRepository.deleteById(id);
    }

    @Override
    public Task update(Long id, Task newTask) {
        Optional<Task> optionalTask = this.findById(id);

        if (optionalTask.isPresent()) {
            Task task = optionalTask.get();
            if (newTask.hasName()) {
                task.setName(newTask.getName());
            }
            task.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
            return this.taskRepository.save(task);
        }
        return null;
    }
}
