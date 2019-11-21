package controller;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @author RitualYang
 * @create 2019-11-21 20:30
 */
@Controller
public class LoginController {
    @Autowired
    private DefaultKaptcha defaultKaptcha;


}
