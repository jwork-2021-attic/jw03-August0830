package example;

public class HeapSorter implements Sorter {
    private int[] a;

    @Override
    public void load(int[] a) {
        this.a = a;
    }

    private void swap(int i, int j) {
        int temp;
        temp = a[i];
        a[i] = a[j];
        a[j] = temp;
        plan += "" + a[i] + "<->" + a[j] + "\n";
    }

    private String plan = "";
    void adjustDown(int pos,int len){
        for(int largest = 2*pos+1;largest<len;largest=2*largest+1){
            if(largest!=len-1 && a[largest+1]>a[largest])
                largest++;
            if(a[(largest-1)/2]<a[largest]){
                swap((largest-1)/2,largest);
            }
            else
                break;
        }
    }
    @Override
    public void sort() {
        for(int i=a.length/2-1;i>=0;--i){
            adjustDown(i, a.length);
        }//build heap
        for(int i=a.length-1;i>0;--i){
            swap(0,i);
            adjustDown(0, i);
        }
        //swap(0,1);
    }

    @Override
    public String getPlan() {
        return this.plan;
    }
}