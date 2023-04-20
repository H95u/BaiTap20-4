
import java.util.Scanner;

public class MySystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentManage studentManage = new StudentManage();
        int choice;
        do {
            System.out.println("-----------MENU-----------");
            System.out.println("1. Tạo mới 1 hs");
            System.out.println("2. Xóa 1 hs theo id");
            System.out.println("3. Hiển thị 1 hs theo id");
            System.out.println("4. Hiển thị tất cả hs");
            System.out.println("5. Sửa thông tin hs");
            System.out.println("6. Hiển thị tất cả hs + thông tin học lực dựa theo điểm TB");
            System.out.println("7. Hiển thị hs có điểm cao nhất, thấp nhất");
            System.out.println("8. Tìm kiếm hs theo tên gần đúng");
            System.out.println("9. Hiển thị tất cả hs theo giới tính");
            System.out.println("10. Hiển thị tất cả hs theo lớp");
            System.out.println("11. Quản lý lớp học");
            System.out.println("0. Thoát");
            System.out.println("MỜI NHẬP VÀO LỰA CHỌN CỦA BẠN");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    Student student = studentManage.createStudent();
                    studentManage.addNewStudent(student);
                    studentManage.displayAll();
                    break;
                case 2:
                    studentManage.deleteStudent();
                    break;
                case 3:
                    studentManage.displayStudentByID();
                    break;
                case 4:
                    studentManage.displayAll();
                    break;
                case 5:
                    studentManage.updateStudent();
                    studentManage.displayAll();
                    break;
                case 6:
                    studentManage.displayAcademicAbility();
                    break;
                case 7:
                    studentManage.displayLowAndHighAvgPoint();
                    break;
                case 8:
                    studentManage.displayStudentContainName();
                    break;
                case 9:
                    studentManage.displayByGender();
                    break;
                case 10:
                    studentManage.displayByClassroom();
                    break;
                case 11:
                    int myChoice;
                    do {
                        System.out.println("-----------MENU-----------");
                        System.out.println("1. Tạo mới 1 lớp");
                        System.out.println("2. Sửa thông tin lớp theo id");
                        System.out.println("3. Xóa lớp theo id");
                        System.out.println("4. Lấy ra 1 lớp theo id");
                        System.out.println("5. Hiển thị tất cả các lớp");
                        System.out.println("0. Thoát");
                        System.out.println("NHẬP VÀO LỰA CHỌN CỦA BẠN");
                        myChoice = Integer.parseInt(scanner.nextLine());
                        switch (myChoice) {
                            case 1:
                                ClassroomManage.addNewClassroom();
                                break;
                            case 2:
                                ClassroomManage.editClassroom();
                                ClassroomManage.displayAllClass();
                                break;
                            case 3:
                                ClassroomManage.deleteClassroom();
                                ClassroomManage.displayAllClass();
                                break;
                            case 4:
                                System.out.println("Mời nhập vào id");
                                int id = Integer.parseInt(scanner.nextLine());
                                System.out.println(ClassroomManage.getClassroom(id));
                                break;
                            case 5:
                                ClassroomManage.displayAllClass();
                                break;
                        }
                    } while (myChoice != 0);
                    break;
            }
        } while (choice != 0);
    }
}
