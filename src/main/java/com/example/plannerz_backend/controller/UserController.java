package com.example.plannerz_backend.controller;

import com.example.plannerz_backend.dao.UserRepository;
import com.example.plannerz_backend.model.ApiMessage;
import com.example.plannerz_backend.model.LoginData;
import com.example.plannerz_backend.model.User;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor //생성자 주입
public class UserController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());
    private final UserRepository userRepository;

    // 유저 로그인 관리
    @PostMapping("/api/user/login")
    public Object checkLogin(@RequestBody LoginData data){
        User user = userRepository.findUserByUseridAndUserpw(data.getUserid(), data.getUserpw());
        logger.info(data.getUserid());
        logger.info(data.getUserpw());

        if(user == null){
            return new ApiMessage("아이디 또는 비밀번호를 확인해주세요.");
        }
        else{
            return user;
        }
    }

    // 회원가입
    @PostMapping("/api/user")
    public Object addUser(@RequestBody User user){
        try{
            return userRepository.save(user);
        }
        catch(Exception e) {
            return new ApiMessage(e.getMessage());
        }
    }

    // 유저 정보 불러오기
    @GetMapping("/api/user")
    public User findUser(@RequestParam Long id){
        return userRepository.findById(id).get();
    }

    // 아이디 중복체크
    @GetMapping("/api/user/check")
    public Object findUserByUserId(@RequestParam String userid){
        User user = userRepository.findUserByUserid(userid);

        if(user != null){
            return new ApiMessage("아이디 확인");
        }
        else{
            return user;
        }
    }
}
