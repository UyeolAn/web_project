/**
 * objAry.js
 */
const mem1 = {
  name: "안우열",
  age: 25,
  phone: "010-4806-9966"
};
const mem2 = {
  name: "김륜형",
  age: 25,
  phone: "010-5163-2028"
};
const mem3 = {
  name: "배승호",
  age: 25,
  phone: "010-8014-2323"
};
const mem4 = {
  name: "김태현",
  age: 25,
  phone: "010-3047-4211"
};
const members = [mem1, mem2, mem3, mem4];

let target = document.querySelector("#memberList>tbody");
members.forEach(member => {
  // 속성값 추가
  let tr = document.createElement("tr");
  for (let prop in member) {
    let td = document.createElement("td");
    td.innerText = member[prop];
    tr.appendChild(td);
  }

  // 삭제버튼 추가
  let td = document.createElement("td");
  let delBtn = document.createElement("button");
  delBtn.innerText = "삭제";
  delBtn.onclick = () => {
    td.parentElement.remove();
    alert("삭제되었습니다");
  };
  td.appendChild(delBtn);
  tr.appendChild(td);

  // tbody 에 붙이기
  target.appendChild(tr);
});

document.querySelectorAll("#memberList>tbody>tr").forEach((tr) => {
  tr.addEventListener("mouseover", () => {
    tr.setAttribute("style", "background: #eee");
  });
  tr.addEventListener("mouseout", () => {
    tr.setAttribute("style", "background: white");
  });
});

document.querySelector("#add").addEventListener("click", () => {
  let tr = document.createElement("tr");
  tr.addEventListener("mouseover", () => {
    tr.setAttribute("style", "background: #eee");
  });
  tr.addEventListener("mouseout", () => {
    tr.setAttribute("style", "background: white");
  });

  // 속성값 추가
  const member = {
    name: document.getElementById("name").value,
    age: document.getElementById("age").value,
    phone: document.getElementById("phone").value
  };
  for (let prop in member) {
    let td = document.createElement("td");
    td.innerText = member[prop];
    tr.appendChild(td);
  }

  // 삭제버튼 추가
  let td = document.createElement("td");
  let delBtn = document.createElement("button");
  delBtn.innerText = "삭제";
  delBtn.onclick = () => {
    td.parentElement.remove();
    alert("삭제되었습니다");
  };
  td.appendChild(delBtn);
  tr.appendChild(td);

  // tbody 에 붙이기
  target.appendChild(tr);
});