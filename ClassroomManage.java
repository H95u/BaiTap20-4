import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ClassroomManage {
    private ArrayList<Classroom> classrooms;
    private Scanner scanner = new Scanner(System.in);

    public ClassroomManage() {
        classrooms = new ArrayList<>();
        classrooms.add(new Classroom("Lớp 1"));
        classrooms.add(new Classroom("Lớp 2"));
    }

    public void displayAllClass() {
        for (Classroom classroom : classrooms) {
            System.out.println(classroom);
        }
    }

    public void addNewClassroom() {
        System.out.println("Nhập tên lớp");
        String name = scanner.nextLine();
        Classroom classroom = new Classroom(name);
        classrooms.add(classroom);
    }

    public Classroom getClassroom(int id) {
        for (int i = 0; i < classrooms.size(); i++) {
            if (classrooms.get(i).getId() == id) {
                return classrooms.get(i);
            }
        }
        return null;
    }

    public void editClassroom() {
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

    public void deleteClassroom(Classroom classroom) {
        classrooms.remove(classroom);
    }

    public void setClassrooms(ArrayList<Classroom> classrooms) {
        this.classrooms = classrooms;
    }

    public ArrayList<Classroom> getClassrooms() {
        return classrooms;
    }
}
