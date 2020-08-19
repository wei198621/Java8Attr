package com.tiza.leo.DateTime;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.time.Clock;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.chrono.Era;
import java.time.chrono.IsoChronology;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.time.temporal.ValueRange;

import static org.junit.Assert.*;

/**
 * Author: tz_wl
 * Date: 2020/8/19 16:21
 * Content:
 */
public class DateTimeTestTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void Test01(){
        ChronoField dayOfMonth = ChronoField.DAY_OF_MONTH;
        System.out.println("dayOfMonth = " + dayOfMonth);
        ValueRange range = dayOfMonth.range();
        System.out.println("range = " + range);
        TemporalUnit baseUnit = dayOfMonth.getBaseUnit();
        System.out.println("baseUnit = " + baseUnit);
        TemporalUnit rangeUnit = dayOfMonth.getRangeUnit();
        System.out.println("rangeUnit = " + rangeUnit);
        boolean timeBased = dayOfMonth.isTimeBased();
        System.out.println("timeBased = " + timeBased);
        boolean dateBased = dayOfMonth.isDateBased();
        System.out.println("dateBased = " + dateBased);
    }


    @Test
    public void Test02(){
        ChronoUnit days = ChronoUnit.DAYS;
        boolean dateBased = days.isDateBased();
        System.out.println("dateBased = " + dateBased);
        boolean timeBased = days.isTimeBased();
        System.out.println("timeBased = " + timeBased);
        Duration duration = days.getDuration();
        System.out.println("duration = " + duration);
    }


    @Test
    public void Test03(){
        LocalTime now1 = LocalTime.now();
        LocalDateTime now2 = LocalDateTime.now();
        LocalDate now = LocalDate.now();
        boolean supported = now.isSupported(ChronoField.NANO_OF_DAY);
        System.out.println("supported = " + supported);
        boolean supported1 = now.isSupported(ChronoUnit.DAYS);
        System.out.println("supported1 = " + supported1);
    }


    /**
    *@Description: LocalDate
    *@Param:
    *@return:
    *@date: 2020/8/19
    */
    @Test
    public void Test04(){
        LocalDate of = LocalDate.of(2020, 2, 12);
        LocalDate of1 = LocalDate.of(2020, Month.JANUARY, 30);
        LocalDate parse = LocalDate.parse("2002-02-20");
        LocalDate parse1 = LocalDate.parse("2002/02/11", DateTimeFormatter.ofPattern("yyyy/MM/dd"));
        System.out.println("parse1 = " + parse1);

        LocalDate.now();
        LocalDate now = LocalDate.now(Clock.systemDefaultZone());
        System.out.println("now = " + now);
        LocalDate now1 = LocalDate.now(ZoneId.of("Asia/Shanghai"));
        System.out.println("now1 = " + now1);
        LocalDate date = LocalDate.ofYearDay(2000, 39);
        System.out.println("date = " + date);
    }


    @Test
    public void Test05(){
        LocalTime of = LocalTime.of(0, 1, 2, 3);
        System.out.println("of = " + of);
        LocalTime parse = LocalTime.parse("20:20:20");
        System.out.println("parse = " + parse);
        LocalTime parse1 = LocalTime.parse("10:20:22", DateTimeFormatter.ofPattern("HH:mm:ss"));
        System.out.println("parse1 = " + parse1);

        LocalTime now = LocalTime.now();
        System.out.println("now = " + now);
        LocalTime now1 = LocalTime.now(Clock.systemDefaultZone());
        System.out.println("now1 = " + now1);

        LocalTime localTime = LocalTime.ofSecondOfDay(1 * 24 * 60 * 60 - 1);
        System.out.println("localTime = " + localTime);
        LocalTime localTime1 = LocalTime.ofNanoOfDay(1L * 60 * 60 * 1000000000);
        System.out.println("localTime1 = " + localTime1);
    }



    @Test
    public void Test06(){
        LocalDateTime of = LocalDateTime.of(2010, 2, 3, 4, 4);
        System.out.println("of = " + of);
        LocalDateTime of1 = LocalDateTime.of(2010, 2, 3, 4, 4, 5, 2222);
        System.out.println("of1 = " + of1);
    }



    @Test
    public void Test07(){

        LocalDate now = LocalDate.now();
        IsoChronology chronology = now.getChronology();
        System.out.println("chronology = " + chronology);
        Era era = now.getEra();
        System.out.println("era = " + era);
        long l = now.toEpochDay();
        System.out.println("l = " + l);

        ValueRange range = now.range(ChronoField.DAY_OF_MONTH);
        System.out.println("range = " + range);

    }


    @Test
    public void Test08(){

        LocalTime now = LocalTime.now();
        int nano = now.getNano();
        System.out.println("nano = " + nano);
        long l = now.toNanoOfDay();
        System.out.println("l = " + l);  //l = 61904052000000
        int i = now.toSecondOfDay();
        System.out.println("i = " + i);
    }


    @Test
    public void Test09(){

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String format = LocalDate.now().format(dateTimeFormatter);
        System.out.println("format = " + format);

    }

    @Test
    public void Test10(){

        LocalDate now = LocalDate.now();
        LocalDate date = now.withMonth(2);
        System.out.println("date = " + date);

    }

    @Test
    public void Test11(){
        LocalDate now = LocalDate.now();
        LocalDate date = now.plusDays(2);
        System.out.println("date = " + date);
        LocalDate date1 = now.minusDays(3);
        System.out.println("date1 = " + date1);

    }

    @Test
    public void Test12(){

        LocalDate date1 = LocalDate.now();
        LocalDate date2 = LocalDate.parse("2020-01-20");
        boolean before = date1.isBefore(date2);
        System.out.println("before = " + before);

    }



    @Test
    public void Test13(){

        Instant now = Instant.now();
        System.out.println("now = " + now);

    }




    @Test
    public void Test14(){


        Instant now = Instant.now();
        Instant parse = Instant.parse("2020-08-11T02:02:53.241Z");
        Duration between = Duration.between(now, parse);
        System.out.println("between = " + between);

        Duration duration1 = Duration.ofDays(1);
        System.out.println("duration1 = " + duration1);

    }



    @Test
    public void Test15(){

        Duration duration = Duration.ofHours(10);
        Duration duration1 = duration.dividedBy(10);
        Duration duration2 = duration.multipliedBy(10);

        System.out.println("duration = " + duration+"   duration1 = " + duration1+"   duration2 = " + duration2);
    }

}