package com.example.demo.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PythonRequester {
    final static Logger log = LoggerFactory.getLogger(PythonRequester.class);

    // Spring의 Controller를 Requester(즉 클라이언트)로 만들겠다는 의미
    @RequestMapping(value = "/doRequestPythonRest",
            produces = MediaType.APPLICATION_JSON_VALUE,
            method = RequestMethod.GET)
    public String doRequestPythonRest() {
        log.info("doRequestPythonRest()");

        List<HttpMessageConverter<?>> converters = new ArrayList<HttpMessageConverter<?>>();
        converters.add(new FormHttpMessageConverter());
        converters.add(new StringHttpMessageConverter());

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setMessageConverters(converters);

        MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
        map.add("str", "request test");

        // Python RESTFUL API Server에 데이터 요청하기
        // 1. 요청 서버가 센서 데이터를 수집하는 서버임
        //    여기서 센서 정보들을 가공해서
        //    전기세를 계산하는 프로그램을 서버가 계산해준다고 가정한다.
        String result = restTemplate.getForObject(
                "http://localhost:5000/dataServer",
                String.class
        );
        log.info("result = " + result);

        return result;
    }
}
