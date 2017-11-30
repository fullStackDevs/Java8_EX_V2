package Java_SE8_ForReally_Impatients_CH_1;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import static java.util.Comparator.comparing;

public class Main {

    public static void main(String[] args) {

        File currentDirectory = new File(".");

        System.out.println("--- Exercice 2 ---");

        //    2. Using the listFiles(FileFilter) and isDirectory methods of the java.io.File class,
        //    write a method that returns all subdirectories of a given directory. Use a
        //    lambda expression instead of a FileFilter object. Repeat with a method
        //    expression.

        //*****
        // V1 - this can be simplified (see V3 and V4)
        //*****
        Function<File, List<File>> getSubdirs =  (File directory) -> {
            List<File> subdirs = new ArrayList<>();
            for(File f : directory.listFiles()) {
                if(f.isDirectory()) {
                    subdirs.add(f);
                }
            }
            return subdirs;
        };

        List<File> subdirectories = getSubdirs.apply(new File("."));
        System.out.println("V1 --- Subdirectories found in the current directory with a lambda function : " + subdirectories);

        //==========================================================================================================
        //*****
        // V2
        //****

        List<File> subdirectories2 = getSubdirectories(new File("."));
        System.out.println("V2 --- Subdirectories found in the current directory: " + subdirectories2);

        //==========================================================================================================
        //*****
        // V3
        //****
        File[] subdirectories3 = currentDirectory.listFiles(f -> f.isDirectory());
        System.out.println("V3 --- subdirectories of the current directory: " + Arrays.asList(subdirectories3));

        //==========================================================================================================
        //*****
        // V4
        //*****
        File[] subdirectories4 = currentDirectory.listFiles(File::isDirectory);
        System.out.println("V4 --- subdirectories of the current directory: " + Arrays.asList(subdirectories4));

        //==========================================================================================================
        //*****
        // V5 - OK VERSION
        //*****
        File[] subdirectories5 = getSubdirectories5(currentDirectory);
        System.out.println("V5 --- subdirectories for the current direcotry: " + Arrays.asList(subdirectories5));

        //==========================================================================================================
        //*****
        // V6 - BEST VERSION
        //*****

        File[] subdirectories6 = getSubdirectories6(currentDirectory);
        System.out.println("V6 --- subdirectories for the current directory: " + Arrays.asList(subdirectories6));

        //==========================================================================================================
        //==========================================================================================================

//        3. Using the list(FilenameFilter) method of the java.io.File class, write a method
//        that returns all files in a given directory with a given extension. Use a lambda
//        expression, not a FilenameFilter. Which variables from the enclosing scope does
//        it capture?

        System.out.println();
        System.out.println("--- Exercice 3 ---");
        System.out.println("Files with the extension 'txt' from the current direcotry: " + Arrays.asList(getFilesWithExtention(currentDirectory, ".txt")));
        File lambdaExpressionsPart1_sources = new File("./src/lambdaExpressionsPart1");
        System.out.println("Files with the extension '.java' from the ./src/lambdaExpressionsPart1: " + Arrays.asList(getFilesWithExtention(lambdaExpressionsPart1_sources, ".java")));


        //==========================================================================================================
        //==========================================================================================================

//        4. Given an array of File objects, sort it so that the directories come before the
//        files, and within each group, elements are sorted by path name. Use a lambda
//        expression, not a Comparator.

        System.out.println();
        System.out.println("--- Exercice 4 ---");
        Comparator<File> directoriesBeforeFiles = (f1, f2) -> {
            int result = 0;
            if(f1.isDirectory() && !f2.isDirectory()) {
                result = 1;
            } else if(!f1.isDirectory() && f2.isDirectory()) {
                result = -1;
            }
            return result;
        };

        //Comparator<File> alphabeticalOrder = (f1, f2) -> f1.getName().compareTo(f2.getName());
        Comparator<File> alphabeticalOrder = comparing(File::getName);
        File[] sortedFiles = sortFilesFromDierctory(new File("."), directoriesBeforeFiles, alphabeticalOrder);
        System.out.println("Content of the current directory sorted - directories first - alphabetically and then files - sorted alphabetically: " + Arrays.asList(sortedFiles));

        //==========================================================================================================
        //==========================================================================================================

//      7. Write a static method andThen that takes as parameters two Runnable instances
//      and returns a Runnable that runs the first, then the second. In the main method,
//      pass two lambda expressions into a call to andThen, and run the returned
//      instance.

        System.out.println();
        System.out.println("--- Exercice 7 ---");
        Runnable r1 = () -> System.out.println("This is from the first Runnable parameter of the andThen.");
        Runnable r2 = () -> System.out.println("Thi is from the second Runnable parameter of the andThen.");
        Runnable printTwoMessages = andThen(r1, r2);
        Thread thread = new Thread(printTwoMessages);
        thread.start();



    }


    //*****
    // V2 - this can be simplified (see V3 and V4)
    static List<File> getSubdirectories(File directory) {
        List<File> subdirs = new ArrayList<>();
        for(File f : directory.listFiles()) {
            if(f.isDirectory()) {
                subdirs.add(f);
            }
        }
        return subdirs;
    }

    //*****
    // V5
    //*****
    public static File[] getSubdirectories5(File dir) {
        return dir.listFiles(f -> f.isDirectory());
    }

    //*****
    // V6
    //*****
    public static File[] getSubdirectories6(File dir) {
        return dir.listFiles(File::isDirectory);
    }

    public static File[] getFilesWithExtention(File directory, String extension) {
        return directory.listFiles(f -> f.getName().endsWith(extension));
    }

    public static File[] sortFilesFromDierctory(File directory, Comparator c1, Comparator c2) {
        File[] filesFromDirectory = directory.listFiles();
        Arrays.sort(filesFromDirectory, c1.reversed().thenComparing(c2));
        return filesFromDirectory;
    }

    public static Runnable andThen(Runnable r1, Runnable r2) {
        //***THE OLD CODING STYLE VERSION:

//        Runnable result = new Runnable() {
//            public void run() {
//                r1.run();
//                r2.run();
//            }
//        };
//        return result;

        //***THE FUNCTIONAL VERSION OF THE ABOVE CODE:
        return () -> {
                        r1.run();
                        r2.run();
                };
    }



}

