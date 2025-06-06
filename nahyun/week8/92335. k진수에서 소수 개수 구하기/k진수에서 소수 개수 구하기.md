# [level 2] k진수에서 소수 개수 구하기 - 92335 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/92335) 

---

### 문제 설명

<h5>문제 설명</h5>

<p>양의 정수 <code>n</code>이 주어집니다. 이 숫자를 <code>k</code>진수로 바꿨을 때, 변환된 수 안에 아래 조건에 맞는 소수(Prime number)가 몇 개인지 알아보려 합니다.</p>

<ul>
<li><code>0P0</code>처럼 소수 양쪽에 0이 있는 경우</li>
<li><code>P0</code>처럼 소수 오른쪽에만 0이 있고 왼쪽에는 아무것도 없는 경우</li>
<li><code>0P</code>처럼 소수 왼쪽에만 0이 있고 오른쪽에는 아무것도 없는 경우</li>
<li><code>P</code>처럼 소수 양쪽에 아무것도 없는 경우</li>
<li>단, <code>P</code>는 각 자릿수에 0을 포함하지 않는 소수입니다.

<ul>
<li>예를 들어, 101은 <code>P</code>가 될 수 없습니다.</li>
</ul></li>
</ul>

<p>예를 들어, 437674을 3진수로 바꾸면 <code>211</code>0<code>2</code>01010<code>11</code>입니다. 여기서 찾을 수 있는 조건에 맞는 소수는 왼쪽부터 순서대로 211, 2, 11이 있으며, 총 3개입니다. (211, 2, 11을 <code>k</code>진법으로 보았을 때가 아닌, 10진법으로 보았을 때 소수여야 한다는 점에 주의합니다.) 211은 <code>P0</code> 형태에서 찾을 수 있으며, 2는 <code>0P0</code>에서, 11은 <code>0P</code>에서 찾을 수 있습니다.</p>

<p>정수 <code>n</code>과 <code>k</code>가 매개변수로 주어집니다. <code>n</code>을 <code>k</code>진수로 바꿨을 때, 변환된 수 안에서 찾을 수 있는 <strong>위 조건에 맞는 소수</strong>의 개수를 return 하도록 solution 함수를 완성해 주세요.</p>

<hr>

<h5>제한사항</h5>

<ul>
<li>1 ≤ <code>n</code> ≤ 1,000,000</li>
<li>3 ≤ <code>k</code> ≤ 10</li>
</ul>

<hr>

<h5>입출력 예</h5>
<table class="table">
        <thead><tr>
<th>n</th>
<th>k</th>
<th>result</th>
</tr>
</thead>
        <tbody><tr>
<td>437674</td>
<td>3</td>
<td>3</td>
</tr>
<tr>
<td>110011</td>
<td>10</td>
<td>2</td>
</tr>
</tbody>
      </table>
<hr>

<h5>입출력 예 설명</h5>

<p><strong>입출력 예 #1</strong></p>

<p>문제 예시와 같습니다. </p>

<p><strong>입출력 예 #2</strong></p>

<p>110011을 10진수로 바꾸면 110011입니다. 여기서 찾을 수 있는 조건에 맞는 소수는 11, 11 2개입니다. 이와 같이, 중복되는 소수를 발견하더라도 모두 따로 세어야 합니다.</p>

<h5>문제가 잘 안풀린다면😢</h5>

<p>힌트가 필요한가요? [코딩테스트 연습 힌트 모음집]으로 오세요! → <a href="https://school.programmers.co.kr/learn/courses/14743?itm_content=lesson92335" target="_blank" rel="noopener">클릭</a></p>


> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges

---

### 알고리즘

**k진수로 바꾸는 방법**<br>
1. n을 k로 계속 나누며 나머지를 쭉 나열한다.
2. n을 k로 나누었을 때의 몫이 0이 되면, 마지막으로 나머지를 넣어준다.
3. 나열했던 나머지를 역순으로 바꾼다.

**예제**<br>
47을 3진수로 바꿔보자! <br>
47 % 3 = 2, 47 / 3 = 15<br>
15 % 3 = 0, 15 / 3 = 5 (몫이 0일 때가 아니므로 계속 해야함!)<br>
5 % 3 = 2, 5 / 3 = 1<br>
1 % 3 = 1, 1 / 3 = 0<br><br>

나머지들을 순서대로 나열하면 `2021` 인데, 이 수를 역순으로 뒤집어주면 `1202`가 나오고,  <br>
이게 바로 n의 k진수이다.<br>

---

조건을 보면 `0`의 사이거나, `0`의 앞이거나, `0`의 뒤거나... `0`을 기준으로 하는 조건들이다.  <br>
`0`의 인덱스를 구한 후, 문자열의 가장 처음부터 `0` 전까지의 문자를 자른다.  <br>
자른 문자가 소수인지 판단한 후, 그 수는 문자열에서 없애준다.  <br>
그러면 앞 뒤를 검사할 필요 없이 그냥 `0`만 찾아주면 된다.<br>

**예제**<br>
`110011`을 검사해보자!<br><br>

1. `0`의 인덱스를 찾는다: `2`
2. 처음부터 `0` 앞까지의 문자열을 자른다: `"11"`
3. `"11"`은 소수인가? → `true` → `result++`
4. 처음부터 방금 찾은 `0`의 인덱스까지 자른다: `110`이 잘리고, `"011"` 남음
5. `0`의 인덱스를 찾는다: `0`
6. 처음부터 `0` 앞까지의 문자열을 자른다: `""` (비어있음)
7. 소수인가? → `false`
8. 처음부터 방금 찾은 `0`의 인덱스까지 자른다: `"11"`

...

이런 식으로 반복하면 된다!<br><br>

**소수판별함수**<br>
이건 간단해서 생략ㅎㅎ
