package africa.semicolon.Diary.data.repositories;

import africa.semicolon.Diary.data.models.Entry;

import java.util.ArrayList;

public class EntryRepositoryImpl implements EntryRepository {

    ArrayList<Entry> entries = new ArrayList<Entry>();

    @Override
    public void save(Entry entry) {
        entries.add(entry);
    }

    @Override
    public void delete(String title) {

        boolean found = false;
        int i = 0;
        for(i = 0; i < entries.size(); i++) {
            if(title.equals(entries.get(i).getTitle())){
                found = true;
                break;
            }
        }
        if(found)entries.remove(i);
    }

    @Override
    public void update(String title, String body) {
        boolean found = false;
        int i = 0;
        for(i = 0; i < entries.size(); i++) {
            if(title.equals(entries.get(i).getTitle())){
                found = true;
                break;
            }
        }
        if(found){
            entries.get(i).setTitle(title);
            entries.get(i).setBody(body);
        }
    }

    @Override
    public Entry findByTitle(String title) {
        boolean found = false;
        int i = 0;
        for(i = 0; i < entries.size(); i++) {
            if(title.equals(entries.get(i).getTitle())){
                found = true;
                break;
            }
        }
        if(found)return entries.get(i);
        else return null;
    }
}
