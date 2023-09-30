# The Spider Steps
## Easy
<div class="problems_problem_content__Xm_eO"><p><span style="font-size:18px">A spider present at the bottom of the well of height H, needs to get out of it. The walls of the well are very slippery. In each step, it climbs U metres and slips down D metres. If in the last step, the spider gets out of the well by climbing U metres, it does not slip back. Find the number of steps the spider takes.</span></p>

<p><br>
<span style="font-size:18px"><strong>Example 1:</strong></span></p>

<pre><span style="font-size:18px"><strong>Input: </strong>
H = 200, U = 50, D = 1
<strong>Output:</strong> 5
<strong>Explaination: </strong>
First Step: 50 -1 = 49 
Second Step: 49 + 50 - 1 = 98 
Third Step: 98 + 50 - 1 = 147 
Fouth Step: 147 + 50 - 1 = 196
Fifth Step: Reach beyond H.</span></pre>

<p><br>
<span style="font-size:18px"><strong>Example 2:</strong></span></p>

<pre><span style="font-size:18px"><strong>Input: </strong>
H = 100, U = 5, D = 3
<strong>Output:</strong> 49
<strong>Explanation:</strong>
A single step covers (U-D=2) in each step. 
You can cover 96 in 48 steps. In the 49th 
step increment by 5 and don't decrement by 3.</span></pre>

<p><br>
<span style="font-size:18px"><strong>Example 3:</strong></span></p>

<pre><span style="font-size:18px"><strong>Input:</strong>
H = 10, U = 4, D = 1
<strong>Output:</strong> 4
<strong>Explaination:</strong>
First Step: 4 - 1 = 3
Second Step: 3 + 4 - 1 = 6 
Third Step: 6 + 4 - 1 = 9 
Fourth Step: 9+4 = 13 &gt; 10
</span></pre>

<p>&nbsp;</p>

<p><span style="font-size:18px"><strong>Your Task:</strong><br>
You do not need to read input or print anything. Your task is to complete the function <strong>minStep()</strong> which takes H, U and D as input parameters and returns the steps required to go beyond H.</span></p>

<p><br>
<span style="font-size:18px"><strong>Expected Time Complexity:</strong> O(1)<br>
<strong>Expected Auxiliary Space:</strong> O(1)</span></p>

<p><br>
<span style="font-size:18px"><strong>Constraints:</strong><br>
50 ≤ H ≤ 1000<br>
1 ≤ D &lt; U ≤ 100</span></p>
</div>