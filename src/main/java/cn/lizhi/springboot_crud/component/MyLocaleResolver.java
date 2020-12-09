package cn.lizhi.springboot_crud.component;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

@Component
public class MyLocaleResolver implements LocaleResolver {

    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        // 获取请求参数
        String l = request.getParameter("l");
        // 获取默认的区域信息对象 -- 当请求不存在l的请求参数时，使用
        Locale requestLocale = Locale.getDefault();
        if (l != null && l.length() != 0) {
            String[] split = l.split("_");
            requestLocale = new Locale(split[0], split[1]);
        }

        return requestLocale;

    }

    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

    }
}
