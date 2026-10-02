public class Mago extends Personagem{

    public Mago(String nome, int vida, int ataque1, int ataque2, int recurso) {
       super(nome, vida, ataque1, ataque2, "Chama Arcana", "Ruína Elemental", "Mana", recurso);
    }

    @Override
   public int atacar1() {

       if(gastarRecurso(20)) {
           return getAtaque1();
       }

       System.out.println("Mana insuficiente, este ataque tem custo 20!");
       return 0;
   }

   @Override
   public int atacar2() {
       if(gastarRecurso(40)) {
           return getAtaque2();
       }

       System.out.println("Mana insuficiente, este ataque tem custo 40!");
       return 0;
   }

   @Override
   public void funcionalidadeRodada() {
       System.out.println(getNome() + " ganha 10 de mana");
       aumentarRecurso(10);
   }

}
