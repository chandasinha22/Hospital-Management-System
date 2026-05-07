import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        PatientDAO dao = new PatientDAO();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n=== Hospital Management System ===");
            System.out.println("1. Add Patient");
            System.out.println("2. View All Patients");
            System.out.println("3. Delete Patient");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    sc.nextLine();
                    System.out.print("Name: ");
                    String name = sc.nextLine();
                    System.out.print("Age: ");
                    int age = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Disease: ");
                    String disease = sc.nextLine();
                    System.out.print("Phone: ");
                    String phone = sc.nextLine();
                    dao.addPatient(name, age, disease, phone);
                    break;
                case 2:
                    dao.viewPatients();
                    break;
                case 3:
                    System.out.print("Enter Patient ID to delete: ");
                    int id = sc.nextInt();
                    dao.deletePatient(id);
                    break;
                case 4:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 4);
        sc.close();
    }
}