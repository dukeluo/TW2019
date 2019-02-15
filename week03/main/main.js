function calcCost(quantity, price) {
    return quantity * price;
}

function main(distance, parkingTime) {
    const START_DISTANCE = 2;
    const START_PRICE = 6;
    const PER_KM_PRICE = 0.8;
    const FLAG_DISTANCE = 8;
    const PRICE_INCREASE = 0.5;

    let cost = 0;

    if (distance > 0) {
        cost += START_PRICE;
        distance -= START_DISTANCE;
    }
    if (distance > 0) {
        cost += calcCost(distance, PER_KM_PRICE);
        distance -= FLAG_DISTANCE - START_DISTANCE;
    }
    if (distance > 0) {
        cost += calcCost(distance, PER_KM_PRICE*PRICE_INCREASE);
    }
    return Math.round(cost);
}


module.exports = main;
