import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        ArrayList<Teacher> teachers = new ArrayList<>();

        teachers.add(new Teacher("Ms Kong", "S2345671H", 25, "Mathematics", "kong25@edu.com"));
        teachers.add(new Teacher("Mr Sam", "S1234567H", 30, "English", "sam30@edu.com"));

        doMenu(); // Start the main menu
    }

    public static void doMenu() {
        int option;

        do {
            System.out.println("-------------------------------------");
            System.out.println("Tuition Management System");
            System.out.println("-------------------------------------");
            System.out.println("1. Add User");
            System.out.println("2. View All Users");
            System.out.println("3. Delete Users");
            System.out.println("4. Exit");
            option = Helper.readInt("Enter an option > ");

            switch (option) {
                case 1:
                    doAddUserMenu(); // Call the add user menu method
                    break;
               
                case 4:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option!");
            }

        } while (option != 4);
    }

    public static void doAddUserMenu() {
           int choice = 0;

        do {
            System.out.println("--------------------");
            System.out.println("ADD USER");
            System.out.println("--------------------");
            System.out.println("1. Add Student Account");
            System.out.println("2. Add Teacher Account");
            System.out.println("3. Back");
            choice = Helper.readInt("Enter an option > ");

           

        } while (choice != 3);
    }

    public static void addTeacherMenu(ArrayList<Teacher> teachers) {
        System.out.println("--------------------");
        System.out.println("ADD TEACHER USER");
        System.out.println("--------------------");
        String tname = Helper.readString("Enter teacher's name > ");
        String tnric = Helper.readString("Enter teacher's NRIC > ");
        int tage = Helper.readInt("Enter teacher's age > ");
        String tcourse = Helper.readString("Enter teacher's course > ");
        String temail = Helper.readString("Enter teacher's email > ");

        addTeacher(teachers, tname, tnric, tage, tcourse, temail);
    }
    

    public static void addTeacher(ArrayList<Teacher> teachers, String tname, String tnric, int tage, String tcourse,
            String temail) {
        teachers.add(new Teacher(tname, tnric, tage, tcourse, temail));
        System.out.println("Teacher added successfully!");
        doMenu();
    }

    public static void viewAllUsers(ArrayList<Teacher> teachers) {
        System.out.println("--------------------");
        System.out.println("VIEW ALL USERS");
        System.out.println("--------------------");
        
        
        System.out.println("Teachers:");
        for (Teacher teacher : teachers) {
            System.out.println("Name: " + teacher.getTname() + ", NRIC: " + teacher.getTnric());
        }
    }

    public static void deleteUsers(ArrayList<Teacher> teachers) {
        System.out.println("--------------------");
        System.out.println("DELETE USER");
        System.out.println("--------------------");

        String nric = Helper.readString("Enter NRIC of user to delete > ");
        boolean userDeleted = deleteUser(teachers, nric);
        if (userDeleted) {
            System.out.println("User deleted successfully!");
        } else {
            System.out.println("User not found or incorrect personal details.");
        }
    }

    public static boolean deleteUser(ArrayList<Teacher> teachers,
            String nric) {
       

        teachers.removeIf(teacher -> teacher.getTnric().equals(nric));

        return teachers.isEmpty();
    }
}
