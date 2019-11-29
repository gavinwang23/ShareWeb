package com.share.rest;

import com.share.entity.response.CarouselAndArticlesInIndex;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/index")
@ResponseBody
public class IndexRest extends BaseController {
    private static final Logger log = LoggerFactory.getLogger(IndexRest.class);

    @GetMapping("get")
    public CarouselAndArticlesInIndex getIndexCarouselAndArticles() {
        CarouselAndArticlesInIndex response = new CarouselAndArticlesInIndex();

        return response;
    }
}
