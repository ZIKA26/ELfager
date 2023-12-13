package Users;
import System.User;
import System.CrudEmp;
import  System.FileHandling;
public class Employee extends User implements CrudEmp {
    private static FileHandling fileHandler_data;
    private static int nextId = 1;

    public void setId() {
        String filecontent = fileHandler_data.ReadFile();
        String[] lines = filecontent.split("\n");
        if(filecontent.isEmpty()){
            this.id=nextId;
        }
        else{

            String[] mealData = lines[lines.length-1].split(",");
            this.id=(Integer.parseInt(mealData[0]))+1;
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private String name;
    private double salary;
    private String email;
    public Employee() {
        fileHandler_data = new FileHandling("C:\\Users\\t\\IdeaProjects\\FInal\\Employee_data.txt");
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public boolean add(Employee emp) {
        String EmployeeData = emp.getId() + "," + emp.getName() + "," + emp.getSalary() + "," + emp.getEmail();
        return fileHandler_data.WriteToFile(EmployeeData);
    }

    @Override
    public boolean delete(int id) {
        String fileContent = fileHandler_data.ReadFile();
        String[] lines = fileContent.split("\n");
        String updatedContent = "";
        // Find and remove the Employee with the given ID
        for (String line : lines) {
            String[] employeeData = line.split(",");
            if (!employeeData[0].equals(Integer.toString(id))) {
                updatedContent += line + "\n";
            }
        }

        // Write the updated content back to the file
        return fileHandler_data.updatesToFile(updatedContent);  }

    @Override
    public boolean update(int id, Employee updatedemployee) {
        // Read all Employees from the file
        String fileContent = fileHandler_data.ReadFile();
        String[] lines = fileContent.split("\n");

        String updatedContent = "";

        // Find the Employee with the same ID as the updated Employee
        for (String line : lines) {
            String[] employeeData = line.split(",");

            if (employeeData[0].equals(Integer.toString(id))) {
                updatedContent += id + ","
                        + updatedemployee.getName() + ","
                        + updatedemployee.getSalary() + ","
                        + updatedemployee.getEmail() + "\n";
            } else {
                updatedContent += line + "\n";
            }
        }

        // Write the updated content back to the file
        return fileHandler_data.updatesToFile(updatedContent);
    }

    @Override
    public void list() {
        // Read all Employees from the file
        String fileContent = fileHandler_data.ReadFile();
        String[] lines = fileContent.split("\n");

        // Display each Employee's information
        for (String line : lines) {
            if (!line.trim().isEmpty()) { // Check if the line is not empty or whitespace
                String[] employeeData = line.split(",");
                if (employeeData.length == 4) { // Check if the line has all expected data
                    System.out.println("ID: " + employeeData[0] + ", Name: " + employeeData[1] + ", Salary: " + employeeData[2] + ",Email:" + employeeData[3]);
                } else {
                    System.out.println("Invalid data: " + line);
                }
            }
        }

    }

    @Override
    public String search(String Name) {
        String fileContent = fileHandler_data.ReadFile();
        String[] lines = fileContent.split("\n");
        String Employee_searched="";
        // Find and Get the Employee with the given Name
        for (String line : lines) {
            String[] employeeData = line.split(",");
            if (employeeData[1].equals(Name) && employeeData.length == 4) {
                Employee_searched+="ID: " + employeeData[0] + ", Name: " + employeeData[1] + ", Salary: " + employeeData[2] + ",Email:" + employeeData[3];
            }
        }
      return Employee_searched;
    }


}

