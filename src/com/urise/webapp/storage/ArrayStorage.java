package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private Resume[] storage = new Resume[10000];

    private int count = 0;

    public void clear() {
       /*for (int i = 0; i < count; i++) {
            storage[i] = null;
        }
        count = 0;*/
        Arrays.fill(storage, null);
        count = 0;
    }

    public void save(Resume r) {
        int i = getIndex(r.getUuid());
        if(i!=-1){
            System.out.println("Данный uuid: "+ r.getUuid()+ " уже существует.");
        } else if (count == storage.length) {
            System.out.println("Переполнение массива ArraySorage");
        }else {
            storage[count] = r;
            count++;
        }
    }

    public Resume get(String uuid) {
        int i = getIndex(uuid);
        if (i == -1) {
            System.out.println("Элемент с uuid: " + uuid + " не найден");
            return null;
        } else {
            return storage[i];
        }
    }

    public void delete(String uuid) {
        int i = getIndex(uuid);
        if (i == -1) {
            System.out.println("Элемент с uuid: " + uuid + " не найден");
        } else {
            storage[i] = storage[count - 1];
            storage[count - 1] = null;
            count--;
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        Resume[] allResume = Arrays.copyOf(storage, count);
        return allResume;
    }

    public int size() {
        return count;
    }

    private int getIndex(String uuid) {
        for (int i = 0; i < count; i++) {
            if (storage[i].getUuid() == uuid) {
                return i;
            }
        }
        return -1;
    }

    public void update(Resume resume) {
        int i = getIndex(resume.getUuid());
        if (i == -1) {
            System.out.println("Элемент с uuid: " + resume.getUuid() + " не найден");
        } else {
            storage[i] = resume;
        }
    }
}
