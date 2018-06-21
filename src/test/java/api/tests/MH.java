package api.tests;

import org.apache.commons.lang3.builder.CompareToBuilder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.*;

class Car<Make, Model, Color, Year, Price, Rating, MPG> {
    private String Make;
    private String Model;
    private String Color;
    private Integer Year;
    private Double Price;
    private Double Rating;
    private Integer MPG;

    public Car(String make, String model, String color, Integer year, Double price, Double rating, Integer MPG) {
        Make = make;
        Model = model;
        Color = color;
        Year = year;
        Price = price;
        Rating = rating;
        this.MPG = MPG;
    }

    public String getMake() {
        return Make;
    }

    public String getModel() {
        return Model;
    }

    public String getColor() {
        return Color;
    }

    public Double getPrice() {
        return Price;
    }

    public Double getRating() {
        return Rating;
    }

    public Integer getMPG() {
        return MPG;
    }

    public Integer getYear() {

        return Year;
    }

    @Override
    public String toString() {
        return "Car{" +
                "Make='" + Make + '\'' +
                ", Model='" + Model + '\'' +
                ", Color='" + Color + '\'' +
                ", Year=" + Year +
                ", Price=" + Price +
                ", Rating='" + Rating + '\'' +
                ", MPG='" + MPG + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Car<?, ?, ?, ?, ?, ?, ?> car = (Car<?, ?, ?, ?, ?, ?, ?>) o;

        return new EqualsBuilder()
                .append(Make, car.Make)
                .append(Model, car.Model)
                .append(Price, car.Price)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(Make)
                .append(Model)
                .append(Price)
                .toHashCode();
    }
}

