import java.io.File;
import java.io.FilenameFilter;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) {

//        File folder = new File("/usr/lib/jvm");
//
//        File[] files = folder.listFiles();
//
//        Comparator<File> comparator = new MyCustomFileComparator();
//        Arrays.sort(files, comparator);
//
//        for(File f : files){
//            System.out.println("" + f.isDirectory() + f.isHidden() + f.getName());
//        }
//
////        File[] files1 = folder.listFiles();
////        Arrays.sort(files1, (f1, f2) -> f1.compareTo(f2));
////        for (File file : files){
////            if (!file.isHidden()) {
////                if (file.isDirectory()) {
////                    System.out.println("DIRECTORY \t " + file.getName());
////                } else {
////                    System.out.println("FILE \t" + file.getName());
////                }
////            }
////        }
//    }
//
//    private static class MyCustomFileComparator implements Comparator<File> {
//        @Override
//        public int compare(File f1, File f2) {
//            boolean f1Hidden = f1.isHidden();
//            boolean f2Hidden = f2.isHidden();
//
//            boolean f1Directory = f1.isDirectory();
//            boolean f2Directory = f2.isDirectory();
//
//            if(f1Directory && !f2Directory){
//                return -1;
//            } else if (!f1Directory && f2Directory) {
//                return 1;
//            } else {
//                if(f1Hidden && !f2Hidden){
//                    return -1;
//                } else if (!f1Hidden && f2Hidden) {
//                    return 1;
//                } else {
//                    return f1.compareTo(f2);
//                }
//            }
//        }
//    }

        File folder = new File("/home/dmytro/YouTube");
//        // yakho papku ne isnue???
//        boolean exists = folder.exists();
//        if (!exists){
//            //treba zupunutu vukonany
//            System.exit(0);
//        }
//        // prohodumos po katalogu,pereviryemo ho unas e
//
//        System.out.println(folder);
//        System.out.println("Exist" + folder.exists());
//        System.out.println("is dir" + folder.isDirectory());
//        System.out.println("is file" + folder.isFile());

        File[] list = folder.listFiles(new MyCustomFilenameFilter());
        for (File file : list) {
            System.out.println(file.getName());
            System.out.println(file.isDirectory());
            System.out.println(file.isFile());
            System.out.println(file.length());
            System.out.println();
        }
        System.out.println("======\n");
        listDir(folder, 0);
    }

    private static void listDir(File folder, int level) {
        File[] files = folder.listFiles();
        level++;

        // TODO sort files in the following order
        // 1. alphabetically
        // 2. hidden first
        // 3. folders first

        //TODO in order to achieve this you should implement custom comparator and pass it to the sort method
        //Arrays.sort(files, <your custom comparator>);


        // TODO print in tree like structure, e.g. use some number of spaces and special characters like |, └──, ├──, for each level
        for (File file : files) {
            String padding = " ├── ";
            for (int i = 0; i < level; i++) {
                padding += " | ";
            }
            for (int j = 0; j < level; j++) {
                padding += " └── ";
            }

            System.out.println(padding + file.getName());

            if (file.isDirectory()) {
                listDir(file, level);
            }
        }
    }

    static class MyCustomFilenameFilter implements FilenameFilter {

        @Override
        public boolean accept(File dir, String name) {
            boolean isHidden = name.startsWith(".");
            return !isHidden;
        }
    }
}
