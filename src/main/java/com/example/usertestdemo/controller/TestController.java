package com.example.usertestdemo.controller;

import com.example.usertestdemo.domain.CourseInfo;
import com.example.usertestdemo.domain.MyException;
import com.example.usertestdemo.domain.Users;
import com.example.usertestdemo.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

import static com.example.usertestdemo.util.LocaleUtil.localeByLanguageTag;

@RestController
@RequestMapping("/Test")
@ControllerAdvice
@Api(tags = "用户测试管理-张利子和葛沁阳--小小阳")
public class TestController {

    @Autowired
    UserService userService;

    @ResponseBody
    @RequestMapping("/lizi/{id}")
    public Users test(@PathVariable Integer id)  throws  Exception{
        return userService.selectPrimary(id);
    }

    @ApiOperation(value = "用户测试查询",notes = "用户测试查询notes")
    @RequestMapping(value = "/getuser/{id}",method = RequestMethod.GET)
    public Users getUser(@PathVariable Integer id)  throws  Exception{
        return userService.selectPrimary(id);
    }

    @RequestMapping(value = "/deleteuser/{id}",method = RequestMethod.DELETE)
    public Integer deleteUser(@PathVariable Integer id){
        return userService.deletePrimary(id);
    }

    @RequestMapping(value = "/adduser",method = RequestMethod.PUT)
    public Integer addUser(@RequestBody(required=false) CourseInfo courseInfo){
        return userService.addPrimary(courseInfo);
    }

    @RequestMapping("testException")
    public String testException() throws Exception{
        throw new MissingServletRequestParameterException("name","String");
    }

    @RequestMapping("testMyException")
    public String testMyException() throws MyException{
        throw new MyException("i am a myException");
    }

    //测试多语言
    @RequestMapping("testLang/{code}")
    public String testLang(HttpServletRequest request,@PathVariable String code) throws Exception{
        String language = request.getHeader("language");
        Locale locale = localeByLanguageTag(language);

        return this.initMessageSource().getMessage(code, null, locale);

    }

    private MessageSource initMessageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("i18n/message");
        messageSource.setDefaultEncoding("UTF-8");
        messageSource.setCacheSeconds(3600);
        return messageSource;
    }
}


