package africa.semicolon.Diary.data.repositories;

import africa.semicolon.Diary.data.models.Diary;
import africa.semicolon.Diary.data.models.Entry;

import java.util.ArrayList;
import java.util.List;

public class DiaryRepositoryImpl implements DiaryRepository {

    List<Diary> diaries = new ArrayList<Diary>();
    private EntryRepositoryImpl entryRepository = new EntryRepositoryImpl();


    @Override
    public void save(Diary diary) {
        diaries.add(diary);
    }

    @Override
    public Diary findByUsername(String username) {
        boolean found = false;
        int index = 0;
        for(index = 0; index < diaries.size(); index++) {
            if(username.equals(diaries.get(index).getUserName())){
                found = true;
                break;
            }
        }
        if(found)return diaries.get(index);
        else return null;
    }

    @Override
    public long count() {
        return diaries.size();
    }

    @Override
    public List<Diary> findAll() {
        return diaries;
    }

    @Override
    public void delete(Diary diary) {

        diaries.remove(diary);
    }

    @Override
    public void delete(String username) {
        boolean found = false;
        int index = 0;
        for(index = 0; index < diaries.size(); index++) {
            if(username.equals( diaries.get(index).getUserName())){
                found = true;
                break;
            }
        }
         if(found)diaries.remove(index);
    }

    @Override
    public void createEntry(String title, String body) {
        Entry entry = new Entry();
        entry.setTitle(title);
        entry.setBody(body);
        entryRepository.save(entry);
    }
}
