package com.urise.webapp;

import com.urise.webapp.model.Resume;
import com.urise.webapp.storage.MapStorage;

public class MainTestMap {
    public static void main(String[] args) {
        String UUID_1 = "uuid1";
        Resume RESUME_UUID_1 = new Resume(UUID_1);
        String UUID_2 = "uuid2";
        Resume RESUME_UUID_2 = new Resume(UUID_2);
        String UUID_3 = "uuid3";
        Resume RESUME_UUID_3 = new Resume(UUID_3);
        String UUID_4 = "uuid4";
        Resume RESUME_UUID_4 = new Resume(UUID_4);

        MapStorage Map = new MapStorage();
        Map.save(RESUME_UUID_1);
        Map.save(RESUME_UUID_2);
        Map.save(RESUME_UUID_3);
        Map.save(RESUME_UUID_4);
        System.out.println(Map.size());
        /*for (Resume r: Map.getAll()) {
            System.out.println(r);
        }
        //System.out.println(Map.getAll());
        Map.delete(UUID_2);
        System.out.println(Map.size());
        for (Resume r: Map.getAll()) {
            System.out.println(r);
        }*/
    }
}
