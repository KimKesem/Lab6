package org.client.ClientStuff;

import org.client.BasicPerson.Person;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class RandomNum {
    public int createRandomNum(MapWrapper<Integer, Person> hashMap) {
        List<Integer> a = new ArrayList<>();
        for (Integer key : hashMap.keySet()) {
            a.add(hashMap.get(key).weDoGetID());
        }

        int randomNum = ThreadLocalRandom.current().nextInt(Collections.max(a), Collections.max(a)+100);
        return randomNum;
    }
}