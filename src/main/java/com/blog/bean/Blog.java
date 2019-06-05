package com.blog.bean;

public class Blog {

    private int id;
    private int theme_id;
    private String title;
    private String content_abstract;
    private String content;
    private String commit_date;
    private String lasted_update_date;
    private int read_count;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTheme_id() {
        return theme_id;
    }

    public void setTheme_id(int theme_id) {
        this.theme_id = theme_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent_abstract() {
        return content_abstract;
    }

    public void setContent_abstract(String content_abstract) {
        this.content_abstract = content_abstract;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCommit_date() {
        return commit_date;
    }

    public void setCommit_date(String commit_date) {
        this.commit_date = commit_date;
    }

    public String getLasted_update_date() {
        return lasted_update_date;
    }

    public void setLasted_update_date(String lasted_update_date) {
        this.lasted_update_date = lasted_update_date;
    }

    public int getRead_count() {
        return read_count;
    }

    public void setRead_count(int read_count) {
        this.read_count = read_count;
    }
}
