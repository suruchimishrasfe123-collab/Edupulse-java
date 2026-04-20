fetch("http://localhost:8080/EduPulse/students")
.then(res => res.json())
.then(data => {

    let table = document.getElementById("table");

    data.forEach(s => {
        table.innerHTML += `
        <tr>
            <td>${s.name}</td>
            <td>${s.performanceScore}</td>
        </tr>`;
    });

});