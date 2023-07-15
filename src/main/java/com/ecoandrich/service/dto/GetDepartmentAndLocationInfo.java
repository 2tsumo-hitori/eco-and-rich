package com.ecoandrich.service.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;

import static com.fasterxml.jackson.annotation.JsonInclude.*;
import static com.fasterxml.jackson.annotation.JsonInclude.Include.*;

@Data
@JsonInclude(NON_NULL)
@AllArgsConstructor
public class GetDepartmentAndLocationInfo {

    private GetDepartmentInfo departmentInfo;

    private GetLocationInfo locationInfo;

    @Data
    @AllArgsConstructor
    @JsonInclude(NON_NULL)
    public static class GetDepartmentInfo {

        private int departmentId;

        private String departmentName;
    }

    @Data
    @AllArgsConstructor
    @JsonInclude(NON_NULL)
    public static class GetLocationInfo {

        private int locationId;

        private String streetAddress;

        private String postalCode;

        private String city;

        private String stateProvince;
    }
}
