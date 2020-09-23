package com.seavus.talent.WebCalculator;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CalculatorController {

    @RequestMapping(path = "/calculate", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public String calculate(@RequestParam String firstOperand, @RequestParam String operator, @RequestParam String secondOperand) {
        int firstOperandParsed;
        int secondOperandParsed;
        try {
            firstOperandParsed = Integer.parseInt(firstOperand);
            secondOperandParsed = Integer.parseInt(secondOperand);
        } catch (Exception e) {
            return "Invalid input!";
        }
        return operator.equals("minus") ? String.valueOf(firstOperandParsed - secondOperandParsed)
                : operator.equals("plus") ?
                String.valueOf(firstOperandParsed + secondOperandParsed) : "Invalid operator!";
    }
}
