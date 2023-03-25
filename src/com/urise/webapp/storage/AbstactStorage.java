package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.model.Resume;

import java.util.Collections;
import java.util.List;

public abstract class AbstactStorage implements Storage {
    public void update(Resume r) {
        Object searchKey = getExistStorageException(r.getUuid());
        doUpdate(r, searchKey);
    }

    public void save(Resume r) {
        Object searchKey = getNoExistStorageException(r.getUuid());
        doSave(r, searchKey);
    }

    public void delete(String uuid) {
        Object searchKey = getExistStorageException(uuid);
        doDelete(searchKey);
    }

    private Object getExistStorageException(String uuid) {
        Object searchKey = getSearchKey(uuid);
        if (!isExist(searchKey)) {
            throw new NotExistStorageException(uuid);
        }
        return searchKey;
    }

    private Object getNoExistStorageException(String uuid) {
        Object searchKey = getSearchKey(uuid);
        if (isExist(searchKey)) {
            throw new ExistStorageException(uuid);
        }
        return searchKey;
    }

    public Resume get(String uuid) {
        Object searchKey = getExistStorageException(uuid);
        return doGet(searchKey);
    }

    public List<Resume> getAllSorted(){
        List<Resume> list = doCopyAll();
        Collections.sort(list);
        return list;
    }

    protected abstract List<Resume> doCopyAll();
    protected abstract Resume doGet(Object searchKey);

    protected abstract void doUpdate(Resume r, Object searchKey);

    protected abstract boolean isExist(Object searchKey);

    protected abstract Object getSearchKey(String uuid);

    protected abstract void doSave(Resume r, Object searchKey);

    protected abstract void doDelete(Object searchKey);

}
