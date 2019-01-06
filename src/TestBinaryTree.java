import java.util.Scanner;

public class TestBinaryTree {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入先根序列的长度");
        int length=input.nextInt();
        System.out.println("请输入先根序列");
        String[] prelist =new String[length];
        for(int i = 0;i<prelist.length;i++) {
            prelist[i] = input.next();
        }
        BinaryTree<String> bitree = new BinaryTree<String>(prelist);
        System.out.println("请输入所需要的操作：");
        String s = input.next();
        while(!s.equals("0")) {
            switch (s) {
                case "1":
                    bitree.preorder();
                    break;
                case "2":
                    bitree.inorder();
                    break;
                case "3":
                    bitree.postorder();
                    break;
                case "4":
                    bitree.preorderTraverse();
                    break;
                case "5":
                    bitree.inorderTraverse();
                    break;
            }
            s = input.next();
        }
    }
}