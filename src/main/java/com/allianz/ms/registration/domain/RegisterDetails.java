package com.allianz.ms.registration.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by dmcloughlin on 17/01/2018.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterDetails {

    private String email;
    private String memberNumber;
    private String dob;
}