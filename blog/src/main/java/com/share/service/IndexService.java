package com.share.service;

import com.share.dao.mapper.IndexInformationStationMapper;
import com.share.entity.dao.IndexInformationStation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IndexService {

    @Autowired
    private IndexInformationStationMapper indexInformationStationMapper;

    public List<IndexInformationStation> getIndexInformationListByState(String state) {
        return indexInformationStationMapper.getIndexInformationListByState(state);
    }

    public void addIndexInformation(List<IndexInformationStation> list) {
        indexInformationStationMapper.addIndexInformation(list);
    }
}
