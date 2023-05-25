package com.example.RecordCollector20;

import com.example.RecordCollector20.Controllers.RecordController;
import com.example.RecordCollector20.Entities.Record;
import com.example.RecordCollector20.Entities.User;
import com.example.RecordCollector20.Repositories.RecordRepository;
import com.example.RecordCollector20.Repositories.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ApplicationTests {
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RecordRepository recordRepository;

	@Autowired
	private RecordController recordController;

	@Test
	void contextLoads() {
	}

	@Test
	void getIdByEmail(){
		User user = userRepository.findByEmail("test@test.se").get();
		Long userId = user.getId();
		Assertions.assertEquals(userId, 14L);
	}

	@Test
	void getByFirstname(){
		User user = userRepository.findByFirstName("testuser").get();
		Long userId = user.getId();
		Assertions.assertEquals(userId, 14L);

	}

	@Test
	void addRecord(){
		int numberOfRecords = recordRepository.findAll().size();
		recordRepository.save(new Record(userRepository.findById(1L).get(), "Axis Bold As Love", "Jimi Hendrix"));
		Assertions.assertEquals(recordRepository.findAll().size(), numberOfRecords+1);
	}

	@Test
	void checkRecord(){


	}





}
