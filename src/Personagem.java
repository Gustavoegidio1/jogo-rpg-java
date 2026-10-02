public class Personagem {
    private String nome;
    private int vidaMaxima;
    private int vidaAtual;
    private int ataque1;
    private int ataque2;
    private String nomeAtaque1;
    private String nomeAtaque2;
    private String nomeRecurso;
    private int recursoMax;
    private int recursoAtual;
    private int nivel;
    private int moedas;

    public Personagem(String nome, int vidaMaxima, int ataque1, int ataque2, String nomeAtaque1, String nomeAtaque2, String nomeRecurso, int recursoMax) {
        this.nome = nome;
        this.vidaMaxima = vidaMaxima;
        this.vidaAtual = vidaMaxima;
        this.ataque1 = ataque1;
        this.ataque2 = ataque2;
        this.nomeAtaque1 = nomeAtaque1;
        this.nomeAtaque2 = nomeAtaque2;
        this.nomeRecurso = nomeRecurso;
        this.recursoMax = recursoMax;
        this.recursoAtual = recursoMax;
        this.nivel = 1;
        this.moedas = 100;
    }

    public String getNome() {
        return nome;
    }

    public String getNomeAtaque1() {
        return nomeAtaque1;
    }

    public String getNomeAtaque2() {
        return nomeAtaque2;
    }

    public int atacar1() {
        return ataque1;
    }

    public int getAtaque1() {
        return ataque1;
    }

    public int atacar2() {
        return ataque2;
    }

    public int getAtaque2() {
        return ataque2;
    }

    public int getVidaMaxima() {
        return vidaMaxima;
    }

    public void aumentarVida(int vidaGanha) {
        this.vidaAtual += vidaGanha;

        if (this.vidaAtual > this.vidaMaxima) {
            this.vidaAtual = this.vidaMaxima;
        }
    }

    public void receberDano(int dano) {
        this.vidaAtual -= dano;

        if (this.vidaAtual < 0) {
            this.vidaAtual = 0;
        }
    }

    public int getVidaAtual() {
        return vidaAtual;
    }

    public void aumentarMoedas(int moedasGanhas) {
        this.moedas += moedasGanhas;
    }

    public boolean gastarMoedas(int moedasGastas) {
        if (moedas >= moedasGastas) {
            this.moedas -= moedasGastas;
            return true;
        }
        return false;
    }

    public int getMoedas() {
        return moedas;
    }

    public void aumentarNivel(int niveisGanhos) {
        this.nivel += niveisGanhos;
    }

    public int getNivel() {
        return nivel;
    }

    public void funcionalidadeRodada() {
        System.out.println(getNome() + " ganha 5 de vida");
        aumentarVida(5);
    }

    public int getRecursoMax() {
        return recursoMax;
    }

    public int getRecursoAtual() {
        return recursoAtual;
    }

    public String getNomeRecurso() {
        return nomeRecurso;
    }

    public boolean gastarRecurso(int quantidade) {
        if (recursoAtual >= quantidade) {
            recursoAtual -= quantidade;
            return true;
        }
        return false;
    }

    public boolean aumentarRecurso(int quantidade) {
        if(quantidade > 0) {
            recursoAtual += quantidade;

            if (recursoAtual > recursoMax) {
                recursoAtual = recursoMax;
            }
            return true;
        }

        return false;

    }

    public void restaurarRecurso() {
        this.recursoAtual = recursoMax;
    }

    public void aumentarVidaMax(int quantidade) {
        this.vidaMaxima += quantidade;
    }

    public void zerarRecurso() {
        recursoAtual = 0;
    }

    public void reviver() {
        this.vidaAtual = vidaMaxima;
        restaurarRecurso();
    }
}
