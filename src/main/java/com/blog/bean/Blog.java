package com.blog.bean;

public class Blog {

    private Integer id;
    private int theme_id;
    private String title;
    private String content_abstract;
    private String markdown_content;
    private String html_content;
    private String commit_date;
    private String lasted_update_date;
    private String cover_image;
    private int read_count;
    private int readable;

    public String getMarkdown_content() {
        return markdown_content;
    }

    public void setMarkdown_content(String markdown_content) {
        this.markdown_content = markdown_content;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public String getHtml_content() {
        return html_content;
    }

    public void setHtml_content(String html_content) {
        this.html_content = html_content;
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

    public int getReadable() {
        return readable;
    }

    public void setReadable(int readable) {
        this.readable = readable;
    }

    public String getCover_image() {
        return cover_image;
    }

    public void setCover_image(String cover_image) {
        this.cover_image = cover_image;
    }
}
