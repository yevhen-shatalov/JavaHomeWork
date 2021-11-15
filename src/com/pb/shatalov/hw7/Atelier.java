package com.pb.shatalov.hw7;

public class Atelier {

    public static void main(String[] args) throws Exception {

        Tshirt tshirt = new Tshirt(Size.M, 50, "yellow");
        Pants pants = new Pants(Size.S, 40, "green");
        Skirt skirt = new Skirt(Size.S, 30, "blue");
        Tie tie = new Tie(Size.XS, 10, "brown");

        Clothes[] clothes = new Clothes[]{tshirt, pants, skirt, tie};
        System.out.println("Мужская одежда");
        dressMan(clothes);
        System.out.println("Женская одежда");
        dressWomen(clothes);
    }

    public static void dressMan(Clothes... clothes) {
        for (Clothes cloth : clothes) {
            if (cloth instanceof ManClothes) {
                System.out.println(cloth);
            }
        }
    }

    public static void dressWomen(Clothes... clothes) {
        for (Clothes cloth : clothes) {
            if (cloth instanceof WomenClothes) {
                System.out.println(cloth);
            }
        }
    }
}