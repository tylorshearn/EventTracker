window.addEventListener('load', function (evt) {
console.log('script.js loaded');
init();
})

function init() {
    displayDreams();
    event.preventDefault();
    document.newDreamForm.addDream.addEventListener('click', createDream);
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

function createDream(event) {
    event.preventDefault();
    console.log('Adding Dream');
    let form = document.newDreamForm;
    let dream = {
      title: form.title.value,
      isActive: form.isActive.value,
      description: form.description.value,
      userId: form.userId.value,
      effect: form.effect.value,
      kind: form.kind.value,  
    };
    postDream(dream);
  }

  function postDream(dream) {
    console.log('Posting Dream');
    console.log(dream);
  
    let xhr = new XMLHttpRequest();
    xhr.open('POST', 'user/{userId}/dreams');
    xhr.onreadystatechange = function() {
      if (xhr.readyState === 4) {
        if (xhr.status === 201 || xhr.status === 200) {
          let newDream = JSON.parse(xhr.responseText);
          displayDreams(newDream);
        } else {
          displayError('Error creating dream: ' + xhr.status);
        }
      }
    };
  
    xhr.setRequestHeader("Content-type", "application/json");
    xhr.send(JSON.stringify(dream));
  }