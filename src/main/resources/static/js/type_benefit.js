$(document).ready(function () {
// //    page signin
//     $("#signin").on("click", function () {
//         var name = $("#nameInput").val();
//         var pass = $("#passInput").val();
//         (name === "" || pass === "") ? empty() : values(name, pass);
//         function values(someName, somePass) {
//             //send values Nahuy
//             console.log("Name is: " + someName, "\nPassword is: " + somePass);
//             $.ajax({
//                 url: "signin.html",
//                 data: {someName: someName, somePass: somePass},
//                 success: function () {
//                     $("#div").append("Name is: " + someName + "\nPassword is: " + somePass);
//                 }
//             });
//         }
//         function empty() {
//             alert("Empty field(s)!");
//             return false;
//         }
//     });
// //    page signin

// //page searching
//     $("#search").on("click", function () {
//         var search = $("#searchInput").val();
//         (search === "") ? empty() : values(search);
//         function values(someSearch) {
//             //send values Nahuy
//             console.log("You are searching for: " + someSearch);
//             $.ajax({
//                 url: "search.html",
//                 data: {someSearch: someSearch},
//                 success: function () {
//                     $("#div").append("Search is: " + someSearch + "\n");
//                 }
//             });
//         }
//         function empty() {
//             alert("Empty field!");
//             return false;
//         }
//     });
// //    page searching

//populate the modal
    $(this).on("click", "#editButton", function () {
        var tr = $(this).closest("tr");
        var id = $(tr).find("td.id").html();
        var benefitName = $(tr).find("td.benefitName").html();


        var modal = $('#myModal');
        modal.modal();
        $.ajax({
            url: "type_benefit_edit",
            data: {
                id: id
            },
            success: function (answer) {
                modal.find(".modal-body").html(answer)
            }
        })
    });
//populate the modal

// add button
    $(this).on("click", "#addButton", function () {
        var modal = $('#myModal');
        modal.modal();
        $.ajax({
            url: "type_benefit_add",
            success: function (answer) {
                modal.find(".modal-body").html(answer)

                    $("input#benefitName").attr("value", "");
                    $("input#benefitName").attr("placeholder", "input benefitName");

            }
        })
    });
//add button

//save in modal edit
    $("#myModal").on("click", "#sendEdit", function () {
        $.ajax({
            data: {
                id: $("#txtId").val(),
                fio: $("#txtFio").val(),
                spec: $("#txtSpec").val(),
                ben: $("#txtBen").val()
            },
            success: function () {
                alert("save edit");
            }
        });
    });
//save in modal edit

//delete button
    $(this).on("click", "#deleteButton", function () {
        var tr = $(this).closest("tr");
        var id = $(tr).find("td.id").html();
        if (confirm("Delete?")) {
            $.ajax({
                url: "type_benefit_delete",
                data: {
                    id: id
                },
                success: function () {
                    location.reload();
                }
            });
        }

    });
//delete button

// save in modal add
    $("#myModal1").on("click", "#sendEdit", function () {
        $.ajax({
            url: "search.html",
            data: {
                id: $("#txtId").val(),
                fio: $("#txtFio").val(),
                spec: $("#txtSpec").val(),
                ben: $("#txtBen").val()
            },
            success: function () {
                alert("save add");
            }
        });
    });
//save in modal add
});