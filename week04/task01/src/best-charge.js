"use strict";

function bestCharge(selectedItems) {
  let items = loadAllItems();
  let promotions = loadPromotions();
  let sum = 0;

  selectedItems = selectedItems.map(function (item) {
    let i;

    item = item.split(/\s*x\s*/);
    i = items.find(function (e) {
      return e.id === item[0];
    });
    item.push(i.name);
    item.push(i.price);
    return item;
  });
  selectedItems.forEach(function (item) {
    sum += (+item[1]) * item[3];
  });


  let op1 = sum;
  let op2 = sum;
  let op2ItemIds = promotions[1].items;
  let op2ItemNames = [];
  let selectedPromotions;
  let diff;

  if (sum >= 30) {
    op1 -= 6;
  }
  selectedItems.forEach(function (item) {
    if (op2ItemIds.indexOf(item[0]) !== -1) {
      op2 -= 0.5 * item[3] * (+item[1]);
      op2ItemNames.push(item[2]);
    }
  });
  if (op1 <= op2 && op1 < sum) {
    selectedPromotions = 0;
    diff = sum - op1;
    sum = op1;
  } else if (op1 > op2) {
    selectedPromotions = 1;
    diff = sum - op2;
    sum = op2;
  }


  let billText = "============= 订餐明细 =============\n";

  selectedItems.forEach(function (item) {
    billText += item[2] + " x " + item[1] + " = " + (+item[1]*item[3]) + "元\n";
  });
  billText += "-----------------------------------\n";
  if (selectedPromotions !== undefined) {
    billText += "使用优惠:\n";
    billText += promotions[selectedPromotions].type;
    if (selectedPromotions === 1) {
      billText += "(" + op2ItemNames.join("，") + ")";
    }
    billText += "，省" + diff + "元\n";
    billText += "-----------------------------------\n";
  }
  billText += "总计：" + sum + "元\n";
  billText += "===================================\n";
  return billText.trim();
}
