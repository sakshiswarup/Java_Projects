package com.carportal;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.security.SecureRandom;
import java.util.Base64;

//Encryption
public class A {
   // public static void main(String[] args) {
//        PasswordEncoder encrypt = new BCryptPasswordEncoder();
//        System.out.println(encrypt.encode("testing"));

 //       String password = BCrypt.hashpw("testing", BCrypt.gensalt(12));//log_rounds =3, 2^3=8 times password will be encrypted
  //      System.out.println(password);
   // }


//        public static void main(String[] args) {
//            SecureRandom secureRandom = new SecureRandom();
//            byte[] key = new byte[32]; // 256 bits = 32 bytes
//            secureRandom.nextBytes(key);
//            String secretKey = Base64.getEncoder().encodeToString(key);
//
//            System.out.println("Generated Secret Key: " + secretKey);
//    }
public static void main(String[] args) {
    System.out.println(new BCryptPasswordEncoder().encode("testing"));
}


}
