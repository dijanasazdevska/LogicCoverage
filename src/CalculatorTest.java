import org.junit.Assert;
import org.junit.Test;

import java.sql.Date;
import java.text.DateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import static org.junit.Assert.*;

public class CalculatorTest {
        /* Restricted Active Clauses  Coverage RACC
         a: month1==month2
            b: m4!=0
            c: m100==0
            d: m400!=0

*/
public int getDaysBetween(int day1,int month1,int day2, int month2,int year){
    LocalDate dateBefore = LocalDate.of(year, month1, day1);
    LocalDate dateAfter = LocalDate.of(year, month2, day2);
    int noOfDaysBetween = (int) ChronoUnit.DAYS.between(dateBefore, dateAfter);
    return noOfDaysBetween;
}
    /* Calculator.java
    * line 18 : a
    * line 25 : b || (c && d)*/
    // a = T , month1==month2
    @Test
    public void testPredicate1_1(){
        int month1,month2;
        month1=month2=2;
        int day1=1,day2= 23;
        int year=2022;




        assertEquals(  getDaysBetween(day1,month1,day2,month2,year) ,Calculator.cal(month1,day1,month2,day2,year));


    }
    /*for reaching this predicate a must be false
    test3 for predicate 2  b || (c && d)
    * b=T, m4!=0
    * c=F m100!=0
    * d=F m400!=0 */
    @Test
    public void testPredicate2_3(){
    int day1=4,day2=29;
    int month1=10, month2=12;
    int year=2021;
        assertEquals(  getDaysBetween(day1,month1,day2,month2,year) ,Calculator.cal(month1,day1,month2,day2,year));


    }
    /*
    test7 for predicate 2  b || (c && d)
    b=F,m4==0
    c=T,  m100==0
    d=F m400==0*/
    @Test
    public void testPredicate2_7(){
        int day1=15,day2=31;
        int month1=3,month2=5;
        int year=2020;
        assertEquals(  getDaysBetween(day1,month1,day2,month2,year) ,Calculator.cal(month1,day1,month2,day2,year));






    }
    /*    test5 for predicate 2  b || (c && d)
b=F m4==0
c=T m100==0
d=T m400!=0
     */
    @Test
    public void testPredicate2_5(){
        int year=1700;
        int month1=9, month2=11;
        int day1=9,day2=11;

        assertEquals(  getDaysBetween(day1,month1,day2,month2,year) ,Calculator.cal(month1,day1,month2,day2,year));



    }
    /*
    *b= F	m4==0
    * c=T m100==0
    * d=F m400==0*/
    @Test
    public void testPredicate2_6(){
        int year=2000;
        int month1=4,month2=12;
        int day1=9,day2=19;
        assertEquals(  getDaysBetween(day1,month1,day2,month2,year) ,Calculator.cal(month1,day1,month2,day2,year));






    }

}
