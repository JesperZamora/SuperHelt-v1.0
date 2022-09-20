
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DatabaseTest {

    @Test
    void arraylistLargerThanZero() {

        //Arrange
        Database database = new Database();

        //Act
        database.tilføjSuperhelt("Jesper", "Wolff", 1990, true, "Lille", 1200);

        //Assert
        assertTrue(database.getSuperhelteData().size() > 0);
    }

    @Test
    void arraylistNotEqualsToNull() {
        //Arrange
        Database database = new Database();

        //Act
        database.tilføjSuperhelt("Jesper", "Wolff", 1990, true, "Lille", 1200);

        //Assert
        assertNotEquals(database.getSuperhelteData().get(0), null);
    }

    @Test
    void arraylistSizeEqualsToOne() {
        //Arrange
        Database database = new Database();

        //Act
        database.tilføjSuperhelt("Jesper", "Wolff", 1990, true, "Lille", 1200);

        //Assert
        assertEquals(database.getSuperhelteData().size(), 1);
    }

    @Test
    void arraylistSizeEquelsToZero() {
        //Arrange
        Database database = new Database();

        //Assert
        assertEquals(database.getSuperhelteData().size(), 0);
    }


    @Test
    void findSuperheltNameNotEqual() {
        Database database = new Database();

        database.tilføjSuperhelt("Jesper", "Wolff", 1990, true, "Lille", 1200);

        assertNotEquals(database.getSuperhelteData().equals("Jesper"), "Jesper");

    }
}