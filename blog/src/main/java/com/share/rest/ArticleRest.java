package com.share.rest;

import com.share.entity.ArticleStation;
import com.share.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
}
