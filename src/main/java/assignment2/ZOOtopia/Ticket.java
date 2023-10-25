package assignment2.ZOOtopia;

import org.w3c.dom.Attr;

class Ticket
{
    private Attraction attraction ;

    public Attraction getAttraction() {
        return attraction;
    }

    public void setAttraction(Attraction attraction) {
        this.attraction = attraction;
    }

    public Ticket(Attraction attraction) {
        this.attraction = attraction;
    }

}
