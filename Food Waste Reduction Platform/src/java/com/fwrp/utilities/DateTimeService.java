/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fwrp.utilities;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

/**
 *
 * @author jessica Gunawan 
 */
public class DateTimeService {
     public static Date getCurrentUtcDateTime() {
        LocalDateTime utcDateTime = LocalDateTime.now(ZoneOffset.UTC);
        return Date.from(utcDateTime.toInstant(ZoneOffset.UTC));
    }
}
