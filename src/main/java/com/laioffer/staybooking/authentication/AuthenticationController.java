package com.laioffer.staybooking.authentication;


import com.laioffer.staybooking.model.LoginRequest;
import com.laioffer.staybooking.model.LoginResponse;
import com.laioffer.staybooking.model.RegisterRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/auth") //代表下面的路径都共享上面的根目录
public class AuthenticationController {


    private final AuthenticationService authenticationService;


    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }


    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public void register(@RequestBody RegisterRequest body) {
        authenticationService.register(body.username(), body.password(), body.role());
    }


    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest body) {
        String token = authenticationService.login(body.username(), body.password());
        return new LoginResponse(token);
    }
    //这里没有logout是因为服务器会直接把token删掉（服务器不知道你logout没有）
    //下次再登录就再给你一个token
}
