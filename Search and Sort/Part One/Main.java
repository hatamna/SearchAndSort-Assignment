import java.util.*;

class Main {
  static Scanner input = new Scanner(System.in);
  static ArrayList<item> groceryList = new ArrayList<item>();
  static int numItems = 0;

  static String RESET = "\u001B[0m";
  static String RED = "\u001B[31m";
  static String GREEN = "\u001B[32m";
  static String YELLOW = "\u001B[33m";

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

  public static double checkDouble() {
    boolean doubFound = false;
    double num = 0;
    outer: do{
      try {
        num = input.nextDouble();
        input.nextLine();
        break outer;
      } catch (InputMismatchException e) {
        System.out.print(RED + "Please enter a valid double: \n-> " + RESET);
        input.nextLine();
      }
    } while (!doubFound);
    return num;
  }

  public static int Search(int N, ArrayList<item> arr, String target) {
    // using for loop to traverse the array
    for (int i = 0; i < N; i++) {
      // if target is found return
      if (arr.get(i).getName().equals(target))
        return i + 1;
    }
    // if the target is not present return
    return -1;
  }

  // Insert Sorting
  public static void insertionSort(ArrayList<item> list) {
    int n = list.size();
    for (int i = 1; i < n; i++) {
      String key = list.get(i).getName();
      int j = i - 1;
      while (j >= 0 && list.get(j).getName().compareTo(key) > 0) {
        list.get(j + 1).setName(list.get(j).getName());
        j = j - 1;
      }
      list.get(j + 1).setName(key);
    }
  }

  public static void exitMessage(){
    System.out.println("Here is your list (Before Sorting): \n");
    for (int i = 0; i < numItems; i++){
      System.out.println((i+1) + ". " + groceryList.get(i).toString());
    }
    insertionSort(groceryList);
    System.out.println("\nHere is your list (After Sorting): \n");
    for (int i = 0; i < numItems; i++){
      System.out.println((i+1) + ". " + groceryList.get(i).toString());
    }
    double total = 0;
    for (int i = 0; i < numItems; i++){
      total += groceryList.get(i).getPrice() * groceryList.get(i).getQuantity();
    }
    System.out.printf(GREEN + "\nThe total price for this list is: $%.2f before tax and $%.2f after tax.", total, total * 1.13);
  }

  public static void editItem(){
    System.out.print("What is the index of the element you wish to modify?: ");
    int i = checkInt();
    System.out.print("Enter the new name of the item: ");
    String n = input.next();
    try{
      groceryList.get(i-1).setName(n);
    } catch (IndexOutOfBoundsException e){
      System.out.println(RED + "Invalid index, please try again." + RESET);
      editItem();
    }
    
  }
  
  public static void removeItem(){
    boolean found = false;
    System.out.print("\nEnter the name of the item you want to remove: ");
    String object = input.next();
    for (int i = 0; i < groceryList.size(); i++) {
      if (groceryList.get(i).getName().equals(object)) {
        groceryList.remove(groceryList.get(i));
        System.out.println("Item Removed Successfully.");
        found = true;
      }
    }
    if (!found){
      System.out.println(RED + "Item not found. " + RESET);
    }
    
  }
  
  public static void showList(){
    System.out.println("Here is your list: \n");
    for (int i = 0; i < groceryList.size(); i++){
      System.out.println((i + 1) + ". " +groceryList.get(i) + "\n");
    }
  }

  public static void checkItem(){
    System.out.print("\nEnter the name of the item you want to check: ");
    String tar = input.next();
    int val = Search(numItems, groceryList, tar);
    if (val == -1) {
      System.out.println(RED + "Not Found" + RESET);
      System.out.print("Do you want to add it to the list (Y/N): ");
      String ans = input.next();
      if (ans.toLowerCase().equals("y")) {
        addToList();
      }
    } else {
      System.out.println("\nFound at " + String.valueOf(val));
    }
  }

  public static void addToList() {
    System.out.print("Enter the name of the item: ");
    String itemName = input.next();
    System.out.print("Enter the quantity of the item: ");
    int itemQuantity = checkInt();
    System.out.print("Enter the price of the item: ");
    double itemPrice = checkDouble();
    System.out.print("Enter the category of the item (Food/Clothes/Hygiene/Other): ");
    String itemCat = input.next();
    groceryList.add(new item(itemName, itemQuantity, itemPrice, itemCat));
  }

  public static void DisplayMain() {
    System.out.print(
        "\nWrite the number of the action you want to perform:\n1. See List\n2. Check if element is found in the list\n3. Add element to the list\n4. Remove element from the list\n5. Edit element on list\n6. See Sorted List and Exit\n-> ");
  }

  public static void main(String[] args) {
    System.out.print("Hello to the grocery list App!\n\nHow many items do you want to add? ");
    numItems = checkInt();

    for (int i = 0; i < numItems; i++) {
      addToList();
    }

    int choice = 0;
    while (choice != 6) {
      DisplayMain();
      choice = input.nextInt();
      switch (choice) {
        case 1:
          showList();
          break;
        case 2:
          checkItem();
          break;
        case 3:
          addToList();
          break;
        case 4:
          removeItem();
          break;
        case 5:
          editItem();
          break;
        case 6:
          exitMessage();
          break;
        default:
          System.out.println(RED + "Invalid Input" + RESET);
      }
    }
  }
}