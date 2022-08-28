public class BinarySearchTree {

    Node root;

    public void addNode(int key, String name) {
        Node newNode = new Node(key, name);
        if(root == null){
            root = newNode;
        }else{
            Node focusNode = root;
            Node parent;

            while(true){
                parent = focusNode;
                if(key < focusNode.key){
                    focusNode = focusNode.leftChild;
                    if(focusNode == null){
                        parent.leftChild = newNode;
                        return;
                    }
                }else{
                    focusNode = focusNode.rightChild;
                    if(focusNode == null){
                        parent.rightChild = newNode;
                        return;
                    }
                }
            }
        }
    }

    
    public void inOrderTravel(Node focusNode) {
        if(focusNode != null){
            inOrderTravel(focusNode.leftChild);
            System.out.println(focusNode);
            inOrderTravel(focusNode.rightChild);
        }
    }

    public void preOrderTravel(Node focusNode) {
        if(focusNode != null){
            System.out.println(focusNode);
            preOrderTravel(focusNode.leftChild);
            preOrderTravel(focusNode.rightChild);
        }
    }

    public Node findNode(int key){
        Node focusNode = root;

        while(focusNode.key != key){
            if(key < focusNode.key){
                focusNode = focusNode.leftChild;
            }else{
                focusNode = focusNode.rightChild;
            }
            if(focusNode == null){
                return null;
            }
        }
        return focusNode;
    }

    public boolean remove(int key){
        Node focusNode = root;
        Node parent = root;

        boolean isItALeftChild = true;

        while(focusNode.key != key){
            parent = focusNode;
            if(key < focusNode.key){
                isItALeftChild = true;
                focusNode = focusNode.leftChild;
            }else{
                isItALeftChild = false;
                focusNode = focusNode.rightChild;
            }

            if(focusNode == null)
                return false;
        }

        if(focusNode.leftChild == null && focusNode.rightChild == null){
            if(focusNode == root){ //
                root = null;
            }else if(isItALeftChild){
                parent.leftChild = null;
            }else{
                parent.rightChild = null;
            }
        }else if(focusNode.rightChild == null){
            if(focusNode == root){
                root = focusNode.leftChild;
            }else if(isItALeftChild){
                parent.leftChild = focusNode.leftChild;
            }else{
                parent.rightChild = focusNode.rightChild;
            }
        }else if(focusNode.leftChild == null){
            if(focusNode == root){
                root = focusNode.rightChild;
            }else if(isItALeftChild){
                parent.leftChild = focusNode.rightChild;
            }else{
                parent.rightChild = focusNode.leftChild;
            }
        }else{
            Node replacement = getReplacement(focusNode);
            if(focusNode == root)
                root = replacement;
            else if(isItALeftChild)
                parent.leftChild = replacement;
            else
                parent.rightChild = replacement;

            replacement.leftChild = focusNode.leftChild;
        }
        return true;
    }

    public Node getReplacement(Node replacedNode ){
        Node replacementparent = replacedNode;
        Node replacement = replacedNode;

        Node focusNode = replacedNode.rightChild;

        while(focusNode != null){
            replacementparent = replacement;
            replacement = focusNode;
            focusNode = focusNode.leftChild;
        }

        if(replacement != replacedNode.rightChild){
            replacement.leftChild = replacement.rightChild;
            replacement.rightChild = replacedNode.rightChild;
        }

        return replacement;
    }

    public static void main(String[] args) {
        BinarySearchTree myTree = new BinarySearchTree();

        /*
        myTree.addNode(99, "Boss");
        myTree.addNode(25, "Vice Press");
        myTree.addNode(15, "PM");
        myTree.addNode(8, "Sales manager");
        myTree.addNode(19, "Intern");
        myTree.addNode(75, "Intern");
        myTree.addNode(80, "Intern");
        myTree.addNode(85, "Vice Press");
        myTree.addNode(200, "Intern");
        myTree.addNode(100, "Intern");
        myTree.addNode(300, "Intern");
        myTree.addNode(45, "Intern");
        */
        myTree.addNode(50, "Boss");
        myTree.addNode(1, "Vice Press");
        myTree.addNode(55, "PM");
        //yTree.addNode(53, "name");
        myTree.addNode(90, "Sales manager");
        //myTree.addNode(53, "Intern");
        //myTree.addNode(30, "Intern");
        //myTree.addNode(18, "Intern");
        //myTree.addNode(2, "Intern");
        //myTree.addNode(35, "Intern");
        //myTree.addNode(27, "Intern");





        
        //myTree.preOrderTravel(myTree.root);

        //System.out.println(myTree.findNode(85));
        //myTree.remove(25);
        //System.out.println(myTree.findNode(1).name);
        
        myTree.inOrderTravel(myTree.root);
        System.out.println("-------");
        myTree.remove(50);
        myTree.inOrderTravel(myTree.root);
        //myTree.preOrderTravel(myTree.root);
    }
}

class Node {
    int key;
    String name;

    Node leftChild;
    Node rightChild;

    Node(int key, String name){
        this.key = key;
        this.name = name;
    }

    public String toString(){
        return "" + key;
    }
}
