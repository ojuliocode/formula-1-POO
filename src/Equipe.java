import java.util.Arrays;

public class Equipe {
    private Carro carro;
    private Piloto[] pilotos = new Piloto[4];
    private Piloto pilotoAtual;
    private String nome;
    private boolean trocarPilotoAtual(int pilotoId){
        for (int i = 0; i < pilotos.length; i++) {
            if(pilotos[i].getId() == pilotoId){
                this.pilotoAtual = pilotos[i];
                return true;
            }
        }

        return false;
    }

    private boolean trocarPneu(int tipoDePneu){
        if(tipoDePneu >= 1 && tipoDePneu <= 5){
            this.carro.setTipoDePneu(tipoDePneu);
            return true;
        }
        return false;
    }

    public void pitStop(int tipoDePneu, int pilotoId){
        boolean pilotoExiste = false;
        for (int i = 0; i < pilotos.length; i++) {
            if(pilotos[i] != null) {
                if (pilotos[i].getId() == pilotoId) {
                    pilotoExiste = true;
                }
            }
        }
        if(!pilotoExiste)
            System.out.println("Piloto não está na lista!");
        else{
            trocarPneu(tipoDePneu);
            trocarPilotoAtual(pilotoId);
        }

    }

    public boolean adicionarPiloto(Piloto piloto){
        boolean equipeCheia = true;

        for (int i = 0; i < pilotos.length; i++) {
            if(pilotos[i] == null) {
                pilotos[i] = piloto;
                equipeCheia = false;
                break;
            }
        }

        if(equipeCheia){
            System.out.println("Equipe cheia");
            return false;
        }
        int newIdGeral = Piloto.getIdGeral() + 1;
        Piloto.setIdGeral(newIdGeral);
        piloto.setId(newIdGeral);
        this.trocarPilotoAtual(piloto.getId());
        return true;
    }

    public boolean retirarPiloto(int pilotoId){

        for (int i = 0; i < pilotos.length; i++) {
            if(pilotos[i] != null) {
                if (pilotos[i].getId() == pilotoId){
                    pilotos[i] = null;
                    Piloto.setIdGeral(Piloto.getIdGeral() - 1);
                    return true;
                }
            }
        }

        return false;
    }

    public void constroiCarro(int tipoDePneu, int potencia, boolean turbo){
        this.carro = new Carro(tipoDePneu, potencia, turbo);
    }

    public Equipe(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Equipe{" +
                "carro=" + carro +
                ", pilotos=" + Arrays.toString(pilotos) +
                ", pilotoAtual=" + pilotoAtual +
                ", nome='" + nome + '\'' +
                '}';
    }

    public Carro getCarro() {
        return carro;
    }
}
