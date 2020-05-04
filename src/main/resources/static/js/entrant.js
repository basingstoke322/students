$(document).ready(function () {
    $(this).on("click", "#editButton", function () {
        var tr = $(this).closest("tr");
        var id = $(tr).find("td.id").html();
        var spec_name = $(tr).find("td.spec_name").html();
        var spec_cost = $(tr).find("td.spec_cost").html();

        var modal = $('#myModal');
        modal.modal();
        $.ajax({
            url: "entrant_edit",
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
            url: "entrant_add",
            success: function(answer){
                modal.find(".modal-body").html(answer)
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