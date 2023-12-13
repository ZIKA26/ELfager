package Project;

import Auth.auth;

import java.util.Scanner;

import static java.lang.System.exit;
import System.*;
import Users.Customer;
import Users.Employee;

public class Interfaces {
    protected Scanner s;
    public Interfaces()
    {        this.s = new Scanner(System.in);

        System.out.println("----WELCOME IN RESTRUNT MANANGEMENT SYSTEM----");
        int choice;
        do {
            System.out.println(" 1.Login..");
            System.out.println(" 2.Exit.");
            System.out.println("Enter Your Choice...: ");
            choice=s.nextInt();
            switch (choice){
                case 1:
                  login_menu();
                    break;
                case 2:
                    exit(1);
                    break;
                default:
                    System.out.println("Invalid Option...");
            }
        }
        while (true);

    }


    public void login_menu()
    {   int User_type;

        System.out.println("Enter UserName : ");
        String UserName = s.next();
        System.out.println("Enter Password : ");
        String Password = s.next();
        System.out.println("User type : ");
        System.out.println("1)admin");
        System.out.println("2)Employee");
        System.out.println("3)Customer");
        User_type = s.nextInt();
        switch (User_type)
        {

            case 1:
                auth login_admin=new auth();
                login_admin.setUserName(UserName);
                login_admin.setPassword(Password);
                login_admin.setType(User_type);
                login_admin.login();
                System.out.println(login_admin.getId());
                if(login_admin.check(login_admin))
                  Admin_menu();
                else
                  System.out.println("UserName Or PassWord Invalid...");
                break;
            case 2:
                auth login_employee=new auth();
                login_employee.setUserName(UserName);
                login_employee.setPassword(Password);
                login_employee.setType(User_type);
                login_employee.login();
                System.out.println(login_employee.getId());

                if(login_employee.check(login_employee)){
                    System.out.println("Welcome Empolyee....");
                    Employee_menu();}
                else
                    System.out.println("UserName Or PassWord Invalid...");
                break;
            case 3:
                auth login_Customer=new auth();
                login_Customer.setUserName(UserName);
                login_Customer.setPassword(Password);
                login_Customer.setType(User_type);
                login_Customer.login();
                System.out.println(login_Customer.getId());

                if(login_Customer.check(login_Customer)) {
                    System.out.println("Welcome Customer....");
                    Customer_menu();}
                else
                    System.out.println("UserName Or PassWord Invalid...");
                break;


            default:
                System.out.println("Invalid Choice..");
                break;
        }

    }
    public void Admin_menu()
    {   System.out.println("----Welcome Admin----");
        int c ;

        do{
        System.out.println("1)Manage Employee");//
        System.out.println("2)Manage Meals");
        System.out.println("3)Make Reports");
        System.out.println("4)manage Loyalty points");//elfager -> 50;
        System.out.println("5)Edit Your Information");
        System.out.println("----------------------");
        c = s.nextInt();
        switch (c)
        {

            case 1:
                manage_Employee_menu();
                break;
            case 2:
                manage_meal_menu();
                break;
            case 3:
                Make_Reports_menu();
                break;
            case 4:
                break;
            case 5:
                Edit_info_menu();
                break;
            default:
                System.out.println("Invalid option..");
        }}while (c!=0);

    }
    public void manage_Employee_menu()
    {
        System.out.println("1)Add Employee");
        System.out.println("2)Delete Employee");
        System.out.println("3)Update Employee");
        System.out.println("4)List Employee");
        System.out.println("5)search ");

        int c = s.nextInt();
        switch (c)
        {

            case 1:
                add_emp_menu();
                break;
            case 2:
                System.out.println("Enter ID to Delete :");
                int id=s.nextInt();
                Employee Delete_Employee=new Employee();
                if(Delete_Employee.delete(id))
                    System.out.println("Deleted Successfully");
                else
                    System.out.println("Delete Denied");

                break;
            case 3:
                update_emp_menu();
                break;
            case 4:
                Employee List_Employee=new Employee();
                List_Employee.list();
                //List Employee...
                break;
            case 5:
                System.out.println("Enter Name To Search : ");
                String Search_name=s.next();
                Employee Search_Employee=new Employee();
                System.out.println(Search_Employee.search(Search_name));
                //Search employee...
                break;
            default:
                System.out.println("Invalid option..");
        }

    }
    public void manage_meal_menu()
    {
        System.out.println("---------------");
        System.out.println("1)Add meal");
        System.out.println("2)Delete meal");
        System.out.println("3)Update meal");
        System.out.println("4)List meal");//
        System.out.println("5)search");
        System.out.println("---------------");

        int c = s.nextInt();

        switch (c)
        {

            case 1:
                add_meal_menu();
                // add meal
                break;
            case 2:
                System.out.println("Enter ID to Delete :");
                int id=s.nextInt();
                Meals deleted_meal=new Meals();

                if( deleted_meal.delete(id))
                    System.out.println("Deleted Successfully");
                else
                    System.out.println("Delete Denied");
                //Delete meal
                break;
            case 3:
                update_meal_menu();
                //Update meal..
                break;
            case 4:
               Meals List_meal=new Meals();
                List_meal.list();
                //List meal...
                break;
            case 5:
                System.out.println("Enter Name To Search : ");
                String Search_name=s.next();
                Meals Search_meal=new Meals();
                System.out.println(Search_meal.search(Search_name));

                //Search meal...
                break;
            default:
                System.out.println("Invalid option..");
        }


    }
    public void Make_Reports_menu()
    {    int c ;
        do{
        System.out.println("--------------------------");
        System.out.println("1)make report for Employee");
        System.out.println("2)make report for customer");
        System.out.println("3)List Employee");
        System.out.println("4)List customer");
        System.out.println("--------------------------");
             c = s.nextInt();
        switch (c)
        {

            case 1:
                // make report Employee
                System.out.println("Enter id for employee to make report: ");
                int id_Emp = s.nextInt();
                Report Emp_report=new Report();
                Emp_report.list(id_Emp);
                break;
            case 2:
                System.out.println("Enter id for customer to make report: ");
                int id_Cus = s.nextInt();
                Report Cus_report=new Report();
               Cus_report.listcus(id_Cus);
                //make report customer
                break;
            case 3:
                Employee List_Emp=new Employee();
                List_Emp.list();
                //list Employee..
                break;
            case 4:
                Customer List_Cus=new Customer();
                List_Cus.list();
                //List Cusyomer...
                break;

            default:
                System.out.println("Invalid option..");
        }}while (c!=0);

    }

