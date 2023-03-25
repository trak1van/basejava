package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MapResumeStorage extends AbstactStorage {

    private HashMap<String, Resume> map = new HashMap<>();

    @Override
    protected List<Resume> doCopyAll() {
        return new ArrayList<>(map.values());
    }

    @Override
    protected Resume doGet(Object resume){
        return (Resume) resume;
    }

    @Override
    protected void doUpdate(Resume r, Object resume){
        map.put(r.getUuid(), r);
    }

    @Override
    protected boolean isExist(Object resume) {
        return resume!=null;
    }

    @Override
    protected Resume getSearchKey(String uuid) {
        return map.get(uuid);
    }

    @Override
    protected void doSave(Resume r, Object resume) {
        map.put(r.getUuid(), r);
    }

    @Override
    protected void doDelete(Object resume) {
        map.remove(((Resume) resume).getUuid());
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public Resume[] getAll() {
        return map.values().toArray(new Resume[map.size()]);
    }

    @Override
    public int size() {
        return map.size();
    }
}
