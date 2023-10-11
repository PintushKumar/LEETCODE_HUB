# TreeMap Operations
## Easy
<div class="problems_problem_content__Xm_eO"><p><span style="font-size:18px">Implement different operations on Treemap. Operations will be performed by different types of queries.<br>
A query can be of four&nbsp;types:<br>
1. a x y&nbsp;(adds an entry&nbsp;with key x and value&nbsp;y to the Treemap)<br>
2. b x (print value of &nbsp;x if&nbsp;present in the Treemap else print -1.&nbsp;)<br>
3. c (prints the size of the Treemap)<br>
4. d x ( removes an entry&nbsp;with key x from the map )<br>
5. e (print map sorted by key)</span></p>

<p><strong><span style="font-size:18px">Example 1:</span></strong></p>

<pre><span style="font-size:18px"><strong>Input</strong>:
6
a 1 2 a 66 3 b 66 d 1 c e

<strong>Output</strong>:
3 1 66</span>

<span style="font-size:18px"><strong>Explanation:</strong>
There are five queries. Queries are performed in this order
1. a 1 2    ---&gt;  map has a key 1 with value 2 
2. a 66 3   ---&gt; map has a key 66 with value 3
3. b 66     ---&gt; prints the value of key 66 if its present in the map ie 3.
4. d 1      ---&gt; removes an entry from map with key 1
5. c        ---&gt; prints the size of the map ie 1
6. e        ---&gt; prints the map sorted by key</span></pre>

<p>&nbsp;</p>

<p><strong><span style="font-size:18px">Example 2:</span></strong></p>

<pre><span style="font-size:18px"><strong>Input</strong>:
4
a 1 66 b 5 c e

<strong>Output</strong>:
-1 1 1</span>

<span style="font-size:18px"><strong>Explanation:</strong>
There are three&nbsp;queries.&nbsp;Queries&nbsp;are&nbsp;performed in this order
1. a 1 66 &nbsp; ---&gt; adds a key 1 with a value of 66 in the map
2. b 5 &nbsp; &nbsp; &nbsp;---&gt; &nbsp;since the key 5 is not present in the map hence -1 is printed.
3. c &nbsp; &nbsp; &nbsp; &nbsp;---&gt; prints the size of the map ie 1 </span>
<span style="font-size:18px">4. e&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;---&gt; prints the map sorted by key</span></pre>

<p><span style="font-size:18px"><strong>Your Task:</strong></span><br>
<span style="font-size:18px">You are required to complete the following functions:<br>
<strong>add_Value</strong> : Takes HashMap, x, y as arguments and maps x as key and y as its value. Does not return anything.<br>
<strong>find_value</strong> : Takes HashMap and x as arguments. If HM contains x key then return the value, else return -1.<br>
<strong>getSize</strong> : Takes HashMap as argument and just returns its size.<br>
<strong>removeKey</strong> : Takes HashMap and x as arguments and removes x if it exists. Does not return anything.<br>
<strong>sorted_By_Key</strong></span> : <span style="font-size:18px">Takes HashMap as argument and prints the keys that are sorted. Don't print newline.</span></p>

<p><span style="font-size:18px"><strong>Constraints:</strong><br>
1 &lt;= Q &lt;= 100</span></p>
</div>