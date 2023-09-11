/**
 * obj.js
 */
let name = "Hong"; // string
let age = 20; // number
let obj = {
  name,
  age,
  phone: '010-1111-1111',
  showInfo: function () {
    return this.name + ", " + this.age;
  }
}

console.log(obj.name);
console.log(obj.age);
console.log(obj.phone);
console.log(obj.showInfo());

obj.hobbis = ['reading', 'eating', 'sleeping'];

for (let prop in obj) {
  console.log(`속성 : ${prop}, 값: ${obj[prop]}`);
}

console.log(obj.hobbis[0]);

let li;
let txt;
for (let hobby of obj.hobbis) {
  li = document.createElement("li");
  txt = document.createTextNode(hobby);
  li.appendChild(txt);
  document.getElementById("myHobby").appendChild(li);
}
