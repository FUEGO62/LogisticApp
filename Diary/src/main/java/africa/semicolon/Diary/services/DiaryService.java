package africa.semicolon.Diary.services;

import africa.semicolon.Diary.data.models.Diary;

public interface DiaryService {
    void register(String username, String password);
    long getNumberOfDiaries();
    Diary findDiaryByUsername(String username);
    void deleteDiaryByUsername(String username);
    void createEntry(String diaryName,String title, String body);
    void updateEntry(String diaryName,String title, String body);
    void deleteEntry(String diaryName,String title);
    String readEntry(String diaryName,String title);

}
