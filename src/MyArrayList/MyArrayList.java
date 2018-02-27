package MyArrayList;

import java.lang.reflect.Array;

public class MyArrayList <T> {
	
	private T myArr[];
	int count = 0;
	int increment = 2;
	Class<T> myClass;

	@SuppressWarnings("unchecked")
	public MyArrayList (Class<T> c){
		this.myArr = (T[]) Array.newInstance(c, 1);
		this.myClass = c;
	}
    public T get(int index) {
        return myArr[index];
    }

    @SuppressWarnings("unchecked")
	public void add(T obj) {
    	if (count >= myArr.length) {
    		System.out.println("Resize, current size: " + count + " for item: " + obj);
    		T myArrTmp[] = (T[]) Array.newInstance(myClass, myArr.length + increment);
    		System.arraycopy(myArr, 0, myArrTmp, 0, myArr.length);
    		myArr = myArrTmp;
    	}
    	myArr[count] = obj;
    	count++;
    }

    public T remove(int index) {
    	T element = myArr[index];
    	System.arraycopy(myArr, index+1, myArr, index, myArr.length - (index + 1));
    	count--;
        return element;
    }

    public int size() {
        return count;
    }


    public static void main(String[] args) {
        MyArrayList<Integer> mal = new MyArrayList<>(Integer.class);
        mal.add(2);
        mal.add(new Integer(5));
        mal.add(new Integer(1));
        mal.add(new Integer(23));
        mal.add(new Integer(14));
//        mal.add("hallo");
        for(int i=0;i<mal.size();i++){
            System.out.println(mal.get(i).getClass()+" " + mal.get(i));
        }
        System.out.println();
        mal.add(new Integer(29));
        System.out.println("Element at Index 5:"+ (mal.get(5) + mal.get(4)) );
        System.out.println("List size: "+mal.size());
        System.out.println("Removing element at index 2: "+mal.remove(2));
        for(int i=0;i<mal.size();i++){
            System.out.print(mal.get(i)+" ");
        }
    }
}
