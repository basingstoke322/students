$(document).ready(function () {
    $(this).on("click", "#editButton", function () {
        let modal = $('#myModal');
        modal.modal();
        $.ajax({
            url: "entrant_edit",
            data: {
                id: $(this).closest("tr").find("td.id").html()
            },
            success: function (answer) {
                $("#exampleModalLabel").text("EDITING");
                modal.find(".modal-body").html(answer)
                $('#divBlank').hide();
                $.ajax({
                    url: "BlankEdit",
                    data: {
                        id: $("select#blank").val(),
                    },
                    success: function (ans) {
                        modal.find("#myDiv").html(ans)
                        $("#myForm").css({
                            "display": "inline-block",
                            "border": "dashed",
                            "width": "470.8px"
                        });

                        $('#myForm').submit(function (e) {
                            e.preventDefault();
                            $.ajax({
                                url: "blankAddPost",
                                data: $('#myForm').serialize(),
                                success: function () {
                                    console.log("Save edit");
                                    $('select#blank option[value="' + $("select#blank").val() + '"]').attr('selected', 'selected');
                                }
                            });
                        })
                    }
                });
            }
        })
    });
//populate the modal

// add button
    $(this).on("click", "#addButton", function () {
        var modal = $('#myModal');
        modal.modal();
        $.ajax({
            url: "blank_cond",
            success: function (answer) {
                modal.find(".modal-body").html(answer);
                $("#exampleModalLabel").text("Добавить");
                $('button#blank').click(function () {
                    $.ajax({
                        url: "entrant_add",
                        success: function (answer) {
                            modal.find(".modal-body").html(answer)
                            $('#myForm').submit(function (e) {
                                e.preventDefault();
                                $.ajax({
                                    url: "blankAddPost",
                                    method: "POST",
                                    data: $('#myForm').serialize(),
                                    success: function () {
                                    }
                                })
                                // return false;
                            });
                        }
                    })
                })
                $('button#new_blank').click(function () {
                    $.ajax({
                        url: "blankAddGet",
                        method: "GET",
                        success: function (answer) {
                            $("#exampleModalLabel").text("Добавить");
                            modal.find(".modal-body").html(answer)
                            $("input#examResults").on("keypress keyup blur", function (event) {
                                $(this).val($(this).val().replace(/[^\d].+/, ""));
                                if ((event.which < 48 || event.which > 57)) {
                                    event.preventDefault();
                                }
                            });
                            $("#myForm").css({
                                "display": "inline-block",
                                "border": "dashed",
                                "width": "470.8px"
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
                                    success: function (ans) {
                                        let idAnswer = ans;
                                        console.log("id is " + idAnswer + "\n");
                                        $("#myForm").hide();
                                        $.ajax({
                                            url: "entrant_add",
                                            success: function (answer) {
                                                modal.find(".modal-body").html(answer)
                                                $('select#blank option[value="' + idAnswer + '"]').attr('selected', 'selected');
                                            }
                                        })
                                    }
                                })
                                // return false;
                            });
                            // return false;
                        }
                    });
                })
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
                url: "entrant_delete",
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