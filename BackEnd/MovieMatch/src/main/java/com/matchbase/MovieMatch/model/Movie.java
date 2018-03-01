package com.matchbase.MovieMatch.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;
import java.util.List;

@Entity
public class Movie {

    @Id
    private int id;
    @Column
    private String title;
    @Column
    private Date releaseDate;
//    @Column
//    private List<String> genreList;
    @Column
    private String posterPath;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    /*public List<String> getGenreList() {
        return genreList;
    }

    public void setGenreList(List<String> genreList) {
        this.genreList = genreList;
    }*/

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }
}
