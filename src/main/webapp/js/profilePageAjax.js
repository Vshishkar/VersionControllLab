$(document).ready(function(){
        $.ajax({url: "create_rep", success: function(result){
                $(".repository-list").html(result);
            }
        });
});