package com.codegym.formatter;
import com.codegym.model.Office;
import com.codegym.sevice.OfficeSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;
import java.text.ParseException;
import java.util.Locale;
@Component
public class OfficesFormatter implements Formatter<Office> {
    private OfficeSevice officeSevice;
    @Autowired
    public OfficesFormatter(OfficeSevice officeSevice){
        this.officeSevice = officeSevice;
    }
    @Override
    public Office parse(String text, Locale locale) throws ParseException {
        return officeSevice.findById(Long.parseLong(text));
    }
    @Override
    public String print(Office object, Locale locale) {
        return  "[" + object.getId() + ", " +object.getName() + "]";
    }
}
