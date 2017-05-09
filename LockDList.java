/* LockDList.java */

package list;

public class LockDList extends DList{

  public void lockNode(DListNode node) {
    ((LockDListNode) node).locked = true;
  }
  
  protected LockDListNode newNode(Object item, DListNode prev, DListNode next) {
    return new LockDListNode(item, prev, next);
  }
  
  public void remove(DListNode node) {
    if (((LockDListNode) node).locked == false) {
      if (node != null) {
        node.next.prev = node.prev;
        node.prev.next = node.next;
        size--;
      }
    }
  }
}