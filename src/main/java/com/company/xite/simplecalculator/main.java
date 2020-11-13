package com.company.xite.simplecalculator;

import com.company.xite.simplecalculator.classifier.NumberClassificationService;
import com.company.xite.simplecalculator.classifier.NumberClassifier;
import org.springframework.boot.SpringApplication;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class main {
   static final String regex = "(?:(^-?\\d+)([xX*/+\\-])\\s*)+(-?\\d+\\s*)";
   static final Pattern pattern = Pattern.compile(regex);
    public static void main(String[] args) {

      //  final Matcher matcher = pattern.matcher(string);
        System.out.println(calac("     0/    000"));

    }
    static double calac(String equl){
        String w =  equl.replaceAll(" ","" );
        final Matcher matcher = pattern.matcher(w);
        if(matcher.find()){
            if(matcher.groupCount() ==3 && w.length() == (matcher.group(1).length()+matcher.group(3).length()+1)){
                if(matcher.group(1).replaceAll("0+","0").equals("-0")
                        || matcher.group(3).replaceAll("0+","0").equals("-0")) {
                    throw new IllegalArgumentException();
                }
                double v1 = Double.parseDouble(matcher.group(1));
                double v2 = Double.parseDouble(matcher.group(3));
                String operator = matcher.group(2);
                switch (operator){
                    case "+":
                        return v1+v2;
                     //   break;
                    case "-":
                        return v1-v2;
                  //      break;
                    case "*":
                    case "x":
                    case "X":
                        return v1*v2;
                    //    break;
                    case "/":
                        return v1/v2;
                   //     break;
                }

            }
            throw new IllegalArgumentException();
        }
        throw new IllegalArgumentException();

    }


}