   public void Edit_info_menu()
   {   auth Edit_info=new auth();
       System.out.println("Enter Your ID to Edit Your information (But You cannot edit id..) : ");
       int id =s.nextInt();
       System.out.println("Enter Your Type : ");
       int type =s.nextInt();
       System.out.println("Enter New UserName : ");
       String New_Username=s.next();
       Edit_info.setUserName(New_Username);
       System.out.println("Enter New Password : ");
       String New_Password=s.next();
       Edit_info.setPassword(New_Password);
      if(Edit_info.Check_updated_Profile_info(id,Edit_info,type))
          System.out.println(" Edit Successfully");
      else
          System.out.println("Id or Type False");
   }

        public void add_emp_menu()
        {   Employee New_Employee = new Employee();
            New_Employee.setId();
            System.out.println("Enter Name : ");
            String name = s.next();
            New_Employee.setName(name);
            System.out.println("Enter Salary : ");
            double salary = s.nextDouble();
            New_Employee.setSalary(salary);
            System.out.println("Enter Email : ");
            String email = s.next();
            New_Employee.setEmail(email);
           if( New_Employee.add(New_Employee))
               System.out.println("Added Successfully..");
           else
               System.out.println("Added Denied");


        }
    public void update_emp_menu()
    {    Employee Update_Employee = new Employee();
        System.out.println("Enter ID to Edit :");
        int id=s.nextInt();
        System.out.println("Enter New Name :");
        String name = s.next();
        Update_Employee.setName(name);
        System.out.println("Enter New Salary :");
        double salary = s.nextDouble();
        Update_Employee.setSalary(salary);
        System.out.println("Enter New Email :");
        String email = s.next();
        Update_Employee.setEmail(email);
         if(Update_Employee.update(id,Update_Employee))
             System.out.println("Updated Successfully");
         else
             System.out.println("Updated Denied");


    }
    public void add_meal_menu()
    {        Meals New_meal = new Meals();
         New_meal.setId();
        System.out.println("Enter Name : ");
        String name = s.next();
        New_meal.setName(name);
        System.out.println("Enter price : ");
        int price = s.nextInt();
        New_meal.setPrice(price);
        System.out.println("Enter Quantity : ");
        int quantity = s.nextInt();
        New_meal.setQuantity(quantity);
        if( New_meal.add(New_meal))
            System.out.println("Added Successfully..");
        else
            System.out.println("Added Denied");


    }
    public void update_meal_menu()
    {   Meals update_meal = new Meals();
        System.out.println("Enter ID to Edit :");
        int id=s.nextInt();
        System.out.println("Enter New Name :");
        String name = s.next();
        update_meal.setName(name);
        System.out.println("Enter New  Price :");
        int price = s.nextInt();
        update_meal.setPrice(price);
        System.out.println("Enter New Quantity :");
        int quantity = s.nextInt();
        update_meal.setQuantity(quantity);
        if(update_meal.update(id,update_meal))
            System.out.println("Updated Successfully");
        else
            System.out.println("Updated Denied");
    }

