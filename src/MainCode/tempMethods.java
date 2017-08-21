package MainCode;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * Created by BaoTNM on 21.08.2017.
 */
public class tempMethods {


    private static void createDirectory(String folderName, String path) {
        //System.out.println(testFile.getAbsolutePath());
        //String pathName = "C:/Users/Bao Thien/Downloads/testFolder/";
        //String pathName = path;

        new File(path+folderName).mkdirs();
    }

    private static void readStringToTxtFile (String path, String text) {

        File testFile = new File(path);

        try {

            FileWriter fw = new FileWriter(testFile) ;
            fw.write(text);
            fw.close();

        } catch (IOException e) {
            e.printStackTrace();

        }

    }

    private static void ArrayListToFile(String folderName, String fileName, ArrayList<String> text) {

        String path = "C:/Users/Bao Thien/Downloads/"+folderName+"/"+fileName+".txt";
        File file = new File(path);

        try {
            if(!file.exists() ) {
                file.createNewFile();
            }

            BufferedWriter bfOut = new BufferedWriter(new FileWriter(file));

            for (int i=0; i< text.size(); i++) {
                bfOut.write(text.get(i));
                bfOut.newLine();
            }

            bfOut.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void readFromFile (String folderName, String fileName, ArrayList<String> text) {
        String path = "C:/Users/Bao Thien/Downloads/"+folderName+"/"+fileName+".txt";
        File file = new File(path);

        BufferedReader bfInn = null;
        String line;

        try {
            bfInn = new BufferedReader(new FileReader(file));

            while ((line = bfInn.readLine() ) != null ) {
                System.out.println(line);
            }

        } catch (IOException e){
            e.printStackTrace();
        } finally {
            try {
                bfInn.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    private static void DoubleArraylistToFile (String path, String fileName, ArrayList<ArrayList<File>>  filesSplitAlfabetically ) {
        String newFilePath = path+"\\"+fileName+".txt";

        // checks if the a file with the same name exists
        //if( new File(newFilePath).exists() )

        File file = new File(newFilePath);
        BufferedWriter bfOut;

        // now when false goes into if, and means that the file already exists. And when if is true goes into else and means that the file was already created
        try {
            bfOut = new BufferedWriter(new FileWriter(file));

            if(file.exists() ) {
                System.out.println("File with the name:"+fileName+" allready exists");
            } else {
                file.createNewFile();
                bfOut.write("First Line test");

                for (int i=0; i< filesSplitAlfabetically.size(); i++) {
                    if (i==0) {
                        bfOut.write("Files in ABCDE:");
                    } else if (i==1) {
                        bfOut.write("\nFiles in FGHIJ:");
                    } else if (i==2) {
                        bfOut.write("\nFiles in KLMNO:");
                    } else if (i==3) {
                        bfOut.write("\nFiles in PQRST:");
                    } else if (i==4) {
                        bfOut.write("\nFiles in UVWXYZ:");
                    }

                    for (int j=0; j < filesSplitAlfabetically.get(i).size(); j++) {
                        for (File f : filesSplitAlfabetically.get(i).get(j).listFiles() ) {
                            bfOut.write(f.getName() );
                            bfOut.newLine();
                        }


                    }

                }
                bfOut.close();

            }


        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private static Matcher patternMatcher (String text) {
        String stringAE = "^(A|B|C|D|E)";
        String stringFJ = "^(F|G|H|I|J)";
        String stringKO = "^(K|L|M|N|O)";
        String stringPT = "^(P|Q|R|S|T)";
        String stringUZ = "^(U|V|W|X|Y|Z)";

        Pattern pAE = Pattern.compile(stringAE);
        Pattern pFJ = Pattern.compile(stringFJ);
        Pattern pKO = Pattern.compile(stringKO);
        Pattern pPT = Pattern.compile(stringPT);
        Pattern pUZ = Pattern.compile(stringUZ);

        Matcher m;

        ArrayList<Pattern> patternList = new ArrayList<Pattern>(Arrays.asList(pAE,pFJ,pKO,pPT,pUZ) );

        for (Pattern p : patternList) {
            if(p.matcher(text).matches() )
                return m = pAE.matcher(text);
        }

        return null;
    }

    private static void checkInDepthFolderFiles () {
        try {

            List<File> listRegularFiles = Files.walk(Paths.get("C:/Users/Bao Thien/Downloads/testfolder")).filter(Files::isRegularFile).map(Path::toFile).collect(Collectors.toList() );
            List<File> listDirectories = Files.walk(Paths.get("C:/Users/Bao Thien/Downloads/testfolder")).filter(Files::isDirectory).map(Path::toFile).collect(Collectors.toList() );

            System.out.println();


        } catch(IOException e) {
            e.printStackTrace();
        }

    }

    private static void checkSpesificFolderNames (String path) {
        File file = new File(path);
        ArrayList<String> fileNames = new ArrayList<String>(Arrays.asList(file.list()));

        System.out.println("Fil Navn:");
        System.out.println(fileNames);

        /*
        File folder = new File("C:/Users/Bao Thien/Downloads/testfolder");
        File[] listOfFiles = folder.listFiles();

        for (File file : listOfFiles) {
            if (file.isDirectory())
                System.out.println(file.getName());
        }

        for (File file : listOfFiles) {
            if (file.isFile())
                System.out.println(file.getName());
        }

        System.out.println(" ");
        // replace \\ with /
        s = s.replace("\\", "/");
        */

    }
}
