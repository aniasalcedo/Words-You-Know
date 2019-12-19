function myFunction() {
  var input, filter, table, tr, td, i, txtValue;
  input = document.getElementById("myInput");
  filter = input.value.toUpperCase();
  table = document.getElementById("myTable");
  tr = table.getElementsByTagName("tr");
  for (i = 0; i < tr.length; i++) {
    tdCol1 = tr[i].getElementsByTagName("td")[0];
    tdCol2 = tr[i].getElementsByTagName("td")[1];
    if (tdCol1 || tdCol2) {
      txtValueCol1 = tdCol1.textContent || tdCol1.innerText;
      txtValueCol2 = tdCol2.textContent || tdCol2.innerText;
      if ((txtValueCol1.toUpperCase().indexOf(filter) > -1) ||
      (txtValueCol2.toUpperCase().indexOf(filter) > -1)){
        tr[i].style.display = "";
      } else {
        tr[i].style.display = "none";
      }
    }
  }
}

var selectedForDeletion = []; // [  ]
function doClick(event, id, word) {
    console.log('tr clicked');
    console.log('what word though?')
    console.log('id ', id, ' word =>', word);
    console.log('here is the event', event)
    if (selectedForDeletion.length >= 1) {
        selectedForDeletion = [];
    };
    selectedForDeletion.push(id);
    console.log('after sfd', selectedForDeletion)
}

function doDelete(event) {
    console.log('selected to delete =>');
    console.log(selectedForDeletion) // [ id_num ]
}