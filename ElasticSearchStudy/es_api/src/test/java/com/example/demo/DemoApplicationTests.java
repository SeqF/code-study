package com.example.demo;

import com.example.demo.pojo.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.TermQueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.subphase.FetchSourceContext;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    @Qualifier("restHighLevelClient")
    private RestHighLevelClient client;

    //测试索引的创建   Request
    @Test
    void testCreateIndex() throws IOException {
        //1.创建索引请求
        CreateIndexRequest request = new CreateIndexRequest("hm_biss");
        //2.客户端执行请求  IndicesClient,请求后获得响应
        CreateIndexResponse createIndexResponse = client.indices().create(request, RequestOptions.DEFAULT);
        System.out.println(createIndexResponse);
    }

    //测试获取索引，只能判断是否存在
    @Test
    void testExistIndex() throws IOException {
        GetIndexRequest request = new GetIndexRequest("hm_biss");
        boolean exists = client.indices().exists(request, RequestOptions.DEFAULT);
        System.out.println(exists);
    }

    //测试删除索引
    @Test
    void testDeleteIndex() throws IOException {
        DeleteIndexRequest request = new DeleteIndexRequest("hm_biss");
        //删除
        AcknowledgedResponse delete = client.indices().delete(request, RequestOptions.DEFAULT);
        System.out.println(delete.isAcknowledged());
    }

    //测试添加文档
    @Test
    void testAddDocument() throws IOException {
        //创建对象
        User user = new User("hm", 24);
        //创建请求
        IndexRequest request = new IndexRequest("hm_biss");
        //规则 put hm_biss/_doc/1
        request.id("1")
                .timeout(TimeValue.timeValueSeconds(1))
                .timeout("1s");
        //将我们的数据放入请求  json
        ObjectMapper mapper = new ObjectMapper();
        request.source(mapper.writeValueAsString(user), XContentType.JSON);
        //客户端发送请求,获取响应的结果
        IndexResponse indexResponse = client.index(request, RequestOptions.DEFAULT);

        System.out.println(indexResponse.toString());
        System.out.println(indexResponse.status());   //对应命令返回的状态
    }

    //获取文档,判断是否存在
    @Test
    void testIsDocumentExists() throws IOException {
        GetRequest request = new GetRequest("hm_biss", "1");
        //不获取返回的 _source 的上下文
        request.fetchSourceContext(new FetchSourceContext(false))
                .storedFields("_none_");
        boolean exists = client.exists(request, RequestOptions.DEFAULT);
        System.out.println(exists);
    }

    //获取文档的信息
    @Test
    void testGetDocument() throws IOException {
        GetRequest request = new GetRequest("hm_biss", "1");
        GetResponse response = client.get(request, RequestOptions.DEFAULT);
        System.out.println(response.getSourceAsString()); //打印文档内容
        System.out.println(response);   //返回全部内容
    }

    //更新文档信息
    @Test
    void testUpdateDocument() throws IOException {
        UpdateRequest updateRequest = new UpdateRequest("hm_biss", "1");
        updateRequest.timeout("1s");

        User user = new User("homo", 24);
        ObjectMapper mapper = new ObjectMapper();
        updateRequest.doc(mapper.writeValueAsString(user), XContentType.JSON);

        UpdateResponse update = client.update(updateRequest, RequestOptions.DEFAULT);
        System.out.println(update.status());
    }

    //删除文档
    @Test
    void testDeleteDocument() throws IOException {
        DeleteRequest request = new DeleteRequest("hm_biss", "1");
        request.timeout("1s");

        DeleteResponse response = client.delete(request, RequestOptions.DEFAULT);
        System.out.println(response.status());
    }

    //批量插入数据
    @Test
    void testBulkRequest() throws IOException {
        BulkRequest bulkRequest = new BulkRequest();
        bulkRequest.timeout("10s");

        ArrayList<User> userlist = new ArrayList<>();
        userlist.add(new User("hm1", 1));
        userlist.add(new User("hm2", 2));
        userlist.add(new User("hm3", 3));

        ObjectMapper mapper = new ObjectMapper();
        for (int i = 0; i < userlist.size(); i++) {
            //批量更新和批量删除，就在这里修改对应的请求
            bulkRequest.add(
                    new IndexRequest("hm_biss")
                            .id("" + (i + 1)) //不写ID就会随机生成
                            .source(mapper.writeValueAsString(userlist.get(i)), XContentType.JSON)
            );
        }
        BulkResponse bulkResponse = client.bulk(bulkRequest, RequestOptions.DEFAULT);
        System.out.println(bulkResponse.hasFailures()); //是否失败，返回false即成功
    }

    //查询
    // SearchRequest  搜索请求
    // SearchSourceBuilder  条件构造
    // HighlightBuilder  构建高亮
    // TermQueryBuilder  精确查询
    // MatchAllQueryBuilder  匹配查询
    // xxxBuilder 就是各种命令
    @Test
    public void testSearch() throws IOException {
        SearchRequest searchRequest = new SearchRequest("hm_biss");
        //构建搜索条件
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();

        //查询条件，使用煤QueryBuilders 工具类来实现
        //常用： QueryBuilder.termQuery  精确查询
        //      QueryBuilder.matchAllQuery  匹配所有
        TermQueryBuilder termQueryBuilder = QueryBuilders.termQuery("name", "hm1");
        sourceBuilder.query(termQueryBuilder)
                     .timeout(new TimeValue(60, TimeUnit.SECONDS));

        searchRequest.source(sourceBuilder);

        ObjectMapper objectMapper = new ObjectMapper();
        SearchResponse searchResponse = client.search(searchRequest, RequestOptions.DEFAULT);
        System.out.println(objectMapper.writeValueAsString(searchResponse.getHits()));  //getHits()获取查询结果,是一个对象

        for (SearchHit documentFields : searchResponse.getHits().getHits()) {  //这里再进行一次getHits()获得的是hits数组
            System.out.println(documentFields.getSourceAsMap());
        }
    }

}
