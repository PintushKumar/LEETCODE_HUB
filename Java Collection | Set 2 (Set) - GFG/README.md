# Java Collection | Set 2 (Set)
## Easy
<div class="problems_problem_content__Xm_eO"><p><span style="font-size:18px">Implement different operations on a set&nbsp;s&nbsp;.</span></p>

<p><span style="font-size:18px"><strong>Input:</strong><br>
The first line of input contains an integer <strong>T</strong> denoting the no of test cases . Then T test cases follow. The first line of input contains an integer <strong>Q</strong> denoting the no of queries . Then in the next line are <strong>Q</strong>&nbsp;space separated queries .<br>
A query can be of&nbsp;four&nbsp;types&nbsp;<br>
<strong>1.</strong> a x (inserts an element x to the set s)<br>
<strong>2.</strong> b (prints the contents of the set s in increasing order)<br>
<strong>3.</strong> c x&nbsp;(erases an element x from the set s)<br>
<strong>4.</strong> d x (prints 1 if the element x is present in the set&nbsp;else print -1)<br>
<strong>5.</strong> e (prints the size of the set s)</span></p>

<p><span style="font-size:18px"><strong>Output:</strong><br>
The output for each test case will&nbsp;&nbsp;be space separated integers denoting the results of each query . </span></p>

<p><span style="font-size:18px"><strong>Constraints:</strong><br>
1 &lt;= T &lt;= 100<br>
1 &lt;= Q &lt;= 100</span></p>

<p><span style="font-size:18px"><strong>Example:</strong></span><br>
<span style="font-size:18px"><strong>Input:</strong><br>
2<br>
6<br>
a 1 a 2 a 3 b c 2 b<br>
5<br>
a 1 a 5 e d 5 d 2</span></p>

<p><span style="font-size:18px"><strong>Output</strong>:<br>
1 2 3 1 3<br>
2 1 -1</span></p>

<p><span style="font-size:18px"><strong>Explanation :<br>
Testcase 1:</strong><br>
There are six&nbsp;queries.&nbsp;Queries&nbsp;are&nbsp;performed in this order<br>
1. a 1 &nbsp; &nbsp; { insert 1 to set now set has {1}&nbsp;}<br>
2. a 2 &nbsp; &nbsp; {inserts 2&nbsp;to set now set has {1,2}&nbsp;}<br>
3. a 3 &nbsp; &nbsp; {inserts 3 to set now set has {1,2,3}&nbsp;}<br>
4. b &nbsp; &nbsp; &nbsp; &nbsp;{prints the set contents ie 1,2,3}<br>
5. c 2 &nbsp; &nbsp; {removes 2 from the set&nbsp;}<br>
6. b &nbsp; &nbsp; &nbsp; &nbsp;{prints the set contents ie 1,3}<br>
<br>
<strong>Testcase 2:</strong><br>
There are five&nbsp;queries.&nbsp;Queries&nbsp;are&nbsp;performed in this order<br>
1. a 1&nbsp; &nbsp; &nbsp;{inserts 1 to set now set has {1}}<br>
2. a 11 &nbsp; {inserts 11 to set now set has {1,11}}<br>
3. e&nbsp; &nbsp; &nbsp; &nbsp; {prints the size of the set ie 2}<br>
4. d 5&nbsp; &nbsp; &nbsp;{since five is present prints 1}<br>
5. d 2 &nbsp; &nbsp; {since 2 is not present in the set prints -1}</span><br>
&nbsp;</p>
</div>