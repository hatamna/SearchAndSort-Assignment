class item{
  public String name;
  public int quantity;
  public double price;
  public String category;

  public item(){
    name = "N/A";
    quantity = 0;
    price = 0.0;
    category = "N/A";
  }

  public item(String n, int q, double p, String c){
    name = n;
    quantity = q;
    price = p;
    category = c;
  }

  public String getName(){
    return name;
  }

  public int getQuantity(){
    return quantity;
  }

  public double getPrice(){
    return price;
  }

  public String getCategory(){
    return category;
  }

  public void setName(String n){
    name = n;
  }

  public void setQuantity(int q){
    quantity = q;
  }

  public void setPrice(double p){
    price = p;
  }

  public void setCategory(String c){
    category = c;
  }

  public String toString(){
    return "Name: " + name + "\nQuantity: " + quantity + "\nPrice: " + price + "\nCategory: " + category;
  }
}