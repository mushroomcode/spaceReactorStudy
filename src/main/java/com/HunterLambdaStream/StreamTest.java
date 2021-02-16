package com.HunterLambdaStream;

import com.Entity.Hunter;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *  Java8的Stream功能，集成lambda测试
 */
public class StreamTest  {

    public static void main(String[] args) {

        //
        List<Hunter> hunters2Programmers = new ArrayList<Hunter>() {
            {
                add(new Hunter("Jarrod", "Pace", "PHP programmer", "male", 34, 15520));
                add(new Hunter("Clarette", "Cicely", "PHP programmer", "female", 23, 12300));
                add(new Hunter("Victor", "Channing", "PHP programmer", "male", 32, 16000));
                add(new Hunter("Tori", "Sheryl", "PHP programmer", "female", 21, 14100));
                add(new Hunter("Osborne", "Shad", "PHP programmer", "male", 32, 19100));
                add(new Hunter("Rosalind", "Layla", "PHP programmer", "female", 25, 13100));
                add(new Hunter("Fraser", "Hewie", "PHP programmer", "male", 36, 110000));
                add(new Hunter("Quinn", "Tamara", "PHP programmer", "female", 21, 15000));
                add(new Hunter("Alvin", "Lance", "PHP programmer", "male", 38, 19600));
                add(new Hunter("Evonne", "Shari", "PHP programmer", "female", 40, 18100));
            }
        };

        List<Hunter> hunters1Programmers = new ArrayList<Hunter>() {
            {
                add(new Hunter("Elsdon", "Jaycob", "Java programmer", "male", 43, 22000));
                add(new Hunter("Tamsen", "Brittany", "Java programmer", "female", 23, 15500));
                add(new Hunter("Floyd", "Donny", "Java programmer", "male", 33, 18000));
                add(new Hunter("Sindy", "Jonie", "Java programmer", "female", 32, 18600));
                add(new Hunter("Vere", "Hervey", "Java programmer", "male", 22, 12200));
                add(new Hunter("Maude", "Jaimie", "Java programmer", "female", 27, 19900));
                add(new Hunter("Shawn", "Randall", "Java programmer", "male", 30, 22300));
                add(new Hunter("Jayden", "Corrina", "Java programmer", "female", 35, 17100));
                add(new Hunter("Palmer", "Dene", "Java programmer", "male", 33, 22000));
                add(new Hunter("Addison", "Pam", "Java programmer", "female", 34, 12300));
            }
        };

        // 使用Java stream 进行数据过滤
        hunters1Programmers.stream()
                .filter((p) -> (p.getSalary() > 1400))
                .forEach((p) -> System.out.printf("%s, %s; \n", p.getFirstName(), p.getLastName()));

        /**
         * 使用 function Predicate 自定义过滤器
         */
        Predicate<Hunter> ageFilter = p->(p.getAge() > 25) ;
        Predicate<Hunter> salaryFilter = (p) -> (p.getSalary() > 1400);
        Predicate<Hunter> ageAndSalary = (p) -> (
            p.getAge() > 25 && p.getSalary() > 1400
        );

        System.out.println(" ========= ");
        hunters2Programmers.stream()
                .filter(ageFilter).filter(salaryFilter)
                .forEach((p) -> System.out.printf("%s, %s; \n", p.getFirstName(), p.getLastName()));

        System.out.println("  --------  ");
//        hunters2Programmers.stream()
//                .filter(ageAndSalary)
//                .forEach((p) -> System.out.printf("%s, %s; \n", p.getFirstName(), p.getLastName()));

        /**
         * sorted 方法，可以 s1 - s2 为ASC，s2 - s1 为DESC
         */
        hunters1Programmers
                .stream()
                .sorted((p, p2) -> (int) (p.getSalary() - p2.getSalary()))
                .forEach((p) -> System.out.printf("%s, %s; \n", p.getFirstName(), p.getLastName()));

        System.out.println("------------");
        List<Hunter> sortList = hunters1Programmers
                .stream()
                .sorted((p, p2) -> (int)(p2.getSalary() - p.getSalary()))
                // 这个collect只是为了返回一个List集合
                .collect(Collectors.toList());
//        int a = ":io".length();
        Stream.of("Honda", "Toyota", "volvo", "Tesla", "Vw", "BMW", "Audi")
                .mapToInt(String::length)
                .forEach(System.out::println);

        List<String> firstNameList = hunters1Programmers
                .parallelStream()
                .map(Hunter::getFirstName).collect(Collectors.toList());
        firstNameList.forEach(System.out::println);

        sortList.forEach((p) -> System.out.printf("%s, %s, %f; \n", p.getFirstName(), p.getLastName(), p.getSalary()));
    }
}
