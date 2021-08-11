package helperFunction;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class HelperFunctions {
    public static int returnArraySize(ArrayList<ProductGroup>array) {
        try {
            return array.size();
        } catch(NullPointerException e) {
            return 0;
        }
    }
    public static int returnInteger(String input) {
        try {
            return Integer.parseInt(input);
        }catch(NumberFormatException e) {
            return -1;
        }
    }
    public static ArrayList<ProductGroup> csvReader() throws IOException {
        FileReader fr = null;
        BufferedReader br = null;
        ArrayList<ProductGroup> list = new ArrayList<ProductGroup>();
        try {
            fr = new FileReader("C:\\WorkSpace\\ProductsCatalog\\src\\main\\java\\Product groups.csv");
            br = new BufferedReader(fr);
            String textLine;
            int counter = 0;
            while ((textLine = br.readLine()) != null) {
                counter++;
                if (counter == 1) {
                    continue;
                }
                String[] categoryLine = textLine.split(";");
                ProductGroup x = new ProductGroup(
                        returnInteger(categoryLine[0]),
                        returnInteger(categoryLine[1]),
                        categoryLine[2]);
                list.add(x);
            }
        } catch (Exception exc) {
            System.out.printf("Exception while HelperFunctions.csvReader): %s%n", exc.getMessage());
        } finally {
            br.close();
            fr.close();
        }
        return list;
    }
    public static void printFullCategories(ArrayList<ProductGroup> array, int index) {
        ProductGroup currentItem = array.get(index);
        if(currentItem.getParentId() == -1) {
            System.out.println(currentItem.getTitle());
            array.forEach(x -> {
                if(x.getParentId() == currentItem.getId()){
                    System.out.println(" - " + x.getTitle());
                    array.forEach((z -> {
                        if(z.getParentId() == x.getId()) {
                            System.out.println("  - - " + z.getTitle());
                        }
                    }));
                }
            });
        }
        if(array.size()-1>index){
            printFullCategories(array,index+1);
        }
    }
}
