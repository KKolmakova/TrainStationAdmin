"use strict";

let restoreBtn = document.getElementById("restoreBtn");

restoreBtn.addEventListener('change', (evt) => {
  let freeSeats = document.getElementById("freeSeats").value;

  if (freeSeats == 0) {
    catalogItem = document.createElement('div');

    catalogItem.className = 'warning-item';
    catalogItem.innerHTML =
      `
          <div class="alert alert-warning d-flex align-items-center" role="alert">
            <svg class="bi flex-shrink-0 me-2" width="24" height="24" role="img" aria-label="Warning:"><use xlink:href="#exclamation-triangle-fill"/></svg>
            <div>
              An example warning alert with an icon
            </div>
          </div>
      `;
    insertableCatalogList.append(catalogItem);
  }
});
