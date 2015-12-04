package com.springapp.mvc.converter;

import org.springframework.core.convert.converter.Converter;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by richard on 15-12-2.
 */
public class DateConverter implements Converter<String, Date> {

    @Override
    public Date convert(String date) {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        try {

            return simpleDateFormat.parse(date);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
