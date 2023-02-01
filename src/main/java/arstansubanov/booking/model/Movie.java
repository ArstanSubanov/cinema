package arstansubanov.booking.model;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "tb_movie")
public class Movie {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "age_rating")
    private String ageRating;

    @Column(name = "movie_rating")
    private String movieRating;

    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Column(name = "image")
    private String image;

    @Column(name = "active")
    private boolean active;

    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL)
    private List<MovieSession> movieSessions;
}
