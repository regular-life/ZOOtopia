package assignment2.ZOOtopia;

class SpecialDeal
{
    private Integer threshold_number ;
    private Integer discount_percentage ;

    public Integer getThreshold_number() {
        return threshold_number;
    }

    public void setThreshold_number(Integer threshold_number) {
        this.threshold_number = threshold_number;
    }

    public Integer getDiscount_percentage() {
        return discount_percentage;
    }

    public void setDiscount_percentage(Integer discount_percentage) {
        this.discount_percentage = discount_percentage;
    }

    public SpecialDeal(Integer threshold_number, Integer discount_percentage) {
        this.threshold_number = threshold_number;
        this.discount_percentage = discount_percentage;
    }
}