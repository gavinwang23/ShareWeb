package com.share.rest;

import com.mysql.cj.util.StringUtils;
import com.share.entity.ArticleStation;
import com.share.entity.BaseJsonResponse;
import com.share.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
}
