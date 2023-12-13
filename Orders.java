package System;


import Users.Customer;
import java.lang.reflect.Field;

public class Orders extends User{
    private int id;
    private int customerId;
    private int totalAmount;
    private String mealName;
    private static int nextId = 1;
    private static FileHandling fileHandler_data;
    public Orders() {
        fileHandler_data = new FileHandling("C:\\Users\\t\\IdeaProjects\\FInal\\orders");
    }
        public void setId() {
            String filecontent = fileHandler_data.ReadFile();
            String[] lines = filecontent.split("\n");
            if (filecontent.isEmpty()) {
                this.id = nextId;
            } else {

                String[] customerData = lines[lines.length - 1].split(",");
                this.id = (Integer.parseInt(customerData[0])) + 1;
            }
        }
        public void setMealName(String mealName) {
           Meals meal=new Meals();
        this.mealName= meal.search(mealName);}
        public void setCustomerId(int customerId)
        {  User u=new User();
        this.customerId=u.getId();
    }
        public void setTotalAmount(int totalAmount) { this.totalAmount=totalAmount;}
        public int getId() {return id;}
        public String getMealName() {return mealName;}
        public int getCustomerId() {return customerId;}
        public int getTotalAmount() {return totalAmount;}

    public boolean makeOrder(Orders order) {

        String orderData = order.getId() + "," +order.getCustomerId() + "," + order.getMealName() + "," + order.getTotalAmount();
        return fileHandler_data.WriteToFile(orderData);
    }

    public boolean CanelOrder(int orderId) {
        String fileContent = fileHandler_data.ReadFile();
        String[] lines = fileContent.split("\n");

        String updatedContent = "";

        // Find and remove the customer with the given ID
        for (String line : lines) {
            String[] orderData = line.split(",");
            if (!orderData[0].equals(Integer.toString(orderId))) {
                updatedContent += line + "\n";
            }
        }

        // Write the updated content back to the file
        return fileHandler_data.updatesToFile(updatedContent);
    }

    public void list(int id) {
        // Read all customers from the file
        fileHandler_data= new FileHandling("C:\\Users\\t\\IdeaProjects\\FInal\\orders");
        Customer customer = new Customer();
        if(customer.search(id)!=null) {
            String[] customerData = customer.search(id).split(",");
            String fileContent = fileHandler_data.ReadFile();
            String[] lines = fileContent.split("\n");
            // Display each customer's information
            for (String line : lines) {
                if (!line.trim().isEmpty()) {
                    String[] orderData = line.split(",");
                    if (id == Integer.parseInt(orderData[1])) {
                        if (orderData.length == 4) { // Check if the line has all expected dat
                            System.out.println("ID: " + orderData[0] + ", Customer Name: " + customerData[1] + ", Meal Name: " + orderData[2] + ", Total Amount: " + orderData[3]);
                        } else {
                            System.out.println("Invalid data: " + line);
                        }
                    }
                }
            }
        }
        else{
            System.out.println("There is no customer whis this ID");
        }
    }
    public void list() {
        // Read all customers from the file
        FileHandling fileH=new FileHandling("C:\\Users\\t\\IdeaProjects\\FInal\\Meals_data.txt");
        String fileContent = fileH.ReadFile();
        Notification offer = new Notification();
        String[] lines = fileContent.split("\n");

        // Display each customer's information
        for (String line : lines) {
            if (!line.trim().isEmpty()) { // Check if the line is not empty or whitespace
                String[] mealData = line.split(",");
                if (mealData.length == 4) { // Check if the line has all expected data
                    System.out.println("ID: " + mealData[0] + ", Name: " + mealData[1] + ", price: " + (Integer.parseInt(mealData[2])-(Integer.parseInt(mealData[2])*(offer.makeOffer())/100.0)) + ",Quantity:" + mealData[3]);
                } else {
                    System.out.println("Invalid data: " + line);
                }
            }
        }
    }




}
