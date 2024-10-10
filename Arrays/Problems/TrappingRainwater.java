public class TrappingRainwater {

    public static int getWater(int heigth[]){
        int water = 0; //TOTAL WATER.
        int width = 1; //WIDTH OF EACH BAR.
        
        //AUXILIARY ARRAY
        int leftBoundry[] = new int[heigth.length];
        int rigthBoundry[] = new int[heigth.length];

        //STORING LEFT-BOUNDRY.
        leftBoundry[0] = heigth[0];
        for(int i=1;i<leftBoundry.length;i++){
            leftBoundry[i]= Math.max(leftBoundry[i-1], heigth[i]); //COMPARING PREVIOUS-BAR MAX-BOUNDRY AND CURRENT BAR HEIGTH.     
        }

        //STORING RIGTH-BOUNDRY.
        rigthBoundry[rigthBoundry.length-1] = heigth[heigth.length-1];
        for(int i=rigthBoundry.length-2;i>=0;i--){
            rigthBoundry[i] = Math.max(rigthBoundry[i+1], heigth[i]); //COMPARING NEXT-BAR MAX-BOUNDRY AND CURRENT BAR HEIGTH.
        }

        // CALCULATE TRAPPED WATER.
        for(int i=1;i<=heigth.length-2;i++){ // IGNORE 1ST AND LAST BAR.
            int waterLevel = Math.min(leftBoundry[i], rigthBoundry[i]); // WATER LEVEL FOR EACH BAR.
            int water_at_bar = (waterLevel - heigth[i]) * width; //WATER AT SINGLE-BAR. 

            water = water + water_at_bar; 

        }


        return water;
    }
    
    public static void main(String[] args) {
        int array[] = {4,0,3,2,5};

        System.out.println(getWater(array));
    }
}
