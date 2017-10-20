import java.util.ArrayList;


/**
 * @apiNote solution from "programmers.co.kr" coding test example
 */
public class Solution {
    public boolean solution(int[] arr) {
        boolean answer = true;
        int i=0;

        ArrayList<Integer> numList = new ArrayList<>();
        for (i=0; i<arr.length; i++){
            if(arr.length < arr[i]){
                return false;
            }
            if(numList.indexOf(arr[i]) < 0){
                numList.add(arr[i]);
            }
        }
        if(numList.size() != arr.length){
            return false;
        }
        return answer;
    }

    void main(char[] args){
        solution(new int[]{1,3,4,2});
    }
}
