package africa.semicolon.Diary.data.repositories;

import africa.semicolon.Diary.data.models.Diary;

import java.util.ArrayList;
import java.util.List;

public class DiaryRepositoryImpl implements DiaryRepository {

    List<Diary> diaries = new ArrayList<Diary>();


    @Override
    public void save(Diary diary) {
        diaries.add(diary);
    }

    @Override
    public Diary findByUsername(String username) {
        boolean found = false;
        int i = 0;
        for(i = 0; i < diaries.size(); i++) {
            if(username.equals(diaries.get(i).getUserName())){
                found = true;
                break;
            }
        }
        if(found)return diaries.get(i);
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
        int i = 0;
        for(i = 0; i < diaries.size(); i++) {
            if(username.equals( diaries.get(i).getUserName())){
                found = true;
                break;
            }
        }
         if(found)diaries.remove(i);
    }
}
