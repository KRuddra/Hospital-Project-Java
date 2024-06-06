import java.util.Scanner;  // Import the Scanner class for user input
import java.io.BufferedReader;  // Import BufferedReader to read from a file
import java.io.FileReader;  // Import FileReader to read text files
import java.io.IOException; // Import IOException for handling file input/output errors
import java.io.* ;  // Import the File class
import java.util.ArrayList;  // Import ArrayList for dynamic lists
import java.util.List;  // Import List interface for lists

class Main {  // Main class definition
  public static void main(String[] args) {  // Main method start
    String filename = "text.txt";  // Specify the file name to read data from
    List<String> hospitals = new ArrayList<>();  // Create a list to store hospital names
    List<String> hwards = new ArrayList<>();  // Create a list to store hospital wards
    List<String> clinics = new ArrayList<>();  // Create a list to store clinic names
    List<String> cwards = new ArrayList<>();  // Create a list to store clinic wards

    try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {  // Try to read the file using BufferedReader
      String line;  // Variable to store each line of the file
      reader.readLine();  // Skip the first line (assuming it contains headers)

      while ((line = reader.readLine()) != null) {  // Read each line until the end of the file
        String[] values = line.split("\t");  // Split the line into values using tab as a delimiter
        String name = values[0];  // Extract the name from the values
        String ward = values[2];  // Extract the ward from the values
        String category = values[1];  // Extract the category from the values

        if (category.equals("Hospital")) {  // Check if the category is a hospital
          hospitals.add(name);  // Add the hospital name to the list
          hwards.add(ward);  // Add the hospital ward to the list
        } else if (category.equals("Clinic")) {  // Check if the category is a clinic
          clinics.add(name);  // Add the clinic name to the list
          cwards.add(ward);  // Add the clinic ward to the list
        }
      }
    } catch (IOException e) {  // Catch and handle any IOException (file input/output errors)
      System.out.println("Error reading file: " + e.getMessage());  // Print an error message if an exception occurs
    }

    // Increment number in numaccessed.txt
    try {
        int num = 0;
        if (new File("numaccessed.txt").exists()) { // Check if the file exists
            Scanner fileScanner = new Scanner(new File("numaccessed.txt"));
            num = fileScanner.nextInt(); // Read the current number
            fileScanner.close();
        }
        num++; // Increment the number

        // Now create the writer to overwrite the file
        FileWriter writer = new FileWriter("numaccessed.txt", false);
        writer.write(String.valueOf(num)); // Write the new number to the file
        writer.close(); // Close the file
    } catch (IOException e) {
        System.out.println("Error accessing numaccessed.txt: " + e.getMessage());
    }

    Scanner input = new Scanner(System.in);  // Create a Scanner object for user input
    int newNum = 0;  // Initialize variable for user menu selection
    int y = 0;  // Initialize variables
    int z = 0;  // Initialize variables
    Hospital hospital = new Hospital();  // Create a Hospital object
    Clinic clinic = new Clinic(clinics, cwards);  // Create a Clinic object with clinics and clinic wards lists
    Messages message = new Messages();  // Create a Messages object for displaying messages
    message.WelcomeMessage();  // Display a welcome message
    int wardNumber = message.WardMessage();  // Get the initial ward number from the user

    while (newNum != -1){  // Start a loop until the user chooses to exit
      newNum = message.Options();  // Display menu options and get user input
      switch (newNum){  // Switch statement based on user input
        case 1:  // Option to find a specific hospital
          System.out.println("Enter the name of the hospital you want to find");
          String hospitalName = input.nextLine();
          System.out.println("The hospital you are looking for is in ward: "+hospital.findWardNumber(hospitals, hwards, hospitalName) +"\n");
          break;
        case 2:  // Option to display hospitals in the current ward
          System.out.println("The hospitals in your ward are: "+ hospital.binarySearchHospitals(hospitals, hwards, Integer.toString(wardNumber), 0, hwards.size() - 1) + "\n");
          break;
        case 3:  // Option to display total information about hospitals
          hospital.totalInfo();
          System.out.println("\n");
          break;
        case 4:  // Option to display clinics in the current ward
          clinic.outputClinicsInWard(Integer.toString(wardNumber));
          break;
        case 5:  // Option to input a new ward number
          wardNumber = message.WardMessage();
          break;
        case 6:  // Option to input personal data (name, age, and ward)
          System.out.println("Enter your name: ");
          String name = input.nextLine();
          System.out.println("Enter your age: ");
          int age = input.nextInt();
          System.out.println("Enter the ward you live in: ");
          int ward = input.nextInt();
          y = 1;
          PersonalData data = new PersonalData(name, age, ward);  // Create a PersonalData object with user input
          break;
      }
    }
  }
}

//Have to do a while loop that ends when -1 is pressed


// 1 Error proof class - use logical operator / working
// 7 recursive method - use modified Binary Search (return all ward hospitasls) / working
// 8 2d array - use clinic class - clinic and ward number / working
// 15 assoication - between hospitals and doctors / working


// 17 retrive data - exel spreadsheet / working
// 18 input data - exel spreadsheet - numtimeacessed / working
// 19 sort algorithm - sort using bubble sort by ward num / working
// 20 search algorithm - modified Binary Search (return all ward hospitasls) by ward number / working







// 1 Error proof class - use logical operator / working
// 2 Switch - decision statement / done
// 3 While loop - use loop / done
// 4 method no parameters - use WelcomeMessage / done
// 5 method with return - use WardMessage / done
// 6 method with parameters - use WardMessage / done
// 7 recursive method - use modified Binary Search (return all ward hospitasls) / working
// 8 2d array - use clinic class - clinic and ward number / working
// 9 instance variables - wardNum in hospital / working
// 10 instance methods - Options() - message class / done
// 11 static variables - totalHospitals / done
// 12 overloaded construtor - personalData class constructor / done
// 13 overriding - totalNumber() in hospital / done
// 14 inheritance - between hospital and clinic / done
// 15 assoication - between hospitals and doctors / working
// 16 poloymorphsism - totalNumber() in hospital / done
// 17 retrive data - exel spreadsheet / working
// 18 input data - exel spreadsheet - numtimeacessed / working
// 19 sort algorithm - sort using bubble sort by ward num / working
// 20 search algorithm - modified Binary Search (return all ward hospitasls) by ward number / working

