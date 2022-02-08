package shared.commontypes;

public class NodeSumTuple {
    public TreeNode node;
    public int currentSum;

    public NodeSumTuple(TreeNode node, int previousSum) {
      this.node = node;
      this.currentSum = previousSum + node.val;
    }
}
