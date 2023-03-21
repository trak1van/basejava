package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.model.Resume;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public abstract class AbstractStorageTest {

    private Storage storage;
    private static final String UUID_1 = "uuid1";
    private static final Resume RESUME_UUID_1 = new Resume(UUID_1);
    private static final String UUID_2 = "uuid2";
    private static final Resume RESUME_UUID_2 = new Resume(UUID_2);
    private static final String UUID_3 = "uuid3";
    private static final Resume RESUME_UUID_3 = new Resume(UUID_3);
    private static final String UUID_4 = "uuid4";
    private static final Resume RESUME_UUID_4 = new Resume(UUID_4);

    public AbstractStorageTest(Storage storage) {
        this.storage = storage;
    }

    @Before
    public void setUp() throws Exception {
        storage.clear();
        storage.save(RESUME_UUID_1);
        storage.save(RESUME_UUID_2);
        storage.save(RESUME_UUID_3);
    }

    public void assertSize(int size) {
        assertEquals(size, storage.size());
    }

    public void assertResume(Resume r){
        assertEquals(r, storage.get(r.getUuid()));
    }

    @Test
    public void size() {
        assertSize(3);
    }

    @Test
    public void get() {
        assertResume(RESUME_UUID_1);
        assertResume(RESUME_UUID_2);
        assertResume(RESUME_UUID_3);
    }

    @Test
    public void clear() {
        storage.clear();
        assertSize(0);
    }

    @Test
    public void getAll() {
        Resume[] allResume = storage.getAll();
        assertEquals(3, allResume.length);
        assertResume(RESUME_UUID_1);
        assertResume(RESUME_UUID_2);
        assertResume(RESUME_UUID_3);
    }

    @Test
    public void update() {
        Resume newResume = new Resume(UUID_2);
        storage.update(newResume);
        Assert.assertTrue(newResume==storage.get(UUID_2));
    }

    @Test
    public void save() {
        storage.save(RESUME_UUID_4);
        assertSize(4);
        assertResume(RESUME_UUID_4);
    }

    @Test(expected = ExistStorageException.class)
    public void saveExist() {
        storage.save(RESUME_UUID_3);
    }

   /* @Test(expected = StorageException.class)
    public void saveOverFlow(){
        try {
            for (int i = 4; i <= AbstractArrayStorage.STORAGE_LIMIT; i++) {
                storage.save(new Resume());
            }
        }catch (StorageException e){
            Assert.fail();
        }
        storage.save(new Resume());
    }*/

    @Test(expected = NotExistStorageException.class)
    public void delete() {
        storage.delete(UUID_2);
        assertSize(2);
        storage.get(UUID_2);
    }

    @Test(expected = NotExistStorageException.class)
    public void deleteNotExist() throws Exception {
        storage.delete("dummy");
    }


    @Test(expected = NotExistStorageException.class)
    public void getNotExist() throws Exception {
        storage.get("dummy");
    }

    @Test(expected = NotExistStorageException.class)
    public void updateNotExist() throws Exception {
        storage.get("dummy");
    }
}