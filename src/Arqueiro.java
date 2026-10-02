public class Arqueiro extends Personagem{

    public Arqueiro(String nome, int vidaMaxima, int ataque1, int ataque2,  int quantidadeFlechas) {
        super(nome, vidaMaxima, ataque1, ataque2, "Flecha Sombria", "Tiro do Predador","Flechas", quantidadeFlechas);
    }

    @Override
    public int atacar1() {
        if(gastarRecurso(2)) {
            return getAtaque1();
        }

        System.out.println("Flechas insuficientes, este ataque tem custo 2!");
        return 0;
    }

    @Override
    public int atacar2() {
        if(gastarRecurso(4)) {
            return getAtaque2();
        }

        System.out.println("Flechas insuficientes, este ataque tem custo 4!");
        return 0;
    }

    @Override
    public void funcionalidadeRodada() {
        System.out.println(getNome() + " ganha 1 flecha");
        aumentarRecurso(1);
    }
}
