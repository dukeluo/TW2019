const main = require('../main/main');

describe('taxi fee', function () {
    it("returns the number 0 when given 0 km distance and 0 min parking wait", function () {
        let distance = 0;
        let parkingTime = 0;
        let result = main(distance, parkingTime);

        expect(result).toEqual(0);
    });

    it("returns the number 6 when given 1 km distance and 0 min parking wait", function () {
        let distance = 1;
        let parkingTime = 0;
        let result = main(distance, parkingTime);

        expect(result).toEqual(6);
    });

    it("returns the number 9 when given 6 km distance and 0 min parking wait", function () {
        let distance = 6;
        let parkingTime = 0;
        let result = main(distance, parkingTime);

        expect(result).toEqual(9);
    });

    it("returns the number 13 when given 10 km distance and 0 min parking wait", function () {
        let distance = 10;
        let parkingTime = 0;
        let result = main(distance, parkingTime);

        expect(result).toEqual(13);
    });
});
