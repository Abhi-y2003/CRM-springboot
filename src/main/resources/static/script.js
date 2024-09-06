document.addEventListener("DOMContentLoaded", () => {
    fetchEmployees();

    const form = document.getElementById("employeeForm");
    form.addEventListener("submit", function(event) {
        event.preventDefault();
        addEmployee();
    });
});

function fetchEmployees() {
    fetch("http://localhost:8080/employee")
        .then(response => response.json())
        .then(data => {
            const employeeList = document.getElementById("employeeList");
            employeeList.innerHTML = "";
            data.forEach(employee => {
                const li = document.createElement("li");
                li.className = "employee-card";

                const employeeInfo = document.createElement("div");
                employeeInfo.className = "employee-info";
                employeeInfo.innerHTML = `
                    <span>${employee.name}</span>
                    <span>${employee.email}</span>
                    <span>${employee.phone}</span>
                `;

                const employeeActions = document.createElement("div");
                employeeActions.className = "employee-actions";

                const deleteButton = document.createElement("button");
                deleteButton.textContent = "Delete";
                deleteButton.onclick = () => deleteEmployee(employee.id);

                employeeActions.appendChild(deleteButton);

                li.appendChild(employeeInfo);
                li.appendChild(employeeActions);
                employeeList.appendChild(li);
            });
        });
}

function addEmployee() {
    const name = document.getElementById("name").value;
    const email = document.getElementById("email").value;
    const phone = document.getElementById("phone").value;

    const employee = { name, email, phone };

    fetch("http://localhost:8080/employee", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(employee)
    })
    .then(response => response.text())
    .then(data => {
        alert(data);
        fetchEmployees(); 
        document.getElementById("employeeForm").reset(); 
    });
}

function deleteEmployee(id) {
    fetch(`http://localhost:8080/employee/${id}`, {
        method: "DELETE"
    })
    .then(response => response.text())
    .then(data => {
        alert(data);
        fetchEmployees(); 
    });
}
