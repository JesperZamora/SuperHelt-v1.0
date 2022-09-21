import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DatabaseTest {
    Superhelt s1;
    Superhelt s2;
    Database database;


    @BeforeEach
    void setUp () {
        //test fixture
        database = new Database();
        s1 = new Superhelt("Jesper", "Wolff", 1990, true, "lille", 1000); // Hardcode superhelt 1
        s2 = new Superhelt("Paul", "Wolff", 1991, true, "Stor", 1200); // Hardcode superhelt 2
        database.getSuperhelteData().addAll(List.of(s1, s2));

    }

    @Test
    void testTilføjSuperhelt() { // Tester metoden ved at tilføje en tredje superhelt (udover de 3 hardcodet)

        int expectedSize = 3;

        database.tilføjSuperhelt("Osama", "Wolff", 1990, true, "Lille", 1200);

        assertEquals(expectedSize, database.getSuperhelteData().size());
    }

    @Test
    void testFindSuperhelt() {
        String expectedAliasNavn = "Jesper";
        assertEquals(expectedAliasNavn, s1.getAliasNavn());
    }

    @Test
    void testFindSuperheltNavn() {
        String expectedAliasNavn = "Kokos";
        assertEquals(expectedAliasNavn, s1.getAliasNavn());
    }

}