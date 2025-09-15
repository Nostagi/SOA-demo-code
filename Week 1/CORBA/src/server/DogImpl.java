package serverService;

import MessageApp.*;
import org.omg.CORBA.*;

public class DogImpl extends DogPOA{
    private ORB orb;
    private Dog mrD = new Dog();

    public void setORB(ORB orb_val) {
        orb = orb_val;
    }

    @Override 
    public void setDog(String name, String kind, String hairColor, int age) {
        System.out.println("Server receive a request of setting new Dog");
        System.out.println("Dog Info:");
        System.out.println("Name: " + name);
        System.out.println("Kind: " + kind);
        System.out.println("Hair Color: " + hairColor);
        System.out.println("Age: " + age);
        System.out.println();

        mrD = new Dog(name, kind, hairColor, age);
    }

    // Getter/Setter
    @Override
    public String getName() { 
        System.out.println("Client request to get " + mrD.getName() + " name!\n");
        return mrD.getName(); }
    @Override
    public void setName(String name) { 
        System.out.println("Client request to set " + mrD.getName() + " as " + name + "!\n");
        mrD.setName(name); 
    }

    @Override
    public String getKind() { 
        System.out.println("Client request to get " + mrD.getName() + " kind!\n");
        return mrD.getKind(); 
    }
    @Override
    public void setKind(String kind) { 
        System.out.println("Client request to set " + mrD.getName() + " as a" + kind + " dog!\n");
        mrD.setKind(kind);}

    @Override
    public String getHairColor() { 
        System.out.println("Client request to get " + mrD.getName() + " hair color!\n");
        return mrD.getHairColor(); 
    }
    @Override
    public void setHairColor(String color) { 
        System.out.println("Client request to set " + mrD.getName() + " as a" + color + " dog!\n");
        mrD.setHairColor(color); 
    }

    @Override
    public int getAge() { 
        System.out.println("Client request to get " + mrD.getName() + " age!\n");
        return mrD.getAge(); 
    }
    @Override
    public void setAge(int age) { 
        System.out.println("Client request to set " + mrD.getName() + " as a" + age + " dog!\n");
        mrD.setAge(age); 
    }

    // Behaviors
    @Override
    public String bark() {
        System.out.println("Client want " + mrD.getName() + " to BARK!\n");
        return mrD.bark();
    }

    @Override
    public String walk() {
        System.out.println("Client want " + mrD.getName() + " to WALK!\n");
        return mrD.walk();
    }

    @Override
    public String playCatch(String item) {
        System.out.println("Client want " + mrD.getName() + " to PLAY CATCH with a/an " + item + "\n");
        return mrD.playCatch(item);
    }
}

class Dog {
    private String name = null;
    private String kind = null;
    private String hairColor = null;
    private int age = 0;

    public Dog() {}

    public Dog(String name, String kind, String hairColor, int age) {
        this.name = name;
        this.kind = kind;
        this.hairColor = hairColor;
        this.age = age;
    }

    // Getter/Setter
    public String getName() {
        if (this.name != null) return this.name;
        return "This Dog don't have a name yet!!!";
    }

    public void setName(String name) { this.name = name; }

    public String getKind() {
        if (this.kind != null) return kind; 
        return "Sorry, we still don't know which kind the dog is!!!";
    }

    public void setKind(String kind) { this.kind = kind; }

    public String getHairColor() { 
        if (this.hairColor != null) return hairColor;
        return "Sorry, we still don't know which color the dog is!!!" ;
    }
    
    public void setHairColor(String color) { this.hairColor = color; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    // Hành vi
    public String bark() {
        return name + " the " + kind + " says: Woof! Woof!";
    }

    public String walk() {
        return name + " is walking around happily.";
    }

    public String playCatch(String item) {
        return name + " is playing catch with a " + item + ".";
    }
}
