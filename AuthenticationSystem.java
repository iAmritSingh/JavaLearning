import java.util.LinkedList;
import java.util.Scanner;
class User{
    private String username;
    private String password;

    public User(String username , String password){
        this.username = username;
        this.password = password;
    }

    public String getUsername(){
        return this.username;
    }

    public String getPassword(){
        return this.password;
    }

}

public class AuthenticationSystem {

    private LinkedList<User> userList;

    public AuthenticationSystem(){
        userList = new LinkedList<>();
    }

    public void register(String username, String password){
        User newUser = new User(username,password);
        userList.add(newUser);
        System.out.println("User Registered Successfully");
    }
    public boolean login(String username, String password){
        for(User usr:userList){
            if(usr.getUsername().equals(username) && usr.getPassword().equals(password)){
                return true;
            }

        }
        return false;
    }

    public static void main(String[] args){
        AuthenticationSystem authSystem = new AuthenticationSystem();
        Scanner scanner = new Scanner(System.in);
        boolean loggedIn = false;

        while(!loggedIn){
            System.out.println("Choose an option");
            System.out.println("1. Register");
            System.out.println("1. Login");
            System.out.println("1. exit");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice){
                case 1:
                    System.out.println("Enter a username");
                    String regUsername = scanner.nextLine();
                    System.out.println("Enter a password");
                    String regPassword = scanner.nextLine();
                    authSystem.register(regUsername,regPassword);
                    break;

                case 2:
                    System.out.println("Enter a username");
                    String loginUsername = scanner.nextLine();
                    System.out.println("Enter your password");
                    String loginPassword = scanner.nextLine();

                    if(authSystem.login(loginUsername,loginPassword)){
                        System.out.println("Login Successfull");
                        loggedIn = true;
                    }
                    else{
                        System.out.println("Login Unsuccessfull");
                    }
                    break;

                case 3:
                    System.out.println("Exiting.....");
                    loggedIn = true;
                    break;

                default:
                    System.out.println("Invalid Choice...try again...");


            }

        }
        scanner.close();

    }


}
