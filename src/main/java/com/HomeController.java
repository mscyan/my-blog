package com;

import com.alibaba.druid.support.json.JSONUtils;
import com.baidu.ueditor.ActionEnter;
import io.swagger.annotations.Api;
import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.util.Streams;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
@Api(value = "Home", description = "Home", tags = "主页")
public class HomeController {

    @RequestMapping(value = "home", method = RequestMethod.GET)
    @ResponseBody
    public String home(){
        return "hello world " + new Date();
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index_default(){
        return "/index.html";
    }

    @RequestMapping(value = "index", method = RequestMethod.GET)
    public String index(){

        return "/index.html";
    }

    @RequestMapping(value = "/ueditor/commonDispatcher")
    @ResponseBody
    public String dispatcher(HttpServletRequest request,
                             MultipartFile file,
                             HttpServletResponse response) {

        String action = request.getParameter("action");

        if(action.equals("uploadFile")){
            Map<String, Object> map = new HashMap<>();
            map.put("state", "SUCCESS") ;
            map.put("original", "abc.jpg") ;
            map.put("size", 12312) ;
            map.put("title", "abc.jpg") ;
            map.put("type", "jpg") ;
            map.put("url", "http://www.jiajiajia.club:8089/a.png") ;


            return JSONUtils.toJSONString(map);
        }

        return "/* 前后端通信相关的配置,注释只允许使用多行方式 */\n" +
                "{\n" +
                "    /* 上传图片配置项 */\n" +
                "    \"imageActionName\": \"uploadFile\", /* 执行上传图片的action名称 */\n" +
                "    \"imageFieldName\": \"upfile\", /* 提交的图片表单名称 */\n" +
                "    \"imageMaxSize\": 2048000, /* 上传大小限制，单位B */\n" +
                "    \"imageAllowFiles\": [\".png\", \".jpg\", \".jpeg\", \".gif\", \".bmp\"], /* 上传图片格式显示 */\n" +
                "    \"imageCompressEnable\": true, /* 是否压缩图片,默认是true */\n" +
                "    \"imageCompressBorder\": 1600, /* 图片压缩最长边限制 */\n" +
                "    \"imageInsertAlign\": \"none\", /* 插入的图片浮动方式 */\n" +
                "    \"imageUrlPrefix\": \"\", /* 图片访问路径前缀 */\n" +
                "    \"imagePathFormat\": \"/ueditor/jsp/upload/image/{yyyy}{mm}{dd}/{time}{rand:6}\", /* 上传保存路径,可以自定义保存路径和文件名格式 */\n" +
                "                                /* {filename} 会替换成原文件名,配置这项需要注意中文乱码问题 */\n" +
                "                                /* {rand:6} 会替换成随机数,后面的数字是随机数的位数 */\n" +
                "                                /* {time} 会替换成时间戳 */\n" +
                "                                /* {yyyy} 会替换成四位年份 */\n" +
                "                                /* {yy} 会替换成两位年份 */\n" +
                "                                /* {mm} 会替换成两位月份 */\n" +
                "                                /* {dd} 会替换成两位日期 */\n" +
                "                                /* {hh} 会替换成两位小时 */\n" +
                "                                /* {ii} 会替换成两位分钟 */\n" +
                "                                /* {ss} 会替换成两位秒 */\n" +
                "                                /* 非法字符 \\ : * ? \" < > | */\n" +
                "                                /* 具请体看线上文档: fex.baidu.com/ueditor/#use-format_upload_filename */\n" +
                "\n" +
                "    /* 涂鸦图片上传配置项 */\n" +
                "    \"scrawlActionName\": \"uploadscrawl\", /* 执行上传涂鸦的action名称 */\n" +
                "    \"scrawlFieldName\": \"upfile\", /* 提交的图片表单名称 */\n" +
                "    \"scrawlPathFormat\": \"/ueditor/jsp/upload/image/{yyyy}{mm}{dd}/{time}{rand:6}\", /* 上传保存路径,可以自定义保存路径和文件名格式 */\n" +
                "    \"scrawlMaxSize\": 2048000, /* 上传大小限制，单位B */\n" +
                "    \"scrawlUrlPrefix\": \"\", /* 图片访问路径前缀 */\n" +
                "    \"scrawlInsertAlign\": \"none\",\n" +
                "\n" +
                "    /* 截图工具上传 */\n" +
                "    \"snapscreenActionName\": \"uploadimage\", /* 执行上传截图的action名称 */\n" +
                "    \"snapscreenPathFormat\": \"/ueditor/jsp/upload/image/{yyyy}{mm}{dd}/{time}{rand:6}\", /* 上传保存路径,可以自定义保存路径和文件名格式 */\n" +
                "    \"snapscreenUrlPrefix\": \"\", /* 图片访问路径前缀 */\n" +
                "    \"snapscreenInsertAlign\": \"none\", /* 插入的图片浮动方式 */\n" +
                "\n" +
                "    /* 抓取远程图片配置 */\n" +
                "    \"catcherLocalDomain\": [\"127.0.0.1\", \"localhost\", \"img.baidu.com\"],\n" +
                "    \"catcherActionName\": \"catchimage\", /* 执行抓取远程图片的action名称 */\n" +
                "    \"catcherFieldName\": \"source\", /* 提交的图片列表表单名称 */\n" +
                "    \"catcherPathFormat\": \"/ueditor/jsp/upload/image/{yyyy}{mm}{dd}/{time}{rand:6}\", /* 上传保存路径,可以自定义保存路径和文件名格式 */\n" +
                "    \"catcherUrlPrefix\": \"\", /* 图片访问路径前缀 */\n" +
                "    \"catcherMaxSize\": 2048000, /* 上传大小限制，单位B */\n" +
                "    \"catcherAllowFiles\": [\".png\", \".jpg\", \".jpeg\", \".gif\", \".bmp\"], /* 抓取图片格式显示 */\n" +
                "\n" +
                "    /* 上传视频配置 */\n" +
                "    \"videoActionName\": \"uploadvideo\", /* 执行上传视频的action名称 */\n" +
                "    \"videoFieldName\": \"upfile\", /* 提交的视频表单名称 */\n" +
                "    \"videoPathFormat\": \"/ueditor/jsp/upload/video/{yyyy}{mm}{dd}/{time}{rand:6}\", /* 上传保存路径,可以自定义保存路径和文件名格式 */\n" +
                "    \"videoUrlPrefix\": \"\", /* 视频访问路径前缀 */\n" +
                "    \"videoMaxSize\": 102400000, /* 上传大小限制，单位B，默认100MB */\n" +
                "    \"videoAllowFiles\": [\n" +
                "        \".flv\", \".swf\", \".mkv\", \".avi\", \".rm\", \".rmvb\", \".mpeg\", \".mpg\",\n" +
                "        \".ogg\", \".ogv\", \".mov\", \".wmv\", \".mp4\", \".webm\", \".mp3\", \".wav\", \".mid\"], /* 上传视频格式显示 */\n" +
                "\n" +
                "    /* 上传文件配置 */\n" +
                "    \"fileActionName\": \"uploadfile\", /* controller里,执行上传视频的action名称 */\n" +
                "    \"fileFieldName\": \"upfile\", /* 提交的文件表单名称 */\n" +
                "    \"filePathFormat\": \"/ueditor/jsp/upload/file/{yyyy}{mm}{dd}/{time}{rand:6}\", /* 上传保存路径,可以自定义保存路径和文件名格式 */\n" +
                "    \"fileUrlPrefix\": \"\", /* 文件访问路径前缀 */\n" +
                "    \"fileMaxSize\": 51200000, /* 上传大小限制，单位B，默认50MB */\n" +
                "    \"fileAllowFiles\": [\n" +
                "        \".png\", \".jpg\", \".jpeg\", \".gif\", \".bmp\",\n" +
                "        \".flv\", \".swf\", \".mkv\", \".avi\", \".rm\", \".rmvb\", \".mpeg\", \".mpg\",\n" +
                "        \".ogg\", \".ogv\", \".mov\", \".wmv\", \".mp4\", \".webm\", \".mp3\", \".wav\", \".mid\",\n" +
                "        \".rar\", \".zip\", \".tar\", \".gz\", \".7z\", \".bz2\", \".cab\", \".iso\",\n" +
                "        \".doc\", \".docx\", \".xls\", \".xlsx\", \".ppt\", \".pptx\", \".pdf\", \".txt\", \".md\", \".xml\"\n" +
                "    ], /* 上传文件格式显示 */\n" +
                "\n" +
                "    /* 列出指定目录下的图片 */\n" +
                "    \"imageManagerActionName\": \"listimage\", /* 执行图片管理的action名称 */\n" +
                "    \"imageManagerListPath\": \"/ueditor/jsp/upload/image/\", /* 指定要列出图片的目录 */\n" +
                "    \"imageManagerListSize\": 20, /* 每次列出文件数量 */\n" +
                "    \"imageManagerUrlPrefix\": \"\", /* 图片访问路径前缀 */\n" +
                "    \"imageManagerInsertAlign\": \"none\", /* 插入的图片浮动方式 */\n" +
                "    \"imageManagerAllowFiles\": [\".png\", \".jpg\", \".jpeg\", \".gif\", \".bmp\"], /* 列出的文件类型 */\n" +
                "\n" +
                "    /* 列出指定目录下的文件 */\n" +
                "    \"fileManagerActionName\": \"listfile\", /* 执行文件管理的action名称 */\n" +
                "    \"fileManagerListPath\": \"/ueditor/jsp/upload/file/\", /* 指定要列出文件的目录 */\n" +
                "    \"fileManagerUrlPrefix\": \"\", /* 文件访问路径前缀 */\n" +
                "    \"fileManagerListSize\": 20, /* 每次列出文件数量 */\n" +
                "    \"fileManagerAllowFiles\": [\n" +
                "        \".png\", \".jpg\", \".jpeg\", \".gif\", \".bmp\",\n" +
                "        \".flv\", \".swf\", \".mkv\", \".avi\", \".rm\", \".rmvb\", \".mpeg\", \".mpg\",\n" +
                "        \".ogg\", \".ogv\", \".mov\", \".wmv\", \".mp4\", \".webm\", \".mp3\", \".wav\", \".mid\",\n" +
                "        \".rar\", \".zip\", \".tar\", \".gz\", \".7z\", \".bz2\", \".cab\", \".iso\",\n" +
                "        \".doc\", \".docx\", \".xls\", \".xlsx\", \".ppt\", \".pptx\", \".pdf\", \".txt\", \".md\", \".xml\"\n" +
                "    ] /* 列出的文件类型 */\n" +
                "\n" +
                "}";
    }

    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> ueUpload(HttpServletRequest request,
                                        HttpServletResponse response,
                                        @PathVariable String appPath) throws IllegalStateException, IOException,
            FileUploadException {

        Map<String, Object> m = new HashMap<String, Object>();
        // 对上传文件夹和临时文件夹进行初始化
        String rootDir = "C:\\projects\\pic";

        String tmpDir = rootDir + "/tmp";
        File tmpDirPath = new File(tmpDir);

        if (ServletFileUpload.isMultipartContent(request)) {
            request.setCharacterEncoding("utf-8");


            DiskFileItemFactory dff = new DiskFileItemFactory();// 创建该对象
            dff.setRepository(tmpDirPath);// 指定上传文件的临时目录
            dff.setSizeThreshold(2 * 1024 * 1024);// 指定在内存中缓存数据大小,单位为byte
            ServletFileUpload sfu = new ServletFileUpload(dff);// 创建该对象
            sfu.setFileSizeMax(1000000000);// 指定单个上传文件的最大尺寸
            sfu.setSizeMax(1000000000);// 指定一次上传多个文件的总尺寸
            FileItemIterator fii = sfu.getItemIterator(request);// 解析request
            // 请求,并返回FileItemIterator集合
            while (fii.hasNext()) {
                FileItemStream fis = fii.next();// 从集合中获得一个文件流
                if (!fis.isFormField() && fis.getName().length() > 0) {// 过滤掉表单中非文件域

                    String filename = fis.getName();

                    String[] FileName = filename.split("\\.");

                    String preFile = FileName[0];
                    String endFile = FileName[1];


                    Date date = new Date();
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
                    String nowdate = sdf.format(date);


                    String newFileName = preFile + "_" + nowdate + "." + endFile;

                    appPath = appPath.trim().replaceAll("\\.", "/");

                    File appDir = new File(rootDir + "/" + appPath);
                    if (!appDir.isDirectory()) {

                        appDir.mkdir();
                    }
                    // 创建按月分类的子文件夹
                    String currentMonth = "sdf"; //new DateUnit().getTheFormatDate(new Date(), "yyyyMM");
                    File appSubDir = new File(appDir + "/" + currentMonth);
                    if (!appSubDir.isDirectory()) {
                        appSubDir.mkdir();
                    }

                    String newFilepath = appSubDir + "/" + newFileName;

                    BufferedInputStream in = new BufferedInputStream(fis.openStream());// 获得文件输入流
                    BufferedOutputStream out =
                            new BufferedOutputStream(new FileOutputStream(new File(newFilepath)));// 获得文件输出流
                    Streams.copy(in, out, true);// 开始把文件写到你指定的上传文件夹
                    m.put("path", appPath + "/" + currentMonth + "/");
                    m.put("filename", newFileName);

                    m.put("original", filename);
                    m.put("name", newFileName);
                    m.put("url", appPath + "/" + currentMonth + "/"+newFileName);
                    m.put("state", "SUCCESS");
                    m.put("type", ".jpg");
                    m.put("size", "99697");

                }
            }
        }

        return m;
    }

    public static void main(String[] args){
        //;
    }
}
