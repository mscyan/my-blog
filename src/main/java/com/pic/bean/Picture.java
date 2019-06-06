package com.pic.bean;

public class Picture {

    private int id;
    private String pic_path;
    private String given_uri;
    private int fetch_count;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPic_path() {
        return pic_path;
    }

    public void setPic_path(String pic_path) {
        this.pic_path = pic_path;
    }

    public String getGiven_uri() {
        return given_uri;
    }

    public void setGiven_uri(String given_uri) {
        this.given_uri = given_uri;
    }

    public int getFetch_count() {
        return fetch_count;
    }

    public void setFetch_count(int fetch_count) {
        this.fetch_count = fetch_count;
    }

    public Picture(String pic_path, String given_uri, int fetch_count) {
        this.pic_path = pic_path;
        this.given_uri = given_uri;
        this.fetch_count = fetch_count;
    }
}
