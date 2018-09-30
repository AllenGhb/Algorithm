package chap02_GettingStarted;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Test {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        List<Stack<Character>> contentStackList = new ArrayList<Stack<Character>>(n);
        if(0 < n && n <= 100){
            while(n > 0){
                Scanner scanStr = new Scanner(System.in);
                String str = scanStr.next();
                Stack<Character> contentStack = new Stack<Character>();
                for(int i=0 ; i < str.length();i++){
                    contentStack.push(str.charAt(i));
                }
                contentStackList.add(contentStack);
                n--;
            }
            for(Stack<Character> charStack : contentStackList){
                Stack<Character> compareStack = new Stack<Character>();
                while(!charStack.empty()){
                    if(compareStack.empty()){
                        compareStack.push(charStack.pop());
                    }else{
                        Character character = compareStack.pop();
                        if(character.equals(charStack.pop())){
                            continue;
                        }else{
                            charStack.push(character);
                        }
                    }

                }
                System.out.println(compareStack.empty() ? "YES" : "NO");
            }
        }
    }

}
