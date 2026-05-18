package fr.univ_amu.iut.exercice4;

/// Exercice 4 - Replace Conditional with Polymorphism.
///
/// Cette classe `Animal` a un champ `type` (une [String]...) et une méthode
/// [#faireDuBruit()] qui est un gros `switch` sur ce type. Chaque fois qu'on
/// ajoute une espèce, il faut modifier le switch - et risque d'oublier un cas.
///
/// Smells présents :
///
/// - **Type Code** : le champ `type` est un String alors qu'il représente une
///   énumération fermée (chien, chat, vache, canard)
/// - **Switch Statements** : le switch duplique la logique "qui fait quel bruit"
/// - **Shotgun Surgery** : ajouter une nouvelle espèce demande de modifier
///   potentiellement plusieurs méthodes (ici uniquement `faireDuBruit()`, mais
///   imaginez si on ajoute `nourrir()`, `dormir()`, etc.)
///
/// Refactoring attendu : **Replace Conditional with Polymorphism**. Transformer
/// `Animal` en classe abstraite, créer `Chien`, `Chat`, `Vache`, `Canard` qui
/// héritent et redéfinissent `faireDuBruit()`. Le switch disparaît ; la JVM
/// s'occupe du dispatch. On garde un point d'entrée `Animal.creer(type, nom)`
/// qui retourne la bonne sous-classe, pour les appelants qui ne connaissent que
/// le type sous forme de String.
public abstract class Animal {

  private final String nom;

  public Animal(String nom) {
    this.nom = nom;
  }

  public String getNom() {
    return nom;
  }

  public static Animal creer(String type, String nom) {
    Animal thisAnimal;
    switch (type) {
      case "chien":
        thisAnimal = new Chien(nom);
        break;
      case "chat":
        thisAnimal = new Chat(nom);
        break;
      case "vache":
        thisAnimal = new Vache(nom);
        break;
      case "canard":
        thisAnimal = new Canard(nom);
        break;
      default:
        throw new IllegalStateException("Type inconnu : " + type);
    }
    return thisAnimal;
  }

  // Retourne le cri de l'animal selon son type.
  public abstract String faireDuBruit();
}
