// Time complexity : O(n) String traversal
// Space complexity : O(n) Hashmap

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        
        // key : Character, Integer : Count of that character
        // Hashmap w.rt. p string
        HashMap<Character, Integer> map = new HashMap<>();
        
        // output
        List<Integer>  result = new ArrayList<>();
        
        // Iterate through p
        for (int i = 0; i < p.length(); i++) {
            
            // current char
            char c =  p.charAt(i);
            
            if (map.containsKey(c)){
                // more than one occurrence
                map.put(c, map.get(c) + 1);
            }
            else {
                // first time
                map.put(c, 1);  
            }

        }
        
        
        int match = 0;
        
        // sliding window is moved towards the right based on the new character
        
        for (int i = 0; i< s.length(); i++){
            
            // get the s character
            char c = s.charAt(i);
            
            // incoming 
            if (map.containsKey(c)){
                // Decrease the count if the c is present in the hash
                int count = map.get(c);
                count--;
                map.put(c, count);
                
                // equal characters in window of s and p
                if (count == 0){
                    match++;
                }
                
            }
            
            // outgoing
            // window length is the p-length
            if (i - p.length() >= 0){
                
                char ch = s.charAt(i - p.length()); // first character of the window
            
                if (map.containsKey(ch)){
                    // add the count back as it is present in hashmap and not in window
                    int count = map.get(ch);
                    count++;
                    map.put(ch, count);
                    
                    if ( count == 1){
                        match--;
                    }
                }
                
            }
        
            
            // if match count is same as p
            if (match == map.size()){
                
                result.add(i - p.length() + 1);
            }
            
        }
        
         return result;
    }
}