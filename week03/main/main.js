module.exports = function main(distance, parkingTime) {
    const START_DISTANCE = 2;
    const START_PRICE = 6;

    if (distance === 0) {
        return 0;
    }
    if (distance < START_DISTANCE) {
        return START_PRICE;
    }
};
