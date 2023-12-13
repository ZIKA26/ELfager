package Users;
import System.User;
import System.CrudCus;
import System.FileHandling;
public class Customer extends User implements CrudCus {
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

    private  String Name;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    private  String Email;
    public Customer() {
     this.fileHandler_data=new FileHandling("C:\\Users\\t\\IdeaProjects\\FInal\\Customer_data");
    }

    @Override
    public boolean add(Customer Cus) {

        FileHandling fileHandler = new FileHandling("C:\\Users\\t\\IdeaProjects\\FInal\\Customer_data");
        String CustomerData = Cus.getId() + "," + Cus.getName() + "," + Cus.getEmail();
        return fileHandler.WriteToFile(CustomerData);
    }

    @Override
    public boolean delete(int id) {
        FileHandling fileHandler = new FileHandling("C:\\Users\\t\\IdeaProjects\\FInal\\Customer_data");
        String fileContent = fileHandler.ReadFile();
        String[] lines = fileContent.split("\n");
        String updatedContent = "";
        // Find and remove the Customer with the given ID
        for (String line : lines) {
            String[] CustomerData = line.split(",");
            if (!CustomerData[0].equals(Integer.toString(id))) {
                updatedContent += line + "\n";
            }
        }

        // Write the updated content back to the file
        return fileHandler.updatesToFile(updatedContent);


    }

    @Override
    public boolean update(int id, Customer updatedcustomer) {
        FileHandling fileHandler = new FileHandling("C:\\Users\\t\\IdeaProjects\\FInal\\Customer_data");
        // Read all Customers from the file
        String fileContent = fileHandler.ReadFile();
        String[] lines = fileContent.split("\n");
        String updatedContent = "";
        // Find the Customer with the same ID as the updated Customer
        for (String line : lines) {
            String[] CustomerData = line.split(",");

            if (CustomerData[0].equals(Integer.toString(id))) {
                updatedContent += id + ","
                        + updatedcustomer.getName() + ","
                         + updatedcustomer.getEmail() + "\n";
            } else {
                updatedContent += line + "\n";
            }
        }

        // Write the updated content back to the file
        return fileHandler.updatesToFile(updatedContent);

    }

    @Override
    public void list() {
        FileHandling fileHandler = new FileHandling("C:\\Users\\t\\IdeaProjects\\FInal\\Customer_data");
        // Read all Customers from the file
        String fileContent = fileHandler.ReadFile();
        String[] lines = fileContent.split("\n");
        // Display each Customer's information
        for (String line : lines) {
            if (!line.trim().isEmpty()) { // Check if the line is not empty or whitespace
                String[] CustomerData = line.split(",");
                if (CustomerData.length == 3) { // Check if the line has all expected data
                    System.out.println("ID: " + CustomerData[0] + ", Name: " + CustomerData[1]  + ",Email:" +CustomerData[2]);
                } else {
                    System.out.println("Invalid data: " + line);
                }
            }
        }

    }

    @Override
    public String search(String Name) {
        FileHandling fileHandler = new FileHandling("C:\\Users\\t\\IdeaProjects\\FInal\\Customer_data");
        String fileContent = fileHandler.ReadFile();
        String[] lines = fileContent.split("\n");
        String meal_searched ="";

        // Find and Get the Customer with the given Name
        for (String line : lines) {
            String[] CustomerData = line.split(",");
            if (CustomerData[1].equals(Name) && CustomerData.length == 3) {
                meal_searched+="ID: " + CustomerData[0] + ", Name: " + CustomerData[1] + ",Email:" + CustomerData[2];
            }
        }
         return meal_searched;
    }
    public String search(int id) {
        String fileContent = fileHandler_data.ReadFile();
        String[] lines = fileContent.split("\n");

        // Find and remove the customer with the given ID
        for (String line : lines) {
            String[] customerData = line.split(",");
            if (customerData.length == 3) {
                int customerId = Integer.parseInt(customerData[0]);
                if (customerId == id) {
                    return line; // Return the name of the customer
                }
            }
        }
        return null;
    }

    }

