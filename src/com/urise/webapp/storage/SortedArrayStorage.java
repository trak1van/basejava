package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;
import java.util.Comparator;

public class SortedArrayStorage extends AbstractArrayStorage {

    /*
    private static class ResumeComparator implements Comparator<Resume> {
        @Override
        public int compare(Resume o1, Resume o2) {
            return o1.getUuid().compareTo(o2.getUuid());
        }
    }
*/

    private static final Comparator<Resume> RESUME_COMPARATOR = new Comparator<Resume>() {
        @Override
        public int compare(Resume o1, Resume o2) {
            return o1.getUuid().compareTo(o2.getUuid());
        }
    };
//    @Override
//    protected int getIndex(String uuid) {
//        Resume searchKey = new Resume();
//        searchKey.setUuid(uuid);
//        return Arrays.binarySearch(storage, 0, count, searchKey);
//    }

    @Override
    protected void fillDeteleElement(int index) {
        int numMoved = count - index - 1;
        if(numMoved>0){
            System.arraycopy(storage, index + 1, storage, index, numMoved);
        }
    }

    @Override
    protected void insertElement(int index, Resume r) {
        int insertIdx = -index - 1;
        System.arraycopy(storage, insertIdx, storage, insertIdx + 1, count - insertIdx);
        storage[insertIdx] = r;
    }

    @Override
    protected Integer getSearchKey(String uuid) {
        Resume searchKey = new Resume(uuid);
        return Arrays.binarySearch(storage, 0, count, searchKey, RESUME_COMPARATOR);
    }
}
