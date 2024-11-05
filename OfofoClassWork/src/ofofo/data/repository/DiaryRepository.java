package ofofo.data.repository;

import ofofo.data.model.Diary;

import java.util.List;

public interface DiaryRepository {
    long count();
    void delete(Diary diary);
    void deleteAll();
    void deleteById(String id);
    boolean existsById(String id);
    Diary findById(String id);
    void save(Diary diary);
    List<Diary> findAll();

}
