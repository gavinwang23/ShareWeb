package com.share.rest;

import com.mysql.cj.util.StringUtils;
import com.share.common.CommonEnum;
import com.share.entity.dao.ArticleStation;
import com.share.entity.BaseJsonResponse;
import com.share.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.Date;

@RestController
@RequestMapping("/api")
@ResponseBody
public class ArticleRest extends BaseController {

    @Value("${system.static.files.path}")
    private String filePath;

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
    public BaseJsonResponse addImageInArticle(
            @RequestParam("files") MultipartFile[] files,
            @RequestParam(value = "userName", required = false) String userName,
            @RequestParam(value = "title", required = false) String title
    ) throws IOException {
        if (files == null || files.length == 0 || StringUtils.isNullOrEmpty(userName) || StringUtils.isNullOrEmpty(title))
            throw new RuntimeException(CommonEnum.NO_VERIFY_CODE.getMessage());

        for (MultipartFile file : files) {
            String path = filePath + "/" + file.getOriginalFilename();
            File f = new File(path);
            if (StringUtils.isNullOrEmpty(f.getParent()))
                f.mkdirs();

            f.createNewFile();
            InputStream is = file.getInputStream();
            FileOutputStream fos = new FileOutputStream(f);
            byte[] b = new byte[1024];
            int length;
            while ((length = is.read(b)) > 0)
                fos.write(b);

            is.close();
            fos.flush();
            fos.close();
        }
        return new BaseJsonResponse();
    }
}
