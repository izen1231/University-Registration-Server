package com.registration.university.api

import com.sun.istack.internal.logging.Logger
import org.hibernate.bytecode.BytecodeLogger.LOGGER
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*
import javax.persistence.Id

@RestController
@RequestMapping("/todos")
class TodoController(val todoRepository: TodoRepository){
    @GetMapping
    fun getTodos() = todoRepository.findAll()

    @RequestMapping(path = ["/{todoId}"], method = [RequestMethod.GET])
    fun getTodo(@PathVariable("todoId")todoId: Long): Optional<Todo>?{
        return todoRepository.findById(todoId)
    }

    @PostMapping
    fun newTodo(@RequestBody todo: Todo): Todo {
        todoRepository.save(todo)
        return todo
    }

    @RequestMapping(path = ["/{todoId}"], method = [RequestMethod.PUT])
    @ResponseStatus(HttpStatus.OK)
    fun updateTodo(@RequestBody todo: Todo, @PathVariable("todoId") todoId: Long): Optional<Todo> {
        var target: Todo = todoRepository.findById(todoId).get()
        target.title = todo.title
        target.description = todo.description
        target.finished = todo.finished

        todoRepository.save(target)
        return todoRepository.findById(todoId)
    }

    @RequestMapping(path = ["/{todoId}"], method = [RequestMethod.DELETE])
    fun deleteTodo(@PathVariable("todoId")todoId: Long): ResponseEntity<String> {
        todoRepository.deleteById(todoId)

        return ResponseEntity.ok("Entity deleted");

    }
}



