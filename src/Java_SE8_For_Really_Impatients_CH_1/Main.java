package Java_SE8_For_Really_Impatients_CH_1;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

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


}

