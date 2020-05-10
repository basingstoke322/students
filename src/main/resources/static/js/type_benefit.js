$(document).ready(function () {
//populate the modal
    $(this).on("click", "#editButton", function () {
        var tr = $(this).closest("tr");
        var id = $(tr).find("td.id").html();
        var modal = $('#myModal');
        modal.modal();
        $.ajax({
            url: "type_benefit_edit",
            data: {
                id: id
            },
            success: function (answer) {
                modal.find(".modal-body").html(answer)
                $("#exampleModalLabel").text("Изменить");
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
                $("#exampleModalLabel").text("Добавить");
                    $("input#benefitName").attr("value", "");
                    $("input#benefitName").attr("placeholder", "Наименование");
                $('#myForm').submit(function (e) {
                    e.preventDefault();
                    if (
                        modal.find("input#benefitName").val() === ""
                    ) {
                        $("input#benefitName").attr({"class": "is-invalid form-control"});
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

//delete button
    $(this).on("click", "#deleteButton", function () {
        var tr = $(this).closest("tr");
        var id = $(tr).find("td.id").html();
        if (confirm("Удалить данную запись?")) {
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
});