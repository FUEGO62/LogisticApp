package africa.semicolon.Diary.services;

import africa.semicolon.Diary.data.models.Diary;
import africa.semicolon.Diary.data.repositories.DiaryRepository;
import africa.semicolon.Diary.data.repositories.DiaryRepositoryImpl;

public class DiaryServiceImpl implements DiaryService {

    DiaryRepository diaryRepository = new DiaryRepositoryImpl();
    EntryService entryService = new EntryServiceImpl();

    @Override
    public void register(String username, String password) {

        Diary diaries = findDiaryByUsername(username);
        if (diaries != null) {
            throw new IllegalArgumentException("Username " + username + " is already in use");
        }
        if(username.equals("") || password.equals("")) {
            throw new IllegalArgumentException("Username and password cannot be empty");
        }
        if(!username.matches("[a-z]+")){
            throw new IllegalArgumentException("Username must contain at least one letter");
        }
        if(!password.matches("[a-z]+")){
            throw new IllegalArgumentException("Password must contain at least one letter");
        }
        Diary diary = new Diary();
        diary.setPassword(password);
        diary.setUserName(username);
        diaryRepository.save(diary);

    }

    @Override
    public long getNumberOfDiaries() {
        return diaryRepository.count();
    }

    @Override
    public Diary findDiaryByUsername(String username) {
        if(username.equals("")) {
            throw new IllegalArgumentException("Username cannot be empty");
        }
        if(diaryRepository.findByUsername(username) == null) {
            throw new IllegalArgumentException("Username " + username + " does not exist");
        }
        return diaryRepository.findByUsername(username);
    }



    @Override
    public void deleteDiaryByUsername(String username) {

        diaryRepository.delete(username);
    }

    @Override
    public void createEntry(String title, String body) {
        entryService.createEntry(title, body);
    }

    @Override
    public void updateEntry(String title, String body) {
        entryService.updateEntry(title, body);
    }

    @Override
    public void deleteEntry(String title) {
        entryService.deleteEntry(title);
    }

    @Override
    public String readEntry(String title) {
        return entryService.readEntry(title);
    }
}
