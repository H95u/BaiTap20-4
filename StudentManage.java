import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class StudentManage implements ManageInterface<Student> {
    private ArrayList<Student> students;
    private Map<Integer, String> genders;

    private Scanner scanner;
    private static double countCheckAge = 0;
    private static double countCheckAvgPoint = 0;

    public StudentManage() {
        students = new ArrayList<>();
        genders = new TreeMap<>();
        genders.put(1, "Nam");
        genders.put(2, "Nữ");
        genders.put(3, "Khác");
        scanner = new Scanner(System.in);
    }

    @Override
    public Student createStudent() {
        System.out.println("Nhập vào tên");
        String name = scanner.nextLine();
        int age;
        do {
            System.out.println("Nhập vào tuổi >=6 , <=60");
            age = Integer.parseInt(scanner.nextLine());
            if (!checkAge(age)) System.out.println("Nhập sai! Nhập lại");
        } while (!checkAge(age) && countCheckAge % 3 != 0);
        if (countCheckAge % 3 == 0) return null;
        double avgPoint;
        do {
            System.out.println("Nhập vào điểm >=0 , <=10");
            avgPoint = Double.parseDouble(scanner.nextLine());
            if (!checkAvgPoint(avgPoint)) System.out.println("Nhập sai! Nhập lại");
        } while (!checkAvgPoint(avgPoint) && countCheckAvgPoint % 3 != 0);
        if (countCheckAvgPoint % 3 == 0) return null;
        System.out.println("Nhập vào giới tính");
        System.out.println(genders);
        int choice = Integer.parseInt(scanner.nextLine());
        String gender = getGender(choice);
        System.out.println("Nhập vào lớp");
        ClassroomManage.displayAllClass();
        System.out.println("Nhập vào lựa chọn");
        int id = Integer.parseInt(scanner.nextLine());
        Classroom classroom = ClassroomManage.getClassroom(id);
        return new Student(name, age, gender, avgPoint, classroom);
    }

    @Override
    public Student updateStudent() {
        Student student = getStudent();
        if (student != null) {
            System.out.println("Nhập vào tên mới");
            String name = scanner.nextLine();
            int age;
            do {
                System.out.println("Nhập vào tuổi mới >=6 , <=60");
                age = Integer.parseInt(scanner.nextLine());
                if (!checkAge(age)) System.out.println("Nhập sai! Nhập lại");
            } while (!checkAge(age) && countCheckAge % 3 != 0);
            if (countCheckAge % 3 == 0) return null;
            double avgPoint;
            do {
                System.out.println("Nhập vào điểm mới >=0 , <=10");
                avgPoint = Double.parseDouble(scanner.nextLine());
                if (!checkAvgPoint(avgPoint)) System.out.println("Nhập sai! Nhập lại");
            } while (!checkAvgPoint(avgPoint) && countCheckAvgPoint % 3 != 0);
            if (countCheckAvgPoint % 3 == 0) return null;
            System.out.println("Nhập vào giới tính mới");
            System.out.println(genders);
            int choice = Integer.parseInt(scanner.nextLine());
            String gender = getGender(choice);
            System.out.println("Nhập vào lớp");
            ClassroomManage.displayAllClass();
            System.out.println("Nhập vào lựa chọn");
            int id = Integer.parseInt(scanner.nextLine());
            Classroom classroom = ClassroomManage.getClassroom(id);
            student.setName(name);
            student.setAge(age);
            student.setAvgPoint(avgPoint);
            student.setGender(gender);
            student.setClassroom(classroom);
        } else {
            System.out.println("Không có id bạn vừa nhập!");
        }
        return student;
    }

    @Override
    public Student deleteStudent() {
        displayAll();
        Student student = getStudent();
        if (student != null) {
            students.remove(student);
            return student;
        } else {
            System.out.println("Không có id bạn vừa nhập!");
            return null;
        }
    }

    @Override
    public Student getStudent() {
        System.out.println("Nhập vào id");
        int id = Integer.parseInt(scanner.nextLine());
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }

    @Override
    public void displayAll() {
        for (Student student : students) {
            if (student != null) {
                System.out.println(student);
            }
        }
    }

    public String getGender(int i) {
        return genders.get(i);
    }

    public void addNewStudent(Student student) {
        students.add(student);
    }

    public void displayStudentByID() {
        Student student = getStudent();
        if (student != null) {
            System.out.println(student);
        } else {
            System.out.println("Không có id bạn vừa nhập");
        }
    }

    public void displayAcademicAbility() {
        for (Student student : students) {
            double avgPoint = student.getAvgPoint();
            if (avgPoint > 8) {
                System.out.println(student + "Học lực : Giỏi");
            } else if (avgPoint > 6) System.out.println(student + "Học lực : Giỏi");
            else if (avgPoint > 4.5) System.out.println(student + "Học lực : TB");
            else System.out.println(student + "Học lực : Kém");
        }
    }

    public void displayLowAndHighAvgPoint() {
        int maxIndex = 0;
        int minIndex = 0;
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getAvgPoint() > students.get(maxIndex).getAvgPoint()) {
                maxIndex = i;
            }
            if (students.get(i).getAvgPoint() < students.get(minIndex).getAvgPoint()) {
                minIndex = i;
            }
        }
        System.out.println("Cao nhất : " + students.get(maxIndex));
        System.out.println("Thấp nhât : " + students.get(minIndex));
    }

    public void displayStudentContainName() {
        System.out.println("Nhập vào tên bạn muốn tìm ");
        String name = scanner.nextLine();
        for (Student student : students) {
            if (student.getName().contains(name)) {
                System.out.println(student);
            }
        }
    }

    public void displayByGender() {
        System.out.println("Nhập vào giới tính");
        System.out.println(genders);
        int choice = Integer.parseInt(scanner.nextLine());
        String gender = getGender(choice);
        if (gender != null) {
            for (Student student : students) {
                if (student.getGender().equals(gender)) {
                    System.out.println(student);
                }
            }
        } else {
            System.out.println("Không có");
        }
    }

    public void displayByClassroom() {
        System.out.println("Nhập vào lớp");
        ClassroomManage.displayAllClass();
        int choice = Integer.parseInt(scanner.nextLine());
        Classroom classroom = ClassroomManage.getClassroom(choice);
        if (classroom != null) {
            for (Student student : students) {
                if (student.getClassroom() == classroom) {
                    System.out.println(student);
                }
            }
        } else {
            System.out.println("Không có");
        }
    }

    public boolean checkAvgPoint(double avgPoint) {
        countCheckAvgPoint++;
        return avgPoint >= 0 && avgPoint <= 10;
    }

    public boolean checkAge(int age) {
        countCheckAge++;
        return age >= 6 && age <= 60;
    }
}
