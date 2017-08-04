 $(document).ready(function () {
        $('#myInput').datepicker({
            format: "dd/mm/yyyy"
        });
    });

var startDate;
var endDate;
$('#dp4').datepicker({
    onStart: function(obj){
        startDate =  obj;
    }
}).on('changeDate', function(ev){
    if (ev.date.getTime() > endDate.getTime()){
        $('#alert').show().find('strong').text('The start date can not be greater then the end date!');
    } else {
        $('#alert').hide();
        startDate = new Date(ev.date);
        $('#startDate').text($('#dp4').data('date'));
    }
    $(this).datepicker('hide');
});
$('#dp5').datepicker({
    onStart: function(obj){
        endDate =  obj;
    }
}).on('changeDate', function(ev){
    if (ev.date.getTime() < startDate.getTime()){
        $('#alert').show().find('strong').text('The end date can not be less then the start date!');
    } else {
        $('#alert').hide();
        endDate = new Date(ev.date);
        $('#endDate').text($('#dp5').data('date'));
    }
    $('#dp5').datepicker('hide');
});


$('#myInput').datepicker();