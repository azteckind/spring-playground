package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/lessons")
public class LessonsController {

    private final LessonRepository repository;

    public LessonsController(LessonRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/{id}")
    public Optional<Lesson> show(@PathVariable int id) {
        Long newId = (long) id;
        return this.repository.findById(newId);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        this.repository.deleteById(id);
    }

    @GetMapping("")
    public Iterable<Lesson> all() {
        return this.repository.findAll();
    }

    @PostMapping("")
    public Lesson create(@RequestBody Lesson lesson) {
        return this.repository.save(lesson);
    }

    @PatchMapping("/{id}")
    public Lesson patch(@PathVariable Long id, @RequestBody Lesson lesson) {
        Lesson oldLesson = this.repository.findById(id).get();
        lesson.setId(oldLesson.getId());
        return this.repository.save(lesson);
    }

}
