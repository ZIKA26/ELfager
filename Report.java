package System;

public class Report  {
    public void list(int id)
    {     FileHandling fileHandler = new FileHandling("C:\\Users\\t\\IdeaProjects\\FInal\\Employee_data.txt");
        // Read all Employees from the file
        String fileContent = fileHandler.ReadFile();
        String[] lines = fileContent.split("\n");

        // Display  Employee's information with given id
        for (String line : lines) {
            if (!line.trim().isEmpty()) { // Check if the line is not empty or whitespace
                String[] employeeData = line.split(",");
                if (employeeData.length == 4 && employeeData[0].equals(Integer.toString(id))) { // Check if the line has all expected data
                    System.out.println("ID: " + employeeData[0] + ", Name: " + employeeData[1] + ", Salary: " + employeeData[2] + ",Email:" + employeeData[3]);
                }
            }
        }

    }
    public void listcus(int id) {
        FileHandling fileHandler = new FileHandling("C:\\Users\\t\\IdeaProjects\\FInal\\Customer_data");

        // Read all customers from the file
        String fileContent = fileHandler.ReadFile();
        String[] lines = fileContent.split("\n");

        // Display  customer's information with given id
        for (String line : lines) {
            if (!line.trim().isEmpty()) { // Check if the line is not empty or whitespace
                String[] CustomerData = line.split(",");
                if (CustomerData.length == 3 && CustomerData[0].equals(Integer.toString(id))) { // Check if the line has all expected data
                    System.out.println("ID: " + CustomerData[0] + ", Name: " +CustomerData[1] + ",Email:" + CustomerData[2]);
                }
            }
        }
    }
}
