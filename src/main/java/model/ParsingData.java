package model;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParsingData {

    public Polynomial parse(String string){
        Pattern pattern = Pattern.compile("(-?\\b\\d+)[xX]\\^(-?\\d+\\b)");
        Matcher matcher = pattern.matcher(string);
        List<Monomial> lm = new ArrayList<>();

        while(matcher.find()){
            lm.add(new Monomial(Integer.parseInt(matcher.group(2)),Double.parseDouble(matcher.group(1))));
        }
        return new Polynomial(lm);
    }
}
