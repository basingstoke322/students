$(document).ready(function () {
//populate the modal
    $(this).on("click", "#editButton", function () {
        var tr = $(this).closest("tr");
        var id = $(tr).find("td.id").html();
        var modal = $('#myModal');
        modal.modal();
        $.ajax({
            url: "type_education_edit",
            data: {
                id: id
            },
            success: function(answer){
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
            url: "type_education_add",
            success: function(answer){
                modal.find(".modal-body").html(answer)
                    $("input#educName").attr("value", "");
                    $("input#educName").attr("placeholder", "input educName");
                $('#myForm').submit(function (e) {
                    e.preventDefault();
                    if (
                        modal.find("input#educName").val() === ""
                    ) {
                        $("input#educName").attr({"class": "is-invalid form-control"});
                        return false;
                    }
                    $.ajax({
                        method: "POST",
                        data: $('#myForm').serialize(),
                        success: function () {
                            location.reload();
                        }
                    })
                });
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
                url: "type_education_delete",
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


//save in modal add
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



})