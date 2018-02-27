package MyArrayList;

public class MyArrayList1 <T> {
	
	private Object[] myArr = new Object[1];
	int count = 0;
	int increment = 2;

	@SuppressWarnings("unchecked")
	public T get(int index) {
    	if (index >= count)
    		throw new ArrayIndexOutOfBoundsException();
        return (T)myArr[index];
    }

	public void add(T obj) {
    	if (count >= myArr.length) {
    		System.out.println("Resize, current size: " + count + " for item: " + obj);
    		Object myArrTmp[] = new Object[myArr.length + increment];
    		System.arraycopy(myArr, 0, myArrTmp, 0, myArr.length);
    		myArr = myArrTmp;
    	}
    	myArr[count] = obj;
    	count++;
    }

    public T remove(int index) {
		@SuppressWarnings("unchecked")
		T element = (T)myArr[index];
    	System.arraycopy(myArr, index+1, myArr, index, myArr.length - (index + 1));
    	count--;
        return element;
    }

    public int size() {
        return count;
    }


    public static void main(String[] args) {
        MyArrayList1<Integer> mal = new MyArrayList1<>();
        mal.add(2);
        mal.add(new Integer(5));
        mal.add(new Integer(1));
        mal.add(new Integer(23));
        mal.add(new Integer(14));
//        mal.add("hallo");
        System.out.println(mal.get(0));
        for(int i=0;i<mal.size();i++){
            System.out.println(mal.get(i).getClass()+" " + mal.get(i));
        }
        System.out.println();
        mal.add(new Integer(29));
        System.out.println("Element at Index 5:"+ mal.get(5) );
        System.out.println("List size: "+mal.size());
        for(int i=0;i<mal.size();i++){
            System.out.print(mal.get(i)+" ");
        }
        System.out.println("Removing element at index 2: "+mal.remove(2));
        for(int i=0;i<mal.size();i++){
            System.out.print(mal.get(i)+" ");
        }
        System.out.println();
//        System.out.println("Can I index after last element nr " + mal.size() + ": "+ mal.get(mal.size()));
    }
}
