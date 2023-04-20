import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ClassroomManage {
    private static ArrayList<Classroom> classrooms = new ArrayList<>(Arrays.asList(
            new Classroom("Lớp 1"),
            new Classroom("Lớp 2")
    ));
    private static Scanner scanner = new Scanner(System.in);

    public ClassroomManage() {
    }

    public static void displayAllClass() {
        if (classrooms.size() == 0) {
            System.out.println("Chưa có lớp!");
        } else {
            for (Classroom classroom : classrooms) {
                System.out.println(classroom);
            }
        }
    }

    public static void addNewClassroom() {
        System.out.println("Nhập tên lớp");
        String name = scanner.nextLine();
        Classroom classroom = new Classroom(name);
        classrooms.add(classroom);
    }

    public static Classroom getClassroom(int id) {
        for (int i = 0; i < classrooms.size(); i++) {
            if (classrooms.get(i).getId() == id) {
                return classrooms.get(i);
            }
        }
        return null;
    }

    public static void editClassroom() {
        displayAllClass();
        System.out.println("Mời nhập vào id");
        int id = Integer.parseInt(scanner.nextLine());
        Classroom classroom = getClassroom(id);
        if (classroom != null) {
            System.out.println("Nhập vào tên lớp mới");
            classroom.setName(scanner.nextLine());
        } else {
            System.out.println("Không có id vừa nhập");
        }
    }

    public static void deleteClassroom() {
        displayAllClass();
        System.out.println("Mời nhập vào id");
        int id = Integer.parseInt(scanner.nextLine());
        Classroom classroom = getClassroom(id);
        if (classroom != null) {
            classrooms.remove(classroom);
        } else {
            System.out.println("Không có id vừa nhập");
        }
    }

    public void setClassrooms(ArrayList<Classroom> classrooms) {
        this.classrooms = classrooms;
    }

    public ArrayList<Classroom> getClassrooms() {
        return classrooms;
    }
}
