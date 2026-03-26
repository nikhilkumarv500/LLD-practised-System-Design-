package Observers;

public class ConsoleObserver implements IObservers {
    
    @Override
    public void update(String msg) {
        System.out.println("[Console Notification] = " + msg);
    }

}
