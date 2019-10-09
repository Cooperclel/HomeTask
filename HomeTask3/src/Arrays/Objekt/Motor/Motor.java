package Arrays.Objekt.Motor;

public class Motor {
    private int volume;
    private String benzineType;
    private String name;

    public Motor(int volume, String benzineType, String name){
        this.volume = volume;
        this.benzineType = benzineType;
        this.name = name;
    }

    public void setVolume(int volume){
        this.volume = volume;
    }
    public int getVolume(){
        return volume;
    }

    public void setBenzineType(String benzineType){
        this.benzineType = benzineType;
    }
    public String getBenzineType() {
        return benzineType;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public String toString(){
        return "Motor:" + " volume = " + volume + " benzinType " + benzineType + " name " + name + "\n";
    }
}
