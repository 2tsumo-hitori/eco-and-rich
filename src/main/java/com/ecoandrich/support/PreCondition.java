package com.ecoandrich.support;

import com.ecoandrich.support.exception.ParameterInValidException;


public class PreCondition {

    public static ParameterInValidException throwMessage() {
        return new ParameterInValidException("일치하는 회원 정보가 없습니다.");
    }
}
