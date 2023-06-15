class MyQueue {
    Stack<Integer>st1 = new Stack<>();
    Stack<Integer>st2 = new Stack<>();

    public MyQueue() {
        
    }
    
    public void push(int x) {
        st1.push(x);
    }
    
    public int pop() {
        if(st1.size()==0){
            return -1;
        }else{
            while(st1.size()>1){
                st2.push(st1.pop());
            }
            int val = st1.pop();
            while(st2.size()>0){
                st1.push(st2.pop());
            }
            return val;
        }
    }
    
    public int peek() {
        if(st1.size()==0){
            return -1;
        }else{
            while(st1.size()>1){
                st2.push(st1.pop());
            }
            int val = st1.pop();
            st2.push(val);
            while(st2.size()>0){
                st1.push(st2.pop());
            }
            return val;
        }
    }
    
    public boolean empty() {
        if(st1.size()==0){
            return true;
        }else{
            return false;
        }
    }
}

// first solution using Array

// class MyQueue {
//     int arr[] = new int [10000005];
//     int front ;
//     int rear ;
//     public MyQueue() {
//         front =0;
//         rear =0;
//     }
    
//     public void push(int x) {
//         arr[rear++]=x;
//     }
    
//     public int pop() {
//         if(front ==rear){
//             return -1;
//         }
//         else{
//             return arr[front++];
//         }
//     }
    
//     public int peek() {
//         if(front ==rear){
//             return -1;
//         }
//         return arr[front];
//     }
    
//     public boolean empty() {
//         if(front == rear){
//             return true;
//         }else{
//             return false;
//         }
//     }
// }

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */