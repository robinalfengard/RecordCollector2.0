package com.example.RecordCollector20.Repositories;

import com.example.RecordCollector20.Entities.Record;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecordRepository extends JpaRepository<Record, Long> {


    List<Record> findAllByUserId(Long id);
}
