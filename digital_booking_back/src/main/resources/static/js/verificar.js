console.log("Si esta funcando");
const url = window.location.origin;
console.log(url);
const queryString = window.location.search;
console.log(queryString);
const urlParams = new URLSearchParams(queryString);
console.log(urlParams);
const code = urlParams.get('code');
console.log(code);
completo = url + "/api/usuarios/verificar/" + code;
console.log(completo);
window.location.replace(completo);