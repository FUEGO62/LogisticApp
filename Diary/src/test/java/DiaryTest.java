import africa.semicolon.Diary.data.models.Diary;
import africa.semicolon.Diary.data.repositories.DiaryRepository;
import africa.semicolon.Diary.data.repositories.DiaryRepositoryImpl;
import africa.semicolon.Diary.services.DiaryService;
import africa.semicolon.Diary.services.DiaryServiceImpl;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DiaryTest {

    @Test
    public void test_That_Register_Function_Works(){
        DiaryServiceImpl diaryService = new DiaryServiceImpl();
        assertEquals(0,diaryService.getNumberOfDiaries());
        diaryService.register("jesse","password");
        assertEquals(1,diaryService.getNumberOfDiaries());

    }

    @Test
    public void test_That_Register_Function_Throws_Exception_With_Invalid_Password(){
        DiaryServiceImpl diaryService = new DiaryServiceImpl();
        assertThrows(IllegalArgumentException.class, ()->diaryService.register("jesse",""));
        assertThrows(IllegalArgumentException.class, ()->diaryService.register("jesse"," "));
    }

    @Test
    public void test_That_Register_Function_Throws_Exception_With_Invalid_Username(){
        DiaryServiceImpl diaryService = new DiaryServiceImpl();
        assertThrows(IllegalArgumentException.class, ()->diaryService.register("","pssword"));
        assertThrows(IllegalArgumentException.class, ()->diaryService.register(" ","password"));
    }

    @Test
    public void test_That_Register_Function_Throws_Exception_With_Username_Already_In_Use(){
        DiaryServiceImpl diaryService = new DiaryServiceImpl();
        diaryService.register("jesse","password");
        assertThrows(IllegalArgumentException.class, ()->diaryService.register("jesse","pass"));

    }


    @Test
    public void test_That_Get_Number_Of_Diary_Function_Works(){
        DiaryServiceImpl diaryService = new DiaryServiceImpl();
        assertEquals(0,diaryService.getNumberOfDiaries());
        diaryService.register("jesse","password");
        diaryService.register("dera","password");
        assertEquals(2,diaryService.getNumberOfDiaries());

    }

    @Test
    public void test_That_Find_Diary_By_Username_Works(){
        DiaryServiceImpl diaryService = new DiaryServiceImpl();
        diaryService.register("jesse","password");
        diaryService.register("fuego","password");
        Diary diary = diaryService.findDiaryByUsername("jesse");
        assertEquals("jesse",diary.getUserName());
    }

    @Test
    public void test_That_Find_Diary_By_Username_Throws_Exception_With_Unregistered_Names(){
        DiaryServiceImpl diaryService = new DiaryServiceImpl();
        assertThrows(IllegalArgumentException.class, ()->diaryService.findDiaryByUsername("jesse"));
    }
    @Test
    public void test_That_Find_Diary_By_Username_Throws_Exception_With_Invalid_Username(){
        DiaryServiceImpl diaryService = new DiaryServiceImpl();
        assertThrows(IllegalArgumentException.class, ()->diaryService.findDiaryByUsername(""));
    }

    @Test
    public void test_That_Delete_Diary_By_Username_Works(){
        DiaryServiceImpl diaryService = new DiaryServiceImpl();
        diaryService.register("jesse","password");
        diaryService.register("fuego","password");
        diaryService.deleteDiaryByUsername("jesse");
        assertEquals(null,diaryService.findDiaryByUsername("jesse"));
    }

    @Test
    public void test_That_Delete_Diary_By_Username_Throws_Exception_With_Invalid_Username(){
        DiaryServiceImpl diaryService = new DiaryServiceImpl();
        assertThrows(IllegalArgumentException.class, ()->diaryService.deleteDiaryByUsername(""));
    }
}
