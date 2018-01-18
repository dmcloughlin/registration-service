package com.allianz.ms.registration.commands;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created by dmcloughlin on 17/01/2018.
 */
@Data
@AllArgsConstructor
public class RegisterDetailsCommand {

    private String id;
    private String email;
    private String memberNumber;
    private String dob;
}