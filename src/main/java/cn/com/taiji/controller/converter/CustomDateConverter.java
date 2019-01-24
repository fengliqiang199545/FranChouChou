package cn.com.taiji.controller.converter;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CustomDateConverter implements Converter<String, Date> {
    @Override
    public Date convert(String s) {
        //Converter 的实现，将日期串转换成日期类型（日期格式为：yyyy-MM-dd）
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        try {
            //转换成功则直接返回
            return simpleDateFormat.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        //如果参数转换失败则直接返回null
        return null;
    }
}
