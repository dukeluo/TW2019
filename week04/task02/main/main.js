const database = require("./database.js");
const loadAllItems = database.loadAllItems;
const loadPromotions = database.loadPromotions;


/*
 * using an array to record the information that needs to be printed of a item
 *
 * information is recorded in the following order:
 * [name, unit, price, count, cost, freeCount, diff]
 */
function printInventory(inputs) {
    let inputsDataObj = {};
    let items = loadAllItems();
    let promotions = loadPromotions();

    inputs.forEach(function (item) {
        if (item.indexOf("-") !== -1) {
            let a = item.split("-");

            if (inputsDataObj.hasOwnProperty(a[0])) {
                inputsDataObj[a[0]] += (+a[1]);
            } else {
                inputsDataObj[a[0]] = (+a[1]);
            }
        } else {
            if (inputsDataObj.hasOwnProperty(item)) {
                inputsDataObj[item]++;
            } else {
                inputsDataObj[item] = 1;
            }
        }
    });
    for (let barcode in inputsDataObj) {
        let arr = [];
        let item = items.find(function (i) {
            return i.barcode === barcode;
        });
        let count = (+inputsDataObj[barcode]);
        let cost = count * item.price;
        let freeCount = 0;
        let diff = 0;

        if (promotions[0].barcodes.indexOf(barcode) !== -1) {
            freeCount = Number.parseInt(count/3);
            diff = freeCount * item.price;
            cost -= diff;
        }
        arr = arr.concat(item.name, item.unit, item.price, count, cost, freeCount, diff);
        inputsDataObj[barcode] = arr;
    }


    let printedText = "***<没钱赚商店>购物清单***\n";
    let freeText = "";
    let sum = 0;
    let less = 0;

    for (let barcode in inputsDataObj) {
        let item = inputsDataObj[barcode];

        printedText += `名称：${item[0]}，数量：${item[3]}${item[1]}，单价：${item[2].toFixed(2)}(元)，小计：${item[4].toFixed(2)}(元)\n`;
        sum += item[4];
        if (item[6]) {
            freeText += `名称：${item[0]}，数量：${item[5]}${item[1]}\n`;
            less += item[6];
        }
    }
    printedText += "----------------------\n";
    printedText += "挥泪赠送商品：\n";
    printedText += freeText;
    printedText += "----------------------\n";
    printedText += `总计：${sum.toFixed(2)}(元)\n`;
    printedText += `节省：${less.toFixed(2)}(元)\n`;
    printedText += '**********************';
    console.log(printedText);
    return 1;
};


module.exports = printInventory;
