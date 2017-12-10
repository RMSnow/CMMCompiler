package demo.org.cmm.interpreter;

import org.antlr.runtime.tree.CommonTree;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import java.util.Iterator;

public class CMMTree {
	public static JTree outTree(CommonTree tree) {
		DefaultMutableTreeNode root = new DefaultMutableTreeNode("ASTree");
		if (tree != null) {
			buildTree(tree, root);
		}
		DefaultTreeModel model = new DefaultTreeModel(root);
		JTree jTree = new JTree(model);
		//
		//System.out.println(jTree.toString());
		return jTree;	
		
		
//		JScrollPane jScrollPane = new JScrollPane(jTree);
//		jScrollPane.setPreferredSize(new Dimension(500, 600));
//		JPanel panel = new JPanel();
//		panel.setPreferredSize(new Dimension(800, 600));
//		panel.add(jScrollPane);
//		JFrame frame = new JFrame("Klpyang");
//		frame.setContentPane(panel);
//		frame.pack();
//		frame.setVisible(true);
	}

	/**
	 * �ݹ����
	 * 
	 * @param tree
	 * @param root
	 */
	private static void buildTree(CommonTree tree, DefaultMutableTreeNode root) {
		if (tree.getChildren() != null) {
			for (Iterator iterator = tree.getChildren().iterator(); iterator
					.hasNext();) {
				CommonTree node = (CommonTree) iterator.next();
				String nodeString = node.toString();
				DefaultMutableTreeNode treeNode = new DefaultMutableTreeNode(
						nodeString);
				root.add(treeNode);
				buildTree(node, treeNode);
				//
				//System.out.println("1");
			}
		}

	}

}
