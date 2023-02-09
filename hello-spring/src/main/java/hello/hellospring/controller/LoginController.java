package hello.hellospring.controller;

import hello.hellospring.domain.Member;
import hello.hellospring.service.MemberService;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
@CrossOrigin(originPatterns = "http://localhost:8080")
@RestController
@RequestMapping("/api")
@Controller
public class LoginController {

    private final MemberService memberService;
    private final JdbcTemplate jdbcTemplate;
    public LoginController(MemberService memberService, JdbcTemplate jdbcTemplate) {
        this.memberService = memberService;
        this.jdbcTemplate = jdbcTemplate;
    }


    @GetMapping("/login")
    @ResponseBody //json 데이터
    public Member login(@RequestParam("name") String name) {
        Member user = new Member();
        user.setName(name);
        user.setPhoneNumber("010-3911-2532");
        user.setEmail("bak3839@naver.com");
        user.setPassword("aa123");
        return user;
    }

    @GetMapping("/insert")
    public Member DataInsert (@RequestParam String email, @RequestParam String password) {
        System.out.println("받은 ID : " + email + " 받은 PW : " + password);

        Member member = new Member();
        member.setEmail(email);
        member.setPassword(password);
        member.setPhoneNumber("010-3911-2532");
        member.setName("basweq");
        memberService.join(member);
        return member;
    }

}
