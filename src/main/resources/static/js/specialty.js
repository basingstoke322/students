$(document).ready(function () {
//populate the modal
    $(this).on("click", "#editButton", function () {
        var tr = $(this).closest("tr");
        var id = $(tr).find("td.id").html();
        var modal = $('#myModal');
        modal.modal();
        $.ajax({
            url: "specialty_edit",
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
            url: "specialty_add",
            success: function (answer) {
                modal.find(".modal-body").html(answer)
                if (modal.find("input#specCost").val() == 0) {
                    $("input#specCost").attr("value", "");
                    $("input#specName").attr("placeholder", "input spec_name");
                    $("input#specCost").attr("placeholder", "input spec_cost");
                }
                $("input#specCost").on("keypress keyup blur", function (event) {
                    $(this).val($(this).val().replace(/[^\d].+/, ""));
                    if ((event.which < 48 || event.which > 57)) {
                        event.preventDefault();
                    }
                });
                $('#myForm').submit(function (e) {
                    e.preventDefault();
                    if (
                        modal.find("input#specName").val() === "" ||
                        modal.find("input#specCost").val() === ""
                    ) {
                        $("input#specName").attr({"class": "is-invalid form-control"});
                        $("input#specCost").attr({"class": "is-invalid form-control"});
                        return false;
                    }
                    $.ajax({
                        method: "POST",
                        data: $('#myForm').serialize(),
                        success: function () {
                            location.reload();
                        }
                    })
                    // return false;
                });
            }
        })
    });
//add button

//delete button
    $(this).on("click", "#deleteButton", function () {
        var tr = $(this).closest("tr");
        var id = $(tr).find("td.id").html();
        if (confirm("Delete?")) {
            $.ajax({
                url: "specialty_delete",
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
})