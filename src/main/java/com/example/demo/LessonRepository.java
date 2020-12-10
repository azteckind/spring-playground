package com.example.demo;

import org.springframework.data.repository.CrudRepository;

public interface LessonRepository extends CrudRepository<Lesson, Long> {

    Iterable<Lesson> findAll();

    Lesson save(Lesson lesson);
}
