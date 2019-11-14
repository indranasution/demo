package com.homecredit.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Modules {
    private String moduleName;
    private Integer moduleOrder;
}
