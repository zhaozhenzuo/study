package algo;

public class InsertSortNew {

    public static void main(String[] args) {
        InsertSortNew insertSortNew=new InsertSortNew();
        int[] a={3,2,5,1};
        insertSortNew.sortAsc(a,a.length);
        for(int t:a){
            System.out.println(t);
        }
    }

    public void sortAsc(int[] a,int n){
        if (n<=1) {
            return;
        }

        //3,2,5
        for(int i=1;i<n;i++){
            int curValue=a[i];
            int j=i-1;
            for(;j>=0;j--){
                if(curValue>=a[j]){
                    //已经有序
                    break;
                }
                //swap
                a[j+1]=a[j];
            }
            a[j+1]=curValue;
        }

    }

}
