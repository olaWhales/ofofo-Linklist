package ofofo.data.repository;

import ofofo.data.model.Diary;

import java.util.ArrayList;
import java.util.List;

public class DiaryRepositoryImpl implements DiaryRepository {
    private List<Diary> diaries = new ArrayList<Diary>();


    @Override
    public long count() {
        return diaries.size();
    }

    @Override
    public void delete(Diary diary) {
        for(int index = 0 ; index < diaries.size() ; index++) {
            if(diary.equals(diaries.get(index))) {
                diaries.remove(diary);
            }
        }
    }

    @Override
    public void deleteAll() {
        diaries.clear();

    }

    @Override
    public void deleteById(String id) {
        for(int index = 0; index < diaries.size(); index++) {
            if(diaries.get(index).getUserName().equals(id)) {
                diaries.remove(diaries.get(index));
            }
        }
    }

    @Override
    public boolean existsById(String id) {
        for (Diary diary : diaries) {
            if(diary.getUserName().equals(id)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Diary findById(String id) {
        for (Diary diary : diaries) {
            if(diary.getUserName().equals(id)) {
                return diary;
            }
        }
        return null;
    }

    @Override
    public void save(Diary diary) {
        if(diary.getUserName()  == null || diary.getPassword() == null) throw new IllegalArgumentException("Diary is null");
        diaries.add(diary);
    }

    @Override
    public List<Diary> findAll() {
    for(Diary diary : diaries){
        return (List<Diary>) diary;
     }
        return diaries;
    }


}