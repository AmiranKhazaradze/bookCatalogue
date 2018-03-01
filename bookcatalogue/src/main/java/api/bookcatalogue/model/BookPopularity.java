package api.bookcatalogue.model;

import lombok.Data;

@Data
public class BookPopularity {

    private int id;

    private String name;
    private String author;
    private int popularity;

    public BookPopularity(int id, String name, String author, int popularity) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.popularity = popularity;
    }
}
