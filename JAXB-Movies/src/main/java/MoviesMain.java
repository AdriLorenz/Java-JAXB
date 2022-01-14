import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class MoviesMain {

    private static final String CINEMA_XML = "./cinema-jaxb.xml";

    public static void main(String[] args) throws JAXBException, IOException {

        var moviesList = new ArrayList<Movie>();

        // create books
        var movie1 = new Movie();
        movie1.setName("Spiderman: No Way Home");
        movie1.setDirector("Jon Watts");
        movie1.setReleaseDate(2021);
        movie1.setGenre("action");
        movie1.setCompany("Marvel");
        moviesList.add(movie1);

        var movie2 = new Movie();
        movie2.setName("Avengers: Infinity War");
        movie2.setDirector("Russo Brothers");
        movie2.setReleaseDate(2018);
        movie2.setGenre("action");
        movie2.setCompany("Marvel");
        moviesList.add(movie2);

        // create bookstore, assigning book
        var cinema = new Cinema();
        cinema.setName("Yelmo: Los Alisios");
        cinema.setLocation("Los Alisios");
        cinema.setNumberOfRooms(10);
        cinema.setBillboard(moviesList);

        // create JAXB context and instantiate marshaller
        JAXBContext context = JAXBContext.newInstance(Cinema.class);
        Marshaller m = context.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        // Write to System.out
        m.marshal(cinema, System.out);

        // Write to File
        m.marshal(cinema, new File(CINEMA_XML));

        // get variables from our xml file, created before
        System.out.println();
        System.out.println("Output from our XML File: ");
        Unmarshaller um = context.createUnmarshaller();
        Cinema cinema2 = (Cinema) um.unmarshal(new FileReader(
                CINEMA_XML));
        List<Movie> list = cinema2.getBillboard();
        for (Movie movie : list) {
            System.out.println("Movie: " + movie.getName() + " from "
                    + movie.getDirector());
        }
    }
}
