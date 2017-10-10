package test;

import java.util.ArrayList;

public class Snapshot {
    private ArrayList<Integer> data;
    
    public Snapshot(ArrayList<Integer> data)
    {
        this.data = data;
    }
    
    public ArrayList<Integer> restore()
    {
        ArrayList<Integer> l = new ArrayList<Integer>();
        l.add(1);
        l.add(2);
        return l;
    }
    
    public static void main(String[] args)
    {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        Snapshot snap = new Snapshot(list);
        list.set(0, 3);
        list = snap.restore();
        System.out.println(list); // Should output [1, 2]
        list.add(4);
        list = snap.restore();
        System.out.println(list); // Should output [1, 2]
    }
}