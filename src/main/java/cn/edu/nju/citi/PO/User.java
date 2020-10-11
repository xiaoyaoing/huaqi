package cn.edu.nju.citi.PO;

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
