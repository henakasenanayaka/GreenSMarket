/*thamidu js*/

//let searchForm = document.querySelector('.search-form');
let loginForm = document.querySelector('.login-form');
//let navbar = document.querySelector('.navbar');

//document.querySelector('#search-btn').onclick = () => {
//    searchForm.classList.toggle('active');
    //loginForm.classList.remove('active');
    //navbar.classList.remove('active');
//};

document.querySelector('#login-btn').onclick = () => {
    loginForm.classList.toggle('active');
    //searchForm.classList.remove('active');
    //navbar.classList.remove('active');
};

document.querySelector('#menu-btn').onclick = () => {
    //navbar.classList.toggle('active');
    //searchForm.classList.remove('active');
    //loginForm.classList.remove('active');
};

window.onscroll = () => {
    //searchForm.classList.remove('active');
    //loginForm.classList.remove('active');
    //navbar.classList.remove('active');
};