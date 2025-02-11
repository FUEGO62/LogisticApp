package africa.semicolon.Diary.services;

import africa.semicolon.Diary.data.models.Diary;
import africa.semicolon.Diary.data.models.Entry;
import africa.semicolon.Diary.data.repositories.EntryRepository;
import africa.semicolon.Diary.data.repositories.EntryRepositoryImpl;

public class EntryServiceImpl implements EntryService {

    EntryRepository entryRepository = new EntryRepositoryImpl();

    @Override
    public void createEntry(String title, String body) {
        Entry entries = entryRepository.findByTitle(title);
        if (entries != null) {
            throw new IllegalArgumentException("Title " + title + " is already in use");
        }
        Entry entry = new Entry();
        entry.setTitle(title);
        entry.setBody(body);
        entryRepository.save(entry);
    }

    @Override
    public void updateEntry(String title, String body) {

        entryRepository.update(title, body);
    }

    @Override
    public void deleteEntry(String title) {
        entryRepository.delete(title);
    }

    @Override
    public String readEntry(String title) {

        Entry entry = entryRepository.findByTitle(title);
        return entry != null ? String.format(entry.getTitle() + "/n/n" + entry.getBody()) : null;
    }
}
