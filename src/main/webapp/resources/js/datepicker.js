$(function() {
    $('#birthdate').datepicker({
        dateFormat: 'd.m.yy',
        changeMonth: true,
        changeYear: true,
        minDate: new Date((new Date()).getFullYear() - 100, 1 - 1, 1),
        maxDate: new Date(),
        required: true
    });
});