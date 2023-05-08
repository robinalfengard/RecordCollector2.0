package com.example.RecordCollector20.Entities;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Optional;


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
    @Column(name = "SMALL_IMG_URL")
    String smallImageUrl;
    @Column(name = "MEDIUM_IMG_URL")
    String mediumImageUrl;

    @Column(name = "LARGE_IMG_URL")
    String largeImageUrl;

    @Column(name = "URL_TO_HOMEPAGE")
    String urlToHomepage;

    @Column(name = "ID_FROM_API")
    String idFromApi;

    @Column(name = "STREAMABLE")
    String streamable;

    @Column(name = "YEAR")
    String year;


    public Record(User user, String name, String artist, String smallImageUrl, String mediumImageUrl, String largeImageUrl, String urlToHomepage, String idFromApi, String streamable) {
        this.user = user;
        this.albumName = name;
        this.artist = artist;
        this.smallImageUrl = smallImageUrl;
        this.mediumImageUrl = mediumImageUrl;
        this.largeImageUrl = largeImageUrl;
        this.urlToHomepage = urlToHomepage;
        this.idFromApi = idFromApi;
        this.streamable = streamable;
    }
}


