package africa.semicolon.Diary.services;

public interface EntryService {
    void createEntry(String title, String body);
    void updateEntry(String title, String body);
    void deleteEntry(String title);
    String readEntry(String title);
}
