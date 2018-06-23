package com.happymama.admin.service;

import com.google.common.base.Splitter;
import com.happymama.admin.dao.KnowledgeDao;
import com.happymama.admin.model.EmployeeDO;
import com.happymama.admin.model.KnowledgeDO;
import com.happymama.admin.utils.QueryResult;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

/**
 * Created by yaoqiang on 2018/6/22.
 */
@Service
public class KnowledgeService {

    @Resource
    private KnowledgeDao knowledgeDao;

    public boolean addKnowledge(KnowledgeDO knowledgeDO) {
        return knowledgeDao.addKnowledge(knowledgeDO);
    }

    public QueryResult<KnowledgeDO> getKnowledgeList(int firstResult, int maxresult) {
        QueryResult<KnowledgeDO> qr = new QueryResult<>();
        List<KnowledgeDO> list = knowledgeDao.getKnowledgeList(firstResult, maxresult);
        long count = getKnowledgeCount();
        qr.setResultlist(list);
        qr.setTotalrecord(count);
        return qr;
    }


    private long getKnowledgeCount() {
        return knowledgeDao.getKnowledgeCount();
    }

    public void deleteKnowledgeById(int id) {
        knowledgeDao.deleteKnowledgeById(id);
    }

    public KnowledgeDO getKnowledgeById(int id) {
        return knowledgeDao.getKnowledgeById(id);
    }

    public boolean updateKnowledge(KnowledgeDO knowledgeDO) throws ParseException {
        return knowledgeDao.updateKnowledge(knowledgeDO);
    }
}
