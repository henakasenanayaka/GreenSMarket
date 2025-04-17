let searchForm = document.querySelector('.search-form');
let loginForm = document.querySelector('.login-form');
let navbar = document.querySelector('.navbar');

document.querySelector('#search-btn').onclick = () => {
    searchForm.classList.toggle('active');
    loginForm.classList.remove('active');
    navbar.classList.remove('active');
};

document.querySelector('#login-btn').onclick = () => {
    loginForm.classList.toggle('active');
    searchForm.classList.remove('active');
    navbar.classList.remove('active');
};

document.querySelector('#menu-btn').onclick = () => {
    navbar.classList.toggle('active');
    searchForm.classList.remove('active');
    loginForm.classList.remove('active');
};

window.onscroll = () => {
    searchForm.classList.remove('active');
    loginForm.classList.remove('active');
    navbar.classList.remove('active');
};
function toggleAnswer(id) {
    var answer = document.getElementById(id);
    if (answer.style.display === "block") {
        answer.style.display = "none";
    } else {
        answer.style.display = "block";
    }
}
function editStock(productId) {
    // Implement edit functionality here, e.g., open a modal or redirect to an edit page
    alert('Edit product with ID ' + productId);
}

function deleteStock(productId) {
    // Implement delete functionality here, e.g., show a confirmation dialog
    var confirmDelete = confirm('Are you sure you want to delete product with ID ' + productId + '?');
    if (confirmDelete) {
        // Implement actual delete operation, possibly using AJAX to communicate with the server
        alert('Product deleted');
    }
}

function addStock() {
    // Implement add functionality here, e.g., open a modal or redirect to an add page
    alert('Add new product');
}




