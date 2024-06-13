import java.util.*;

public class Main {
    static Team[] list = new Team[20];
  static Game[] games = new Game[10];

  static String RESET = "\u001B[0m";
  static String RED = "\u001B[31m";
  static String GREEN = "\u001B[32m";
  static String YELLOW = "\u001B[33m";

  static Scanner input = new Scanner(System.in);

  public static int binarySearch(String[] arr, String x) {
    int low = 0;
    int high = arr.length - 1;
    while (low <= high) {
      int mid = low + (high - low) / 2;
      if (arr[mid].equals(x)) {
        return mid;
      }
      if (arr[mid].equals(x)){
        low = mid + 1;
      }
      else{
        high = mid - 1;
      }
    }
    return -1;

  }
  
  public static void heapSort() {
    int n = list.length;

    // Build heap (rearrange array)
    for (int i = n / 2 - 1; i >= 0; i--) {
      heapify(n, i);
    }

    // One by one extract an element from heap
    for (int i = n - 1; i >= 0; i--) {
      // Move current root to end
      Team temp = list[0];
      list[0] = list[i];
      list[i] = temp;

      // call max heapify on the reduced heap
      heapify(i, 0);
    }
  }

  // To heapify a subtree rooted with node i which is
  // an index in arr[]. n is size of heap
  static void heapify(int n, int i) {
    int largest = i; // Initialize largest as root
    int l = 2 * i + 1; // left = 2*i + 1
    int r = 2 * i + 2; // right = 2*i + 2

    // If left child is larger than root
    if (l < n && list[l].getPoints() > list[largest].getPoints())
      largest = l;

    // If right child is larger than largest so far
    if (r < n && list[r].getPoints() > list[largest].getPoints())
      largest = r;

    // If largest is not root
    if (largest != i) {
      Team swap = list[i];
      list[i] = list[largest];
      list[largest] = swap;

      // Recursively heapify the affected sub-tree
      heapify(n, largest);
    }
  }

  public static int checkInt() {
    boolean intFound = false;
    int num = 0;
    outer: do{
      try {
        num = input.nextInt();
        input.nextLine();
        break outer;
      } catch (InputMismatchException e) {
        System.out.print(RED + "Please enter a valid integer: \n-> " + RESET);
        input.nextLine();
      }
    } while (!intFound);
    return num;
  }

  public static void displayUnranked() {
    System.out.println();
    for (int i = 0; i < list.length; i++) {
      System.out.println((i + 1) + ". " + list[i]);
    }
  }

  public static void gameSchedule() {
    System.out.println("Here are the upcoming games: \n");
    for (int i = 0; i < games.length; i++) {
      System.out.println(games[i]);
    }

  }

  public static void mainMenu() {
    System.out.print(
        "\n-----------------------------\n\nWhat would you like to do?\n1. View Current Teams\n2. Add Points\n3. Remove Points\n4. View Schedule\n5. Sort List By Name\n6. Sort List By Points\n7. Search for Specific Team\n8. Exit\n-> ");
  }

  public static void main(String[] args) {

    list[0] = new Team("Real Madrid", 90);
    list[1] = new Team("Barcelona", 76);
    list[2] = new Team("Girona", 75);
    list[3] = new Team("Atlético de Madrid", 70);
    list[4] = new Team("Athletic Club", 62);
    list[5] = new Team("Real Betis", 55);
    list[6] = new Team("Real Sociedad", 54);
    list[7] = new Team("Valencia", 48);
    list[8] = new Team("Villarreal", 48);
    list[9] = new Team("Getafe", 43);
    list[10] = new Team("Alavés", 42);
    list[11] = new Team("Sevilla", 41);
    list[12] = new Team("Osasuna", 40);
    list[13] = new Team("Las Palmas", 37);
    list[14] = new Team("Mallorca", 35);
    list[15] = new Team("Rayo Vallecano", 35);
    list[16] = new Team("Celta Vigo", 34);
    list[17] = new Team("Cádiz", 29);
    list[18] = new Team("Granada", 21);
    list[19] = new Team("Almería", 17);

    games[0] = new Game("Real Betis", "Real Madrid", 5, 18, 14, 30);
    games[1] = new Game("Barcelona", "Eibar", 5, 18, 17, 0);
    games[2] = new Game("Getafe", "Valencia", 5, 18, 18, 30);
    games[3] = new Game("Granada", "Atletico Madrid", 5, 18, 20, 0);
    games[4] = new Game("Sevilla", "Real Sociedad", 5, 19, 12, 0);
    games[5] = new Game("Villarreal", "Levante", 5, 19, 14, 30);
    games[6] = new Game("Celta Vigo", "Osasuna", 5, 19, 17, 0);
    games[7] = new Game("Cadiz", "Athletic Bilbao", 5, 19, 18, 30);
    games[8] = new Game("Mallorca", "Alaves", 5, 19, 20, 0);
    games[9] = new Game("Rayo Vallecano", "Espanyol", 5, 20, 17, 0);
    bubbleSort();
    String[] listNames = new String[20];
    for (int i = 0; i < 20; i++) {
      listNames[i] = list[i].getName();
    }

    System.out
        .println("Welcome to the Laliga 2024 soccer tracker!\n\nHere is the current ranking of the current teams: ");
    displayUnranked();
    int choice = 0;
    do {
      mainMenu();
      choice = input.nextInt();
      switch (choice) {
        case 1:
          displayUnranked();
          break;
        case 2:
          System.out.print("What team scored? (Number on Current Ranking): ");
          int team = input.nextInt();
          System.out.print("How many goals did they score?: ");
          int goals = checkInt();
          System.out.print("Were they home (1) or away (2) ?: ");
          int multiplier = checkInt();
          list[team - 1].addPoints(goals * multiplier);
          break;
        case 3:
          System.out.print("What team was deducted points? (Number on Current Ranking): ");
          int t = checkInt();
          System.out.print("How many points were deducted?: ");
          int p = checkInt();
          list[t - 1].removePoints(p);
          break;
        case 4:
          gameSchedule();
          break;
        case 5:
          bubbleSort();
          break;
        case 6:
          heapSort();
          break;
        case 7:
          System.out.print("What team would you like to search?: ");
          String search = input.next();
          System.out.println(search);
          int result = binarySearch(listNames, search);
          if (result == -1)
            System.out.println(
                "Element is not present in array");
          else
            System.out.println("Element is present at index " + (result+1));
          break;
        case 8:
          System.out.println(GREEN + "Thank you for using the Laliga 2024 soccer tracker!");
          System.exit(0);
          break;
        default:
          System.out.println("Invalid input. Please try again.");
      }
    } while (choice != 8);

  }

  public static void bubbleSort() {
    boolean swapped;
    do {
      swapped = false;
      for (int i = 0; i < list.length - 1; i++) {
        if (list[i].getName().compareTo(list[i + 1].getName()) > 0) {
          Team temp = list[i];
          list[i] = list[i + 1];
          list[i + 1] = temp;
          swapped = true;
        }
      }
    } while (swapped);
  }
}