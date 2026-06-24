class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        ArrayList<Car> cars = new ArrayList();
        for (int i = 0; i < position.length; ++i) {
            cars.add(new Car(position[i], speed[i]));
        }
        cars.sort(Comparator.comparing(Car::getPosition).reversed());
        
        ArrayDeque<Float> stack = new ArrayDeque();
        for (Car car: cars) {
            float t = (1f * target - car.position) / car.speed;
            if (!stack.isEmpty()) {
                if (t > stack.peek()) {
                    stack.push(t);
                }
            } else {            
                stack.push(t);
            }

        }
        return stack.size();
    }

    public class Car {
        int position;
        int speed;
        Car(int position, int speed) {
            this.position = position;
            this.speed = speed;
        }

        int getPosition() {
            return position;
        }
    }
}
