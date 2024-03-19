package mongkey.maeilmail.controller;

import lombok.RequiredArgsConstructor;
import mongkey.maeilmail.common.response.ApiResponse;
import mongkey.maeilmail.dto.admin.request.JoinAdminRequestDto;
import mongkey.maeilmail.dto.admin.request.LoginAdminRequestDto;
import mongkey.maeilmail.dto.post.SavePostRequestDto;
import mongkey.maeilmail.dto.user.request.JoinUserRequestDto;
import mongkey.maeilmail.dto.user.request.LoginUserRequestDto;
import mongkey.maeilmail.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class MemberController {
    @Autowired
    private final MemberService memberService;

    /*유저 회원가입*/
    @PostMapping("/user/join")
    public ApiResponse<?> JoinUser(@RequestBody JoinUserRequestDto requestDto){
        String string = requestDto.toString();
        return memberService.joinUser(requestDto);
    }

    /*유저 로그인*/
    @PostMapping("/user/login")
    public ApiResponse<?> LoginUser(@RequestBody LoginUserRequestDto requestDto){
        String string = requestDto.toString();
        return memberService.loginUser(requestDto);
    }

    /*관리자 회원가입*/
    @PostMapping("/admin/join")
    public ApiResponse<?> JoinAdmin(@RequestBody JoinAdminRequestDto requestDto){
        String string = requestDto.toString();
        return memberService.joinAdmin(requestDto);
    }

    /*관리자 로그인*/
    @PostMapping("/admin/login")
    public ApiResponse<?> LoginAdmin(@RequestBody LoginAdminRequestDto requestDto){
        String string = requestDto.toString();
        return memberService.loginAdmin(requestDto);
    }
}
