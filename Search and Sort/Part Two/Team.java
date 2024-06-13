class Team{

  static String RESET = "\u001B[0m";
  static String RED = "\u001B[31m";
  static String GREEN = "\u001B[32m";
  static String YELLOW = "\u001B[33m";
  
  private String name;
  private int points;

  public Team(){
    name = "Team";
    points = 0;
  }

  public Team(String n, int p){
    name = n;
    points = p;
  }

  public String getName(){
    return name;
  }

  public int getPoints(){
    return points;
  }

  public void setName(String n){
    name = n;
  }

  public void setPoints(int p){
    points = p;
  }

  public void addPoints(int p){
    points += p;
  }

  public void removePoints(int p){
    points -= p;
  }

  public String toString(){
    return RED + name + RESET + " with " + GREEN + points + RESET + " points";
  }
}