package com.wty.controller;

import com.wty.model.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.client.solrj.response.UpdateResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.util.NamedList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * @author wty
 * @date 2019/12/24 18:49
 */
@RestController
@Slf4j
public class SolrController {
    @Autowired
    private SolrClient solrClient;

    /**
     * 批量增加
     *
     * @throws IOException
     * @throws SolrServerException
     */
    @RequestMapping("/addUsers")
    public void addUsers() throws IOException, SolrServerException {
        List<User> userList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            User user = new User();
            user.setId(995L);
            user.setAge(Long.valueOf(i));
            user.setUsername("wty" + i);
            user.setPassword("123456");
            user.setMobile("123456789");
            user.setEmail("XXXXXXXX@qq.com");
            userList.add(new User());
        }
        solrClient.addBeans(userList);
        solrClient.commit();
    }

    @RequestMapping("/addUser")
    public void addUser() throws IOException, SolrServerException {
        User user = new User();
        user.setId(995L);
        user.setAge(19L);
        user.setUsername("wty");
        user.setPassword("123456");
        user.setMobile("123456789");
        user.setEmail("XXXXXXXX@qq.com");
        solrClient.addBean(user);
        solrClient.commit();
    }

    /**
     * 根据di查询
     *
     * @param id
     * @throws IOException
     * @throws SolrServerException
     */
    @RequestMapping("/getByIdFromSolr/{id}")
    public void getByIdFromSolr(@PathVariable("id") String id) throws IOException, SolrServerException {

        //根据id查询内容
        SolrDocument solrDocument = solrClient.getById(id);
        //获取filedName
        Collection<String> fieldNames = solrDocument.getFieldNames();
        //获取file名和内容
        Map<String, Object> fieldValueMap = solrDocument.getFieldValueMap();

        List<SolrDocument> childDocuments = solrDocument.getChildDocuments();

        log.info("byId==================" + solrDocument);
        log.info("fieldNames==================" + fieldNames);
        log.info("fieldValueMap==================" + fieldValueMap);
        log.info("childDocuments==================" + childDocuments);
    }

    /**
     * 根据id删除
     *
     * @param id
     * @throws IOException
     * @throws SolrServerException
     */
    @RequestMapping("/delById/{id}")
    public void delById(@PathVariable("id") String id) throws IOException, SolrServerException {
        //根据id删除信息
        UpdateResponse updateResponse = solrClient.deleteById(id);
        //执行的时间
        long elapsedTime = updateResponse.getElapsedTime();

        int qTime = updateResponse.getQTime();
        //请求地址
        String requestUrl = updateResponse.getRequestUrl();
        //请求的结果{responseHeader={status=0,QTime=2}}
        NamedList<Object> response = updateResponse.getResponse();
        //请求结果的头{status=0,QTime=2}
        NamedList responseHeader = updateResponse.getResponseHeader();
        //请求的状态 0
        int status = updateResponse.getStatus();

        log.info("elapsedTime===========" + elapsedTime);
        log.info("qTime===========" + qTime);
        log.info("requestUrl===========" + requestUrl);
        log.info("response===========" + response);
        log.info("responseHeader===========" + responseHeader);
        log.info("status===========" + status);
    }

    /**
     * 条件查询
     *
     * @return
     * @throws IOException
     * @throws SolrServerException
     */
    @RequestMapping("/queryFromSolr")
    public Object queryFromSolr() throws IOException, SolrServerException {
        //第一种方式
//        Map<String, String> queryParamMap = new HashMap<String, String>();
//        queryParamMap.put("q", "*:*");
//        queryParamMap.put("f1","id,name");
//        queryParamMap.put("sort","id asc");
//        MapSolrParams mapSolrParams = new MapSolrParams(queryParamMap);
//        solrClient.query(mapSolrParams);

        //第二种方式
        SolrQuery solrQuery = new SolrQuery();
        solrQuery.setQuery("*:*");
//        solrQuery.addField("*");
        solrQuery.add("q", "id:4567");

        solrQuery.setSort("id", SolrQuery.ORDER.asc);
        //设置查询的条数
        solrQuery.setRows(50);
        //设置查询的开始
        solrQuery.setStart(0);
        //设置高亮
        solrQuery.setHighlight(true);
        //设置高亮的字段
        solrQuery.addHighlightField("item_name");
        //设置高亮的样式
        solrQuery.setHighlightSimplePre("<font color='red'>");
        solrQuery.setHighlightSimplePost("</font>");
        log.info(solrQuery.toString());
        QueryResponse response = solrClient.query(solrQuery);
        //返回高亮显示结果
        Map<String, Map<String, List<String>>> highlighting = response.getHighlighting();
        //response.getResults();查询返回的结果
        SolrDocumentList documentList = response.getResults();
        for (SolrDocument solrDocument : documentList) {
            log.info("solrDocument==============" + solrDocument);
        }
        return documentList;
    }
}
