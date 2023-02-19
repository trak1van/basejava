package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage extends AbstractArrayStorage {
    public void save(Resume r) {
        int index = getIndex(r.getUuid());
        if (index != -1) {
            System.out.println("Resume: " + r.getUuid() + " already exist");
        } else if (count >= storage.length) {
            System.out.println("Storage overflow");
        } else {
            storage[count] = r;
            count++;
        }
    }

    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (index == -1) {
            System.out.println("Resume: " + uuid + " not exist");
        } else {
            storage[index] = storage[count - 1];
            storage[count - 1] = null;
            count--;
        }
    }

    protected int getIndex(String uuid) {
        for (int i = 0; i < count; i++) {
            if (uuid.equals(storage[i].getUuid())) {
                return i;
            }
        }
        return -1;
    }

    public void update(Resume resume) {
        int index = getIndex(resume.getUuid());
        if (index == -1) {
            System.out.println("Resume: " + resume.getUuid() + " not exist");
        } else {
            storage[index] = resume;
        }
    }
}
