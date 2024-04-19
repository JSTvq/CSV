package com.kir138;

import java.io.*;
import java.util.ArrayList;

public class StudentsRepository {
    private ArrayList<Students> res1 = new ArrayList<Students>();
    ArrayList<Integer> grades = new ArrayList<>();

    public StudentsRepository() {
    }

    public StudentsRepository(String file) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            bufferedReader.readLine();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                try {
                    String[] split = line.split(";");
                    //String surname = split[0];
                    //String name = split[1];
                    //int course = Integer.parseInt(split[2]);

                    for (int i = 3; i < split.length; i++) {
                        grades.add(Integer.parseInt(split[i]));
                    }

                    Students students = new Students(split[0], split[1], Integer.parseInt(split[2]), grades);
                    this.res1.add(students);
                    }
                catch (RuntimeException ignored) {}
            }
        }
    }

    public void save(String file) throws IOException {
       try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))) {
           bufferedWriter.write("surname; name; course; listRatings\n");
           for (Students students : this.res1) {
               bufferedWriter.write(students.toCSV());
               bufferedWriter.newLine();
           }
       }
    }

    public void add(Students student) {
        this.res1.add(student);
    }

    /**
     * Найти всех студентов отличников, то есть студентов, у которых все оценки отличные
     */
    public Student search() {
        boolean grade = true;
        for (Integer i : this.grades) {
            if (i != 5) {
                grade = false;
                break;
            }
            if (grade) {
                return this;
            } else {
                return null;
            }
        }
        return null;
    }

    /**
     * Найти средний рейтинг каждого студента
     */

    /**
     * Отсортировать студентов по среднему рейтингу
     */

    /**
     * Найти всех студентов с наибольшим средним баллом, который может быть не обязательно 5, не используя сортировку
     */
    
    @Override
    public String toString() {
        return "StudentsRepository{" +
                "res1=" + res1 +
                '}';
    }
}
