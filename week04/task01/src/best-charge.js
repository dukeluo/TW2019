"use strict";

function turnIntoSelectedItemObj(selectedItemStr, allItems) {
  let [id, count] = selectedItemStr.split(/\s*x\s*/);
  let item = allItems.find(e => e.id === id);
  let cost;

  count = +count;
  cost = count * item.price;
  return Object.assign({}, item, {count, cost});
}


function sumOfPromotionOne(selectedItemObjArray, originalSum, promotion) {
  if (originalSum >= 30) {
    return {
      items: selectedItemObjArray,
      promotionId: 1,
      promotionDescription: `${promotion.type}，省6元`,
      sum: originalSum - 6,
      diff: 6
    };
  }
  return ;
}


function sumOfPromotionTwo(selectedItemObjArray, originalSum, promotion) {
  let discountedItemObjArray = selectedItemObjArray.filter(e => promotion.items.indexOf(e.id) !== -1);

  if (discountedItemObjArray.length) {
    let diff = discountedItemObjArray.reduce((total, curr) => total+0.5*curr.cost, 0);

    return {
      items: selectedItemObjArray,
      promotionId: 2,
      promotionDescription: `${promotion.type}(${discountedItemObjArray.map(e => e.name).join("，")})，省${diff}元`,
      sum: originalSum - diff,
      diff
    };
  }
  return ;
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


  let selectedItemObjArray = selectedItems.map(e => turnIntoSelectedItemObj(e, items));
  let originalSum = selectedItemObjArray.reduce((total, curr) => total+curr.cost, 0);
  let sumOption1 = sumOfPromotionOne(selectedItemObjArray, originalSum, promotions[0]);
  let sumOption2 = sumOfPromotionTwo(selectedItemObjArray, originalSum, promotions[1]);
  let billObj;

  if (!sumOption1 && !sumOption2) {
    billObj = {
      items: selectedItemObjArray,
      promotionId: 0,   // representative no promotion
      promotionDescription: "",
      sum: originalSum,
      diff: 0
    }
  } else {
    billObj = sumOption1.diff >= sumOption2.diff ? sumOption1 : sumOption2;
  }
  return buildBillText(billObj);
}
