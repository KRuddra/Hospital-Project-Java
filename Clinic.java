import java.util.ArrayList;
import java.util.List;

class Clinic extends Hospital{
   private String[][] dataArray;

  //Overriding and Polymorphsism
   public int totalNumber(){
     int totalElements = 0;  

     for (String[] row : dataArray) {
       totalElements += row.length;
     }

     return totalElements;
   }
  
  public Clinic(List<String> clinics, List<String> cwards) {
       // Convert ArrayLists to 2D array
       dataArray = new String[clinics.size()][2];
       for (int i = 0; i < clinics.size(); i++) {
           dataArray[i][0] = clinics.get(i);
           dataArray[i][1] = cwards.get(i);
       }
   }   

  public void outputClinicsInWard(String ward) {
      System.out.println("Clinics in ward " + ward + ":");
      for (String[] row : dataArray) {
          if (row[1].equals(ward)) {
              System.out.println(row[0]);
          }
      }
    System.out.println();
  }
   
}
