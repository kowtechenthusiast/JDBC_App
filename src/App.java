import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);

        do{
            System.out.print("1.Insert  2.Read  3.Update  4.Delete  5.Exit --> ");
            int input = getIntInput(sc);
            switch (input){
                case 1 :
                    System.out.print("ID: ");
                    int id = getIntInput(sc);
                    System.out.print("Name: ");
                    String name = sc.next();
                    System.out.print("Age: ");
                    int age = getIntInput(sc);
                    System.out.print("Salary: ");
                    double salary = getDoubleInput(sc);

                    Employee emp = new Employee(id,name,age,salary);
                    EmployeeDAO.insertEmployee(emp);
                    break;

                case 2 :
                    ArrayList<Employee> list = EmployeeDAO.readEmployee();
                    for(Employee employee : list){
                        System.out.println(employee);
                    }
                    System.out.println();
                    break;

                case 3:
                    System.out.print("ID: ");
                    int idToUpdate = getIntInput(sc);
                    System.out.print("Name: ");
                    String nameToUpdate = sc.next();

                    EmployeeDAO.updateEmployee(nameToUpdate,idToUpdate);
                    break;

                case 4:
                    System.out.print("ID: ");
                    int idToDelete = getIntInput(sc);

                    EmployeeDAO.deleteEmployee(idToDelete);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid input. Please select between 1 to 5.");
            }
            System.out.println();
        }while (true);
    }
    private static int getIntInput(Scanner sc) {
        while (!sc.hasNextInt()) {
            System.out.print("Invalid input. Please enter a valid integer: ");
            sc.next();
        }
        return sc.nextInt();
    }

    private static double getDoubleInput(Scanner sc) {
        while (!sc.hasNextDouble()) {
            System.out.print("Invalid input. Please enter a valid number: ");
            sc.next();
        }
        return sc.nextDouble();
    }
}
