//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Equipe equipe = new Equipe("Grifinória");
        Piloto piloto1 = new Piloto("Harry Potter", 23, "Inglês");
        Piloto piloto2 = new Piloto("Draco", 22, "Inglês");

        equipe.adicionarPiloto(piloto1);
        System.out.println(equipe.toString());

        equipe.constroiCarro(3, 2400, true);
        System.out.println(equipe.getCarro().toString());

        equipe.adicionarPiloto(piloto2);
        equipe.pitStop(1, piloto2.getId());
        System.out.println(equipe.toString());

        equipe.retirarPiloto(piloto1.getId());
        System.out.println(equipe.toString());

        Piloto piloto3 = new Piloto("Luna", 30, "Inglesa");
        Piloto piloto4 = new Piloto("Rony", 24, "Inglês");

        equipe.adicionarPiloto(piloto3);
        equipe.adicionarPiloto(piloto4);

        Piloto piloto5 = new Piloto("Hermione", 23, "Inglesa");
        equipe.adicionarPiloto(piloto5);

        Piloto piloto6 = new Piloto("Cedrico", 20, "Inglês");
        equipe.adicionarPiloto(piloto6);
    }
}