import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class exercise {

    public static void main(String[] args) {
        //firstNonRepeatingChar("swiss");// → 'w'
        //firstNonRepeatingChar("success");// → 'u'
        //firstNonRepeatingChar("aabbcc");// → null

        longestUniqueSubstring("abcabcbb");  // Output: 3  (substring: "abc")
        longestUniqueSubstring("bbbbb");     // Output: 1  (substring: "b")
        longestUniqueSubstring("pwwkew");    // Output: 3  (substring: "wke")
        longestUniqueSubstring("");          // Output: 0  (empty string)
        longestUniqueSubstring("abcddefgh"); // Output: 6  (substring: "cdefgh")


    }


    public static void firstNonRepeatingChar(String s) {
        StringBuilder temp = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (temp.toString().contains(String.valueOf(s.charAt(i)))) {
               temp = new StringBuilder(temp.toString().replace(String.valueOf(s.charAt(i)), ""));
            } else {
                temp.append(String.valueOf(s.charAt(i)));
            }
        }//for
        try {
            System.out.println(temp.charAt(0));
        } catch (Exception e) {
            System.out.println("No unique characters found");
        }
    }


    public static void longestUniqueSubstring(String string){
        Arrays.sort(string.toCharArray());

        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < string.length(); i++) {
            if (!map.containsKey(string.charAt(i))) {
                map.put(string.charAt(i), 1);
            }
        }

        StringBuilder stringToPrint = new StringBuilder();
        for (Map.Entry entry : map.entrySet()) {
            stringToPrint.append(entry.getKey());
        }
        System.out.println(stringToPrint);

        //int left = 0, right = string.length() - 1;
        //while (left < right) {
            //if (!map.containsKey(string.charAt(left)) && !map.containsKey(string.charAt(right))) {
            //}
        //}//while

    }//longestUniqueSubstring



    public class PairSumTwoPointers {
        public static void main(String[] args) {
            int[] nums = {12, 1, 9, 4, 3, 8};
            int k = 12;
            findPairs(nums, k);
        }

        public static void findPairs(int[] nums, int k) {
            Arrays.sort(nums); // Sorting takes O(n log n)
            int left = 0, right = nums.length - 1;

            while (left < right) {
                int sum = nums[left] + nums[right];
                if (sum == k) {
                    System.out.println("(" + nums[left] + ", " + nums[right] + ")");
                    left++; right--;  // Move both pointers
                } else if (sum < k) {
                    left++;  // Need a bigger number
                } else {
                    right--;  // Need a smaller number
                }
            }
        }
    }














}//class
