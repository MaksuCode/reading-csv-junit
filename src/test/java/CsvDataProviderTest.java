import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class CsvDataProviderTest {

    @ParameterizedTest
    @CsvFileSource(resources = "/data.csv", numLinesToSkip = 1)
    public void readFromCSVFileTest_1(String name , String surname , int age){
        assertNotNull(name);
        assertNotNull(surname);
        assertTrue(age > 0);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/data_2.csv", numLinesToSkip = 1)
    public void readFromCSVFileTest_2(String expected , String actual){
        assertEquals(expected , actual);
    }

    @ParameterizedTest
    @CsvSource(value = {
                "Mustafa,  Aksu,  26" ,
                "Mehmet,  Gül, 44 " ,
                "İlhan,  Yılmaz,  33"})
    public void readFromCSVTest(String name , String surname , int age){
        assertNotNull(name);
        assertNotNull(surname);
        assertTrue(age > 0);
    }

}
