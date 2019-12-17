package com.share.entity.response;

import com.share.entity.BaseJsonResponse;
import com.share.entity.dao.IndexInformationStation;

import java.util.List;

public class IndexInformationResponse extends BaseJsonResponse {
    private List<IndexInformationStation> list;

    public List<IndexInformationStation> getList() {
        return list;
    }

    public void setList(List<IndexInformationStation> list) {
        this.list = list;
    }
}
