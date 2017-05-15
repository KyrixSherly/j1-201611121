package headfirst.singleton.threadsafe;

public class ChocolateBoiler{
  private boolean empty;
  private boolean boiled;
  private static ChocolateBoiler uniqueInstance;
  private static int numCalled=0;
  
  private ChocolateBoiler() {
    empty = true;
    boiled = false;
  }
  public static synchronized ChocolateBoiler getInstance() {
    if(uniqueInstance == null) {
      System.out.println("creating...");
      uniqueInstance = new ChocolateBoiler();
    }
    System.out.println("returning....");
    System.out.println("num called...."+numCalled++);
    return uniqueInstance;
  }
  public void fill() {
    if(isEmpty()) {
      System.out.println("filling...");
      empty = false;
      boiled = false;
    }
  }
  public void drain() {
    if (!isEmpty() && isBoiled()) {
      // drain the boiled milk and chocolate
      empty = true;
    }
  }
 
 public void boil() {
   if (!isEmpty() && !isBoiled()) {
     boiled = true;
   }
 }
  public boolean isEmpty() {
    return empty;
  }
  public boolean isBoiled() {
    return boiled;
  }
}