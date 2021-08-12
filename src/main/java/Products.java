import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.stream.Collectors;

import helperFunction.*;

public class Products {


    public static void main(String[] args) throws IOException {
    //HelperFunctions.printFullCategories(HelperFunctions.csvReader(),0);


        buildCatalog(HelperFunctions.csvReader(),0);

    }
        public static void buildCatalog(ArrayList<ProductGroup> array, int index) {
            if (array.get(index).getParentId() == -1) {
                System.out.println(array.get(index).getTitle());
                array.get(index).setSubCategory(array.stream().filter((x) -> x.getParentId() == array.get(index).getId()).collect(Collectors.toCollection(ArrayList::new)));
                for(ProductGroup x : array.get(index).getSubCategory()) {
                    x.setProduct(array.stream().filter((z) -> z.getParentId() == x.getId()).collect(Collectors.toCollection(ArrayList::new)));
                }
                for (ProductGroup p :array.get(index).getSubCategory()){
                    System.out.println(" - " + p.getTitle());
                    for (ProductGroup g : p.getProduct()) {
                        System.out.println(" -- " + g.getTitle());
                    }
                }
            }
            if (index < array.size()-1) {
                buildCatalog(array, index + 1);
            }
        }
//    public static void buildCatalog(ArrayList<ProductGroup> array, int index) {
//        if (array.get(index).getParentId() == -1) {
//            array.get(index).setSubCategory(array.stream().filter((x) -> x.getParentId() == array.get(index).getId()).collect(Collectors.toCollection(ArrayList::new)));
//        }
//        if (array.get(index).getParentId() != -1) {
//            array.get(index).setProduct(array.stream().filter((x) -> x.getParentId() == array.get(index).getId()).collect(Collectors.toCollection(ArrayList::new)));
//        }
//        if (array.get(index).getParentId() == -1) {
//            System.out.println(array.get(index));
//        }
//        if (HelperFunctions.returnArraySize(array.get(index).getSubCategory()) > 0) { // null is not more than zero for every occurance of z.
//            for (ProductGroup z : array) {
//                // System.out.println(z.getParentId()); testai
//                // System.out.println(" - " + z.getTitle());
//
//                //if (z.getParentId()  > 0) {
//                if (HelperFunctions.returnArraySize(z.getProduct()) > 0) {
//                    for (ProductGroup y : z.getProduct()) {
//                        System.out.println(" - - " + y.getTitle());
//                    }
//                }
//            }
//        }
//      if(array.size()-1 > index) {
//            buildCatalog(array,index+1);
//        }
 }






