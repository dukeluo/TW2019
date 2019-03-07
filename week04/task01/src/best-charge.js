"use strict";

function turnIntoSelectedItemObj(selectedItemStr, allItems) {
  let [id, count] = selectedItemStr.split(/\s*x\s*/);
  let item = allItems.find(e => e.id === id);
  let cost;

  count = +count;
  cost = count * item.price;
  return Object.assign({}, item, {count, cost});
}


function calculator(selectedItemObjArray, allPromotions) {
  let sum = selectedItemObjArray.reduce((total, curr) => total+curr.cost, 0);
  let op1 = sum;
  let op2 = sum;
  let diff = 0;
  let promotionId = 0; // representative no promotion
  let promotionDescription = "";
  let op2ItemNames = [];

  if (sum >= 30) {
    op1 -= 6;
  }
  selectedItemObjArray.forEach(e => {
    if (allPromotions[1].items.indexOf(e.id) !== -1) {
      op2 -= 0.5 * e.cost;
      op2ItemNames.push(e.name);
    }
  });
  if (op1 <= op2 && op1 < sum) {
    promotionId = 1;
    diff = sum - op1;
    sum = op1;
    promotionDescription = `${allPromotions[0].type}，省${diff}元`;
  } else if (op1 > op2) {
    promotionId = 2;
    diff = sum - op2;
    sum = op2;
    promotionDescription = `${allPromotions[1].type}(${op2ItemNames.join("，")})，省${diff}元`;
  }
  return {
    items: selectedItemObjArray,
    promotionId,
    promotionDescription,
    sum,
    diff
  };
}


function buildBillText(billObj) {
  let itemStr = [];
  let promotionStr = [];
  let billText;

  itemStr = billObj.items.map(e => `${e.name} x ${e.count} = ${e.cost}元`);
  if (billObj.promotionId) {
    promotionStr = ["使用优惠:", billObj.promotionDescription, "-----------------------------------"];
  }
  billText = ["============= 订餐明细 =============",
              ...itemStr,
              "-----------------------------------",
              ...promotionStr,
              `总计：${billObj.sum}元`,
              "==================================="].join("\n");
  return billText;
}


function bestCharge(selectedItems) {
  let items = loadAllItems();
  let promotions = loadPromotions();
  let incorrectFormatItem = selectedItems.some(e => e.indexOf("x") === -1);
  let selectedItemObjArray, billObj;

  if (!items) {
    console.error("Items is null or undefined!");
    return ;
  }
  if (!promotions) {
    console.error("Promotions is null or undefined!");
    return ;
  }
  if (incorrectFormatItem) {
    console.error("Wrong format!");
    return ;
  }
  selectedItemObjArray = selectedItems.map(e => turnIntoSelectedItemObj(e, items));
  billObj = calculator(selectedItemObjArray, promotions);
  return buildBillText(billObj);
}
