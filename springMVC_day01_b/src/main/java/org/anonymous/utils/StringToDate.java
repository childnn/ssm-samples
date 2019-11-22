package org.anonymous.utils;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author child
 * 2019/4/20 9:21
 * 自定义类型转换器
 */
public class StringToDate implements Converter<String, Date> {
     //s="9012-12-12" //spring 自动将 9012/12/12 --转为--> Date 格式
    @Override//这里需要 自定义格式: 将 "yyyy-MM-dd" --> Date 格式
    public Date convert(String s) {
        SimpleDateFormat simpleDateFormat;

        Date date = null;
        try {
            if (s.contains("-")) { //只转换指定格式的 字符串
                simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

                date = simpleDateFormat.parse(s);

            } else if (s.contains("/")) {
                simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
                date = simpleDateFormat.parse(s);
            } //还可以定义更多的格式
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}
