package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@RestController
@RequestMapping("/lessons")
public class LessonsController {

    private final LessonRepository repository;

    public LessonsController(LessonRepository repository) {
        this.repository = repository;
    }

    @GetMapping("")
    public Iterable<Lesson> all() {
        return this.repository.findAll();
    }

    @PostMapping("")
    public Lesson create(@RequestBody Lesson lesson) {
        return this.repository.save(lesson);
    }

    @GetMapping("/{id}")
    public Optional<Lesson> findingByID(@PathVariable int id) {
        Long newId = (long) id;
        return this.repository.findById(newId);
    }

    @DeleteMapping("/{id}")
    public void deletingByID(@PathVariable Long id) {
        this.repository.deleteById(id);
    }

    @PatchMapping("/{id}")
    public Optional<Lesson> updatingLesson(@PathVariable Long id, @RequestBody Lesson lesson) {
        Optional<Lesson> oldLesson = this.repository.findById(id);
        oldLesson.ifPresent(value -> {
            value.setTitle(lesson.getTitle());
            value.setDeliveredOn(lesson.getDeliveredOn());
            this.repository.save(value);
        });
        return oldLesson;
    }

    @GetMapping("/find/{title}")
    public void findingByTitle(@PathVariable String title) {
        this.repository.findByTitle(title);
    }

    @GetMapping("/between")
    public List<Lesson> findingInBetween(@RequestParam String date1, @RequestParam String date2) throws ParseException {
        SimpleDateFormat formattedDate = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
        Date localDate1 = formattedDate.parse(date1);
        Date localDate2 = formattedDate.parse(date2);

        return this.repository.findBetweenDates(localDate1, localDate2);
    }

}
