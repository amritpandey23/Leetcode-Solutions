class ParkingSystem {
    int maxBig;
    int maxMedium;
    int maxSmall;
    int big;
    int medium;
    int small;

    public ParkingSystem(int big, int medium, int small) {
        this.maxBig = big;
        this.maxMedium = medium;
        this.maxSmall = small;
        this.big = 0;
        this.medium = 0;
        this.small = 0;
    }
    
    public boolean addCar(int carType) {
        switch(carType) {
            case 1:
                if (maxBig == big) {
                    return false;
                } else {
                    big++;
                    return true;
                }
            case 2:
                if (maxMedium == medium) {
                    return false;
                } else {
                    medium++;
                    return true;
                }
            case 3:
                if (maxSmall == small) {
                    return false;
                } else {
                    small++;
                    return true;
                }
        }
        return false;
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */