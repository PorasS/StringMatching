import java.util.Arrays;
import java.util.Scanner;
public class KMP {
    String st;
    String text;
    int arr[];
    public static void main(String args[]){
        Scanner s=new Scanner(System.in);
        System.out.println("Enter the text");
        String t=s.nextLine();
        System.out.println("Enter the pattern");
        String  st1=s.nextLine();
         int arr1[]=new int[st1.length()];
        KMP km=new KMP();
        km.prefixArray(st1,arr1);
        km.stringMatch(t);

    }
    public void stringMatch(String tex){
       text=tex;
       int i=0;
       int j=0;
       while(i!=text.length()){
           if(text.charAt(i)==st.charAt(j)){
               j++;
               i++;
               if(j==st.length()){
                   break;
               }
           }else{
               if(j!=0){
                   j=arr[j-1];
               }else{
                   i++;
               }
           }
       }
       if(j==0){
           System.out.println("pattern: "+st+"  is not present in");
           System.out.println(text);
       }else{
           System.out.println("pattern: "+st+" is present in");
           System.out.println(text);
       }
        System.out.println(j+" "+i);
    }
    public void prefixArray( String str,int array[]){
        st=str;
        arr=array;
        int j=0;
        int i=1;
        while(i!=st.length()){
            if(st.charAt(j)!=st.charAt(i)){
                if(j==0){
                    arr[i]=0;
                    i++;
                }else{
                    j=arr[j-1];
                }
            }else{
                arr[i]=j+1;
                j++;
                i++;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

}
