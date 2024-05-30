package business.ordering;

import business.Table;

/**
 * brief description of the class.
 *
 * (if necessary)
 * detailed description of the class purpose, functionality, usage
 *
 * @author NAME
 * @version 1.0
 */

public class Dish implements Cloneable{
  private int id;
  private String name;
  private int quantity;
  private String description;
  private Table table;
  private double price;

  public Dish(String name){
    this.name = name;
    this.id = 0;
    this.quantity = 0;
    this.price = price;
  }
  public int getId(){
    return this.id;
  }
  public String getName(){
    return name;
  }
  public int getQuantity(){
    return this.quantity;
  }
  public void setQuantity(int id){
    this.quantity = id;
  }
  public void setTable(Table table){this.table = table;}
  public Table getTable(){
    return this.table;
  }

  @Override
  public Dish clone() {
    try {
      return (Dish) super.clone();
    } catch (CloneNotSupportedException e) {
      // This should never happen since MyClass implements Cloneable
      throw new InternalError(e);
    }
  }


  public double getPrice() {
    return price;
  }


  public void setPrice(double price) {
    this.price = price;
  }
  @Override
  public String toString() {
    return "Dish{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", quantity=" + quantity +
            ", price=" + price +
            '}';
  }
  public String getDescription(){
    return this.description;
  }
  public void setDescription(String description){
    this.description = description;
  }
}

