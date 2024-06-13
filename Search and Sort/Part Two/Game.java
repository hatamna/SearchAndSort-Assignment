class Game{

  private String team1;
  private String team2;
  private int month;
  private int day;
  private int hour;
  private int minute;

  static String RESET = "\u001B[0m";
  static String RED = "\u001B[31m";
  static String GREEN = "\u001B[32m";
  static String YELLOW = "\u001B[33m";

  public Game(){
    team1 = "Team 1";
    team2 = "Team 2";
    month = 0;
    day = 0;
    hour = 0;
    minute = 0;
  }

  public Game(String t1, String t2, int mo, int d, int h, int mi){
    team1 = t1;
    team2 = t2;
    month = mo;
    day = d;
    hour = h;
    minute = mi;
  }

  public String getTeam1(){
    return team1;
  }

  public String getTeam2(){
    return team2;
  }

  public int getMonth(){
    return month;
  }

  public int getDay(){
    return day;
  }

  public int getHour(){
    return hour;
  }

  public int getMinute(){
    return minute;
  }

  public void setTeam1(String t1){
    team1 = t1;
  }

  public void setTeam2(String t2){
    team2 = t2;
  }

  public void setMonth(int m){
    month = m;
  }

  public void setDay(int d){
    day = d;
  }

  public void setHour(int h){
    hour = h;
  }

  public void setMinute(int m){
    minute = m;
  }

  public String toString(){
    return "Game between " + RED + team1 + RESET + " and " + RED + team2 + RESET + " on " + GREEN + month + "/" + day + RESET + " at " + YELLOW + hour + ":" + minute + RESET;
  }
}