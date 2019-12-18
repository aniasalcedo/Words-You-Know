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