package business.management;

import business.ordering.Item;

import java.util.ArrayList;

/**
 * brief description of the class.
 *
 * (if necessary)
 * detailed description of the class purpose, functionality, usage
 *
 * @author NAME
 * @version 1.0
 */

public class Storage {
    private ArrayList<Item> storage;
    public Storage(){
        this.storage = new ArrayList<>();

    }

  public ArrayList<Item> getStorage(){
        return storage;
  }
  public ArrayList<Item> getStorage2(){
        return storage;
  }
  public ArrayList<Item> getLowItems(){
        ArrayList<Item> list = new ArrayList<Item>();

        for(Item item: this.storage){
            if(item.getQuantity()<item.getLowerLimit()){
                list.add(item);
            }
        }

        return list;
  }
  public void removeItem(Item item){
        this.storage.remove(item);
  }
}
