




class Node {
		public Double value;
		public java.util.List<Node> children;
	}

public class Test8 {
	/*
	 * 未经测试程序
	 * 
	 * */
	public void doit4(Node root){
		java.util.Stack<Node> st = new java.util.Stack<>();
		java.util.Map<Node,Boolean> visitedNodes = new java.util.HashMap<>();
		st.push(root);
		Node current = null;
		while (!st.isEmpty()) {
			current = st.peek();//获得栈顶元素，不删除
			boolean hasLessChildrenVisted = false;//左子树（value 小的子树）是否访问
			for(Node child : current.children){
				if(child.value < current.value){
					if(visitedNodes.get(child) != null){
						hasLessChildrenVisted = true;
					}
					break;
				}
			}
			if(hasLessChildrenVisted){//左子树（value 小的子树）入栈
				for (int i = current.children.size(); i >= 0; i--) {
					if (current.children.get(i).value < current.value) {
						st.push(current.children.get(i));
					}
				}
				continue;
			}
			System.out.println(current.value);
			visitedNodes.put(current, Boolean.TRUE);
			st.pop();//访问后出栈
			for (int i = current.children.size(); i >= 0; i--) {//右子树（value 大的子树）入栈
				if (current.children.get(i).value >= current.value) {
					st.push(current.children.get(i));
				}
			}
		}
	}
	
	public void doit2(Node root){
		boolean flag = true;
		for(Node node : root.children){
			if(node.children.size() > 0){
				flag = false;
				break;
			}
		}
		if(flag){//所有子节点都是叶子节点
			if(root.value == null){
				Double sum = 0.0;
				for(Node node : root.children){
					if(node.value == null){
						node.value = 1.0;
					}
					sum += node.value;
				}
			}else{
				Double sum = 0.0;
				int numOfNull = 0;
				for(Node node : root.children){
					if(node.value == null){
						numOfNull += 1;
					}
					sum += node.value;
				}
				for(Node node : root.children){
					if(node.value == null){
						node.value = (root.value - sum)/numOfNull;//给每个缺值的子节点附上相同值，使和等于根节点
					}
				}
			}
			return;
		}
		for(Node node : root.children){
			
		}
		
		
	}
	
	/*
	 * 未经测试程序
	 * 对于value未null的节点，找到一个值，将来设定的值必须大于此值
	 * */
	private Double getValuMoreThan(Node root){
		if (root.value != null){
			return root.value;
		}
		if(root.children.size() == 0){
			return 0.0;
		}
		Double valueMoreThan = 0.0;
		Double tmpValue = null;
		for(Node child : root.children){
			valueMoreThan += getValuMoreThan(child);
		}
		return valueMoreThan;
	}
	
	/*
	 * 未经测试程序
	 * 
	 * */
	public void doit(Node root){//默认root必须有value
		int numOfNull = 0;
		Double sum = 0.0;
		for(Node child : root.children){
			if(child.value == null){
				sum += this.getValuMoreThan(child); 
				numOfNull += 1;
			}else{
				sum += child.value;//child 有value的话就加value
			}
		}
		Double average = (root.value - sum)/numOfNull;
		for(Node child : root.children){
			if(child.value == null){
				child.value = this.getValuMoreThan(child) + average;//重复调用this.getValuMoreThan，可以在上次调用时保存值进行优化
			}
			doit(child);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
