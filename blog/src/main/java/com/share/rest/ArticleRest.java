package com.share.rest;

import com.mysql.cj.util.StringUtils;
import com.share.common.CommonEnum;
import com.share.entity.dao.ArticleStation;
import com.share.entity.BaseJsonResponse;
import com.share.entity.response.ImageInsertResponse;
import com.share.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
@ResponseBody
public class ArticleRest extends BaseController {

    @Value("${system.static.files.path}")
    private String filePath;

    @Value("${system.static.files.headPortrait}")
    private String headPortrait;

    @Autowired
    private ArticleService articleService;

    @GetMapping("test")
    public ArticleStation test() {
        return articleService.selectByPrimaryKey(1L);
    }

    @PostMapping("article/add")
    public BaseJsonResponse addArticle(ArticleStation article) {
        if (article == null || StringUtils.isNullOrEmpty(article.getArticleTitle())
                || StringUtils.isNullOrEmpty(article.getUserName()))
            throw new RuntimeException("Can't input empty content.");

        if (article.getArticlePublishTime() == null)
            article.setArticlePublishTime(new Date());

        Integer result = articleService.insertSelective(article);
        if (result != 0)
            throw new RuntimeException(CommonEnum.SERVER_INTERNAL_ERROR.getMessage());

        return new BaseJsonResponse();
    }

    @PostMapping(value = "/article/image/add", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ImageInsertResponse addImageInArticle(
            @RequestParam("files") MultipartFile[] files,
            @RequestParam(value = "userName", required = false) String userName,
            @RequestParam(value = "title", required = false) String title
    ) throws IOException {
        if (files == null || files.length == 0 || StringUtils.isNullOrEmpty(userName) || StringUtils.isNullOrEmpty(title))
            throw new RuntimeException(CommonEnum.NO_CORRECT_INPUT.getMessage());

        List<String> list = new ArrayList<>();
        int i = 1;
        for (MultipartFile file : files) {
            String imageSuffix = file.getOriginalFilename();
            if (!imageSuffix.contains(".") && !imageSuffix.endsWith("bmp") && !imageSuffix.endsWith("gif")
                    && !imageSuffix.endsWith("jpeg") && !imageSuffix.endsWith("png") && !imageSuffix.endsWith("psd")
                    && !imageSuffix.endsWith("swf")&& !imageSuffix.endsWith("svg") && !imageSuffix.endsWith("cdr"))
                throw new RuntimeException(CommonEnum.NO_CORRECT_IMAGE_SUFFIX.getMessage());

            String[] suffix = imageSuffix.split("\\.");
            String path = filePath + "/" + userName + "/" + title + "/" + i + "." + suffix[suffix.length - 1];
            list.add(request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
                    + "/static" + "/" + userName + "/" + title + "/" + i + "." + suffix[suffix.length - 1]);
            File f = new File(path);
            if (f.getParentFile() != null && !f.getParentFile().exists())
                f.getParentFile().mkdirs();

            f.createNewFile();
            InputStream is = file.getInputStream();
            FileOutputStream fos = new FileOutputStream(f);
            byte[] b = new byte[1024];
            int length;
            while ((length = is.read(b)) > 0)
                fos.write(b);

            fos.flush();
            fos.close();
            is.close();

            i++;
        }
        ImageInsertResponse response = new ImageInsertResponse();
        response.setCode(0);
        response.setList(list);
        return response;
    }

    @PostMapping(value = "/headPortrait/userName/add", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ImageInsertResponse addHeadPortrait(
            @RequestParam("files") MultipartFile[] files,
            @RequestParam(value = "userName", required = false) String userName
    )throws IOException {
        return this.addImageInArticle(files,userName,"HeadPortrait" + headPortrait);
    }

}
