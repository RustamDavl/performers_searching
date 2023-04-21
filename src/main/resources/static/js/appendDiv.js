var divElement = `
<div class="adding project-preview projects-list__item" style="cursor: pointer;">
<div class="project-preview__container">
    <div class="project-preview__actions">
        <div class="project-preview__tasks">

            <span class="project-preview__tasks-text">Удалить</span>

        </div>
        <div class="project-preview__edit"
            style="cursor: pointer; min-width: auto; margin-right: 1rem;"><span
                class="project-preview__edit-text">Редактировать</span>

        </div>
        <!-- <div class="project-preview__time-zone">PRSN</div> -->
    </div>
    <h2 data-cy="project-card-title" class="project-preview__title">


        <img src="/image/folder-black-interface-symbol_icon-icons.com_54528.png" width="20"
            height="20">

        <span class="project-preview__title-text">Построить теплицу</span>
    </h2>
    <div class="project-preview__location">Россия, г.Казань, село Аврора</div>
</div>
</div> `



//  orderDiv.classList.add("adding");


//  var parentDiv = document.querySelector(".projects-list__grid");

//  parentDiv.appendChild(orderDiv);

//  document.getElementById("addNewTaskBox").addEventListener('click', addTask);

//  function addTask(){

//  }
var orderDiv = document.createElement("div");
document.getElementById("addNewTaskBox").addEventListener('click', () => {

    orderDiv.insertAdjacentHTML("afterbegin", 
    `<div class="adding project-preview projects-list__item" style="cursor: pointer;">
    <div class="project-preview__container">
        <div class="project-preview__actions">
            <div class="project-preview__tasks">
    
                <span class="project-preview__tasks-text">Удалить</span>
    
            </div>
            <div class="project-preview__edit"
                style="cursor: pointer; min-width: auto; margin-right: 1rem;"><span
                    class="project-preview__edit-text">Редактировать</span>
    
            </div>
            <!-- <div class="project-preview__time-zone">PRSN</div> -->
        </div>
        <h2 data-cy="project-card-title" class="project-preview__title">
    
    
            <img src="/image/folder-black-interface-symbol_icon-icons.com_54528.png" width="20"
                height="20">
    
            <span class="project-preview__title-text">Построить теплицу</span>
        </h2>
        <div class="project-preview__location">Россия, г.Казань, село Аврора</div>
    </div>
    </div> 
    `)


});