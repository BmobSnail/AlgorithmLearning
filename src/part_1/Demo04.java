package part_1;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 栈和队列
 * 猫狗队列
 *
 * 题目:实现一种猫狗队列,可以add,pollAll,pollDog,pollCat,isEmpty,isDogEmpty,isCatEmpty
 *
 * 解题思路:注意cat,dog,总队列更新问题
 * */

public class Demo04 {

    public static class Pet{
        private String type;

        public Pet(String type) {
            this.type = type;
        }

        public String getPetType(){
            return this.type;
        }
    }

    public static class Dog extends Pet{
        public Dog() {
            super("dog");
        }
    }

    public static class Cat extends Pet{
        public Cat(){
            super("cat");
        }
    }

    /**先定义一个新类能记录入队时间*/
    public static class PetEnterQueue{
        private Pet pet;
        private long count;

        public PetEnterQueue(Pet pet, long count) {
            this.pet = pet;
            this.count = count;
        }

        public Pet getPet() {
            return this.pet;
        }

        public long getCount() {
            return this.count;
        }

        public String getEnterPetType() {
            return this.pet.getPetType();
        }
    }

    private Queue<PetEnterQueue> dogQueue;
    private Queue<PetEnterQueue> catQueue;
    private long count;

    public Demo04() {
        this.dogQueue = new LinkedList<>();
        this.catQueue = new LinkedList<>();
        this.count = 0;
    }

    public void add(Pet pet) {
        if (pet.getPetType().equals("dog")) {
            this.dogQueue.add(new PetEnterQueue(pet,this.count++));
        } else if (pet.getPetType().equals("cat")) {
            this.catQueue.add(new PetEnterQueue(pet, this.count++));
        } else {
            throw new RuntimeException("err,not dog or cat");
        }
    }

    public Pet pollAll() {
        if (!this.dogQueue.isEmpty() && !this.catQueue.isEmpty()) {
            if (this.dogQueue.peek().getCount() < this.catQueue.peek().getCount()) {
                return this.dogQueue.poll().getPet();
            } else {
                return this.catQueue.poll().getPet();
            }
        } else if (!this.dogQueue.isEmpty()) {
            return this.dogQueue.poll().getPet();
        } else if (!this.catQueue.isEmpty()) {
            return this.catQueue.poll().getPet();
        }else
            throw new RuntimeException("err,queue is empty");
    }

    public Dog pollDog() {
        if (!isDogEmpty()) {
            return (Dog) this.dogQueue.poll().getPet();
        } else {
            throw new RuntimeException("err,dog queue is empty");
        }
    }

    public Cat pollCat() {
        if (!isCatEmpty()) {
            return (Cat) this.catQueue.poll().getPet();
        } else {
            throw new RuntimeException("err,cat queue is empty");
        }
    }

    public boolean isEmpty() {
        return this.dogQueue.isEmpty() && this.catQueue.isEmpty();
    }

    public boolean isDogEmpty() {
        return this.dogQueue.isEmpty();
    }

    public boolean isCatEmpty() {
        return this.catQueue.isEmpty();
    }
}


