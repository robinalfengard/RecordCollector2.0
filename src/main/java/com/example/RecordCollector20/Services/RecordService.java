package com.example.RecordCollector20.Services;

import com.example.RecordCollector20.Entities.Record;
import com.example.RecordCollector20.Entities.User;
import com.example.RecordCollector20.Repositories.RecordRepository;
import com.example.RecordCollector20.Repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
public class RecordService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    RecordRepository recordRepository;

    // Get records by userID
    public ResponseEntity<List<Record>> getRecords(Long id){
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()){
            return ResponseEntity.ok(recordRepository.findAllByUserId(id));
        }
        return ResponseEntity.noContent().build();
    }

    // Save Record OLD
    public ResponseEntity<Record> save(Long id, String albumName, String artist, String thumb, String idFromApi, String released, String country, String genre ){
        return ResponseEntity.ok(recordRepository.save(new Record(userRepository.findById(id).get(), albumName, artist, thumb, idFromApi, released, country, genre)));
    }

    // Save record by sending a record body with JSON
    public ResponseEntity<String> saveByBody(Record record){
        Long userId = Long.parseLong(record.getUserIdForConstructor());
        User user = userRepository.findById(userId).orElseThrow(() -> new NoSuchElementException("User not found"));
        Record newRecord = new Record(user, record.getAlbumName(), record.getArtist(), record.getThumb(), record.getIdFromApi(), record.getReleased(), record.getCountry(), record.getGenre());
        recordRepository.save(newRecord);
        return  ResponseEntity.ok("Record saved successfully");
    }


    // Delete Record
    public ResponseEntity<String> deleteRecord(Long id, String idFromApi){
        User user = userRepository.findById(id).get();
           List<Record> list = recordRepository.findAllByUserId(id);
           for (Record record : list){
               if (record.getIdFromApi().equals(idFromApi)){
                   recordRepository.delete(record);
                   return new ResponseEntity<>("Record with ID " + id + " has been deleted.", HttpStatus.OK);
               }
           }
        return ResponseEntity.notFound().build();
    }


    // Check if record saved
    public ResponseEntity<Boolean> isPresent(Long userId, String idFromApi){
        List<Record> userRecords = recordRepository.findAllByUserId(userId);
        boolean isPresent = false;
        for (Record record : userRecords){
            isPresent = record.getIdFromApi().equals(idFromApi);
            if(isPresent){
                break;
            }
        }
        return ResponseEntity.ok(isPresent);
    }



}
