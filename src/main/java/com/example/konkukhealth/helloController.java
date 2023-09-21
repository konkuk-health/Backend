package com.example.konkukhealth;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Tag(name="helloController ")
@ApiResponse
public class helloController {

    @Operation(summary = "시작api",description = "개발의 시작을 알리는 api입니다",responses = {
            @ApiResponse(responseCode = "200", description = "회원 조회 성공"),
            @ApiResponse(responseCode = "404", description = "존재하지 않는 리소스 접근")
    })
    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data","hello!!");
        return "hello";
    }
}
