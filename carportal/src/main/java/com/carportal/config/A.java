package com.carportal;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

//Encryption
public class A {
    public static void main(String[] args) {
//        PasswordEncoder encrypt = new BCryptPasswordEncoder();
//        System.out.println(encrypt.encode("testing"));

        String password = BCrypt.hashpw("testing", BCrypt.gensalt(12));//log_rounds =3, 2^3=8 times password will be encrypted
        System.out.println(password);
    }

}
