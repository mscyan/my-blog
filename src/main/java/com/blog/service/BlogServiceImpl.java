package com.blog.service;

import com.alibaba.druid.util.StringUtils;
import com.blog.bean.Blog;
import com.blog.bean.BlogInfo;
import com.blog.bean.Theme;
import com.blog.mapper.BlogMapper;
import com.utils.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("blogService")
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogMapper blogMapper;

    @Override
    public Integer insertOneBlog(Blog blog) {
        return blogMapper.insertBlog(blog);
    }

    @Override
    public List<BlogInfo> getBlogs(int pageSize, int pageNumber, String themeId) {
        List<Blog> blogs = new ArrayList<>();
        if(themeId.equals("blogs")){
            blogs = blogMapper.getBlogs();
        }
        else if(themeId.equals("algorithm")){
            blogs = blogMapper.getAlgorithmBlogs();
        }
        List<BlogInfo> blogInfos = new ArrayList<>();
        for(Blog item : blogs){
            BlogInfo blogInfo = new BlogInfo();
            blogInfo.setCommitDate(item.getCommit_date());
            blogInfo.setContentAbstract(item.getContent_abstract());
            blogInfo.setHtmlContent(item.getHtml_content());
            blogInfo.setReadCount(item.getRead_count());
            blogInfo.setTitle(item.getTitle());
            blogInfo.setId(item.getId());
            blogInfo.setLastUpdateDate(item.getLasted_update_date());

            if(!StringUtils.isEmpty(item.getCover_image())){
                blogInfo.setHasCover(true);
                blogInfo.setCoverImageUrl(item.getCover_image());
            }
            else{
                blogInfo.setHasCover(false);
            }

            List<Theme> themeList = null;
            blogInfo.setThemeList(themeList);

            blogInfos.add(blogInfo);
        }
        return blogInfos;
    }

    @Override
    public List<Blog> getAllBlogs() {
        return blogMapper.getAllBlogs();
    }

    @Override
    public Blog getBlogById(int id) {
        return blogMapper.getBlogById(id);
    }

    @Override
    public Integer updateBlog(Blog blog) {
        return blogMapper.updateBlog(blog);
    }

    @Override
    public ResponseData deleteBlogById_unreal(int id) {
        return null;
    }

    @Override
    public ResponseData deleteBlogById_real(int id) {
        return null;
    }
}
