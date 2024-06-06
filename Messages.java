import java.util.Scanner;
class Messages{
  Scanner input = new Scanner(System.in);
  
  public void WelcomeMessage(){
    System.out.println("Welcome to the Hospital Directory");
  }
  
  public int WardMessage(){
    System.out.println("What ward are you in? Keep in mind, the Toronto Ward numbers range from 1 to 25: ");
    int input1 = input.nextInt();
    return input1;
  }
  
  public int Options(){
    System.out.println("Now that we have the ward you are in please enter one of the options below");
    System.out.println("1. Search for a hospital by Name\n2. Hospitals in Ward\n3. Information on Total hospitals/doctors\n4. Information on Clinics\n5. Change ward number\n6. Enter your own data\nEnter -1 to quit");
  
    int input2 = input.nextInt();
    return input2;
  }
  
  
}