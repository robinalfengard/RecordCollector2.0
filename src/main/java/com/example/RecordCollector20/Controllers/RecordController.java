package com.example.RecordCollector20.Controllers;
import com.example.RecordCollector20.Entities.Record;
import com.example.RecordCollector20.Entities.User;
import com.example.RecordCollector20.Repositories.RecordRepository;
import com.example.RecordCollector20.Repositories.UserRepository;
import com.example.RecordCollector20.Services.RecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import java.util.List;
import java.util.Optional;



@RestController
@RequestMapping("/api/record")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE})
@RequiredArgsConstructor
public class RecordController {

    @Autowired
    RecordService recordService;
    private final UserRepository userRepository;

    @GetMapping("/{id}/records")
    public ResponseEntity<List<Record>> getRecords(@PathVariable Long id){
        return recordService.getRecords(id);
    }

/*    @PostMapping("/savetest/{id}/{albumname}/{artist}")
    public ResponseEntity<Record> saveTest(@PathVariable Long id, @PathVariable String albumname, @PathVariable String artist){
       return recordService.savetest(id, albumname, artist);
    }*/


    @PostMapping("/save/{id}/{albumName}/{artist}/{thumb}/{idFromApi}/{released}/{country}/{genre}")
     public ResponseEntity<Record> save(@PathVariable Long id, @PathVariable String albumName, @PathVariable String artist, @PathVariable String thumb,@PathVariable String idFromApi,@PathVariable String released,@PathVariable String country,@PathVariable String genre){
        return recordService.save(id, albumName, artist, thumb, idFromApi, released, country, genre);
        }

        // Don't work
    @PostMapping("/savebody")
    public ResponseEntity<String> saveBody(Record record){
        recordService.save(record.getUser().getId(), record.getAlbumName(), record.getArtist(), record.getThumb(), record.getIdFromApi(), record.getReleased(), record.getCountry(), record.getGenre());
        return ResponseEntity.ok("Record saved successfully");
    }

    @DeleteMapping("/delete/{id}/{idFromApi}")
    ResponseEntity<String> deleteRecord(@PathVariable Long id, @PathVariable String idFromApi){
        return recordService.deleteRecord(id, idFromApi);
    }


    // not found
    @GetMapping("/check/{id}/{idFromApi}")
    public ResponseEntity<Boolean> isPresent(@PathVariable Long id,@PathVariable String idFromApi){
        return recordService.isPresent(id, idFromApi);
    }





}
