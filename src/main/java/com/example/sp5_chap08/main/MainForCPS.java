package com.example.sp5_chap08.main;

import com.example.sp5_chap08.config.AppCtx;
import com.example.sp5_chap08.spring.ChangePasswordService;
import com.example.sp5_chap08.spring.MemberNotFoundException;
import com.example.sp5_chap08.spring.WrongIdPasswordException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainForCPS {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);
        ChangePasswordService cps = ctx.getBean("changePwdSvc", ChangePasswordService.class);

        try {
            cps.changePassword("madvirus@madvirus.net", "1111", "1234");
            System.out.println("암호를 변경했습니다.");
        } catch (MemberNotFoundException e) {
            System.out.println("회원 데이터가 존재하지 않습니다.");
        } catch (WrongIdPasswordException e) {
            System.out.println("암호가 올바르지 않습니다.");
        }

        ctx.close();
    }
}
