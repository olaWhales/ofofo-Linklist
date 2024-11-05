package ofofo.data.repository;


import ofofo.data.model.Diary;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class DiaryRepositoryImplTest {
    private final DiaryRepository diaryRepository = new DiaryRepositoryImpl();

    @Test
    public void testThatDiaryRepositoryIsEmpty_noDiaryIsSaved() {
        assertEquals(0 , diaryRepository.count());
    }
    @Test
    public void testThatDiaryRepositoryIsNotEmpty_oneDiaryIsSaved() {
        Diary diary = new Diary();
        diary.setUserName("user");
        diary.setPassword("password");
        diaryRepository.save(diary);
        assertEquals(1 , diaryRepository.count());
    }
    @Test
    public void testThatDiaryRepositoryIsNotEmpty_twoDiariesAreSaved() {
        Diary diary = new Diary();
        diary.setUserName("user");
        diary.setPassword("password");
        diaryRepository.save(diary);
        Diary diary2 = new Diary();
        diary2.setUserName("user2");
        diary2.setPassword("password2");
        diaryRepository.save(diary2);
        assertEquals(2 , diaryRepository.count());
    }
    @Test
    public void testThatRepositoryCanNotAddANullDiary(){
        Diary diary = new Diary();
        assertThrows(IllegalArgumentException.class, () -> diaryRepository.save(diary));
    }
    @Test
    public void testThatRepositoryCanDeleteAllDiaries(){
        Diary diary = new Diary();
        diary.setUserName("user");
        diary.setPassword("password");
        diaryRepository.save(diary);
        Diary diary2 = new Diary();
        diary2.setUserName("user2");
        diary2.setPassword("password2");
        diaryRepository.save(diary2);
        assertEquals(2 , diaryRepository.count());
        diaryRepository.deleteAll();
        assertEquals(0 , diaryRepository.count());
    }
@Test
    public void testThatRepositoryCanDeleteById(){
    Diary diary = new Diary();
    diary.setUserName("user");
    diary.setPassword("password");
    diaryRepository.save(diary);
    Diary diary2 = new Diary();
    diary2.setUserName("user2");
    diary2.setPassword("password2");
    diaryRepository.save(diary2);
    assertEquals(2 , diaryRepository.count());
    diaryRepository.deleteById("user2");
    assertEquals(1 , diaryRepository.count());
    }

    @Test
    public void testThatDiaryWithTheGivenIdExist(){
        Diary diary = new Diary();
        diary.setUserName("user");
        diary.setPassword("password");
        diaryRepository.save(diary);
        assertEquals(1 , diaryRepository.count());
        Diary diary2 = new Diary();
        diary2.setUserName("user2");
        diary2.setPassword("password2");
        diaryRepository.save(diary2);
        assertEquals(2 , diaryRepository.count());
        diaryRepository.existsById("user");
        assertTrue(diaryRepository.existsById("user"));
    }
    @Test
    public void testThatDiaryWithTheGivenIdExistByPrinting(){
        Diary diary = new Diary();
        diary.setUserName("user");
        diary.setPassword("password");
        diaryRepository.save(diary);
        assertEquals(1 , diaryRepository.count());
        Diary diary2 = new Diary();
        diary2.setUserName("user2");
        diary2.setPassword("password2");
        diaryRepository.save(diary2);
        assertEquals(2 , diaryRepository.count());
        Diary check = diaryRepository.findById("user");
        assertEquals("user" , check.getUserName());
    }
    @Test
    public void testThatDiaryCanDeleteDiaryByEnteringTheDiary(){
        Diary diary = new Diary();
        diary.setUserName("user");
        diary.setPassword("password");
        diaryRepository.save(diary);
        assertEquals(1 , diaryRepository.count());
        diaryRepository.delete(diary);
        assertEquals(0 , diaryRepository.count());
    }

    @Test
    public void testThatDiaryCandeleteById(){
        Diary diary = new Diary();
        diary.setUserName("user");
        diary.setPassword("password");
        diaryRepository.save(diary);
        assertEquals(1 , diaryRepository.count());
        diaryRepository.deleteById("user");
        assertEquals(0 , diaryRepository.count());
    }
    @Test
    public void testThatDiaryCanDisplayAllDiaryRegister(){
        Diary diary  = new Diary();
        diary.setUserName("user");
        diary.setPassword("password");
        diaryRepository.save(diary);
        Diary diary2 = new Diary();
        diary2.setUserName("user2");
        diary2.setPassword("password2");
        diaryRepository.save(diary2);
        Diary diary3  = new Diary();
        diary.setUserName("user3");
        diary.setPassword("password3");
        diaryRepository.save(diary);
        assertEquals( diaryRepository.count() , 3 );
        List<Diary> diaryList = diaryRepository.findAll();
        assertEquals(2, diaryList.size());
        assertEquals("user" , diaryList.get(0).getUserName() );
        assertEquals("user2" , diaryList.get(1).getUserName() );
        System.out.println(diaryList.get(0));
    }
}