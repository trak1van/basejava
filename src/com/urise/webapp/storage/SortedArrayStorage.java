package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {

    @Override
    public void update(Resume r) {
        int index = getIndex(r.getUuid());
        if (index < 0) {
            System.out.println("Resume: " + r.getUuid() + " not exist");
        }else{
            storage[index] = r;
        }
    }

    @Override
    public void save(Resume r) {
        int index = getIndex(r.getUuid());
        if (index >= 0) {
            System.out.println("Resume:" + r.getUuid() + " already exsits");
        } else {
            if (count >= storage.length) {
                System.out.println("Storage overflow");
            } else {
                storage[-index - 1] = r;
                count++;
            }
        }
    }

    @Override
    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (index < 0) {
            System.out.println("Resume: " + uuid + " not exists");
        } else {
            for (int i = index; i < count - 1; i++) {
                storage[i] = storage[i + 1];
            }
            storage[count - 1] = null;
            count--;
        }
    }

    @Override
    protected int getIndex(String uuid) {
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);
        return Arrays.binarySearch(storage, 0, count, searchKey);
    }
}
