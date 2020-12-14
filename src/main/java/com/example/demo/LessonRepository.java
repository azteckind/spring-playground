package com.example.demo;

import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface LessonRepository extends CrudRepository<Lesson, Long> {

   void findByTitle(String title);
   List<Lesson> findBetweenDates(Date localDate1, Date localDate2);
}
