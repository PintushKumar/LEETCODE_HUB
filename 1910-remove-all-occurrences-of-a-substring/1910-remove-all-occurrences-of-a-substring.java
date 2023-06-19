class Solution {
	public void remove(StringBuilder ans , String part , int pos ){
		if(pos==-1){
			return;
		}
		ans.delete(pos , pos + part.length());
		pos =ans.indexOf(part);
		remove(ans,part,pos);
	}
	public String removeOccurrences(String s, String part) {
// *********************  My Solution ****************************

		// Stack<Character> st =new Stack<>();
		// int slen=s.length();
		// int plen = part.length();
		// char ch = part.charAt(plen-1);
		// for(int i=0;i<slen;i++){
		// 	st.push(s.charAt(i));
		// 	if(st.peek()==part.charAt(plen-1)){
		// 		if( st.size()>=plen){
		// 			boolean flag = false;
		// 			Stack<Character> tempst = new Stack<>();
		// 			for(int j=plen-1;j>=0;j--){
		// 				if(st.peek()!=part.charAt(j)){
		// 					flag =true;
		// 					break;
		// 				}
		// 				tempst.push(st.peek());
		// 				st.pop();
		// 			}
		// 			if(flag ==true){
		// 				while(tempst.size()>0){
		// 					st.push(tempst.pop());
		// 				}
		// 			}
		// 		}
		// 	}
		// }
		// StringBuilder ansStr = new StringBuilder();
		// while(st.size()>0){
		// 	ansStr.append(st.peek());
		// 	st.pop();
		// }
		// ansStr.reverse();
		// return ansStr.toString();

// *************************************************************************

// *********************** Recursive Solution *****************************

  //  StringBuilder ans = new StringBuilder(s);
	//  int pos = ans.indexOf(part);
	//  remove(ans, part, pos);
	//  return ans.toString();

//********************** Iterative Approach ****************************** */
    while(true){
			int index = s.indexOf(part);
			if(index>-1){
				s=s.substring(0,index)+s.substring(index + part.length());
			}else{
				break;
			}
	  }
	 return s;
	}
}