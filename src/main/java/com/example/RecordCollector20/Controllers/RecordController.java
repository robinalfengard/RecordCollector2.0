package com.example.RecordCollector20.Controllers;
import com.example.RecordCollector20.Entities.Record;
import com.example.RecordCollector20.Repositories.RecordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/record")
@RequiredArgsConstructor
public class RecordController {
    @Autowired RecordRepository recordRepository;


    @GetMapping("/myrecords/{id}")
    ResponseEntity<List<Record>> myRecords(@PathVariable Long id){
        return new ResponseEntity<>(recordRepository.findAllByUserId(id), HttpStatus.OK);
    }

    @PostMapping("/save")
      ResponseEntity<Record>  save(@RequestBody Record record){
            return new ResponseEntity<>(recordRepository.save(record), HttpStatus.OK);
        }

    @DeleteMapping("/delete/{id}")
    ResponseEntity<Record> deleteRecord(@PathVariable Long id){
        Optional<Record> record = recordRepository.findById(id);
        if (record.isPresent()) {
            recordRepository.deleteById(id);
        }
        return ResponseEntity.noContent().build();
    }






}
