package MainCode;

import javax.lang.model.element.Name;
import javax.print.attribute.standard.MediaSize;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        File t = new File("C:/Users/Bao Thien/Downloads/testfolder/folder3/tFile2.txt");
        //String p = "C:/Users/Bao Thien/Downloads/testfolder/textFile3.txt";
        //String str = "Susumiya Haruhi's Disappearence";

        //createDirectory("tf4","C:/Users/Bao Thien/Downloads/testfolder/folder4/");

        try {
            //t.getParentFile().mkdirs(); // create parent directory

            // creates new file if the file doesnt exists
            if (t.getParentFile().exists()) {
                if (!t.exists()) {
                    t.createNewFile();
                } else {
                    System.out.println("The folder exists");
                }
            } else
                System.out.println("From the path: " + t.getAbsolutePath()+" \nThe folder is missing: "+ t.getParentFile().getName());

        } catch (IOException e) {
            e.printStackTrace();
        }

        //System.out.println(specificFolderContent("C:/Users/Bao Thien/Downloads/testfolder/folder1/") );
        //consolePrintArraylist(folderSplitAlfabetically("C:/Users/Bao Thien/Downloads/testFolder/folder1"));
        consolePrintArraylist(folderSplitAlfabetically("C:/Users/Bao Thien/Downloads/testFolder/folder1"));


        //for (ArrayList<File> a: specificFolderContent("C:/Users/Bao Thien/Downloads/testfolder/folder1/") ) {
        //    for (File b1: a) {
        //        System.out.println(b1);
        //    }
        //}


        //ArrayList<ArrayList<File>> allFolder = new ArrayList<>();
        //allFolder = specificFolderContent("C:/Users/Bao Thien/Downloads/testfolder/folder1/");

        //for (ArrayList<File> a: splitAlfabetically(allFolder.get(1)) ) {
        //    for (File b1: a) {
        //        System.out.println(b1);
        //    }
        //}


        // prøv å print til egen text fil


        //readStringToTxtFile(p, str);
        //NameList nameList = new NameList();

        //checkSpecificFolderFiles("C:/Users/Bao Thien/Downloads/testfolder");

        //splitFolderAlfabetically("C:\\Users\\Bao Thien\\Dropbox\\Download");
        //splitFolderAlfabetically("G:\\TextAloud");


        //Pattern pat = Pattern.compile("(A|B|C|D|E)");
        //Matcher mat = pat.matcher("Black Mist Taht");
        //System.out.println(mat.find() );

        //Boolean g = mat.matches();
        //System.out.println(g);

        //boolean b = Pattern.matches("B.+", "Black Mist");
        //System.out.println(b);

        //String s = "Susumiya Haruhi";
        //boolean f = s.matches("S");
        //System.out.println(f);

        //DoubleArraylistToFile("C:\\Users\\Bao Thien\\Downloads\\testFolder","AnimeListTestFile", splitFolderAlfabetically("C:\\Users\\Bao Thien\\Dropbox\\Download"));

    }

    private static void createDirectory(String folderName, String path) {
        //System.out.println(testFile.getAbsolutePath());
        //String pathName = "C:/Users/Bao Thien/Downloads/testFolder/";

        String pathName = path;

        new File(pathName+folderName).mkdirs();
    }

    @SuppressWarnings("unchecked")
    private static ArrayList<NameList> specificFolderContent(String path) {
        File specificFolder = new File(path);

        ArrayList<File> directoryFiles = new ArrayList<>(Arrays.asList(specificFolder.listFiles(File::isDirectory) ) );
        ArrayList<File> normalFiles = new ArrayList<>(Arrays.asList(specificFolder.listFiles(File::isFile) ) );

        Collections.sort(normalFiles);
        Collections.sort(directoryFiles);

        NameList directoryF = new NameList(directoryFiles);
        directoryF.setListName("Directory Files ");

        NameList normalF = new NameList(normalFiles);
        normalF.setListName("Normal Files ");

        return new ArrayList<>(Arrays.asList(directoryF,normalF));

        /*
        ArrayList<ArrayList<File>> allFolderFiles = new ArrayList<>();
        //= new ArrayList<>(Arrays.asList(directoryFiles, normalFiles));

        allFolderFiles.add(directoryFiles);
        allFolderFiles.add(normalFiles);

        return allFolderFiles;*/
    }

    @SuppressWarnings("unchecked")
    private static ArrayList<NameList> splitAlfabetically (NameList fileList) {
        ArrayList<File> filesAE = new ArrayList<>();
        ArrayList<File> filesFJ = new ArrayList<>();
        ArrayList<File> filesKO = new ArrayList<>();
        ArrayList<File> filesPT = new ArrayList<>();
        ArrayList<File> filesUZ = new ArrayList<>();
        ArrayList<File> filesNotAlfa = new ArrayList<>();

        //String pattern = "^[A-Za-z]*$";
        String stringAE = "^[A-Ea-e]";
        String stringFJ = "^[F-Jf-j]";
        String stringKO = "^[K-Ok-o]";
        String stringPT = "^[P-Tp-t]";
        String stringUZ = "^[U-Zu-z]";

        Pattern pAE = Pattern.compile(stringAE);
        Pattern pFJ = Pattern.compile(stringFJ);
        Pattern pKO = Pattern.compile(stringKO);
        Pattern pPT = Pattern.compile(stringPT);
        Pattern pUZ = Pattern.compile(stringUZ);

        Matcher m;
        String fName;
        ArrayList<File> arr = fileList.getList();

        for (File f : arr ) {
            fName = f.getName();
            //patternMatcher(fName);

            // will match the input against the pattern
            if (pAE.matcher(fName).find()) {
                filesAE.add(f);
            } else if (pFJ.matcher(fName).find() ) {
                filesFJ.add(f);
            } else if (pKO.matcher(fName).find() ) {
                filesKO.add(f);
            } else if (pPT.matcher(fName).find() ) {
                filesPT.add(f);
            } else if (pUZ.matcher(fName).find() ) {
                filesUZ.add(f);
            } else {
                filesNotAlfa.add(f);
            }
        }

        NameList nAE = new NameList(filesAE); nAE.setListName("Files in A-E: ");
        NameList nFJ = new NameList(filesFJ); nFJ.setListName("Files in F-J: ");
        NameList nKO = new NameList(filesKO); nKO.setListName("Files in K-O: ");
        NameList nPT = new NameList(filesPT); nPT.setListName("Files in P-T: ");
        NameList nUZ = new NameList(filesUZ); nUZ.setListName("Files in U-Z: ");
        NameList nNotAlfa = new NameList(filesNotAlfa); nNotAlfa.setListName("Files in Number/Signs etc: ");

        //ArrayList<NameList> result = new ArrayList<>(Arrays.asList(nAE,nFJ,nKO,nPT,nUZ,nNotAlfa));

        //ArrayList<ArrayList<File>> splitAlfa = new ArrayList<>(Arrays.asList(filesAE, filesFJ, filesKO, filesPT, filesUZ,filesNotAlfa));
        //NameList splitAlfa = new NameList(null);
        //splitAlfa.addList(filesAE);
        //splitAlfa.addList(filesFJ);
        //splitAlfa.addList(filesKO);
        //splitAlfa.addList(filesPT);
        //splitAlfa.addList(filesUZ);
        //splitAlfa.addList(filesNotAlfa);

        //ArrayList<NameList> result = new ArrayList<>();
        //result.add(splitAlfa);

        return new ArrayList<>(Arrays.asList(nAE,nFJ,nKO,nPT,nUZ,nNotAlfa));
    }

    @SuppressWarnings("unchecked")
    private static ArrayList<NameList> folderSplitAlfabetically(String path) {
        ArrayList<NameList> allFolderFiles = specificFolderContent(path);

        ArrayList<NameList> directoryFilesSplitAlfa = splitAlfabetically(allFolderFiles.get(0) ); // adds directory files
        ArrayList<NameList> normalFilesSplitAlfa = splitAlfabetically(allFolderFiles.get(1) ); // adds normal files

        NameList nameDirectoryFilesSplitAlfa = new NameList(directoryFilesSplitAlfa); nameDirectoryFilesSplitAlfa.setListName("Directory files split alfabetically: ");
        NameList nameNormalFilesSplitAlfa = new NameList(normalFilesSplitAlfa); nameNormalFilesSplitAlfa.setListName("Normal files split alfabetically: ");

        //ArrayList<ArrayList<ArrayList<File>>> allFilesSplitAlfa = new ArrayList<>(Arrays.asList(directoryFilesSplitAlfa, normalFilesSplitAlfa));
        //ArrayList<NameList> allNameFilesSplitAlfa = new ArrayList<>(Arrays.asList(nameDirectoryFilesSplitAlfa,nameNormalFilesSplitAlfa));

        //return allFilesSplitAlfa;
        return new ArrayList<>(Arrays.asList(nameDirectoryFilesSplitAlfa,nameNormalFilesSplitAlfa));
    }

    @SuppressWarnings("unchecked")
    private static void consolePrintArraylist(ArrayList<NameList> filesSplitAlfa) {
        //NameList directoryFiles = filesSplitAlfa.get(0);
        //NameList normalFiles = filesSplitAlfa.get(1);

        //get namelist, then the namelists arraylist
        ArrayList<NameList> dirFile = filesSplitAlfa.get(0).getList();
        ArrayList<NameList> norFile = filesSplitAlfa.get(1).getList();

        System.out.println("\nDirectory files in the map: ");
        goThroughNameList(dirFile);

        System.out.println("\nNormal files in the map: ");
        goThroughNameList(norFile);
    }

    private static void goThroughNameList(ArrayList<NameList> arrayNameList) {
        for (NameList na: arrayNameList) {
            ArrayList<File> arr = na.getList();
            System.out.println(na.toString());

            for (File f: arr) {
                System.out.println(f.getName());
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

    private static void ArrayListToFile(String folderName,String fileName,ArrayList<String> text) {

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

    private static void readFromFile (String folderName,String fileName,ArrayList<String> text) {
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



}
