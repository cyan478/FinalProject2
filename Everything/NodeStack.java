public class NodeStack<E> implements Stack<E>{
  
  private int _size;
  private DNode<E> _stackHead, _stackFoot;
  
  public NodeStack(){
    _size = 0;
    _stackHead = _stackFoot = null;
  }
  
  public int size(){
    return _size;
  }
  
  public boolean isEmpty(){
    return size() == 0;
  }
  //  O(1)
  public void push(E value){
    DNode<E> temp = new DNode<E>(value);
    if (_size == 0)
      _stackHead = _stackFoot = temp; 
    else{
      _stackHead.setPrevious(temp);
      temp.setNext(_stackHead);
      _stackHead = temp;
    }
    _size++;
  }
  // O(1)
  public E top() throws EmptyStackException{
    if (isEmpty())
      throw new EmptyStackException("Stack empty");
    return _stackHead.getValue();
  }
  // O(1)
  public E pop() throws EmptyStackException{
    E ans = top();
    DNode<E> temp = _stackHead.getNext();
    _stackHead.setNext(null);
    temp.setPrevious(null);
    _stackHead = temp;
    _size--;
    return ans;
  }
  
  public String toString(){
    String ans ="[";
    if (size() > 0) ans += _stackFoot.getValue();
    if (size() > 1) {
      DNode<E> curr = _stackFoot.getPrevious();
      for (int i = 1; i < size(); i++){
        ans += ", " + curr.getValue();
        curr = curr.getPrevious();
      }
      
    }
    ans += "]";
    return ans;
  }
  
  public static void main(String [] args){
    NodeStack<Integer> a= new NodeStack<Integer>();
    for (int i = 10; i>0; i--)
      a.push(i);
    System.out.println(a);
    System.out.println(a.pop());
    System.out.println(a);
  }
  
}

