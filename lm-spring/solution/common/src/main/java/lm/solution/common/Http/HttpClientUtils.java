package lm.solution.common.Http;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.collections4.MapUtils;

public class HttpClientUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(HttpClientUtils.class);

    /**
     * post请求
     *
     * @param url
     * @return
     */
    public static String doPost(String url) {
        try {
            return RestClient.getClient().postForObject(url, HttpEntity.EMPTY, String.class);
        } catch (Exception e) {
            LOGGER.error("POST请求出错：{}", url, e);
        }

        return null;
    }

    /**
     * post请求
     *
     * @param url
     * @param formParams
     * @return
     */
    public static String doPost(String url, Map<String, String> formParams) {

        if (MapUtils.isEmpty(formParams)) {
            return doPost(url);
        }

        try {
            MultiValueMap<String, String> requestEntity = new LinkedMultiValueMap<>();
            formParams.keySet().stream().forEach(key -> requestEntity.add(key, MapUtils.getString(formParams, key, "")));
            return RestClient.getClient().postForObject(url, requestEntity, String.class);
        } catch (Exception e) {
            LOGGER.error("POST请求出错：{}", url, e);
        }

        return null;
    }

    public static <M> String doPost(String url, M model) {

        if (model == null) {
            return doPost(url);
        }

        ResponseEntity<String> responseEntity = RestClient.getClient().postForEntity(url, model, String.class);
        return responseEntity.getBody();
    }

    public static void doDelete(String url) {

        RestClient.getClient().delete(url);

    }

    public static <M> void doPut(String url, M model) {

        RestClient.getClient().put(url, model);

    }

    /**
     * get请求
     *
     * @param url
     * @return
     */
    public static String doGet(String url) {

        try {
            HttpHeaders headers = new HttpHeaders();
            headers.add("Accept", "application/json");

            HttpEntity<String> entity = new HttpEntity<String>(null, headers);
            ResponseEntity<String> response = RestClient.getClient().exchange(url, HttpMethod.GET, entity, String.class, new HashMap() {
            });

            return response.getBody();
            //return RestClient.getClient().getForObject(url,String.class);
        } catch (Exception e) {
            LOGGER.error("GET请求出错：{}", url, e);
        }

        return null;

    }

}

