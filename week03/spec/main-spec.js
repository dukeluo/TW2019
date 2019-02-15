const main = require('../main/main');

describe('taxi fee', function () {
    it("returns the number 0 when given 0 km distance and 0 min parking wait", function () {
        let distance = 0;
        let parkingTime = 0;
        let result = main(distance, parkingTime);

        expect(result).toEqual(0);
    });
});
