package com.sangay.ecom.learning.functional.streams;


import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class Course {
    private String name;
    private String category;
    private int reviewScore;
    private int noOfStudent;

    public Course(String name, String category, int reviewScore, int noOfCategory) {
        this.name = name;
        this.category = category;
        this.reviewScore = reviewScore;
        this.noOfStudent = noOfCategory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getReviewScore() {
        return reviewScore;
    }

    public void setReviewScore(int reviewScore) {
        this.reviewScore = reviewScore;
    }

    public int getNoOfStudent() {
        return noOfStudent;
    }

    public void setNoOfStudent(int noOfStudent) {
        this.noOfStudent = noOfStudent;
    }

    @Override
    public String toString() {
        return name + ":" + noOfStudent + ":" + reviewScore;
    }
}

public class customClass {

    public static void main(String[] args) {

        List<Course> courses = List.of(
                new Course("Spring", "Framework", 90, 20000),
                new Course("Spring Boot", "Framework", 90, 20000),
                new Course("API", "Framework", 98, 20000),
                new Course("Fullstack", "Framework", 90, 20000),
                new Course("Azure", "Cloud", 98, 20000));

        Predicate<Course> coursePredicate = course -> course.getReviewScore() > 90;
        boolean b = courses.stream()
                .anyMatch(coursePredicate);
        System.out.println(b);

        Function<Course, Integer> getNoOfStudent = Course::getNoOfStudent;
        Comparator<Course> courseComparator = Comparator.comparing(getNoOfStudent);
        Comparator<Course> courseComparatorDecrease = Comparator.comparing(getNoOfStudent).reversed();

        courses.stream()
                .sorted(courseComparator)
                .limit(5)
                .toList();


    }


}
