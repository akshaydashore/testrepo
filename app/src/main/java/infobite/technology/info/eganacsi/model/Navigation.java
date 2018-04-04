package infobite.technology.info.eganacsi.model;

/**
 * Created by kamlesh on 2/17/2018.
 */
public class Navigation {

    private int image;
    private String name;

    public Navigation(int image, String name) {
        this.image = image;
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
