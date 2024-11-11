package Strings.MediumQuestions;

import java.util.*;

/*
Given an array of strings strs, group the anagrams together. You can return the answer in any order.

Example 1:
Input: strs = ["eat","tea","tan","ate","nat","bat"]
Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

Explanation:
    There is no string in strs that can be rearranged to form "bat".
    The strings "nat" and "tan" are anagrams as they can be rearranged to form each other.
    The strings "ate", "eat", and "tea" are anagrams as they can be rearranged to form each other.

Example 2:
Input: strs = [""]
Output: [[""]]

Example 3:
Input: strs = ["a"]
Output: [["a"]]
*/

public class Q49GroupAnagrams {
    
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();

        for (String word : strs) 
        {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            // Use sorted strings as keys to group anagrams efficiently.
            String sortedWord = new String(chars);

            if (!map.containsKey(sortedWord)) {
                map.put(sortedWord, new ArrayList<>());
            }
            // if any new word after sorting matches the already sorted word in map, it's anagram
            map.get(sortedWord).add(word);
        }
        // return all map values
        return new ArrayList<>(map.values());
    }
}