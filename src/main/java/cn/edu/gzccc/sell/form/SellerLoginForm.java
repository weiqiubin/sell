package cn.edu.gzccc.sell.form;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

@Data
public class SellerLoginForm {

    @NotEmpty(message = "用户名必填")
    private String username;

    @NotEmpty(message = "密码必填")
    private String password;

}
