import java.util.Scanner;

class Patient {
    long ID;
    String firstname;
    String lastname;
    int age;
    String blood;
    char gender;
    boolean cured;
    Patient next;
    public Patient() {
        cured = false;
    }
}

class LinkedQueue {
    Patient head;
    Patient last;
    String departmentname;

    public LinkedQueue(String departmentname) {
        head = null;
        last = null;
        this.departmentname = departmentname;
    }

    Patient input() {
        int flag = 0;
        Patient p = new Patient();
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n   Please enter data for patient");
        System.out.print("   First name     : ");
        p.firstname = scanner.nextLine();
        System.out.print("   Last name      : ");
        p.lastname = scanner.nextLine();

        while (true) {
            System.out.print("   Blood Group    : ");
            p.blood = scanner.nextLine();

            if (p.blood.equals("A+") || p.blood.equals("a+") || p.blood.equals("A-") || p.blood.equals("a-") ||
                    p.blood.equals("B+") || p.blood.equals("b+") || p.blood.equals("B-") || p.blood.equals("b-") ||
                    p.blood.equals("O+") || p.blood.equals("o+") || p.blood.equals("O-") || p.blood.equals("o-") ||
                    p.blood.equals("AB+") || p.blood.equals("ab+") || p.blood.equals("AB-") || p.blood.equals("ab-")) {
                flag = 1;
                break;
            } else {
                System.out.println("\n   Invalid Blood Group. Try Again..\n");

            }
        }

        System.out.print("   Gender(m/f)    : ");
        p.gender = scanner.next().charAt(0);
        if((p.gender!='m') && (p.gender!='f')){
            System.out.println("Invalid Gender. Please enter a valid Gender:");
            p.gender = scanner.next().charAt(0);
        }
        System.out.print("   Age            : ");
        p.age = scanner.nextInt();
        if(!((p.age)>=0 && (p.age)<=150)){
            System.out.println("Invalid age. Please enter a valid age:");
            p.age = scanner.nextInt();
        }
        System.out.print("   Mobile number  : ");
        p.ID = scanner.nextLong();

        if (search(p.ID)) {
            p.ID = 0;
            System.out.println("\n   Data not valid. Operation cancelled.");
        }

        return p;
    }

    void output(Patient p) {
        System.out.println("\n  ------------------------------");
        System.out.println("   Patient data:");
        System.out.println("   First Name         : " + p.firstname);
        System.out.println("   Last Name          : " + p.lastname);
        System.out.println("   Gender             : " + p.gender);
        System.out.println("   Age                : " + p.age);
        System.out.println("   Blood Group        : " + p.blood);
        System.out.println("   Mobile Number      : " + p.ID);
        System.out.println("  ------------------------------");
    }

    boolean search(long item) {
        if (head == null) {
            return false;
        } else {
            int flag = 0;
            Patient p = head;

            while (p.next != null && p.ID != item) {
                p = p.next;
            }

            if (p.ID == item) {
                flag = 1;
                return true;
            }

            if (flag == 0) {
                return false;
            }
        }

        return false;
    }

    void insertAtBeg() {
        Patient p = input();

        if (p.ID == 0) {
            return;
        }

        if (head == null) {
            head = p;
            last = p;
            p.next = null;
        } else {
            p.next = head;
            head = p;
        }

        System.out.println("\n\tPatient added:");
        output(p);
    }
    void insertAtEnd() {
        Patient p = input();
        if (p.ID == 0) {
            return;
        }
        if (head == null) {
            head = p;
            last = p;
            p.next = null;
        } else {
            p.next = null;
            last.next = p;
            last = p;
        }
        System.out.println("\n  ------------------------------");
        System.out.println("  |-- HOSPITAL MANAGEMENT SYSTEM --|");
        System.out.println("  ------------------------------");
        System.out.println("\n  ----------PATIENT ADDED-----------");
        output(p);
    }
    void listOfPatients() {
        if (head == null) {
            System.out.println("\n  No patient");
        } else {
            Patient p = head;
            while (p != null) {
                System.out.println("\n   Patient data:");
                System.out.println("   First Name       : " + p.firstname);
                System.out.println("   Last Name        : " + p.lastname);
                System.out.println("   Gender           : " + p.gender);
                System.out.println("   Age              : " + p.age);
                System.out.println("   Blood Group      : " + p.blood);
                System.out.println("   Mobile Number    : " + p.ID);
                System.out.println("  ------------------------------");

                p = p.next;
            }
        }
    }
    void getCuredPatients() {
        if (head == null) {
            System.out.println("\n  No cured patients");
        } else {
            Patient p = head;

            System.out.println("\n   Cured patients:");
            while (p != null) {
                output(p);
                p = p.next;
            }
        }
    }
    void departmentMenu() {
        int choice = 0;
        Scanner scanner = new Scanner(System.in);

        while (choice != 5) {
            System.out.println("\n  ------------------------------");
            System.out.println("  |-- HOSPITAL MANAGEMENT SYSTEM --|");
            System.out.println("  ------------------------------");
            System.out.println("\n   " + departmentname);
            System.out.println("   [1] Add normal patient");
            System.out.println("   [2] Add critically ill patient");
            System.out.println("   [3] Display list");
            System.out.println("   [4] Display cured patient list  ");
            System.out.println("   [5] Change department or exit");
            System.out.print("\n   Please enter your choice : ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    insertAtEnd();
                    System.out.println("\n   Press any key");
                    scanner.nextLine();
                    scanner.nextLine();
                    break;
                case 2:
                    insertAtBeg();
                    System.out.println("\n   Press any key");
                    scanner.nextLine();
                    scanner.nextLine();
                    break;
                case 3:
                    listOfPatients();
                    System.out.println("\n   Press any key");
                    scanner.nextLine();
                    scanner.nextLine();
                    break;
                case 4:
                    getCuredPatients();
                    System.out.println("\n   Press any key");
                    scanner.nextLine();
                    scanner.nextLine();
                    break;
                default:
                    System.out.println("Invalid Choice");
                    System.out.println("Enter The Choice Again:");
                    break;
            }
        }
    }
}
public class JPR {
    public static void main(String[] args) {
        int i, choice = 0;
        LinkedQueue[] departments = new LinkedQueue[4];
        Scanner scanner = new Scanner(System.in);

        for (i = 0; i < 4; i++) {
            switch (i) {
                case 0:
                    departments[i] = new LinkedQueue("GENERAL CLINIC");
                    break;
                case 1:
                    departments[i] = new LinkedQueue("HEART CLINIC");
                    break;
                case 2:
                    departments[i] = new LinkedQueue("LUNG CLINIC");
                    break;
                case 3:
                    departments[i] = new LinkedQueue("PLASTIC SURGERY");
                    break;
            }
        }
        while (choice != 5) {
            System.out.println("\n  ------------------------------");
            System.out.println("  |-- HOSPITAL MANAGEMENT SYSTEM --|");
            System.out.println("  ------------------------------");
            System.out.println("\n   Main Menu\n");

            for (i = 0; i < 4; i++) {
                System.out.println("   " + (i + 1) + ": " + departments[i].departmentname);
            }

            System.out.println("   5: Exit");
            System.out.print("\n   Please enter your choice:");
            choice = scanner.nextInt();

            if (choice >= 1 && choice <= 4) {
                departments[choice - 1].departmentMenu();
            }
        }

        if (choice == 5) {
            System.out.println("\n\t\tThank you! \n");
        }
        System.exit(0);
    }
}