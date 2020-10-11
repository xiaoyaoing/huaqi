package cn.edu.nju.citi.po;

import lombok.Data;

@Data
public class User {
    private Integer id;
    private String username;
    private String email;
    private String password;
    private String token;
    private String fresh_token;
}
