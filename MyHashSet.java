//Time Complexity: O(1)

class MyHashSet {

    boolean storage[][];
    int buckets;
    int bucketItems;

    //constructor
    public MyHashSet() {

        this.buckets = 1000;
        this.bucketItems = 1000;
        this.storage = new boolean[buckets][];

    }

    //Hash functions

    private int hash1(int key){
        return key%buckets;
    }

    private int hash2(int key){
        return key/bucketItems;
    }

    public void add(int key) {

        int hash1 = hash1(key);
        int hash2 = hash2(key);

        if(storage[hash1] == null){
            if(hash1 == 0){
                storage[hash1] = new boolean[bucketItems+1];
            }else{
                storage[hash1] = new boolean[bucketItems];

            }
        }
        //If not null
        storage[hash1][hash2] = true;  //value already exists

    }

    public void remove(int key) {

        int hash1 = hash1(key);
        int hash2 = hash2(key);
        if(storage[hash1] == null) return;
        storage[hash1][hash2] =  false; // remove
    }

    public boolean contains(int key) {

        int hash1 = hash1(key);
        int hash2 = hash2(key);
        if(storage[hash1] == null) return false;
        return storage[hash1][hash2];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */