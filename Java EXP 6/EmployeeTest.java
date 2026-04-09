import java.time.LocalDate;

// ABSTRACT ROOT CLASS
abstract class Employee {
    protected int empId;
    protected String name;
    protected String PANNo;
    protected LocalDate joiningDate;
    protected String designation;

    public Employee(int empId, String name, String PANNo, LocalDate joiningDate, String designation) {
        this.empId = empId;
        this.name = name;
        this.PANNo = PANNo;
        this.joiningDate = joiningDate;
        this.designation = designation;
    }

    // ABSTRACT METHOD
    public abstract double calcCTC();

    public void display() {
        System.out.println("ID: " + empId);
        System.out.println("Name: " + name);
        System.out.println("PAN: " + PANNo);
        System.out.println("Joining Date: " + joiningDate);
        System.out.println("Designation: " + designation);
    }
}

//////////////////////////////////////////////////////////////

// CHILD CLASS 1: FullTimeEmployee
class FullTimeEmployee extends Employee {
    protected double baseSalary;
    protected String role;
    protected double perfBonus;
    protected double hiringCommission;

    public FullTimeEmployee(int empId, String name, String PANNo, LocalDate joiningDate,
                            String designation, double baseSalary, String role,
                            double perfBonus, double hiringCommission) {
        super(empId, name, PANNo, joiningDate, designation);
        this.baseSalary = baseSalary;
        this.role = role;
        this.perfBonus = perfBonus;
        this.hiringCommission = hiringCommission;
    }

    @Override
    public double calcCTC() {
        if (role.equalsIgnoreCase("SWE")) {
            return baseSalary + perfBonus;
        } else if (role.equalsIgnoreCase("HR")) {
            return baseSalary + hiringCommission;
        }
        return baseSalary;
    }
}

//////////////////////////////////////////////////////////////

// CHILD CLASS 2: ContractEmployee
class ContractEmployee extends Employee {
    private int noOfHrs;
    private double hourlyRate;

    public ContractEmployee(int empId, String name, String PANNo, LocalDate joiningDate,
                            String designation, int noOfHrs, double hourlyRate) {
        super(empId, name, PANNo, joiningDate, designation);
        this.noOfHrs = noOfHrs;
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double calcCTC() {
        return noOfHrs * hourlyRate;
    }
}

//////////////////////////////////////////////////////////////

// MULTILEVEL CHILD: Manager (Child of FullTimeEmployee)
class Manager extends FullTimeEmployee {
    private double TA;
    private double eduAllowance;

    public Manager(int empId, String name, String PANNo, LocalDate joiningDate,
                   String designation, double baseSalary, double perfBonus,
                   double TA, double eduAllowance) {

        super(empId, name, PANNo, joiningDate, designation,
              baseSalary, "SWE", perfBonus, 0);

        this.TA = TA;
        this.eduAllowance = eduAllowance;
    }

    @Override
    public double calcCTC() {
        return baseSalary + perfBonus + TA + eduAllowance;
    }
}

//////////////////////////////////////////////////////////////

// MAIN CLASS
public class EmployeeTest {
    public static void main(String[] args) {

        // Full Time Employee - SWE
        FullTimeEmployee emp1 = new FullTimeEmployee(
                101, "Tanmay", "ABCDE1234F",
                LocalDate.of(2022, 5, 10),
                "Software Engineer",
                50000, "SWE", 10000, 0);

        // Full Time Employee - HR
        FullTimeEmployee emp2 = new FullTimeEmployee(
                102, "Riya", "XYZAB5678K",
                LocalDate.of(2023, 1, 15),
                "HR",
                40000, "HR", 0, 8000);

        // Contract Employee
        ContractEmployee emp3 = new ContractEmployee(
                201, "Aman", "LMNOP4321Q",
                LocalDate.of(2024, 3, 1),
                "Contract Developer",
                120, 500);

        // Manager
        Manager manager = new Manager(
                301, "Rahul", "QWERT1234Z",
                LocalDate.of(2020, 7, 20),
                "Manager",
                80000, 20000, 5000, 7000);

        // DISPLAY OUTPUT
        System.out.println("---- FULL TIME EMPLOYEE (SWE) ----");
        emp1.display();
        System.out.println("CTC: " + emp1.calcCTC());

        System.out.println("\n---- FULL TIME EMPLOYEE (HR) ----");
        emp2.display();
        System.out.println("CTC: " + emp2.calcCTC());

        System.out.println("\n---- CONTRACT EMPLOYEE ----");
        emp3.display();
        System.out.println("CTC: " + emp3.calcCTC());

        System.out.println("\n---- MANAGER ----");
        manager.display();
        System.out.println("CTC: " + manager.calcCTC());
    }
}