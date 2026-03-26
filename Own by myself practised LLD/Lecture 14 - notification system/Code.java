import java.util.*;


interface INotification {
    public String getContent();
}

class SimpleTextNotification implements INotification {
    String text = "";

    SimpleTextNotification(String msg) {
        text=msg;
    }

    @Override
    public String getContent() {
        return text;
    }
}

abstract class INotificationDecorator implements INotification {
    INotification oldObj;

    public INotificationDecorator(INotification obj) {
        oldObj=obj;
    }

    // public abstarct String getContent();
    
}

class TimeStampNotificationDecorator extends INotificationDecorator {

    TimeStampNotificationDecorator(INotification obj){
        super(obj);
    }

    @Override
    public String getContent() {
        return " [1:39PM] " + oldObj.getContent();
    }
}

class SignatureStampNotificationDecorator extends INotificationDecorator {

    SignatureStampNotificationDecorator(INotification obj){
        super(obj);
    }

    @Override
    public String getContent() {
        return " [Signatiure] " + oldObj.getContent();
    }
}


// notification oberver design

interface IObserver {
    void update();
}

interface IObervable {
    void addObserver(IObserver iObserver);
    void removeObserver(IObserver iObserver);
    void notifyObservers();
    void setNotification(INotification obj);
    INotification getNotification();
    String getNotificationContent();
}

class NoticationObservable implements IObervable {

    List<IObserver> iObserverList;
    INotification notification;

    NoticationObservable(){
        iObserverList=new ArrayList<>();
    }

    @Override
    public void addObserver(IObserver iObserver) {
        iObserverList.add(iObserver);
    }

    @Override
    public void notifyObservers() {
        for(IObserver x:iObserverList) x.update();
    }

    @Override
    public void removeObserver(IObserver iObserver) {
        //logic
    }

    public void setNotification(INotification notification) {
        this.notification=notification;
        notifyObservers();
    }

    public INotification getNotification() {
        return notification;
    }

    public String getNotificationContent() {
        return notification.getContent();
    }
}

class Logger implements IObserver {

    IObervable iObervable;

    public Logger(IObervable iObervable) {
        this.iObervable=iObervable;
    }

    @Override
    public void update() {
        System.out.println("Console log: " + iObervable.getNotificationContent());
    }
}

interface InternetNotificationStrategy {
    public void sendNotification(String msg);
}

class EmailNotificationStrategy implements InternetNotificationStrategy {
    @Override
    public void sendNotification(String msg) {
        System.out.println(" [strategy=email]" + msg);
    }
}

class SMSNotificationStrategy implements InternetNotificationStrategy {
    @Override
    public void sendNotification(String msg) {
        System.out.println(" [strategy=sms]" + msg);
    }
}

class InternetNotificationStrategyEnginer implements IObserver {
    IObervable iObervable;
    List<InternetNotificationStrategy> internetNotificationStrategies;

    public InternetNotificationStrategyEnginer(IObervable iObervable) {
        this.iObervable=iObervable;
        internetNotificationStrategies=new ArrayList<>();
    }

    public void addStrategy(InternetNotificationStrategy internetNotificationStrategy) {
        internetNotificationStrategies.add(internetNotificationStrategy);
    }

    @Override
    public void update() {
        String msg = iObervable.getNotificationContent();
        for(InternetNotificationStrategy x: internetNotificationStrategies) {
            x.sendNotification(msg);
        }
    }
}

//  client helper - facade pattern

class NotificationServiceManager {
    static NotificationServiceManager selfObj;
    List<INotification> iNotificationList;
    IObervable iObervable;

    private NotificationServiceManager() {
        iObervable = new NoticationObservable();
    }

    public static NotificationServiceManager getInstance() {
        if(selfObj==null) selfObj = new NotificationServiceManager();
        return selfObj;
    }

    void sendNotification(INotification iNotification) {
        iNotificationList.add(iNotification);
        iObervable.setNotification(iNotification);
    }

    void addObserver(IObserver iObserver) {
        iObervable.addObserver(iObserver);
    }

    IObervable getObservable(){
        return iObervable;
    }

}


class NotificationSystemClient {


    void run() {

        INotification notification = new SimpleTextNotification("Simple-text-1");
        notification = new SignatureStampNotificationDecorator(notification);
        notification = new TimeStampNotificationDecorator(notification);
        // System.out.println(notification.getContent());

        IObervable singleTonObservable = NotificationServiceManager.getInstance().getObservable();

        IObserver iObserver = new Logger(singleTonObservable);
        singleTonObservable.addObserver(iObserver);
        singleTonObservable.setNotification(notification);

        System.out.println("");

        IObserver internetObserver = new InternetNotificationStrategyEnginer(singleTonObservable);
        ((InternetNotificationStrategyEnginer)internetObserver).addStrategy(new EmailNotificationStrategy());
        ((InternetNotificationStrategyEnginer)internetObserver).addStrategy(new SMSNotificationStrategy());
        singleTonObservable.addObserver(internetObserver);
        singleTonObservable.setNotification(notification);

    }
}

public class Code {
    public static void main(String[] args) {
        // TimeoutHelper.startTimeout(5000);

        Scanner sc = new Scanner(System.in);

        NotificationSystemClient obj = new NotificationSystemClient();
        obj.run();

        // TimeoutHelper.cancelTimeout();

    }
}
