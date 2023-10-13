package com.kroll;

public class DVD {
    private final String title;
    private final String director;
    private final String releaseYear;
    private String identifier;

    public DVD(String title, String director, String releaseYear) {
        this.title = title;
        this.director = director;
        this.releaseYear = releaseYear;
    }

    public String getTitle() {
        return title;
    }

    public String getDirector() {
        return director;
    }

    public String getReleaseYear() {
        return releaseYear;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    @Override
    public String toString() {
        return String.format("Назва: %s. Режисер: %s. Рік випуску: %s. Ідентифікатор: %s", title, director, releaseYear, identifier);
    }
}
