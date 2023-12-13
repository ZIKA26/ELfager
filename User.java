package System;

public class User {
    private static FileHandling fileHandler_data;
    protected int id;
    private String UserName;
    private String Password;
    private int type;  //1->Admin 2->Employee 3->Customer..

    public User() {
        fileHandler_data = new FileHandling("C:\\Users\\t\\IdeaProjects\\FInal\\src\\Auth\\Users");
    }

    public void setId(int id) {
        this.id=id;

    }



    public int getId() {
        return id;
    }



    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
    public boolean updated_Profile_info(int id,User user,int type)
    {   FileHandling fileHandler =new FileHandling("C:\\Users\\t\\IdeaProjects\\FInal\\src\\Auth\\Users");
        String fileContent = fileHandler.ReadFile();
        String[] lines = fileContent.split("\n");
        String updatedContent = "";
        // Find the User with the same ID as the updated User
        for (String line : lines) {
            String[] UserData = line.split(",");
            if (UserData[0].equals(Integer.toString(id))&&UserData[3].equals(Integer.toString(type))) {
                updatedContent += id + ","
                        + user.getUserName()+ ","
                        + user.getPassword() + "," +type+"\n";
            }
            else
            {
                updatedContent += line + "\n";
            }
        }

        // Write the updated content back to the file
        return fileHandler.updatesToFile(updatedContent);
    }
    public boolean Check_updated_Profile_info(int id,User user,int type)
    {
        boolean c=false;
        FileHandling fileHandler =new FileHandling("C:\\Users\\t\\IdeaProjects\\FInal\\src\\Auth\\Users");
        String fileContent = fileHandler.ReadFile();
        String[] lines = fileContent.split("\n");
        // check id,type...
        for (String line : lines) {
            String[] UserData = line.split(",");
            if (UserData[0].equals(Integer.toString(id))&&UserData[3].equals(Integer.toString(type))) {
                          updated_Profile_info(id,user,type);
                         return true;
                 }

        }
         return false;
        // Write the updated content back to the file
    }






}
