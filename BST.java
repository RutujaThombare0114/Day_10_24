public class BST {
    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
        }
    }

    public static Node insert(Node root, int data){
        Node new_node = new Node(data);
        if(root == null){
            root = new_node;
            return root;
        }
        if(root.data>data){
            root.left = insert(root.left,data);
        }
        if(root.data<data){
            root.right = insert(root.right,data);
        }
        return root;
    }

    public static boolean search(Node root, int key){
        if(root == null){
            return false;
        }
        if(root.data>key){
            return search(root.left, key);
        }
        else if(root.data == key){
            return true;
        }
        else{
            return search(root.right, key);
        }
    }

    public static Node delete(Node root, int data){
        if(root.data>data){
            root.left = delete(root.left, data);
        }
        else if(root.data<data){
            root.right = delete(root.right, data);
        }
        else{
            if(root.left == null && root.right == null){
                return null;
            }
            if(root.left == null){
                return root.right;
            }
            else if(root.right == null){
                return root.left;
            }
            
            Node IS = inordersuccessor(root.right);
            root.data = IS.data;
            root.right = delete(root.right, IS.data);
        }
        return root;
    }
    public static Node inordersuccessor(Node root){
        while(root.left!=null){
            root = root.left;
        }
        return root;
    }

    public static Node update(Node root, int odata, int ndata){
        if(root == null){
            return null;
        }
        if(root.data>odata){
            root.left = update(root.left,odata,ndata);
        }
        else if(root.data<odata){
            root.right = update(root.right,odata,ndata);
        }
        else{
            root.data = ndata;
        }
        return root;
    }

    public static void inorder(Node root){
        if(root == null){
            return;
        }
        inorder(root.left);
        System.out.println(root.data + " ");
        inorder(root.right);
    }

    public static void preorder(Node root){
        if(root == null){
            return;
        }
        System.out.println(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void postorder(Node root){
        if(root == null){
            return;
        }
        postorder(root.left);
        postorder(root.right);
        System.out.println(root.data + " ");
    }
    public static void main(String args[]){
        int values[] = {1,4,5,2,3};
        Node root = null;

        for(int i=0; i<values.length; i++){
            root = insert(root,values[i]);
        }
        System.out.println("Preorder is -->");
        preorder(root);
        System.out.println();

        System.out.println("Inorder is -->");
        inorder(root);
        System.out.println();
        
        System.out.println("Postorder is -->");
        postorder(root);
        System.out.println();
    }
}



