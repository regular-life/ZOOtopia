package assignment2.ZOOtopia;

interface Animal
{
    void setName(String name) ;
    String getName() ;
    void setHistory(String history) ;
    String getHistory() ;
    void setSound(String sound) ;
    String getSound() ;
    void feed() throws InterruptedException;
}

class Mammal implements Animal
{
    private String name;
    private String sound;
    private String history;

    @Override
    public void setName(String name)
    {
        this.name = name;
    }

    @Override
    public String getName()
    {
        return name;
    }

    @Override
    public void feed() throws InterruptedException {
        System.out.println("Feeding " + this.getName() + "...");
        System.out.println(this.getName() + " is eating...");
        System.out.println(this.getName() + "says : " + this.getSound());
    }

    @Override
    public String getSound()
    {
        return sound;
    }

    @Override
    public void setSound(String sound)
    {
        this.sound = sound;
    }

    @Override
    public String getHistory()
    {
        return history;
    }

    @Override
    public void setHistory(String history)
    {
        this.history = history;
    }

    public Mammal(String name, String sound, String history) {
        this.name = name;
        this.sound = sound;
        this.history = history;
    }
}

class Reptile implements Animal
{
    private String name;
    private String sound;
    private String history;

    @Override
    public void setName(String name)
    {
        this.name = name;
    }

    @Override
    public String getName()
    {
        return name;
    }


    @Override
    public void feed() throws InterruptedException {
        System.out.println("Feeding " + this.getName() + "...");
        System.out.println(this.getName() + " is eating...");
        System.out.println(this.getName() + "says : " + this.getSound());
    }

    @Override
    public String getSound()
    {
        return sound;
    }

    @Override
    public void setSound(String sound)
    {
        this.sound = sound;
    }

    @Override
    public String getHistory()
    {
        return history;
    }

    @Override
    public void setHistory(String history)
    {
        this.history = history;
    }

    public Reptile(String name, String sound, String history) {
        this.name = name;
        this.sound = sound;
        this.history = history;
    }
}

class Amphibian implements Animal
{
    private String name;
    private String sound;
    private String history;

    @Override
    public void setName(String name)
    {
        this.name = name;
    }

    @Override
    public String getName()
    {
        return name;
    }


    @Override
    public void feed() throws InterruptedException {
        System.out.println("Feeding " + this.getName() + "...");
        System.out.println(this.getName() + " is eating...");
        System.out.println(this.getName() + "says : " + this.getSound());
    }

    @Override
    public String getSound()
    {
        return sound;
    }

    @Override
    public void setSound(String sound)
    {
        this.sound = sound;
    }

    @Override
    public String getHistory()
    {
        return history;
    }

    @Override
    public void setHistory(String history)
    {
        this.history = history;
    }

    public Amphibian(String name, String sound, String history) {
        this.name = name;
        this.sound = sound;
        this.history = history;
    }
}