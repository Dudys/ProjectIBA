$(function() {

    $.validator.setDefaults({
        errorClass: 'help-block',
        highlight: function (element) {
            $(element)
                .closest('.form-group')
                .addClass('has-error')
        },
        unhighlight: function (element) {
            $(element)
                .closest('.form-group')
                .removeClass('has-error')
        }
    });
   
    $("#form").validate({
        rules: {
            firstname: {
                required: true,
                lettersonly: true,
                minlength: 1,
                maxlength: 60
            },
            lastname: {
                required: true,
                lettersonly: true,
                minlength: 1,
                maxlength: 60
            },
            birthdate: {
                required: true
            }
        },
        messages: {
            firstname: {
                required: 'First name cannot be empty.',
                lettersonly: 'First name cannot contain any number.',
                minlength: 'First name must have at least 1 character',
                maxlength: 'First name cannot have more more than 60 characters'
            },
            lastname: {
                required: 'Last name cannot be empty.',
                lettersonly: 'Last name cannot contain any number.',
                minlength: 'Last name must have at least 1 character',
                maxlength: 'Last name cannot have more more than 60 characters'
            },
            birthdate: {
                required: "Birth date cannot be empty"
            }
        }
    });
    
});