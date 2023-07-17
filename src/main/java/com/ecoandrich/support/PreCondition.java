package com.ecoandrich.support;

import com.ecoandrich.support.exception.ParameterInValidException;
import com.ecoandrich.support.exception.UnExceptedRequestBodyException;
import com.ecoandrich.support.exception.WrongParameterNameException;
import com.ecoandrich.support.exception.WrongRateRangeException;


public class PreCondition {

    public static void require(boolean expression) {
        if (!expression) {
            throw new UnExceptedRequestBodyException("파라미터 값이 잘못되었습니다.");
        }
    }

    public static ParameterInValidException throwMessage() {
        return new ParameterInValidException("일치하는 회원 정보가 없습니다.");
    }

    public static WrongParameterNameException wrongParameterMessage() {
        return new WrongParameterNameException("유효하지 않은 파라미터명입니다.");
    }

    public static void requireNormalRange(boolean expression) {
        if (expression) {
            throw new WrongRateRangeException("1 이상의 숫자를 기입해주세요.");
        }
    }
}
