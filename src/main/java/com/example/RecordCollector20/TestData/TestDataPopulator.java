package com.example.RecordCollector20.TestData;

import com.example.RecordCollector20.Entities.Record;
import com.example.RecordCollector20.Repositories.RecordRepository;
import com.example.RecordCollector20.Repositories.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class TestDataPopulator {
    private final RecordRepository recordRepository;
    @Autowired
    UserRepository userRepository;

    public TestDataPopulator(RecordRepository recordRepository) {
        this.recordRepository = recordRepository;
    }


    @PostConstruct
    public void populateTestData(){
/*        Record test1 = new Record(userRepository.findById(14L).get(), "Love Gun", "Kiss", "123", "123", "123", "123", "123", "123");
        Record test2 = new Record(userRepository.findById(14L).get(), "Destroyer", "Kiss", "123", "123", "123", "123", "123", "123");
        Record test3 = new Record(userRepository.findById(2L).get(), "Black Album", "Metallica", "123", "123", "123", "123", "123", "123");
        Record test4 = new Record(userRepository.findById(1L).get(), "Love Gun", "Kiss", "123", "123", "123", "123", "123", "123");

        recordRepository.save(test1);
        recordRepository.save(test2);
        recordRepository.save(test3);
        recordRepository.save(test4);*/
      /*  Record test5 = new Record(userRepository.findById(14L).get(), "Cool TestSkiva", "TestArtist", "test", "test", "test", "test", "test");
        recordRepository.save(test5);*/

    }
}
