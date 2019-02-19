"use strict";

let items = loadAllItems();
let promotions = loadPromotions();
let messageDiv = document.getElementById("message");
let checkoutBtn = document.getElementById("checkout");
let clearBtn = document.getElementById("clear");

function buildItemsDivText() {
  let itemsDiv = document.getElementById("items");
  let text = "";

  for (let i = 0; i < items.length; i++) {
    let t = `<div class="singal-item">
              <span>${items[i].name}: ${items[i].price} * </span>
              <input type="number" id=${items[i].id} class="item-quantity" min="0" max="128">
            </div>`;

    text += t;
  }
  itemsDiv.innerHTML = text;
}

function buildPromotionsDivText() {
  let promotionsDiv = document.getElementById("promotions");
  let text = "";

  for (let i = 0; i < promotions.length; i++) {
    let t = `<p>${i+1}. ${promotions[i].type}</p>`;

    text += t;
  }
  promotionsDiv.innerHTML = text;
}

function calculatePrice() {
  let itemInputs = document.getElementsByClassName("item-quantity");
  let input = [];

  for (let i = 0; i < itemInputs.length; i++) {
    let t = "";
    let v = itemInputs[i].value;

    if (+v > 0) {
      t += itemInputs[i].id + " x " + v;
      input.push(t);
    }
  }
  if (input.length) {
    messageDiv.innerHTML = bestCharge(input);
  }
}

function clear() {
  messageDiv.innerHTML = "";
}

checkoutBtn.addEventListener("click", calculatePrice);
clearBtn.addEventListener("click", clear);

buildItemsDivText();
buildPromotionsDivText();
