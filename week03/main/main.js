module.exports = function main(distance, parkingTime) {
    const START_DISTANCE = 2;
    const START_PRICE = 6;
    const PER_KM_PRICE = 0.8;

    if (distance === 0) {
        return 0;
    }
    if (distance < START_DISTANCE) {
        return START_PRICE;
    }
    return Math.round(START_PRICE + PER_KM_PRICE * (distance - START_DISTANCE));
};
