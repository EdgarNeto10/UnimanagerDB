var courseId;
window.onload = async function () {

    // Inserir elementos

    courseId = sessionStorage.getItem("courseId");
    try {
        let course = await $.ajax({
            url: `/api/courses/${courseId}`,
            method: "get",
             dataType: "json"
        });
        
        document.getElementById("course").innerHTML = course.nome;
        
        let existingIds = []; // Lista vazia para entrada de ids existentes. 

        for (let plan of course.planoestudos) existingIds.push(plan.unidade.dis_id);
        
        let html = "";

        let units = await $.ajax({
            url: "/api/units",
             method: "get", 
             dataType: "json"
        });

        for (let unit of units)
            if (!existingIds.includes(unit.dis_id))
                html += `<option value=${unit.dis_id}>
 ${unit.dis_nome} (${unit.dis_creditos} credits) </option>`;
        document.getElementById("unit").innerHTML = html;
    } catch (err) { console.log(err); }
}

//Post

async function add() {
    let unitId = document.getElementById("unit").value; // A pegar o valor do id presente na opção 
    let semester = document.getElementById("semester").value;
    let data = {
        curso: { id: parseInt(courseId)},
        unidade: { dis_id: parseInt(unitId)},
        semestre: parseInt(semester)
        };
    try {
        let result = await $.ajax({
            url: `/api/courses/${courseId}/units`,
            method: "post",
             data: JSON.stringify(data), // A enviar informação json presente na variavel * data *
            dataType: "json",
             contentType: "application/json"
        });

        document.getElementById("result").innerHTML = result.msg;
    } 
    catch (err) { console.log(err); }

}