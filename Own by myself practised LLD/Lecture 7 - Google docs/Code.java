
/* this is lecture 7 - Google docs
 * follows SOLID principles
 */

import java.io.FileWriter;
import java.util.*;

interface DocumentElement {
   public String render();
}

class TextElement implements DocumentElement {
    String path;

    TextElement (String s) {
        this.path=s;
    }

    @Override
    public String render() {
        return "[Text = " + path + "]\n";
    }
}

class ImageElement implements DocumentElement {
    String path;

    ImageElement (String s) {
        this.path=s;
    }

    @Override
    public String render() {
        return "[Image = " + path + "]\n";
    }
}

class DocumentManager {
    //document from video

    List<DocumentElement> arr = new ArrayList<>();

    public void addElement(DocumentElement obj) {
        arr.add(obj);
    }

    public String render() {
        String s = "";
        for(DocumentElement x: arr) {
            s += x.render();
        }
        return s;
    }

    public void clear() {
        arr.clear();
    }
}

interface Persistance {
    public void save(String s);
}

class FileStorage implements Persistance {
    @Override
    public void save(String s) {
        try {
            FileWriter obj = new FileWriter("doument.txt");
            obj.write(s);
            obj.close();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}

class DBStorage implements Persistance {
    @Override
    public void save(String s) {
        System.out.println("DB store " + s);
    }
}

class DocumentHelperToClient {
    //documentEditior from video
    
    DocumentManager documentManager = new DocumentManager();
    Persistance persistance;

    void addText(String path) {
        documentManager.addElement(new TextElement(path));
    }

    void addImage(String path) {
        documentManager.addElement(new ImageElement(path));
    }

    public String render() {
        return documentManager.render();
    }

    public void clearDocuments() {
        documentManager.clear();
    }

    public void saveToFile(String s) {
        persistance = new FileStorage();
        persistance.save(s);
    }

    public void saveToDb(String s) {
        persistance = new DBStorage();
        persistance.save(s);
    }

}


class Client {

    void run() {
        System.out.println("Client Run Start");
        
        DocumentHelperToClient obj = new DocumentHelperToClient();

        obj.addImage("Image 1");
        obj.addText("Text 1");

        System.out.println(obj.render());

        obj.saveToFile(obj.render());

        
    }
}


public class Code {
    public static void main(String[] args) {
        // TimeoutHelper.startTimeout(5000);

        Scanner sc = new Scanner(System.in);

        Client obj = new Client();
        obj.run();

        // TimeoutHelper.cancelTimeout();

    }
}
