package com.kir138;

import java.io.IOException;
import java.util.ArrayList;

public class Program {
    public static void main(String[] args) {
        try {
            StudentsRepository studentsRepository = new StudentsRepository("file.csv");
            System.out.println(studentsRepository);

            //ArrayList<Students> gg = new ArrayList<>();
            //gg.add1(1, 2, 3);
            //studentsRepository.add(new Students("Kir", "Vir", 3, gg));
            //studentsRepository.save("out.csv");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
