// page.js
console.log(member1);

let field = 'fullName';
console.log(member1.fullName)
console.log(member2['fullName'])
console.log(member3[field]);

// 배열요소를 반복적으로 for..of
for (let member of members) {
  console.log(`이름은 ${member['fullName']}이고 나이는 ${member['age']} 점수는 ${member['score']}`);
}

// 오브젝트의 속성(필드)을 반복적으로 for..in
for (let prop in member1) {
  console.log(`${prop} => ${member1[prop]}`);
}

// 각 배열요소의 각 필드를 출력.
document.write('<table border=1>');
let fields = ['fullName', 'score', 'age'];
for (let member of members) {
  document.write('<tr>');
  for (let prop of fields) {
    console.log(`${prop} => ${member[prop]}`);
    document.write(`<td>${member[prop]}</td>`);
  }
  document.write('<td><button>클릭</button></td>');
  document.write('</tr>');
  console.log(`--------------------------`)
}
document.write('</table>');