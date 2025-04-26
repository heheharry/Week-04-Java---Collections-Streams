package Day1.JavaGenerics;
import java.util.*;

interface MealPlan {
    String getMealDetails();
}

class VegetarianMeal implements MealPlan {
    public String getMealDetails() {
        return "Vegetarian Meal: Lentil Soup, Salad, Brown Rice";
    }
}

class VeganMeal implements MealPlan {
    public String getMealDetails() {
        return "Vegan Meal: Tofu Stir Fry, Quinoa, Steamed Broccoli";
    }
}

class KetoMeal implements MealPlan {
    public String getMealDetails() {
        return "Keto Meal: Grilled Chicken, Avocado, Zucchini Noodles";
    }
}

class HighProteinMeal implements MealPlan {
    public String getMealDetails() {
        return "High Protein Meal: Egg Whites, Chicken Breast, Greek Yogurt";
    }
}

class Meal<T extends MealPlan> {
    private T mealType;

    public Meal(T mealType) {
        this.mealType = mealType;
    }

    public T getMealType() {
        return mealType;
    }

    public void showMealPlan() {
        System.out.println(mealType.getMealDetails());
    }
}

class MealPlanGenerator {
    public static <T extends MealPlan> void generateMealPlan(Meal<T> meal) {
        meal.showMealPlan();
    }
}

public class MealPlanner {
    public static void main(String[] args) {
        Meal<VegetarianMeal> vegMeal = new Meal<>(new VegetarianMeal());
        Meal<VeganMeal> veganMeal = new Meal<>(new VeganMeal());
        Meal<KetoMeal> ketoMeal = new Meal<>(new KetoMeal());
        Meal<HighProteinMeal> proteinMeal = new Meal<>(new HighProteinMeal());

        MealPlanGenerator.generateMealPlan(vegMeal);
        MealPlanGenerator.generateMealPlan(veganMeal);
        MealPlanGenerator.generateMealPlan(ketoMeal);
        MealPlanGenerator.generateMealPlan(proteinMeal);
    }
}
