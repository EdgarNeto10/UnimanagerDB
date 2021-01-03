var courseId;
window.onload = async function () {
    courseId = sessionStorage.getItem("courseId");
    let elem = document.getElementById("units");
    try {
        let course = await $.ajax({
            url: `/api/courses/${courseId}`, 
            method: "get",
             dataType: "json"
        });
        document.getElementById("course").innerHTML = course.nome;
        let html = "";
        for (let plan of course.planoestudos)
            html += `<section onclick='showUnit(${plan.unidade.dis_id})'>
 <section class="sem">${plan.semestre} Sem</section>
 <section class="cre">Credits ${plan.unidade.dis_creditos}</section>
 <h3 class="name">${plan.unidade.dis_nome}</h3>
 </section>`
        elem.innerHTML = html;
    } catch (err) {
        console.log(err);
        elem.innerHTML = "<h1> Page not vailable </h1>";
    }
}
function showUnit(id) {
    sessionStorage.setItem("unitId", id);
    // Next steps here
}