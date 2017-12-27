package com.wh.main.tree1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {
	private static  TreeNode root;
	
	public BinaryTree() {
		root=new TreeNode(1, "A");
	}
	
	
	/**
	 * 树节点的创建
	 * @author test
	 *
	 */
	public class TreeNode{
		private int index;
		private String data;
	
		private TreeNode left;
		private TreeNode right;
		boolean isVisited ;
		
		
		
		
		
		public int getIndex() {
			return index;
		}
		public void setIndex(int index) {
			this.index = index;
		}
		public String getData() {
			return data;
		}
		public void setData(String data) {
			this.data = data;
		}
		public TreeNode getLeft() {
			return left;
		}
		public void setLeft(TreeNode left) {
			this.left = left;
		}
		public TreeNode getRight() {
			return right;
		}
		public void setRight(TreeNode right) {
			this.right = right;
		}
		public TreeNode(int index, String data) {
			super();
			this.index = index;
			this.data = data;
			this.left=null;
			this.right=null;
		}
		
		
		
	}
	
	/**
	 * create binary tree by using String[]nodes
	 * 			A
	 * 		B 		C
	 * 	  D   E        F
	 *  G    H  I
	 * @param nodes
	 */
	//public void createBinaryTree(String []nodes){
		public void createBinaryTree(){
		TreeNode nodeB=new TreeNode(2, "B");
		TreeNode nodeC=new TreeNode(3, "C");
		TreeNode nodeD=new TreeNode(4, "D");
		TreeNode nodeE=new TreeNode(5, "E");
		TreeNode nodeF=new TreeNode(6, "F");
		TreeNode nodeG=new TreeNode(7, "G");
		TreeNode nodeH=new TreeNode(8, "H");
		TreeNode nodeI=new TreeNode(9, "I");
		root.setLeft(nodeB);
		root.setRight(nodeC);
		nodeC.setRight(nodeF);
		nodeB.setLeft(nodeD);
		nodeB.setRight(nodeE);
		nodeD.setLeft(nodeG);
		nodeE.setLeft(nodeH);
		nodeE.setRight(nodeI);
	
	}
	
	
	public int getHeight(){
		return getHeight(root);
	}

	/**
	 * get height of binary tree
	 * by Recursion
	 * @param node
	 * @return
	 */
	private int getHeight(TreeNode node) {
		if (null!=node) {
			int i=getHeight(node.getLeft());
			int j=getHeight(node.getRight());
			return (i<j)?j+1:i+1;
		}
		return 0;//must be 0,can't be -1
	}

	/**
	 * get size nums of tree node
	 * @return
	 */
	public int getSize(){
		return getSize(root);
	}
	/**
	 * get size of binary tree
	 * by Recursion 递归
	 * @param root
	 * @return
	 */
	private int getSize(TreeNode node) {
		if (null==node) {
			return 0;//must be 0,can't be -1
		}else{
			return 1+getSize(node.getLeft())+getSize(node.getRight());
		}
	}
	
	/**
	 * how to PreOrder??
	 * @param node
	 */
	public String  PreOrder1(TreeNode node){
		StringBuilder sb=new StringBuilder();
		if (null!=node) {
			sb.append(node.data+" ");
			//PreOrder(node.getLeft()); 
			//PreOrder(node.getRight());
			sb.append(PreOrder1(node.left));
			sb.append(PreOrder1(node.right));
		}else{
			return "";
		}
		return sb.toString();
	}
	/**
	 * PreOrder alter use 
	 * by recursion
	 * @param node
	 */
	public void PreOrder(TreeNode node){
		if (null!=node) {
			System.out.print(node.getData()+" ");
			PreOrder(node.left);
			PreOrder(node.right);
		}
		return;
	}
	
	/**
	 * PreOrder not using recursion!
	 * using stack
	 * @param node
	 */
	public void PreOrder2(TreeNode node){
		if (null==node) {
			return;
		}
		Stack<TreeNode> mystack=new Stack<BinaryTree.TreeNode>();
		mystack.push(node);
		TreeNode current=node;
		while(node!=null&&!mystack.isEmpty()){
			current=mystack.pop();
			System.out.print(current.data+" ");
			if (current.right!=null) {
				mystack.push(current.getRight());
			}
			if (current.left!=null) {
				mystack.push(current.getLeft());
			}
			
		}
		return;
		
	}
	
	/**
	 PreOrder  using iterative!
	 * using stack
	 * @param node
	 */
	public String PreOrder3(TreeNode node){
		StringBuilder sb=new StringBuilder();
		Stack<TreeNode> myStack=null;
		if (node!=null) {
			myStack=new Stack<TreeNode>();
			TreeNode current=node;
			myStack.push(current);
			while(!myStack.isEmpty()){
				current=myStack.pop();
				sb.append(current.data+" ");
				if (current.getRight()!=null) {
					myStack.push(current.getRight());
				}
				if (current.getLeft()!=null) {
					myStack.push(current.getLeft());
				}
				
			}
			
		}
		
		
		return sb.toString();
		
	}
	/**
	 * PreOrder by using iterative
	 * return List<T>
	 * best function
	 * @param node
	 * @return
	 */
	public List<String> PreOrder4(TreeNode node){
		List<String>list=new ArrayList<>();
		Stack<TreeNode>myStack=null;
		if (node!=null) {
			myStack=new Stack<>();
			TreeNode current=node;
			myStack.push(current);
			while (!myStack.isEmpty()) {
				current=myStack.pop();
				list.add(current.data);
				if (current.getRight()!=null) {
					myStack.push(current.getRight());
				}
				if (current.getLeft()!=null) {
					myStack.push(current.getLeft());
					
				}
			}
					
			
		}
		
		return list;
	}
	
	/**
	 * InOrder function using recursion
	 * return void
	 * @param node
	 */
	public void InOrder(TreeNode node){
		if (node!=null) {
			InOrder(node.getLeft());
			System.out.print(node.data+" ");
			InOrder(node.getRight());
		}
		return;
	}
	
	/**
	 * InOrder function using recursion
	 * return List<treeNode>
	 * @param node
	 * @return
	 */
//	public List<ArrayList<Object>> InOrder1(TreeNode node){
		public List<myArrayList<Object>> InOrder1(TreeNode node){
		//List<ArrayList<Object>> list=new ArrayList<>();
		//ArrayList<Object>temp=new ArrayList<>();
		
		List<myArrayList<Object>> list=new myArrayList<>();
		myArrayList<Object> temp=new myArrayList<>();
		
		if (null!=node) {
			temp.addAll(InOrder1(node.getLeft()));
			temp.add(node.getData());
			temp.addAll(InOrder1(node.getRight()));
			list.add(temp);
		}
		
		return list;
	}
	
		
		
			public List<ArrayList<Object>> InOrder1_old(TreeNode node){
		
			
			List<ArrayList<Object>> list=new ArrayList<>();
			ArrayList<Object> temp=new ArrayList<>();
			
			if (null!=node) {
				temp.addAll(InOrder1(node.getLeft()));
				temp.add(node.getData());
				temp.addAll(InOrder1(node.getRight()));
				list.add(temp);
			}
			
			return list;
		}
			
			
			/**
			 * InOrder how to iterator
			 * @param node
			 */
			public void InOrder2(TreeNode node){
				if (node!=null) {
					Stack<TreeNode>myStack=new Stack<>();
					TreeNode current=node;
					myStack.push(current);
					while(!myStack.isEmpty()){
						current=myStack.pop();
						InOrder2(node.getLeft());
						System.out.print(node.getData()+" ");
						InOrder2(node.getRight());
					}
				}
				return ;
				
			}
			
			
			/**
			 * InOrder using iterator 
			 * return StringBuilder
			 * 
			 * @param node
			 * @return
			 */
			public String InOrder3(TreeNode node){
				StringBuilder sb=new StringBuilder();
				if (null!=node) {
					
					Stack<TreeNode>stack=new Stack<>();
					TreeNode current=node;
					stack.push(current);
					while(!stack.isEmpty()){
						current=stack.pop();
						sb.append(InOrder3(node.getLeft()));
						sb.append(node.getData()+" ");
						sb.append(InOrder3(node.getRight()));
					}
				}
				
				
				return sb.toString();
			}
			
		/**
		 * postOrder 	
		 * @param node
		 */
	public String PostOrder(TreeNode node){
		StringBuilder sb=new StringBuilder();//存到递归调用栈
		
		if (null!=node) {
			sb.append(PostOrder(node.getLeft()));//后序遍历左子树
			
			sb.append(PostOrder(node.getRight()));//后序遍历右子树
			sb.append(node.getData()+" ");//后序遍历当前节点
		}
		return sb.toString();
		
		
		
	}
	
	/**
	 * PostOrder function 
	 * 直接这样写，顺序会弄反。所以需要两个栈
	 * return void
	 * @param node
	 * @return
	 */
	public String PostOrder1(TreeNode node){
		StringBuilder sb=new StringBuilder();
		
		if (null!=node) {
			Stack<TreeNode>stack=new Stack<>();
			TreeNode current=node;
			stack.push(current);
			while(!stack.isEmpty()){
				current=stack.pop();
				/**
				 * 1.RLC:无论c怎么排，结果都是前序遍历的结果
				 */
				if (current.getLeft()!=null) {
					stack.push(current.getLeft());
				}
				if (current.getRight()!=null) {
					stack.push(current.getRight());
				}
				sb.append(current.data+" ");
			}
			
		}
		
		return sb.toString();
		
	}
	/**
	 * 使用双栈法，后序遍历二叉树
	 * @param node
	 * @return
	 */
	public String PostOrder2(TreeNode node){
		StringBuilder sb=new StringBuilder();
		if (node!=null) {
			Stack<TreeNode>stack1=new Stack<>();
			Stack<Object>stack2=new Stack<>();
			TreeNode current=node;
			stack1.push(current);
			while(!stack1.isEmpty()){
				current=stack1.pop();
				if (current.getLeft()!=null) {
					stack1.push(current.getLeft());
				}
				if (current.getRight()!=null) {
					stack1.push(current.getRight());
				}
				
				stack2.push(current.getData());
				//sb.append(current.getData()+" ");
			}
			
			while(!stack2.isEmpty()){
				sb.append(stack2.pop()+" ");
			}
			
			
		}
		
		
		return sb.toString();
	}
	
	
	/**
	 * 使用标志位，来后序遍历二叉树
	 */
	public String PostOrderB(TreeNode node){
		StringBuilder sb=new StringBuilder();
		
		if (null!=node) {
			Stack<TreeNode> stack=new Stack<>();
			TreeNode current=node;
			TreeNode pre = null;//当前节点的之前访问的节点  
			//current.isVisited=true;//首次访问该节点，记为true
			stack.push(current);
			
			while(!stack.isEmpty()){
				current=stack.peek();
				 
	             if((current.left == null && current.right == null) ||  //当前节点是叶子节点，可以直接访问该节点  
	                     (pre != null &&(pre == current.left|| pre == current.right)))  
	                 //当前一个节点不为空并且是当前节点的左孩子或者右孩子，当是左孩子时说明当前节点右孩子为空，当是右孩子时，说明左右孩子都访问过了，且都不为空  
	             {  
	                System.out.print(current.getData() + "-->");   
	                stack.pop();  
	                pre = current;  
	             }  
	             else  //当前节点为栈顶元素  如果当前节点不是叶子节点，在当前节点之前访问的那个节点不是当前节点的孩子，则进行压栈  
	             {  
	                 if(current.right != null) //先压栈右节点再压栈左节点 这样出栈时是先左后右  
	                 {  
	                     stack.push(current.getRight());  
	                 }  
	                 if(current.left != null)  
	                 {     
	                     stack.push(current.getLeft());  
	                 }  
	             }  

				
			}
		}
		
		return sb.toString();
		
	}
	
	
	
	public String postOrderB1() {
		StringBuilder sb = new StringBuilder();
		LinkedList<TreeNode> stack = new LinkedList<TreeNode>(); // 记录回退路径的工作栈
		TreeNode node = root;
		while (node != null || !stack.isEmpty()) { // 迭代条件
			if (node != null) { // 当前节点不为空
				node.isVisited = true; // 首次访问该节点，记为true
				stack.push(node); // 压栈操作
				node = node.left; // 继续遍历左子树
			} else { // 当前节点为空但工作栈不为空
				node = stack.pop(); // 当前节点弹栈
				if (node.isVisited) {
					node.isVisited = false; // 第二次访问该节点,改为false
					stack.push(node); // 只有在第三次才访问，因此，前节点再次压栈
					node = node.right; // 访问该节点的右子树
				} else { // 第三次访问该节点
					sb.append(node.data + " "); // 访问
					node = null; // 当前节点的左子树、右子树及本身均已访问,需要访问工作栈中的节点
				}
			}
		}
		return sb.toString();
	}
	
	
	
	 
    /** 
     * public class Node { 
        public int data; //树结点标号 
        public Node lchild; //左子树 
        public Node rchild;  //右子树 
    } 
    后序遍历递归定义：先左子树，后右子树，再根节点。 
    后序遍历的难点在于：需要判断上次访问的节点是位于左子树，还是右子树。 
        若是位于左子树，则需跳过根节点，先进入右子树，再回头访问根节点； 
        若是位于右子树，则直接访问根节点。 
     */  
      
    public void postOrder(TreeNode node){  
        if(node==null)  
            return;  
        Stack<TreeNode> s = new Stack<TreeNode>();  
          
        TreeNode curNode; //当前访问的结点  
        TreeNode lastVisitNode; //上次访问的结点  
        curNode = node;  
        lastVisitNode = null;  
          
        //把currentNode移到左子树的最下边  
        while(curNode!=null){  
            s.push(curNode);  
            curNode = curNode.getLeft();  
        }  
        while(!s.empty()){  
            curNode = s.pop();  //弹出栈顶元素  
            //一个根节点被访问的前提是：无右子树或右子树已被访问过  
            if(curNode.getRight()!=null&&curNode.getRight()!=lastVisitNode){  
                //根节点再次入栈  
                s.push(curNode);  
                //进入右子树，且可肯定右子树一定不为空  
                curNode = curNode.getRight();  
                while(curNode!=null){  
                    //再走到右子树的最左边  
                    s.push(curNode);  
                    curNode = curNode.getLeft();  
                }  
            }else{  
                //访问  
                System.out.print(curNode.getData()+" ");  
                //修改最近被访问的节点  
                lastVisitNode = curNode;  
            }  
        } //while  
    }  
	
	
	
	/**
	 * 层序遍历
	 * 非递归
	 * @param node
	 * @return
	 */
	public String levelOrder1(TreeNode node){
		StringBuilder sb=new StringBuilder();
		if (node!=null) {
			Queue<TreeNode> queue=new LinkedList<>();
			TreeNode current=node;
			queue.offer(current);
			while(!queue.isEmpty()){
				current=queue.poll();
				if (current.getLeft()!=null) {
					queue.offer(current.getLeft());
				}
				if (current.getRight()!=null) {
					queue.offer(current.getRight());
					
				}
				
				sb.append(current.getData()+" ");
			}
			
		}
		
		return sb.toString();
	}
	
	
	
	
	 /*
     * 层序遍历
     * 递归
     */
    public void levelOrder(TreeNode Node) {
        if (Node == null) {
            return;
        }

        int depth = getHeight(Node);

        for (int i = 1; i <= depth; i++) {
            levelOrder(Node, i);
        }
    }

    private void levelOrder(TreeNode Node, int level) {
        if (Node == null || level < 1) {
            return;
        }

        if (level == 1) {
            System.out.print(Node.getData() + " ");
            return;
        }

        // 左子树
        levelOrder(Node.getLeft(), level - 1);

        // 右子树
        levelOrder(Node.getRight(), level - 1);
    }
	
	
    /**
     * 前序遍历
     * 非递归
     */
    public void preOrderA(TreeNode Node)
    {
        Stack<TreeNode> stack = new Stack<>();
        while(Node != null || !stack.empty())
        {
            while(Node != null)
            {
                System.out.print(Node.getData() + " ");
                stack.push(Node);
                Node = Node.left;
            }
            if(!stack.empty())
            {
                Node = stack.pop();
                Node = Node.right;
            }
        }
    }

    /**
     * 中序遍历
     * 非递归
     */
    public void midOrderA(TreeNode Node)
    {
        Stack<TreeNode> stack = new Stack<>();
        while(Node != null || !stack.empty())
        {
            while (Node != null)
            {
                stack.push(Node);
                Node = Node.left;
            }
            if(!stack.empty())
            {
                Node = stack.pop();
                System.out.print(Node.getData() + " ");
                Node = Node.right;
            }
        }
    }

    /**
     * 后序遍历
     * 非递归
     */
    public void posOrderA(TreeNode Node)
    {
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        int i = 1;
        while(Node != null || !stack1.empty())
        {
            while (Node != null)
            {
                stack1.push(Node);
                stack2.push(0);
                Node = Node.left;
            }

            while(!stack1.empty() && stack2.peek() == i)
            {
                stack2.pop();
                System.out.print(stack1.pop().getData() + " ");
            }

            if(!stack1.empty())
            {
                stack2.pop();
                stack2.push(1);
                Node = stack1.peek();
                Node = Node.right;
            }
        }
    }

    
    
	
	
	
	public static void main(String[] args) {
		BinaryTree binaryTree=new BinaryTree();
		binaryTree.createBinaryTree();
		int heigh=binaryTree.getHeight();
		System.out.println("tree heigh "+heigh);
		int size=binaryTree.getSize();
		System.out.println("tree size:"+size);
		String dot="................................";
		System.out.println("二叉树的前序遍历");
		System.out.println(dot+dot);
		System.out.println("PreOrder using recursion");
		binaryTree.PreOrder(root);
		String result=binaryTree.PreOrder1(root);
		
		
		System.out.println("\nPreOrder1 results: "+result);
		System.out.println("\n iterative using by PreOrder2 ");
		binaryTree.PreOrder2(root);
		System.out.println("\n iterative using by PreOrder3\n"+binaryTree.PreOrder3(root));
		System.out.println("iterative using by PreOrder4\n"+binaryTree.PreOrder4(root));
		
//		String []nodes=(String[])binaryTree.PreOrder4(root).toArray();
//		for (String node : nodes) {
//			System.out.print(node+" ");
//		}
//		System.out.println();
		System.out.println(dot+dot);
		System.out.println("中序遍历的结果：");
		System.out.println("InOrder using recursion");
		binaryTree.InOrder(root);
		System.out.print("\n采用广义表形式的字符串来表示相应的排序表达式(使用arrayList自带的迭代和打印方法，可以修改)");
		System.out.println("\nInOrder using recursion return List<treeNode> old\n"+binaryTree.InOrder1_old(root));
		System.out.println("InOrder using recursion return List<treeNode> new\n"+binaryTree.InOrder1(root));
		
		System.out.println("InOrder using stack return void");
		binaryTree.InOrder2(root);
		System.out.println("\nInOrder using stack return StringBuilder\n"+binaryTree.InOrder3(root));
		
		System.out.println(dot+dot);
		System.out.println("后序遍历当前节点(递归)");
		System.out.println(binaryTree.PostOrder(root));
		System.out.println("PostOrder using stack return String(貌似把顺序弄反了)");
		System.out.println(binaryTree.PostOrder1(root));
		System.out.println("使用双栈法打印后序遍历当前的二叉树");
		System.out.println(binaryTree.PostOrder2(root));
		System.out.println(dot+dot);
		System.out.println("层次遍历(非递归)");
		System.out.println(binaryTree.levelOrder1(root));
		System.out.println("层次遍历(递归)");
		binaryTree.levelOrder(root);
		System.out.println(dot+dot);
		System.out.println("下面是我怎么看也看不懂的几种非递归遍历，写的也很复杂：(不过运行结果完全正确)");
		System.out.println("前序遍历(非递归)");
		binaryTree.preOrderA(root);
		System.out.println("\n中序遍历（非递归）");
		binaryTree.midOrderA(root);
		System.out.println("\n后序遍历(非递归)");
		binaryTree.posOrderA(root);
		System.out.println("\n后序遍历(非递归，不使用双栈法)");
		System.out.println("\n"+binaryTree.PostOrderB(root));
		System.out.print("后序遍历(非递归，不使用双栈法1)");
		System.out.println(binaryTree.postOrderB1());
		System.out.print("后序遍历(非递归，不使用双栈法2)");
		binaryTree.postOrder(root);
		

		
		
		
		
	}
	
	
}
