package System;


public class Meals implements CrudMeal{

    private static FileHandling fileHandler_data;
    private int id;
    private String name;
    private int price;
    private int quantity;
    private static int nextId = 1;
    public Meals() {
        fileHandler_data = new FileHandling("C:\\Users\\t\\IdeaProjects\\FInal\\Meals_data.txt");
    }


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
        this.name=name;
    }

    public void setPrice(int price) {
        this.price=price;
    }
    public void setQuantity(int quantity) {
        this.quantity=quantity;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
    public int getQuantity() {
        return quantity;
    }

    @Override
    public boolean add(Meals meal ) {
        String mealData = meal.getId() + "," + meal.getName() + "," + meal.getPrice() + "," + meal.getQuantity();
        return fileHandler_data.WriteToFile(mealData);
    }


    @Override

    public boolean delete(int id) {
        // Read all customers from the file
        String fileContent = fileHandler_data.ReadFile();
        String[] lines = fileContent.split("\n");

        String updatedContent = "";

        // Find and remove the customer with the given ID
        for (String line : lines) {
            String[] mealData = line.split(",");
            if (!mealData[0].equals(Integer.toString(id))) {
                updatedContent += line + "\n";
            }
        }

        // Write the updated content back to the file
        return fileHandler_data.updatesToFile(updatedContent);
    }
    @Override

    public boolean update(int id,Meals updatedmeal) {
        // Read all Meals from the file
        String fileContent = fileHandler_data.ReadFile();
        String[] lines = fileContent.split("\n");


        String updatedContent = "";

        // Find the meal with the same ID as the updated meal
        for (String line : lines) {
            String[] mealData = line.split(",");

            if (mealData[0].equals(Integer.toString(id))) {
                updatedContent += id + ","
                        + updatedmeal.getName() + ","
                        + updatedmeal.getPrice() + ","
                        + updatedmeal.getQuantity() + "\n";
            } else {
                updatedContent += line + "\n";
            }
        }

        // Write the updated content back to the file
        return fileHandler_data.updatesToFile(updatedContent);
    }
    @Override

    public void list() {
        // Read all customers from the file
        String fileContent = fileHandler_data.ReadFile();
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
    @Override

    public String search(String name) {

        String fileContent = fileHandler_data.ReadFile();
        String[] lines = fileContent.split("\n");
        String meal_searched ="";
        // Find and remove the customer with the given ID
        for (String line : lines) {
            String[] mealData = line.split(",");
            if (mealData[1].equals(name) && mealData.length == 4) {
                meal_searched+="ID: " + mealData[0] + ", Name: " + mealData[1] + ", Price: " + mealData[2] + ",Quantity:" + mealData[3];
            }      //id [1]...
        }
        return meal_searched;
    }
}
