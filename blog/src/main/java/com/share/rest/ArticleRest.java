package com.share.rest;

import com.mysql.cj.util.StringUtils;
import com.share.entity.ArticleImageRequest;
import com.share.entity.ArticleStation;
import com.share.entity.BaseJsonResponse;
import com.share.service.ArticleService;
import com.sun.istack.internal.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.annotation.MultipartConfig;
import java.util.Date;

@RestController
@RequestMapping("/api")
@ResponseBody
public class ArticleRest extends BaseController {

    @Autowired
    private ArticleService articleService;

    @GetMapping("test")
    public ArticleStation test(){
        return articleService.selectByPrimaryKey(1L);
    }

    @PostMapping("article/add")
    public BaseJsonResponse addArticle(ArticleStation article) {
        if (article == null || StringUtils.isNullOrEmpty(article.getArticleTitle())
                || StringUtils.isNullOrEmpty(article.getUserName()) )
            throw new RuntimeException("Can't input empty content.");

        if (article.getArticlePublishTime() == null)
            article.setArticlePublishTime(new Date());

        Integer result = articleService.insertSelective(article);
        if (result != 0)
            throw new RuntimeException("Server internal error, please contact our engineer.");

        return new BaseJsonResponse();
    }

    @PostMapping(value = "/article/image/add", consumes = {"multipart/form-data"})
    public BaseJsonResponse addImageInArticle(
            @RequestPart("files") MultipartFile[] files,
            @RequestParam("userName") String userName
    ) {
        return new BaseJsonResponse();
    }
}
