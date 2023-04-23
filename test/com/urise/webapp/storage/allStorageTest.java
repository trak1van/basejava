package com.urise.webapp.storage;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({ArrayStorageTest.class, ListStorageTest.class, MapStorageTest.class, SortedArrayStorageTest.class,
MapStorageResumeTest.class,  ObjectPathStorageTest.class,
        ObjectFileStorageTest.class} )
public class allStorageTest {

}
