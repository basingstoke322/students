$(document).ready(function () {
// add button
    $(this).on("click", "#addButton", function () {
        var modal = $('#myModal');
        modal.modal();
        $.ajax({
            url: "blankAddGet",
            success: function (answer) {
                modal.find(".modal-body").html(answer)
                $("input#examResults").on("keypress keyup blur", function (event) {
                    $(this).val($(this).val().replace(/[^\d].+/, ""));
                    if ((event.which < 48 || event.which > 57)) {
                        event.preventDefault();
                    }
                });
                $('#myForm').submit(function (e) {
                    e.preventDefault();
                    if (
                        modal.find("input#firstName").val() === "" ||
                        modal.find("input#lastName").val() === "" ||
                        modal.find("input#otc").val() === ""
                    ) {
                        $("input#firstName").attr({"class": "is-invalid form-control"});
                        $("input#lastName").attr({"class": "is-invalid form-control"});
                        $("input#otc").attr({"class": "is-invalid form-control"});
                        return false;
                    }
                    $.ajax({
                        url: "blankAddPost",
                        method: "POST",
                        data: $('#myForm').serialize(),
                        success: function () {
                            location.reload();
                        }
                    })
                    // return false;
                });
                // return false;
            }
        });
    });
//populate the modal

// add button
    $(this).on("click", "#editButton", function () {
        let id = $(this).closest("tr").find("td.idBlank").html();
        var modal = $('#myModal');
        modal.modal();
        $.ajax({
            url: "BlankEdit",
            data: {
                id: id
            },
            success: function (answer) {
                modal.find(".modal-body").html(answer)
                $('#myForm').submit(function (e) {
                    e.preventDefault();
                    $.ajax({
                        url: "blankAddPost",
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
        var id = $(tr).find("td.idBlank").html();
        if (confirm("Delete?")) {
            $.ajax({
                url: "blank_delete",
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