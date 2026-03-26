import java.util.*;

interface FileSystemItem {
    public void ls();
    public void openAll();
    public int getSize();
    public String getName();
}

class File implements FileSystemItem {
    String name;
    int size;

    public File(String name,int size) {
        this.name=name;
        this.size=size;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void ls() {
        System.out.println("File = " + name);
    }

    @Override
    public void openAll() {
        System.out.println("File = " + name);
    }
    
}

class Folder implements FileSystemItem {
    String name;
    List<FileSystemItem> folderitems = new ArrayList<>();

    public Folder(String name) {
        this.name=name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getSize() {
        int sz=0;
        for(FileSystemItem x:folderitems) {
            sz += x.getSize();
        }
        return sz;
    }

    @Override
    public void ls() {
        System.out.println("--------------------");
        System.out.println("Folder = " + name);
        for(FileSystemItem x:folderitems) {
            System.out.println(x.getName());
        }
        System.out.println("--------------------");
    }

    @Override
    public void openAll() {
        System.out.println("--------------------");
        System.out.println("Folder = " + name);
        for(FileSystemItem x:folderitems){
            x.openAll();
        }
        System.out.println("--------------------");
    }

    public FileSystemItem getFolder(String folderName) {
        for(FileSystemItem x: folderitems) {
            if(x.getName().equals(folderName)) return x;
        }
        return null;
    }

    void addFileSystemItem(FileSystemItem item) {
        folderitems.add(item);
    }
}

class ChangeDir {
    Folder folder;

    ChangeDir(Folder obj) {
        folder=obj;
    }

    public FileSystemItem cd(String folderName) {
        FileSystemItem obj = (FileSystemItem) folder.getFolder(folderName);
        return obj;
    }

}

class client {


    void run() {

        Folder root = new Folder("Root");
        File file1 = new File("file1", 1);
        File file2 = new File("file2", 1);
        File file3 = new File("file3", 1);
        root.addFileSystemItem(file1);
        root.addFileSystemItem(file2);
        root.addFileSystemItem(file3);

        Folder folder2 = new Folder("Folder-2");
        File file4 = new File("file4", 1);
        File file5 = new File("file5", 1);
        File file6 = new File("file6", 1);
        folder2.addFileSystemItem(file4);
        folder2.addFileSystemItem(file5);
        folder2.addFileSystemItem(file6);
        root.addFileSystemItem(folder2);

        folder2.ls();
        root.openAll();

        System.out.println(folder2.getSize());
        System.out.println(root.getSize());

    }
}

public class Code {
    public static void main(String[] args) {
        // TimeoutHelper.startTimeout(5000);

        Scanner sc = new Scanner(System.in);

        client obj = new client();
        obj.run();

        // TimeoutHelper.cancelTimeout();

    }
}
