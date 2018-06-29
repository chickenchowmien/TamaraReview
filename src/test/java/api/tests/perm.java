package api.tests;

import java.util.Arrays;
import java.util.List;
class Cards {

    public enum Number{
        TWO,THREE,FOUR,FIVE,SIX,SEVEN,EIGHT,NINE, TEN, JACK, QUEEN, KING, ACE
    }
    public enum SUIT{
        CLUB, DIAMOND,HEART, SPADE
    }
      class Num{
        List<Number> list;


         public List<Number> getList() {
             return list;
         }

         public void setList(List<Number> list) {
             this.list = list;
         }

         public Num() {
             list=Arrays.asList(Number.values());
         }
     }
      class ST {
        List<SUIT> list;

         public List<SUIT> getList() {
             return list;
         }

         public void setList(List<SUIT> list) {
             this.list = list;
         }

         public ST(){
            list=Arrays.asList(SUIT.values());
         }
     }


     public Num getNum(){
        return new Num();
    }
    public ST getSuit(){
        return new ST();
    }

}
public class perm{
    public static void main(String[] args) {
        Cards card = new Cards();
        Cards.Num n = card.getNum();
        Cards.ST s = card.getSuit();

        for (int outer =0;outer<n.list.size();outer++){
            for (int inner =0;inner<s.list.size();inner++){
                System.out.println(n.list.get(outer));
                System.out.println(s.list.get(inner));

            }
        }
    }
}
