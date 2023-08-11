import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		ArrayList<Student> students = new ArrayList<>();
		ArrayList<Teacher> teachers = new ArrayList<>();

		teachers.add(new Teacher("Ms Kong", "S2345671H", 25, "Mathematics", "kong25@edu.com"));
		teachers.add(new Teacher("Mr Sam", "S1234567H", 30, "English", "sam30@edu.com"));

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

	            if (option == 1) {
	                int choice;

	                do {
	                    System.out.println("--------------------");
	                    System.out.println("ADD USER");
	                    System.out.println("--------------------");
	                    System.out.println("1. Add Student Account");
	                    System.out.println("2. Add Teacher Account");
	                    System.out.println("3. Back");
	                    choice = Helper.readInt("Enter an option > ");

	                    if (choice == 1) {
	                        System.out.println("--------------------");
	                        System.out.println("ADD STUDENT USER");
	                        System.out.println("--------------------");
	                        String name = Helper.readString("Enter student's name > ");
	                        String nric = Helper.readString("Enter student's NRIC > ");
	                        int age = Helper.readInt("Enter student's age > ");
	                        int grade = Helper.readInt("Enter student's grade > ");
	                        String email = Helper.readString("Enter student's email > ");

	                        addStudent(students, name, nric, age, grade, email); // Corrected method call
	                    } else if (choice == 2) {
	                        System.out.println("--------------------");
	                        System.out.println("ADD TEACHER USER");
	                        System.out.println("--------------------");
	                        String tname = Helper.readString("Enter teacher's name > ");
	                        String tnric = Helper.readString("Enter teacher's NRIC > ");
	                        int tage = Helper.readInt("Enter teacher's age > ");
	                        String tcourse = Helper.readString("Enter teacher's course > ");
	                        String temail = Helper.readString("Enter teacher's email > ");
	                        
	                        addTeacher(teachers, tname, tnric, tage, tcourse, temail); // Corrected method call
	                    }

	                } while (choice != 3);
	            } else if (option == 2) {
	                System.out.println("--------------------");
	                System.out.println("VIEW ALL USERS");
	                System.out.println("--------------------");
	                System.out.println("Students:");
	                for (Student student : students) {
	                    System.out.println("Name: " + student.getName() + ", NRIC: " + student.getNric());
	                }
	                System.out.println("Teachers:");
	                for (Teacher teacher : teachers) {
	                    System.out.println("Name: " + teacher.getTname() + ", NRIC: " + teacher.getTnric());
	                }
	            } else if (option == 3) {
	                System.out.println("--------------------");
	                System.out.println("DELETE USER");
	                System.out.println("--------------------");
	                String name = Helper.readString("Enter name of user to delete > "); // Changed "username" to "name"
	                String nric = Helper.readString("Enter NRIC of user to delete > "); // Changed "password" to "nric"
	                boolean userDeleted = deleteUser(students, teachers, name, nric); // Corrected method call
	                if (userDeleted) {
	                    System.out.println("User deleted successfully!");
	                } else {
	                    System.out.println("User not found or incorrect personal details.");
	                }
	            }

	        } while (option != 4);
	        System.out.println("Goodbye!");
	}

	public static void addStudent(ArrayList<Student> students, String name, String nric, int age, int grade,
			String email) {
		students.add(new Student(name, nric, age, grade, email));
		System.out.println("Student added successfully!");
	}

	public static void addTeacher(ArrayList<Teacher> teachers, String tname, String tnric, int tage, String tcourse,
			String temail) {
		teachers.add(new Teacher(tname, tnric, tage, tcourse, temail));
		System.out.println("Teacher added successfully!");
	}

	public static boolean deleteUser(ArrayList<Student> students, ArrayList<Teacher> teachers, String name,
			String nric) {
		students.removeIf(student -> student.getName().equals(name) && student.getNric().equals(nric));
		teachers.removeIf(teacher -> teacher.getTname().equals(name) && teacher.getTnric().equals(nric));

		return students.isEmpty() && teachers.isEmpty();
	}
}

//Aisha Jeerooburkhan 22023536
