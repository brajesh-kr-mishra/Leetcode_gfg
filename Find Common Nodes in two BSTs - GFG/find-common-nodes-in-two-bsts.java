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



//  class Solution {
//     public static int floor(Node root, int x) {
//         ArrayList<Integer> inorderList = new ArrayList<>();
//         inorderTraversal(root, inorderList);

//         int low = 0;
//         int high = inorderList.size() - 1;
//         int floorValue = -1;

//         while (low <= high) {
//             int mid = low + (high - low) / 2;
//             int current = inorderList.get(mid);

//             if (current == x) {
//                 return x; // x is found in the tree, so the floor is x itself.
//             } else if (current < x) {
//                 floorValue = current; // Update the floor value.
//                 low = mid + 1;
//             } else {
//                 high = mid - 1;
//             }
//         }

//         return floorValue;
//     }

//     private static void inorderTraversal(Node root, ArrayList<Integer> list) {
//         if (root == null) {
//             return;
//         }
//         inorderTraversal(root.left, list);
//         list.add(root.data);
//         inorderTraversal(root.right, list);
//     }

   
// }


class Solution {
    // Function to find the nodes that are common in both BST.
    public static ArrayList<Integer> findCommon(Node root1, Node root2) {
        // Create two ArrayLists to store the inorder traversal results.
        ArrayList<Integer> l1 = new ArrayList<>();
        ArrayList<Integer> l2 = new ArrayList<>();

        // Perform inorder traversal on both BSTs.
        inorderTraversal(root1, l1);
        inorderTraversal(root2, l2);

        // Create a HashSet to store elements from the first BST.
        HashSet<Integer> s = new HashSet<>(l1);

        // Create a result ArrayList to store common elements.
        ArrayList<Integer> res = new ArrayList<>();

        // Iterate through the second BST's elements and check if they exist in the HashSet.
        for (int j = 0; j < l2.size(); j++) {
            if (s.contains(l2.get(j))) {
                res.add(l2.get(j));
            }
        }

        return res;
    }

    private static void inorderTraversal(Node root, ArrayList<Integer> list) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left, list);
        list.add(root.data);
        inorderTraversal(root.right, list);
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