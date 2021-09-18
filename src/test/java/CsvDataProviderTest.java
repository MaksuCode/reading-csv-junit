import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Aşağıda Csv , excell tipindeki dosyalardan data çekme örneğini bulabilirsiniz. Junit-5'te bulunan
 *- @CsvFileSource ve @CsvSource anotasyonları ile bu işlemi kolay bir şekilde yapabilirsiniz.
 *  dataların bulunduğu dosyaları /test/resource altına eklemeniz ve path'lerini anotasyonlar içerisinde vermeniz yeterli.
 *
 *  numLinesToSkip parametresi kaç satırı atlamak istediğinizi belirtiyor. Örneğin aşağıda 1 satır atlamışız ki column adlarını data olarak ele almayalım.
 *- @CsvFileSource anotasyonunun alabileceği parametreler ile ilgili README.md dosyasındaki linkleri inceleyebilirsiniz.
 */
public class CsvDataProviderTest {

    // data.csv dosyasına ulaşarak oradaki değerleri çekebiliyoruz.
    @ParameterizedTest
    @CsvFileSource(resources = "/data.csv", numLinesToSkip = 1)
    public void readFromCSVFileTest_1(String column_1 , String column_2 , int column_3){
        assertNotNull(column_1);
        assertNotNull(column_2);
        assertTrue(column_3 > 0);
    }

    // csv file'a ulaşma 2. örnek
    @ParameterizedTest
    @CsvFileSource(resources = "/data_2.csv", numLinesToSkip = 1)
    public void readFromCSVFileTest_2(String expected , String actual){
        assertEquals(expected , actual);
    }

    // Burada dosyaya ulaşmak yerine ufak datalar için @CsvSource kullanılabiliyor ve içine aşağıdaki şekilde yazabiliyoruz.
    @ParameterizedTest
    @CsvSource(value = {
                "Mustafa,  Aksu,  26" ,
                "Mehmet,  Gül, 44 " ,
                "İpek,  Yılmaz,  33"})
    public void readFromCSVTest(String name , String surname , int age){
        assertNotNull(name);
        assertNotNull(surname);
        assertTrue(age > 0);
    }

}
