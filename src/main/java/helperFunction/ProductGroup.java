package helperFunction;

import java.util.ArrayList;

public class ProductGroup {
   private Integer id;
   private Integer parentId;
    private String title;
    private ArrayList<ProductGroup> subCategory;
    private ArrayList<ProductGroup> product;

    public ArrayList<ProductGroup> getProduct() {
        return product;
    }

    public void setProduct(ArrayList<ProductGroup> product) {
        this.product = product;
    }


    public ProductGroup(Integer id, Integer parentId, String title) {
        this.id = id;
        this.parentId = parentId;
        this.title = title;
        this.subCategory = new ArrayList<ProductGroup>();
    }
    public ArrayList<ProductGroup> getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(ArrayList<ProductGroup> subCategory) {
        this.subCategory = subCategory;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;

    }

    @Override
    public String toString() {
        return getId() + " " + getParentId() + " " + getTitle();
    }
}
