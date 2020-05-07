$(document).ready(function () {

//populate the modal
    $(this).on("click", "#editButton", function () {
        var tr = $(this).closest("tr");
        var id = $(tr).find("td.id").html();
        var modal = $('#myModal');
        modal.modal();
        $.ajax({
            url: "benefit_edit",
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
            url: "benefit_add",
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
                url: "benefit_delete",
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