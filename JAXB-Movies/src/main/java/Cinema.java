import java.util.List;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "cinema")
@XmlAccessorType(XmlAccessType.FIELD)
public class Cinema {

    @XmlElementWrapper(name = "billboard")
    @XmlElement(name = "movie")
    private List<Movie> billboard;
    private String name;
    private String location;
    private int numberOfRooms;

    public List<Movie> getBillboard() {
        return billboard;
    }

    public void setBillboard(List<Movie> billboard) {
        this.billboard = billboard;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(int numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }
}
