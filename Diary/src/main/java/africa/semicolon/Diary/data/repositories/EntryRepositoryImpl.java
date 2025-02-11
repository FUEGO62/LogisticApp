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
        int index = 0;
        for(index = 0; index < entries.size(); index++) {
            if(title.equals(entries.get(index).getTitle())){
                found = true;
                break;
            }
        }
        if(found)entries.remove(index);
    }

    @Override
    public void update(String title, String body) {
        boolean found = false;
        int index = 0;
        for(index = 0; index < entries.size(); index++) {
            if(title.equals(entries.get(index).getTitle())){
                found = true;
                break;
            }
        }
        if(found){
            entries.get(index).setTitle(title);
            entries.get(index).setBody(body);
        }
    }

    @Override
    public Entry findByTitle(String title) {
        boolean found = false;
        int index = 0;
        for(index = 0; index < entries.size(); index++) {
            if(title.equals(entries.get(index).getTitle())){
                found = true;
                break;
            }
        }
        if(found)return entries.get(index);
        else return null;
    }
}
