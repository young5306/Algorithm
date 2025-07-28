import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        HashSet<String> hashSet = new HashSet<>(Arrays.asList(phone_book));

        for (String num : phone_book) {
            for (int i = 0; i < num.length(); i++) {
                if (hashSet.contains(num.substring(0, i))) {
                    return false;
                }
            }
        }

        return true;
        
    }
}