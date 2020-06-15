package com.example.demo.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

// 사용자의 URL 요청을 처리하겠다.
@Controller
public class BoardController {
    // static이 붙어있으면 메모리에 상주해 있게 된다.
    // 쉽게 생각하자면 메모리에 통채로 박혀 있다고 생각하면 된다.
    // 결국 data 영역에 상시 배치되어 있는 것이다.

    // static을 남발하는 것은 자제해야한다.
    // 이유는 메모리에 상주하게 되어 그만큼 메모리를 소비하므로
    // 대규모 시스템이 동작할때 static의 남발을 성능 저하를 유발한다.

    // new라는 것은 Heap에 할당하는것이고
    // Heap에 할당한다는 것은 동적으로 할당을 한다는 것이므로
    // 실제 Run-Time에 실행하면서 할당을 하게되어 속도가 느리다.
    // 그러나 static으로 박아놓은것은 메모리는 낭비하지만
    // 프로그램이 동작할때 초기부터 셋팅되어 있는것이라
    // 별도의 동적 할당 메커니즘이 없어 속도 측면에서 이점을 얻을 수 있다.
    static Logger log = LoggerFactory.getLogger(BoardController.class);

    // 사용자의 URL 요청중 /test 로 들어오는 녀석이 있다면 나한테 보내줘 ~
    @GetMapping("/test")
    public String test(Model model) {
        // HTML 태그중 템플릿으로 받을 수 있는 태그가 있는데
        // 해당 태그에서 message를 받을 수 있게 해주는 작업
        // 즉 여기서 message는 일종의 key 값이라고 생각하면 되고
        // 그 뒤쪽에 있는 내용이 실제 value라고 생각하면 되겠다.
        model.addAttribute("message",
                "Hello Spring-Vue-MySQL-WebGL");

        // 이것은 Thymeleaf에 의해서
        // 자동으로 resources/templates/test.html로 정보를 출력하겠다는 의미가 된다.
        return "test";
    }
}
