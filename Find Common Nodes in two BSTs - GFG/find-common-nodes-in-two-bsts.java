//{ Driver Code Starts
//Initial Template for Java

import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;
import java.util.*;
import java.math.*;

class Node{
    int data;
    Node left, right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

// } Driver Code Ends
//User function Template for Java



// User function Template for Java



class Solution {
    // Function to find the nodes that are common in both BST.
    public static ArrayList<Integer> findCommon(Node root1, Node root2) {
        ArrayList<Integer> result = new ArrayList<>();
        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();

        // Initialize the stacks with the leftmost nodes.
        pushLeftNodes(stack1, root1);
        pushLeftNodes(stack2, root2);

        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            Node node1 = stack1.peek();
            Node node2 = stack2.peek();

            if (node1.data == node2.data) {
                result.add(node1.data);
                stack1.pop();
                stack2.pop();

                // Move to the right subtree.
                pushLeftNodes(stack1, node1.right);
                pushLeftNodes(stack2, node2.right);
            } else if (node1.data < node2.data) {
                stack1.pop();
                // Move to the right subtree.
                pushLeftNodes(stack1, node1.right);
            } else {
                stack2.pop();
                // Move to the right subtree.
                pushLeftNodes(stack2, node2.right);
            }
        }

        return result;
    }

    private static void pushLeftNodes(Stack<Node> stack, Node node) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }
}


//{ Driver Code Starts.
class GFG
{
    static Node buildTree(String str)
    {
        // Corner Case
        if(str.length() == 0 || str.equals('N'))
            return null;
        String[] s = str.split(" ");
        
        Node root = new Node(Integer.parseInt(s[0]));
        Queue <Node> q = new LinkedList<Node>();
        q.add(root);
        
        // Starting from the second element
        int i = 1;
        while(!q.isEmpty() && i < s.length)
        {
              // Get and remove the front of the queue
              Node currNode = q.remove();
        
              // Get the current node's value from the string
              String currVal = s[i];
        
              // If the left child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the left child for the current node
                  currNode.left = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.left);
              }
        
              // For the right child
              i++;
              if(i >= s.length)
                  break;
              currVal = s[i];
        
              // If the right child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the right child for the current node
                  currNode.right = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.right);
              }
              
              i++;
        }
    
        return root;
    }
    
    public static void main(String args[]) throws IOException {
    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int t = Integer.parseInt(br.readLine().trim());
        while(t>0)
        {
            String s = br.readLine();
            Node root1 = buildTree(s);
            
            s = br.readLine();
            Node root2 = buildTree(s);
            
            Solution g = new Solution();
            ArrayList<Integer> res = new ArrayList<Integer>();
            res = g.findCommon(root1,root2);
            for(int i = 0;i<res.size();i++)
                System.out.print(res.get(i) + " ");
            System.out.println();
            
            t--;
        }
    }
}
// } Driver Code Ends