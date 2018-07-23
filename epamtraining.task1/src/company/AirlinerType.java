package company;

import java.util.Comparator;

/**
 * Created by piatr on 19.07.18.
 */
public enum AirlinerType implements Comparator<AirlinerType> {
    RegionalLiner(1500), NarrowBodyLiner(3500), WideBodyLiner(15000), Indefinite(Integer.MAX_VALUE);
   private int maxRange;
   AirlinerType(int maxRange){
       this.maxRange = maxRange;
   }
   public int getMaxRange(){
       return maxRange;
   }

   @Override
   public int compare(AirlinerType a1, AirlinerType a2){
       return a1.getMaxRange() - a2.getMaxRange();
   }
}
