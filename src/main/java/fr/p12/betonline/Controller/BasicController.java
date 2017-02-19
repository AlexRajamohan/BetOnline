package fr.p12.betonline.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by zaraki on 14/10/16.
 */

@Controller
public class BasicController {

    @RequestMapping("/log")
    public String displayLoginPage(){

//        System.out.println("ok");
        return "signin";
    }

    @RequestMapping("/basic")
    public String displayBasicTemplate(){

//        System.out.println("ok");
        return "BasicTemplate";
    }

    @RequestMapping("/testCSS")
    public String displayTestCSS(){

//        System.out.println("ok");
        return "testCSS";
    }
}