public class MH {
    public static void main(String[] args) {
        Comparator<Car<String, String, String, Integer, Double, Double, Integer>> COMPARE_YEAR = new Comparator<Car<String, String, String, Integer, Double, Double, Integer>>() {
            @Override
            public int compare(Car<String, String, String, Integer, Double, Double, Integer> o1, Car<String, String, String, Integer, Double, Double, Integer> o2) {

                return new CompareToBuilder()
                        .append(o2.getYear(), o1.getYear())
                        .append(o1.getMake(), o2.getMake())
                        .append(o1.getModel(), o2.getModel()).toComparison();
            }
        };
        Comparator<Car<String, String, String, Integer, Double, Double, Integer>> COMPARE_PRICE = new
                Comparator<Car<String, String, String, Integer, Double, Double, Integer>>() {
                    @Override
                    public int compare(Car<String, String, String, Integer, Double, Double, Integer> o1, Car<String, String, String, Integer, Double, Double, Integer> o2) {
                        if (o1.getPrice() < o2.getPrice()) return -1;
                        else if (o1.getPrice() > o2.getPrice()) return 1;
                        return 0;
                    }
                };
        Comparator<Car<String, String, String, Integer, Double, Double, Integer>> COMPARE_MODEL = new
                Comparator<Car<String, String, String, Integer, Double, Double, Integer>>() {
                    @Override
                    public int compare(Car<String, String, String, Integer, Double, Double, Integer> o1, Car<String, String, String, Integer, Double, Double, Integer> o2) {
                        return new CompareToBuilder()
                                .append(o1.getMake(), o2.getMake())
                                .append(o1.getModel(), o2.getModel()).toComparison();
                    }
                };
        Comparator<Car<String, String, String, Integer, Double, Double, Integer>> COMPARE_MAKE = new
                Comparator<Car<String, String, String, Integer, Double, Double, Integer>>() {
                    @Override
                    public int compare(Car<String, String, String, Integer, Double, Double, Integer> o1, Car<String, String, String, Integer, Double, Double, Integer> o2) {
                        int res = String.CASE_INSENSITIVE_ORDER.compare(o1.getMake(), o2.getMake());
                        if (res == 0) {
                            res = o1.getMake().compareTo(o2.getMake());
                        }
                        return res;
                    }
                };
        Comparator<Car<String, String, String, Integer, Double, Double, Integer>> COMPARE_VALUE = new
                Comparator<Car<String, String, String, Integer, Double, Double, Integer>>() {
                    @Override
                    public int compare(Car<String, String, String, Integer, Double, Double, Integer> o1, Car<String, String, String, Integer, Double, Double, Integer> o2) {
                        double value1 = ((o1.getPrice() + ((2018 + o1.getYear())) * 500) / o1.getRating());
                        double value2 = ((o2.getPrice() + ((2018 + o2.getYear())) * 500) / o2.getRating());
                        if (value1 < value2) return -1;
                        else if (value2 < value1) return 1;

                        return 0;
                    }
                };
        Comparator<Car<String, String, String, Integer, Double, Double, Integer>> COMPARE_MPG = new
                Comparator<Car<String, String, String, Integer, Double, Double, Integer>>() {
                    @Override
                    public int compare(Car<String, String, String, Integer, Double, Double, Integer> o1, Car<String, String, String, Integer, Double, Double, Integer> o2) {
                        return new CompareToBuilder()
                                .append(o2.getMPG(), o1.getMPG())
                                .append(o1.getMake(), o2.getMake())
                                .append(o1.getModel(), o2.getModel()).toComparison();
                    }
                };
        Comparator<Car<String, String, String, Integer, Double, Double, Integer>> COMPARE_YEAR_ONLY = new
                Comparator<Car<String, String, String, Integer, Double, Double, Integer>>() {
                    @Override
                    public int compare(Car<String, String, String, Integer, Double, Double, Integer> o1, Car<String, String, String, Integer, Double, Double, Integer> o2) {

                        return new CompareToBuilder()
                                .append(o2.getYear(), o1.getYear()).toComparison();
                    }
                };
        System.out.println("11111111111111111111111111111111 COMPARING YEAR THEN ALPHABETICAL ORDER " +
                "1111111111111111111111111111");

        for (Car element : MH.compareCars(
                (Car<String, String, String, Integer, Double, Double, Integer> o1,
                                           Car<String, String, String, Integer, Double, Double, Integer> o2) -> {
            if (o1.getPrice() < o2.getPrice()) return -1;
            else if (o1.getPrice() > o2.getPrice()) return 1;
            return 0;
                }
        )
        {
            System.out.println();
        }
        System.out.println("2222222222222222222222222 COMPARING MODEL THEN ALPHABETICAL ORDER " +
                "2222222222222222222222222222");
        for (Car element : MH.compareCars(COMPARE_MODEL)) {
            System.out.println(element);
        }

        System.out.println("33333333333333333333333333333333333 COMPARING PRICE THEN ALPHABETICAL ORDER " +
                "3333333333333333333333333333333333333");
        for (Car element : MH.compareCars(COMPARE_PRICE)) {
            System.out.println(element);
        }
        System.out.println("444444444444444444444444444444444 COMPARING VALUE THEN ALPHABETICAL ORDER " +
                "44444444444444444444444444444444444444444444444");
        for (Car element : MH.compareCars(COMPARE_VALUE)) {
            System.out.println(element);
        }
        System.out.println("555555555555555555555555555555555 COMPARING MPG THEN ALPHABETICAL ORDER " +
                "55555555555555555555555555555555555555555555");
        for (Car element : MH.compareCars(COMPARE_MPG)) {
            System.out.println(element);
        }
        System.out.println("66666666666666666666666666666 RANDOM CAR THEN ALPHABETICAL ORDER " +
                "6666666666666666666666666666666666");
        Set random = new HashSet();
        random.addAll(MH.compareCars(COMPARE_MAKE));
        Iterator it = random.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
            break;
        }
        System.out.println("77777777777777777777 COMPARING MPG BY YEAR THEN MODEL  " +
                "77777777777777777777777777");
//       // Set mpgByYear = (TreeSet)CarValue.compareCars(COMPARE_MAKE);
//        Iterator go = mpgByYear.iterator();
//        List<Map<Integer,Double>> averages = new ArrayList<>();
//        for (Car element : CarValue.compareCars(COMPARE_VALUE)) {
//            System.out.println(element);
//        }

    }



    private static Set<Car<String, String, String, Integer, Double, Double, Integer>> compareCars(Comparator compare) {
        Set<Car<String, String, String, Integer, Double, Double, Integer>> cars = new TreeSet<>(compare);


        cars.add(new Car<String, String, String, Integer, Double, Double, Integer>("Honda", "CRV", "Green", 2016,
                23845.00, 8.0, 33));
        cars.add(new Car<String, String, String, Integer, Double, Double, Integer>("Ford", "Escape", "Red", 2017, 23590.00, 7.8, 32));

        cars.add(new Car<String, String, String, Integer, Double, Double, Integer>("Hyundai", "Santa Fe", "Grey", 2016,
                24950.00, 8.0, 27));

        cars.add(new Car<String, String, String, Integer, Double, Double, Integer>("Mazda", "CX-5", "Red", 2017,
                21795.00, 8.0, 35));
        cars.add(new Car<String, String, String, Integer, Double, Double, Integer>("Subaru", "Forester", "Blue", 2016,
                22395.00, 8.4, 32));
        //cars.add(null);


        return cars;
    }
}
