class PersonalData {
  private String name;
  private int age;
  private int ward;
  
  public PersonalData(String name1){
    System.out.println("Thank you,"+ name +"for entering your name");
    name = name1;
  }

  public PersonalData(String name1, int age1){
    System.out.println("Thank you,"+ name +"for entering your name and age, you are"+ age1 +"years old");
    name = name1;
    age = age1;
  }

  public PersonalData(String name1, int age1, int ward1){
    System.out.println("Thank you,"+ name +"for entering your name and age, you are"+ age1 +"years old. The ward you live in is"+ward+".");
    name = name1;
    age = age1;
    ward = ward1;
  }

  public void setWard(int ward1){
    ward = ward1;
    
  }

  public String getName(){
    return name;
  }
  public int getAge(){
    return age;
  }
  public int getWard(){
    return ward;
  }
  
}