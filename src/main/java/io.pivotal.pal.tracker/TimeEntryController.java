package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/time-entries")
public class TimeEntryController {

    @Autowired
    TimeEntryRepository timeEntryRepository;

    public TimeEntryController() {
    }

    public TimeEntryController(TimeEntryRepository timeEntryRepository) {

        this.timeEntryRepository = timeEntryRepository;
    }


    @PutMapping("{id}")
    public ResponseEntity<TimeEntry> update(@PathVariable("id") long timeEntryId, @RequestBody TimeEntry expected) {

        TimeEntry timeentry = timeEntryRepository.update(timeEntryId, expected);
        if (timeentry != null) {
            return new ResponseEntity<TimeEntry>(timeentry, new HttpHeaders(), HttpStatus.OK);
        }
        return new ResponseEntity<>(new HttpHeaders(), HttpStatus.NOT_FOUND);

    }

    @PostMapping
    public ResponseEntity<TimeEntry> create(@RequestBody TimeEntry timeEntryToCreate) {

        return new ResponseEntity<TimeEntry>(timeEntryRepository.create(timeEntryToCreate), new HttpHeaders(), HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<TimeEntry> read(@PathVariable("id") long timeEntryId) {
        TimeEntry timeentry = timeEntryRepository.find(timeEntryId);
        if (timeentry != null) {
            return new ResponseEntity<TimeEntry>(timeentry, new HttpHeaders(), HttpStatus.OK);
        }
        return new ResponseEntity<>(new HttpHeaders(), HttpStatus.NOT_FOUND);
    }

    @GetMapping
    public ResponseEntity<List<TimeEntry>> list() {

        return new ResponseEntity<>( timeEntryRepository.list(), new HttpHeaders(), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable("id") long timeEntryId) {

        timeEntryRepository.delete(timeEntryId);
        return new ResponseEntity<>( new HttpHeaders(), HttpStatus.NO_CONTENT);

    }
}
