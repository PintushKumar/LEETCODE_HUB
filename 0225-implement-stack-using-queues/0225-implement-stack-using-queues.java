class MyStack {
    static Queue<Integer> q1 ;
   static Queue<Integer> q2;
    public MyStack() {
      q1 = new LinkedList<Integer>();
      q2 = new LinkedList<Integer>();
    }
    
    public void push(int x) {
        q1.add(x);
    }
    
    public int pop() {
        if(q1.size()==0){
            return -1;
        }
        while(q1.size()>1){
            q2.add(q1.remove());
        }
        int ele = q1.remove();
        while(q2.size()!=0){
            q1.add(q2.remove());
        }
        return ele;
    }
    
    public int top() {
        if(q1.size()==0){
            return -1;
        }
        while(q1.size()>1){
            q2.add(q1.remove());
        }
        int ele = q1.remove();
        while(q2.size()!=0){
            q1.add(q2.remove());
        }
        q1.add(ele);
        return ele;
    }
    
    public boolean empty() {
        if(q1.size()==0){
            return true;
        }else{
        return false;
        }
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */