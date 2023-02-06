package bushuev;

public class HashFunctions {

    public long stringHash(String str){
        int pow = 1;
        long hashRes = 0;

        for (int i = 0;i<str.length();i++){
            hashRes += (long) (str.charAt(i) + 1 - 'a') *pow;
            pow*=31;
        }
        return hashRes;
    }

    public long intHash(int value){
        return ((value*1000000007)>>20);
    }
}
