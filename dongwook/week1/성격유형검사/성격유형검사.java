package week1;

import java.util.*;

class 성격유형검사 {
    public String solution(String[] survey, int[] choices) {
        char[] type = {'R','T','C','F','J','M','A','N'};
        HashMap<Character,Integer> index = new HashMap<>();
        int score[] = new int[8];

        for(int i=0; i<8; i++)
            index.put(type[i],i);

        for(int i=0; i<survey.length; i++){
            char[] arr=survey[i].toCharArray();

            switch (choices[i]){
                case 1 : score[index.get(arr[0])]+=3;
                    break;
                case 2 : score[index.get(arr[0])]+=2;
                    break;
                case 3 : score[index.get(arr[0])]+=1;
                    break;
                case 4 : break;
                case 5 : score[index.get(arr[1])]+=1;
                    break;
                case 6 : score[index.get(arr[1])]+=2;
                    break;
                case 7 : score[index.get(arr[1])]+=3;
                    break;
                default : break;
            }
        }
        String answer = "";
        for(int i=0; i<8; i+=2){
            if(score[i]>score[i+1])
                answer+=type[i];
            else if(score[i]==score[i+1]){
                if(type[i]<type[i+1])
                    answer+=type[i];
                else
                    answer+=type[i+1];
            }
            else
                answer+=type[i+1];
        }
        return answer;
    }
}