/**
 * Created by ravi on 11/25/14.
 */
public class AnimalTestMain {

  public static void main(String[] args) {
    Animal cat = new Cat();
    Animal dog = new Dog();
    Animal animal = new Animal();

    new AnimalTester().callAnimalMethods(cat);
    new AnimalTester().callAnimalMethods(dog);
    new AnimalTester().callAnimalMethods(animal);
  }

}
