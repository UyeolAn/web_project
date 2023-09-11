/**
 * ary.js
 */
const myNumbers = [20, 30, 45, 66, 88, 22];
let sum = 0;

for (let num of myNumbers) {
	sum += num;
	console.log(num);
}
console.log(sum);

sum = 0;

myNumbers.forEach((elem, idx) => {
	console.log(`index: ${idx}, value: ${elem}`);
	sum += elem;
});
console.log(sum);

let li;
let txt;
let fruits = ['Apple', 'Banana', 'Cherry'];
fruits.forEach(element => {
	// 배열 원소 추가
	li = document.createElement("li");
	txt = document.createTextNode(element);
	li.appendChild(txt);

	// 버튼 추가(버튼은 개별로 선언해야함)
	let btn = document.createElement("button");
	btn.onclick = function() {
		alert("삭제되었습니다.");
		btn.parentElement.remove();
	}
 	txt = document.createTextNode("삭제");
	btn.appendChild(txt);
	li.appendChild(btn);

	document.querySelector(".fruits").appendChild(li);
});