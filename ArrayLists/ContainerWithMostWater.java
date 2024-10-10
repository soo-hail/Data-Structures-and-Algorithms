import java.util.ArrayList;
public class ContainerWithMostWater{
    public static int bruteForce(ArrayList<Integer> height){
        int water = 0;
        for(int start=0;start<height.size()-1;start++){
            for(int end=start+1;end<height.size();end++){
                int width = end-start;
                int waterLevel = Math.min(height.get(start), height.get(end));
                int currWater =  width*waterLevel;
                water = Math.max(water, currWater);
            }
        }//end forLoop.
        return water;
    }
//---------------------------------------------------------------------------------------------------------------------------------

//Two Pointer aproch.
public static int twoPointer(ArrayList<Integer> list){
    int water = 0;
    //edges of container.
    int start = 0; 
    int end = list.size() -1 ;
    while(start<end){
        int waterLevel = Math.min(list.get(start),list.get(end));
        int width = end-start;
        int currWater = waterLevel * width;
        water = Math.max(water,currWater);
        if(list.get(start)<list.get(end)){
            start++;
        }else{ //start>end
            end--;
        }
    }//end whileLoop.
    return water;
}

//-------------------------------------------------------------------------------------------------------------------
    public static void main(String[] args) {
        ArrayList<Integer> height = new ArrayList<>();
        height.add(1);height.add(8);height.add(6);height.add(2);height.add(5);
        height.add(4);height.add(8);height.add(3);height.add(7);
       
        System.out.println(twoPointer(height));
    }
}