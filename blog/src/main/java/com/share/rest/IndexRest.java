package com.share.rest;

import com.mysql.cj.util.StringUtils;
import com.share.common.CommonEnum;
import com.share.dao.mapper.ArticleStationMapper;
import com.share.entity.BaseJsonResponse;
import com.share.entity.dao.ArticleStation;
import com.share.entity.dao.IndexInformationStation;
import com.share.entity.response.ArticleListResponse;
import com.share.entity.response.IndexInformationResponse;
import com.share.service.ArticleService;
import com.share.service.IndexService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/index")
@ResponseBody
public class IndexRest extends BaseController {
    private static final Logger log = LoggerFactory.getLogger(IndexRest.class);

    @Autowired
    private IndexService indexService;

    @Autowired
    private ArticleService articleService;

    @GetMapping("index_info/get")
    public IndexInformationResponse getIndexInformation() {
        IndexInformationResponse response = new IndexInformationResponse();
        response.setList(indexService.getIndexInformationListByState(CommonEnum.ENABLE.getMessage()));
        return response;
    }

    @PostMapping("index_info/add")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public BaseJsonResponse addIndexInformation(@RequestBody List<IndexInformationStation> list) {
        BaseJsonResponse response = new BaseJsonResponse();
        if (list == null || list.size() == 0)
            return response.buildFailure(CommonEnum.NO_CONTENT_INPUT.getMessage());

        indexService.addIndexInformation(list);
        return response;
    }

    @GetMapping("index_info/delete")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public BaseJsonResponse deleteIndexInformation(@RequestParam("userName") String userName,
                                                   @RequestParam("indexArticleName") String indexArticleName,
                                                   @RequestParam(name = "indexArticleId", required = false) Long indexArticleId) {

        indexService.deleteIndexInfoByUserName(userName, indexArticleName, indexArticleId);
        return new BaseJsonResponse();
    }

    @GetMapping(value = "/articles/get")
    public ArticleListResponse getArticles(
        @RequestParam(name = "pageNo", required = false) Integer pageNo,
        @RequestParam(name = "pageSize", required = false) Integer pageSize
    ) {
        ArticleListResponse response = new ArticleListResponse();
        List<ArticleStation> list = new ArrayList<>();
        list = articleService.getArticleListInIndex(pageNo, pageSize);
        response.setList(list);
        return response;
    }

}
