package assignment2.ZOOtopia;

class Discount
{
    private String discount_category ;
    private Integer discount_percentage ;
    private String discount_code ;

    public String getDiscount_category() {
        return discount_category;
    }

    public void setDiscount_category(String discount_category) {
        this.discount_category = discount_category;
    }

    public Integer getDiscount_percentage() {
        return discount_percentage;
    }

    public void setDiscount_percentage(Integer discount_percentage) {
        this.discount_percentage = discount_percentage;
    }

    public String getDiscount_code() {
        return discount_code;
    }

    public void setDiscount_code(String discount_code) {
        this.discount_code = discount_code;
    }

    public Discount(String discount_category, Integer discount_percentage, String discount_code) {
        this.discount_category = discount_category;
        this.discount_percentage = discount_percentage;
        this.discount_code = discount_code;
    }
}
