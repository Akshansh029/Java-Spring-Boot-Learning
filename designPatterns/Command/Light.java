package designPatterns.Command;


// Receiver 1 - Light
public class Light {
    private String location;
    private boolean isOn = false;
    private int brightness = 0;

    public Light(String location) {
        this.location = location;
    }

    public void on() {
        isOn = true;
        brightness = 100;
        System.out.println(location + " light is ON (100% brightness)");
    }

    public void off() {
        isOn = false;
        brightness = 0;
        System.out.println(location + " light is OFF");
    }

    public void dim(int level) {
        if (isOn) {
            brightness = level;
            System.out.println(location + " light dimmed to " + level + "%");
        } else {
            System.out.println(location + " light is off, cannot dim");
        }
    }

    public int getBrightness() {
        return brightness;
    }
}
