package com.blog.bean;

import java.util.Date;

public class TempBlog
{
    private int blog_id;
    private String blog_title;
    private String blog_content;
    private String blog_desc;
    Date start_date;

    public int getBlog_id() {
        return blog_id;
    }

    public void setBlog_id(int blog_id) {
        this.blog_id = blog_id;
    }

    public String getBlog_title() {
        return blog_title;
    }

    public void setBlog_title(String blog_title) {
        this.blog_title = blog_title;
    }

    public String getBlog_content() {
        return blog_content;
    }

    public void setBlog_content(String blog_content) {
        this.blog_content = blog_content;
    }

    public String getBlog_desc() {
        return blog_desc;
    }

    public void setBlog_desc(String blog_desc) {
        this.blog_desc = blog_desc;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }
}
