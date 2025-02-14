//Approach explained below code
class Solution {
    public String removeOccurrences(String s, String part) {
        StringBuilder sb = new StringBuilder(s);
        int i=0, j=part.length();
        while(j<=sb.length()){
            if(part.equals(sb.substring(i,j))){
                sb.delete(i,j);
                i=0;
                j=part.length();
                continue;
            }
            i++;
            j++;
        }
        return sb.toString();
    }
}

/*
Step-wise Approach:
1. Initialize a StringBuilder with the given string s.
    This allows efficient modification (deletion) instead of using immutable String.

2. Use a sliding window approach with two pointers:
    i (start index of the substring being checked).
    j (end index of the substring, j = i + part.length()).

3. Iterate while j <= sb.length() (ensuring a valid substring can be extracted):
    Extract the substring sb.substring(i, j).
    If this substring matches part, remove it using sb.delete(i, j).
    Reset i and j to 0 and part.length() to restart the search from the beginning.

4. If no match is found, slide the window forward (i++, j++).

5. Return the modified StringBuilder as a string after all occurrences are removed.
 */