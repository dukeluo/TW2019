const database = require("./database.js");
const loadAllItems = database.loadAllItems;
const loadPromotions = database.loadPromotions;


function fixedTwoDec(num) {
    return num.toFixed(2);
}


function tidyInput(inputs) {
    return inputs.sort().reduce((countMap, item) => {
        if (item.indexOf("-") !== -1) {
            let [name, count] = item.split("-");

            countMap[name] = +count;
        } else {
            countMap[item] = ++countMap[item] || 1;
        }
        return countMap;
    }, {});
}


function turnIntoPrintedObjArray(countMap, allItems, allPromotions) {
    let objArray = [];
    let buyTwoOneFreeBarcodes = allPromotions[0].barcodes;

    for( [barcode, count] of Object.entries(countMap)) {
        let {name, unit, price} = allItems.find(e => e.barcode === barcode);
        let cost = price * count;
        let freeCount = 0;
        let diff = 0;

        if (buyTwoOneFreeBarcodes.indexOf(barcode) !== -1) {
            freeCount = Number.parseInt(count/3);
            diff = freeCount * price;
            cost -= diff;
        }
        objArray.push({barcode, name, unit, price, count, cost, freeCount, diff});
    }
    return objArray;
}


function buildBillText(printedObjArray) {
    let itemStr = printedObjArray.map(e => `名称：${e.name}，数量：${e.count}${e.unit}，单价：${fixedTwoDec(e.price)}(元)，小计：${fixedTwoDec(e.cost)}(元)`);
    let freeStr = printedObjArray.filter(e => e.freeCount > 0)
                                 .map(e => `名称：${e.name}，数量：${e.freeCount}${e.unit}`);
    let {sum, less} = printedObjArray.reduce((auxObj, curr) => {
        auxObj.sum += curr.cost;
        auxObj.less += curr.diff;
        return auxObj;
    }, {sum: 0, less: 0});

    if (freeStr.length) {
        freeStr = ["挥泪赠送商品：", ...freeStr, "----------------------"];
    }
    return ["***<没钱赚商店>购物清单***",
            ...itemStr,
            "----------------------",
            ...freeStr,
            `总计：${fixedTwoDec(sum)}(元)`,
            `节省：${fixedTwoDec(less)}(元)`,
            `**********************`].join("\n");
}


function printInventory(inputs) {
    let items = loadAllItems();
    let promotions = loadPromotions();

    if (!items) {
        console.error("Items is null or undefined!");
        return ;
    }
    if (!promotions) {
        console.error("Promotions is null or undefined!");
        return ;
    }
    if (!inputs || !inputs.length) {
        console.error("Input useless!");
        return ;
    }

    let array = turnIntoPrintedObjArray(tidyInput(inputs), items, promotions);
    let text = buildBillText(array);

    console.log(text);
    return 1;
}


module.exports = printInventory;
