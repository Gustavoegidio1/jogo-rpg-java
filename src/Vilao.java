public class Vilao {
    private String nome;
    private int vidaMaxima;
    private int vidaAtual;

    public Vilao(String nome, int vidaMaxima) {
        this.nome = nome;
        this.vidaMaxima = vidaMaxima;
        this.vidaAtual = vidaMaxima;
    }

    public void receberDano(int dano) {
        if(dano > 0) {
            this.vidaAtual -= dano;

            if (this.vidaAtual < 0) {
                this.vidaAtual = 0;
            }
        }
    }

    public String getNome() {
        return nome;
    }

    public int getVidaMaxima(){
        return vidaMaxima;
    }

    public int getVidaAtual() {
        return vidaAtual;
    }

    public int atacar() {
        return 20;
    }
}
