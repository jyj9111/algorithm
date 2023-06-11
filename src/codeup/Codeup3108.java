package codeup;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Students {


    private String code;
    private int testId;
    private String name;

    public Students(String code, int testId, String name) {
        this.code = code;
        this.testId = testId;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public int getTestId() {
        return testId;
    }

    public String getName() {
        return name;
    }
}
public class Codeup3108 {
    
    private List<Students> studentsList = new ArrayList<>();
    
    private Students makeStudent(String code, String testId, String name) {
        return new Students(code, Integer.parseInt(testId), name);
    }
    
    private void addAStudent(Students students) {
        if (!isExist(students))
            studentsList.add(students);
    }
    private void removeAStudent(Students pStudents) {
        for (int i = 1; i <= studentsList.size() ; i++) {
            if(isExist(studentsList.get(i))) studentsList.remove(i);
        }
    }
    
    private boolean isExist(Students pStudent) {
        for (Students student : studentsList) {
            if(pStudent.getTestId() == student.getTestId()) return true;
        }
        return false;
    }

    public void sortStudent(Students sStudent) {
        if(studentsList.isEmpty()) addAStudent(sStudent);
        else {

        }
    }

    public void printStudentList() {
        for(Students st : studentsList) {
            System.out.printf("%s %d %s\n", st.getCode(), st.getTestId(), st.getName());
        }
    }
    public void printSpecificStudents(int[] arr) {
        Collections.sort(studentsList, new Comparator<Students>() {
            @Override
            public int compare(Students o1, Students o2) {
                return o1.getTestId() - o2.getTestId();
            }
        });

        for (int i = 0; i < arr.length; i++) {
            Students fst = studentsList.get(arr[i] - 1);
            System.out.printf("%s %d %s\n", fst.getCode(), fst.getTestId(), fst.getName());
        }
    }

    private void process(Students pStudent) {
        switch (pStudent.getCode()) {
            case "I" -> addAStudent(pStudent);
            case "D" -> removeAStudent(pStudent);
        }
    }
    public void inputProcess(int num , BufferedReader br) throws IOException {
        for (int i = 0; i < num; i++) {
            String[] input = br.readLine().split(" ");
            Students students = makeStudent(input[0], input[1], input[2]);
            process(students);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Codeup3108 cd3108 = new Codeup3108();

        int num = Integer.parseInt(br.readLine());

        cd3108.inputProcess(num, br);
        cd3108.printSpecificStudents(new int[] {1, 2, 3, 4, 5});
        //cd3108.printStudentList();
    }
}
