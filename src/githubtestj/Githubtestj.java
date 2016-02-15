package githubtestj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Stack;


public class Githubtestj {

    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        
        LinkedList<String> actions = new LinkedList<>();
        Stack<String> redostack = new Stack<>();
        String input;
        boolean quit = false;

        while(!quit) {
//            System.out.print("A/U/R/L/C/Q: ");
            System.out.print("I don't know what's happening aaaaaaaaaaaaaaaaaaaaaa: ");
            input = read.readLine();
            switch (input.charAt(0)) {
                case 'A':
                case 'a':
                    System.out.print("Action: ");
                    input = read.readLine();
                    actions.addLast(input);
                    redostack.clear();
                    break;
                case 'U':
                case 'u':
                    if (actions.isEmpty()) System.out.println("Nothing to undo.");
                    else redostack.push(actions.removeLast());
                    break;
                case 'R':
                case 'r':
                    if (redostack.empty()) System.out.println("Nothing to redo.");
                    else actions.addLast(redostack.pop());
                    break;
                case 'L':
                case 'l':
                    if (actions.isEmpty()) System.out.print("Nothing to print.");
                    for (ListIterator<String> iter=actions.listIterator(); iter.hasNext(); ) {
                        if (iter.hasPrevious()) System.out.print(" >> ");
                        System.out.print(iter.next());
                    }
                    System.out.println("");
                    break;
                case 'C':
                case 'c':
                    actions.clear();
                    redostack.clear();
                    break;
                case 'Q':
                case 'q':
                    quit = true;
                    break;
                default:
                    System.out.println("Invalid.");
            }
        }
    }
    
}
