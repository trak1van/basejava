package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.HashMap;

public class MapStorage extends AbstactStorage {

    private HashMap<String, Resume> map = new HashMap<>();

    @Override
    protected Resume doGet(Object searchKey) {
        return map.get((String) searchKey);
    }

    @Override
    protected void doUpdate(Resume r, Object searchKey) {
        map.replace((String) searchKey, r);
    }

    @Override
    protected boolean isExist(Object searchKey) {
        return map.containsKey((String) searchKey);
    }

    @Override
    protected String getSearchKey(String uuid) {
        return uuid;
    }

    @Override
    protected void doSave(Resume r, Object searchKey) {
        map.put((String) searchKey, r);
    }

    @Override
    protected void doDelete(Object searchKey) {
        map.remove((String) searchKey);
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
