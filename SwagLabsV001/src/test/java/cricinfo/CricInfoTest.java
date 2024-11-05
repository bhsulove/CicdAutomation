package cricinfo;

import org.example.cricinfo.CricInfoPage;
import org.testng.annotations.Test;

public class CricInfoTest extends BaseTest{
    private CricInfoPage cricInfoPage;
    @Test
    public void testCricInfo(){
        cricInfoPage = new CricInfoPage(driver);
        cricInfoPage.readTableData();
    }
}