    public void Employee_menu()
    {   System.out.println("----Welcome Employee----");
        int c ;

        do{
            System.out.println("1)Manage Customers");//
            System.out.println("2)Manage Orders");
            System.out.println("3)Manage Billing");
            System.out.println("4)Send Notification");//elfager -> 50;
            System.out.println("5)Edit Your Information");
            System.out.println("----------------------");
            c = s.nextInt();
            switch (c)
            {

                case 1:
                   manage_Customer_menu();
                    break;
                case 2:
                   manage_order_menu();
                    break;
                case 3:
                    Billing view_billing=new Billing();
                    view_billing.list();
                    //Billing
                    break;
                case 4:
                    Notification Send_not=new Notification();
                    Send_not.makeOffer();
                    //notification
                    break;
                case 5:
                    Edit_info_menu();
                    break;
                default:
                    System.out.println("Invalid option..");
            }}while (c!=0);

    }
    public void manage_Customer_menu()
    {
        System.out.println("1)Add Customer");
        System.out.println("2)Delete Customer");
        System.out.println("3)Update Customer");
        System.out.println("4)List Customer");
        System.out.println("5)search ");

        int c = s.nextInt();
        switch (c)
        {

            case 1:
                add_Cus_menu();
                break;
            case 2:
                System.out.println("Enter ID to Delete :");
                int id=s.nextInt();
                Customer Delete_Customer=new Customer();
                if(Delete_Customer.delete(id))
                    System.out.println("Deleted Successfully");
                else
                    System.out.println("Delete Denied");

                break;
            case 3:
                update_Cus_menu();
                break;
            case 4:
                Customer List_Customer=new Customer();
                List_Customer.list();
                break;
            case 5:
                System.out.println("Enter Name To Search : ");
                String Search_name=s.next();
                Customer Search_Customer=new Customer();
                System.out.println( Search_Customer.search(Search_name));

                break;
            default:
                System.out.println("Invalid option..");
        }

    }
    public void manage_order_menu()
    {
        System.out.println("---------------");
        System.out.println("1)Make Order ");
        System.out.println("2)Cancel Order : ");
        System.out.println("---------------");

        int c = s.nextInt();

        switch (c)
        {

            case 1:
              make_order_menu();
                // Make Order..
                break;
            case 2:
                Cancel_order_menu();
               //Cancel Order...
                break;

            default:
                System.out.println("Invalid option..");
        }


    }

    public void add_Cus_menu()
    {  Customer New_Customer= new Customer();
         New_Customer.setId();
        System.out.println("Enter Name : ");
        String name = s.next();
        New_Customer.setName(name);
        System.out.println("Enter Email : ");
        String email = s.next();
        New_Customer.setEmail(email);
        if( New_Customer.add(New_Customer))
            System.out.println("Added Successfully..");
        else
            System.out.println("Added Denied");


    }
    public void update_Cus_menu()
    {   Customer Update_Customer = new Customer();
        System.out.println("Enter ID to Edit :");
        int id=s.nextInt();
        System.out.println("Enter New Name :");
        String name = s.next();
         Update_Customer.setName(name);
        System.out.println("Enter New Email :");
        String email = s.next();
        Update_Customer.setEmail(email);
        if(Update_Customer.update(id,Update_Customer))
            System.out.println("Updated Successfully");
        else
            System.out.println("Updated Denied");


    }
    void Customer_menu()
    {

        int c ;
        do{
            System.out.println("1)Make Order");//
            System.out.println("2)Cancel Order");
            System.out.println("3)Show Notification");
            System.out.println("4)Edit Your Information");
            System.out.println("----------------------");
            c = s.nextInt();
            switch (c)
            {

                case 1:
                    make_order_menu();
                    break;
                case 2:
                    Cancel_order_menu();
                    break;
                case 3:
                    Notification show_not=new Notification();
                    show_not.displayNotification();
                    break;
                case 4:
                    Edit_info_menu();
                    break;
                default:
                    System.out.println("Invalid option..");
            }}while (c!=0);



    }
    void make_order_menu()
    {
        /*Orders Make_order=new Orders();
        Make_order.list();
        Meals meal=new Meals();
        User u=new User();
        System.out.println("Enter Name of The Meal To Make Order : ");
        String id_make=s.next();String Meal_data=meal.search(id_make);
        Meal_data.split(":");/// price ,name
        Make_order.setId();
        Make_order.setCustomerId(u.getId());
*//*
        if(id_make.equals())
*//*
        Make_order.setMealName(id_make);
//        else
            System.out.println("Name invalid");

        Make_order.setTotalAmount();

        Make_order.makeOrder(Make_order);*/
    }
    void Cancel_order_menu()
    {
        Orders Cancel_order=new Orders();
        System.out.println("Enter Your Id to show Your Orders : ");
        int id_Cus=s.nextInt();
        Cancel_order.list(id_Cus);
        System.out.println("Enter Id Of Order You went delete : ");
        int id_Cancel=s.nextInt();
        Cancel_order.CanelOrder(id_Cancel);
    }

}
