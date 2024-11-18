package africa.semicolon.Diary.data.repositories;

import africa.semicolon.Diary.data.models.Entry;

public interface EntryRepository {
    void save(Entry entry);
    void delete(String title);
    void update(String title, String body);
    Entry findByTitle(String title);
}
