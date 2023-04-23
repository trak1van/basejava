package com.urise.webapp.storage;

import com.urise.webapp.exception.StorageException;
import com.urise.webapp.model.Resume;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;

public abstract class AbstractArrayStorageTest extends AbstractStorageTest{
    public AbstractArrayStorageTest(Storage storage) {
        super(storage);
    }

    protected static final File STORAGE_DIR = new File("E:\\repository\\basejava\\basejava\\src\\com\\urise\\webapp\\resultfiles");

    @Test(expected = StorageException.class)
    public void saveOverFlow(){
        try {
            for (int i = 4; i <= AbstractArrayStorage.STORAGE_LIMIT; i++) {
                storage.save(new Resume("Name"+i));
            }
        }catch (StorageException e){
            Assert.fail();
        }
        storage.save(new Resume("Overflow"));
    }
}
