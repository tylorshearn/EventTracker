window.addEventListener('load', function (evt) {
console.log('script.js loaded');
init();
})

function init() {
    loadDreams();
}

function loadDreams() {
    let xhr = new XMLHttpRequest();
    xhr.open('GET', 'api/dreams');
    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4) {
            if (xhr.status === 200) {
                let dreams = JSON.parse(xhr.responseText)
                displayDreams(dreams);
            }
            else {
                displayError('Error retrieving dreams: ' + xhr.status);
            }
        }
    };

    xhr.send();
}

function displayError(msg) {
    let div = document.getElementById('error');
    let h1 = document.createElement('h3');
    h1.textContent = msg;
    div.appendChild(h1)
}

function displayDreams(dreams) {
    let div = document.getElementById('dreamTable');
    for (const dream of dreams) {
        let li = document.createElement('li');
        li.textContent = dream.title;
        div.appendChild(li);
    }
}