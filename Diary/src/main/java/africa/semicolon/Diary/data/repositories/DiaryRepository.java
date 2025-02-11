package africa.semicolon.Diary.data.repositories;

import africa.semicolon.Diary.data.models.Diary;

import java.util.List;

public interface DiaryRepository {
    void save(Diary diary);
    Diary findByUsername(String username);
    long count();
    List<Diary> findAll();
    void delete(Diary diary);
    void delete(String username);
    void createEntry(String title , String body);
}
