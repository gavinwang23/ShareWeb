package com.share.rest;

import com.mysql.cj.util.StringUtils;
import com.share.common.CommonEnum;
import com.share.entity.dao.ArticleCollectionStation;
import com.share.entity.dao.ArticleStation;
import com.share.entity.BaseJsonResponse;
import com.share.entity.response.ArticleListResponse;
import com.share.entity.response.CorpusWithArticlesResponse;
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

    @Value("${system.static.files.pa/th}")
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
                || StringUtils.isNullOrEmpty(article.getUserName()) || StringUtils.isNullOrEmpty(article.getArticleContent()))
            throw new RuntimeException(CommonEnum.NO_CONTENT_INPUT.getMessage());

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
            @RequestParam("userName") String userName,
            @RequestParam("title") String title
    ) throws IOException {
        if (files == null || files.length == 0 || StringUtils.isNullOrEmpty(userName) || StringUtils.isNullOrEmpty(title))
            throw new RuntimeException(CommonEnum.NO_CORRECT_INPUT.getMessage());

        List<String> list = new ArrayList<>();
        int i = 1;
        for (MultipartFile file : files) {
            String imageSuffix = file.getOriginalFilename();
            if (!imageSuffix.contains(".") && !imageSuffix.endsWith("bmp") && !imageSuffix.endsWith("gif")
                    && !imageSuffix.endsWith("jpeg") && !imageSuffix.endsWith("png") && !imageSuffix.endsWith("psd")
                    && !imageSuffix.endsWith("swf") && !imageSuffix.endsWith("svg") && !imageSuffix.endsWith("cdr"))
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

    //通过用户名强行获取所有文章
    @GetMapping(value = "/articles/get")
    public ArticleListResponse getArticles(
        @RequestParam("userName") String userName,
        @RequestParam(value = "corpusName", required = false) String corpusName
        ) {
        if (StringUtils.isNullOrEmpty(userName))
            throw new RuntimeException(CommonEnum.NO_USER_NAME_INPUT.getMessage());

        List<ArticleStation> list = new ArrayList<>();
        if (StringUtils.isNullOrEmpty(corpusName)) {
            ArticleListResponse response = new ArticleListResponse();
            list = articleService.getArticleListByUserName(userName);
            response.setList(list);
            return response;
        }

        ArticleListResponse response = new ArticleListResponse();
        list = articleService.getArticlesByUserNameAndCorpusName(userName, corpusName);
        response.setList(list);
        return response;
    }

    //获取文集,以及文集下的所有文章
    @GetMapping(value = "/corpus/get")
    public CorpusWithArticlesResponse getCorpusWithArticles(@RequestParam("userName") String userName) {
        if (StringUtils.isNullOrEmpty(userName))
            throw new RuntimeException(CommonEnum.NO_USER_NAME_INPUT.getMessage());

        CorpusWithArticlesResponse response = new CorpusWithArticlesResponse();
        response = articleService.getCorpusWithArticlesByUserName(userName);
        return response;
    }

    @PostMapping(value = "/head_portrait/add", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ImageInsertResponse addHeadPortrait(
            @RequestParam("files") MultipartFile[] files,
            @RequestParam("userName") String userName
    ) throws IOException {
        return this.addImageInArticle(files, userName, "HeadPortrait" + headPortrait);
    }

    @PostMapping(value = "/corpus/add")
    public BaseJsonResponse addCorpus(@RequestBody ArticleCollectionStation corpus,
                                      @RequestParam(value = "articles", required = false) List<ArticleStation> articles) {
        if (corpus == null || StringUtils.isNullOrEmpty(corpus.getCollectionName()))
            throw new RuntimeException(CommonEnum.NO_CONTENT_INPUT.getMessage());
        if (corpus.getCreateTime() == null)
            corpus.setCreateTime(new Date());

        if (articles == null || articles.size() == 0) {
            Integer result = articleService.insertSelective(corpus);
            if (result != 0)
                throw new RuntimeException(CommonEnum.SERVER_INTERNAL_ERROR.getMessage());
        }

        articleService.deleteCorpusWithNoArticle(corpus);
        Integer result = articleService.insertCorpusWithArticles(corpus, articles);
        if (result != 0)
            throw new RuntimeException(CommonEnum.SERVER_INTERNAL_ERROR.getMessage());

        return new BaseJsonResponse();
    }

    @GetMapping(value = "article/get")
    public ArticleListResponse getArticle(
            @RequestParam("userName") String userName,
            @RequestParam("articleTitle") String articleTitle
    ){
        if (StringUtils.isNullOrEmpty(userName))
            throw new RuntimeException(CommonEnum.NO_USER_NAME_INPUT.getMessage());

        List<ArticleStation> list = new ArrayList<>();

        ArticleListResponse response = new ArticleListResponse();
        list = articleService.getArticleByUserNameAndArticleTitle(userName, articleTitle);
        response.setList(list);
        return response;
    }

    @GetMapping(value = "follower_articles/get")
    public ArticleListResponse getFollowerArticles(
            @RequestParam("userName") String userName
    ){
        if (StringUtils.isNullOrEmpty(userName))
            throw new RuntimeException(CommonEnum.NO_USER_NAME_INPUT.getMessage());

        List<ArticleStation> list = new ArrayList<>();

        ArticleListResponse response = new ArticleListResponse();
        list = articleService.getFollowerArticlesByUserName(userName);
        response.setList(list);
        return response;
    }

}
