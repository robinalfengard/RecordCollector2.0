package com.example.RecordCollector20.Entities;
import com.example.RecordCollector20.Repositories.UserRepository;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;




@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "RECORD")
public class Record   {


    @Column(name = "ID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    User user;

    @Column(name = "ALBUM_NAME")
    String albumName;
    @Column(name = "ARTIST")
    String artist;
    @Column(name = "THUMB")
    String thumb;

    @Column(name = "ID_FROM_API")
    String idFromApi;

    @Column(name = "RELEASED")
    String released;

    @Column(name = "COUNTRY")
    String country;

    @Column(name = "GENRE")
    String genre;


    public Record(User user, String albumName, String artist, String thumb, String idFromApi, String released, String country, String genre) {
        this.user = user;
        this.albumName = albumName;
        this.artist = artist;
        this.thumb = thumb;
        this.idFromApi = idFromApi;
        this.released = released;
        this.country = country;
        this.genre = genre;
    }




    public Record(User user, String albumName, String artist){
        this.user = user;
        this.albumName = albumName;
        this.artist = artist;
    }



}


