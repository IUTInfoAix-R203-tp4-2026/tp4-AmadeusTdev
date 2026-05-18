package fr.univ_amu.iut.exercice5;

public record MessageEmail(
    String destinataire,
    String expediteur,
    String sujet,
    String corps,
    boolean important,
    int priorite,
    String[] piecesJointes) {

  public String envoyer() {
    StringBuilder sb = new StringBuilder();
    if (important) {
      sb.append("[IMPORTANT] ");
    }
    sb.append("[P").append(priorite).append("] ");
    sb.append("De: ").append(expediteur).append(", A: ").append(destinataire).append("\n");
    sb.append("Sujet: ").append(sujet).append("\n");
    sb.append("Corps: ").append(corps);
    if (piecesJointes != null && piecesJointes.length > 0) {
      sb.append("\nPieces jointes: ");
      for (int i = 0; i < piecesJointes.length; i++) {
        if (i > 0) sb.append(", ");
        sb.append(piecesJointes[i]);
      }
    }
    return sb.toString();
  }
}
