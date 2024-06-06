import java.util.ArrayList;
import java.util.List;

class Hospital {
  static int totalHospitals = 10;
  //Overriding and Polymorphsism
  public int totalNumber(){
    return 10;
  }

  private static List<Doctor> doctors = new ArrayList<>();

  public static void addDoctor(Doctor doctor) {
      doctors.add(doctor);
  }

  public void totalInfo(){
    System.out.println("You can find all the information needed here: https://www.wikiwand.com/en/List_of_hospitals_in_Toronto");
    
  }
  public static String findWardNumber(List<String> hospitals, List<String> hwards, String searchHospital) {
      for (int i = 0; i < hospitals.size(); i++) {
          if (hospitals.get(i).equalsIgnoreCase(searchHospital)) {
              return hwards.get(i);
          }
      }
      return null; // Hospital not found
  }
  
  private List<String> bubbleSort(List<String> hospitals, List<String> wards) {
    int n = hospitals.size();
    boolean swapped;
    do {
      swapped = false;
      for (int i = 0; i < n - 1; i++) {
        if (Integer.parseInt(wards.get(i)) > Integer.parseInt(wards.get(i + 1))) {
          String tempHospital = hospitals.get(i);
          hospitals.set(i, hospitals.get(i + 1));
          hospitals.set(i + 1, tempHospital);

          String tempWard = wards.get(i);
          wards.set(i, wards.get(i + 1));
          wards.set(i + 1, tempWard);

          swapped = true;
        }
      }
      n--;
    } while (swapped);

    return hospitals;
  }

  public List<String> binarySearchHospitals(List<String> hospitals, List<String> wards, String targetWard, int low, int high) {
    bubbleSort(hospitals, wards);
      if (low > high) {
          return new ArrayList<>();
      }

      int mid = (low + high) / 2;
      String currentWard = wards.get(mid);

      if (currentWard.equals(targetWard)) {
          List<String> foundHospitals = new ArrayList<>();

          foundHospitals.add(hospitals.get(mid));

          foundHospitals.addAll(binarySearchHospitals(hospitals, wards, targetWard, low, mid - 1));
          foundHospitals.addAll(binarySearchHospitals(hospitals, wards, targetWard, mid + 1, high));

          return foundHospitals;
      } else if (currentWard.compareTo(targetWard) < 0) {
          return binarySearchHospitals(hospitals, wards, targetWard, mid + 1, high);
      } else {
          return binarySearchHospitals(hospitals, wards, targetWard, low, mid - 1);
      }
  }
}
// has doctor class somewheree