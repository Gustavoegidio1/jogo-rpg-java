import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.println("Bem-vindo ao HunterGame!");
        System.out.println("Crie seu Personagem e se Aventure ");

        aventura(teclado, criarPersonagem(teclado));
    }

   public static void aventura(Scanner teclado, Personagem personagem) {
       System.out.println("============================================================================================");
       System.out.println(
           "Sua aventura começa aos pés de uma imponente montanha, no reino de Asrain.\n" +
                   "Você é filho de Brutus, um homem humilde que dedicou sua vida à caça de monstros,\n" +
                   "enfrentando criaturas perigosas para proteger o reino e garantir o sustento de sua família.\n" +
                   "Desde muito jovem, seu pai o treinou para lutar. Anos de batalhas fizeram com que você\n" +
                   "dominasse a arte do combate e aprendeu, da maneira mais difícil, que sobreviver neste mundo\n" +
                   "exige força, coragem e determinação.\n\n" +
                   "Aos 18 anos, porém, você decidiu que não queria seguir o mesmo caminho para sempre.\n" +
                   "Seu desejo era conhecer o mundo, descobrir o que existia além das fronteiras de Asrain\n" +
                   "e construir sua própria história. Mas havia algo que você nunca conseguiu abandonar:\n" +
                   "o gosto pela batalha e a emoção de enfrentar inimigos cada vez mais perigosos.\n\n" +
                   "Foi então que tomou sua decisão. Você se tornaria um caçador de recompensas.\n" +
                   "Seu objetivo seria simples: viajar pelo mundo em busca dos monstros mais temidos,\n" +
                   "dos homens mais perigosos e das recompensas que pudessem transformar sua vida.\n\n" +
                   "E assim, com sua espada em mãos e o mundo inteiro diante de você,\n" +
                   "sua jornada começa..."
       );
       System.out.println(
           "Procurados:\n" +
           "Krave(Viking, conhecido por matar mais de 100 pessoas, conhecido por 'O Demônio Viking'.\n" +
           "Vruts(Bruxa, famosa no reino Tura por envenenar ao rei e toda a sua família, seu apelido 'A Viúva de Sangue'.\n" +
           "Taros(Lobisomem, em noites de lua cheia ataca diversas cidades com grande sede de sangue, chamado de 'O Flagelo da Lua'.\n"
       );

       String nomeKrave = "Krave";
       int vidaKrave = 120;
       if (luta(personagem, teclado, nomeKrave, vidaKrave)) {
           String nomeVruts = "Vruts";
           int vidaVruts = 150;
           if (luta(personagem, teclado, nomeVruts, vidaVruts)) {
               String nomeTaros = "Taros";
               int vidaTaros = 200;
               luta(personagem, teclado, nomeTaros, vidaTaros);
           }
       }
   }

    public static Personagem criarPersonagem (Scanner teclado) {
        System.out.print("Digite o nome do seu Personagem: ");
        String nome = teclado.nextLine();

        int vidaMaxima = lerVida(teclado);
        int ataque1 = lerAtaque1(teclado);
        int ataque2 = lerAtaque2(teclado);

        System.out.print
                ("Opções de Classes:\n" +
                        "1 - Mago\n" +
                        "2 - Guerreiro\n" +
                        "3 - Arqueiro\n" +
                        "Escolha: ");
        int escolha = teclado.nextInt();

        if (escolha == 1) {
            return criarMago(teclado, nome, vidaMaxima, ataque1, ataque2);
        }

        else if (escolha == 2) {
            return criarGuerreiro(teclado, nome, vidaMaxima, ataque1, ataque2);
        }

        else if (escolha == 3) {
            return criarArqueiro(teclado, nome, vidaMaxima, ataque1, ataque2);

        }

        else {
            System.out.println("Classe inexistente!");
            return null;
        }

    }

    public static int lerVida(Scanner teclado) {
        int vidaMaxima;
        do {
            System.out.print("Digite a vida do seu Personagem(mín:50 máx:100): ");
            vidaMaxima = teclado.nextInt();
        } while (vidaMaxima < 50 || vidaMaxima > 100);

        return vidaMaxima;

    }

    public static int lerAtaque1(Scanner teclado) {
        int ataque1;
        do {
            System.out.print("Digite o dano do primeiro ataque(mín:20 máx:40): ");
            ataque1 = teclado.nextInt();
        } while (ataque1 < 20 || ataque1 > 40);
        return ataque1;
    }

    public static int lerAtaque2(Scanner teclado) {
        int ataque2;
        do {
            System.out.print("Digite o dano do segundo ataque(mín:45 máx:60): ");
            ataque2 = teclado.nextInt();
        } while (ataque2 < 45 || ataque2 > 60);
        return ataque2;
    }

    public static Mago criarMago(Scanner teclado, String nome, int vidaMaxima, int ataque1, int ataque2) {
        int mana;
        do {
            System.out.print("Digite a mana do personagem(mín:50 máx:70): ");
            mana = teclado.nextInt();
            teclado.nextLine();
        }while(mana < 50 || mana > 80);
        return new Mago(nome, vidaMaxima, ataque1, ataque2, mana);
    }

    public static Guerreiro criarGuerreiro(Scanner teclado, String nome, int vidaMaxima, int ataque1, int ataque2) {
        int armadura;
        do {
            System.out.print("Digite a resistência da armadura(mín:20 máx:70): ");
            armadura = teclado.nextInt();
            teclado.nextLine();
        } while (armadura < 20 || armadura > 40);
        return new Guerreiro(nome, vidaMaxima, ataque1, ataque2, armadura);
    }

    public static Arqueiro criarArqueiro(Scanner teclado, String nome, int vidaMaxima, int ataque1, int ataque2) {
        int flechas;
        do {
            System.out.print("Digite a quantidade de flechas(mín:5 máx:10): ");
            flechas = teclado.nextInt();
            teclado.nextLine();
        } while (flechas < 5 || flechas > 10);
        return new Arqueiro(nome, vidaMaxima, ataque1, ataque2, flechas);
    }

    public static void menuBatalha(Personagem personagem) {
        System.out.print(
                "Comandos:\n" +
                "R - " + personagem.getNomeAtaque1() + " Dano: " + personagem.getAtaque1() + "\n" +
                "T - " + personagem.getNomeAtaque2() + " Dano: " + personagem.getAtaque2() + "\n" +
                "Y - Defender: Evita totalmente o Dano\n" +
                "Escolha: ");
    }

    public static void comprarPocao(Scanner teclado, Personagem personagem) {
        while(true) {
            System.out.print(
                    "Esta é a loja das Poções:\n" +
                            "1 - Poção pequena: +30 vida - 30 Moedas\n" +
                            "2 - Poção média: +50 vida - 50 Moedas\n" +
                            "3 - Poção grande: Vida Completa - 100 Moedas\n" +
                            "4 - Não comprar\n" +
                            "Escolha: ");
            int escolha = teclado.nextInt();
            teclado.nextLine();

            if (escolha == 1) {
                if (personagem.gastarMoedas(30)) {
                    personagem.aumentarVida(30);
                    return;
                }
                System.out.println("Não possui moedas para esta compra!");
            } else if (escolha == 2) {
                if (personagem.gastarMoedas(50)) {
                    personagem.aumentarVida(50);
                    return;
                }
                System.out.println("Não possui moedas para esta compra!");
            } else if (escolha == 3) {
                if (personagem.gastarMoedas(100)) {
                    personagem.aumentarVida(100);
                    return;
                }
                System.out.println("Não possui moedas para esta compra!");
            }

            else if (escolha == 4) {
                return;
            }
            else {
                System.out.println("Opção inválida!");
            }
        }
    }

    public static String escolhaAtaque(Scanner teclado, Vilao vilao, Personagem personagem) {
        while(true) {
            menuBatalha(personagem);
            String escolha = teclado.nextLine();
            if (escolha.equals("R") || escolha.equals("r")) {
                System.out.println("Ataque: " + personagem.getNomeAtaque1());
                int dano = personagem.atacar1();

                if (dano > 0) {
                    vilao.receberDano(dano);
                    return "ataque";
                }
            }
            else if (escolha.equals("T") || escolha.equals("t")) {
                System.out.println("Ataque: " + personagem.getNomeAtaque2());
                int dano = personagem.atacar2();

                if (dano > 0) {
                    vilao.receberDano(dano);
                    return "ataque";
                }
            }
            else if (escolha.equals("Y") || escolha.equals("y")) {
                System.out.println(personagem.getNome() + " se Defendeu.");
                return "defesa";
            }

            System.out.println("Opção Inválida!");
            continue;
        }
    }

    public static boolean luta(Personagem personagem, Scanner teclado, String nomeVilao, int vidaVilao) {
        while (true) {
            Vilao vilao = new Vilao(nomeVilao, vidaVilao);
            System.out.println("Luta: " + vilao.getNome());
            do {
                String escolha = escolhaAtaque(teclado, vilao, personagem);
                if (escolha.equals("defesa")) {
                    System.out.println(vilao.getNome() + " não causa dano");
                }

                else if (escolha.equals("ataque")) {
                    personagem.receberDano(vilao.atacar());
                    System.out.println(vilao.getNome() + " causa 20 de dano");
                }

                personagem.funcionalidadeRodada();

                if (vilao.getVidaAtual() > 0 && personagem.getVidaAtual() > 0) {
                    painelLuta(vilao, personagem);
                }

            } while (vilao.getVidaAtual() > 0 && personagem.getVidaAtual() > 0);

            if (vilao.getVidaAtual() <= 0) {
                recompensasVitoria(vilao, personagem, teclado);
                personagem.restaurarRecurso();
                return true;
            }
            else {
                if(derrota(teclado)) {
                    personagem.reviver();
                    continue;
                }
            }
        }
    }

    public static void painelLuta(Vilao vilao, Personagem personagem) {
        System.out.println("Vida " + vilao.getNome() + ": " + vilao.getVidaAtual() + "/" + vilao.getVidaMaxima());
        System.out.println("Vida " + personagem.getNome() + ": " + personagem.getVidaAtual() + "/" + personagem.getVidaMaxima());
        System.out.println(personagem.getNomeRecurso() + ": " + personagem.getRecursoAtual() + "/" + personagem.getRecursoMax());
        System.out.println("=========================");
    }

    public static void recompensasVitoria(Vilao vilao, Personagem personagem, Scanner teclado) {
        System.out.println("Você derrotou " + vilao.getNome());
        personagem.aumentarMoedas(50);
        personagem.aumentarNivel(5);
        personagem.aumentarVidaMax(20);
        System.out.println(
                "Por derrotar " + vilao.getNome() + " você recebe 50 moedas, aumenta 5 níveis e aumenta 20 de vida máxima\n" +
                        "Total de Moedas: " + personagem.getMoedas() + "\n" +
                        "Nível: " + personagem.getNivel() + "\n" +
                        "Vida Máxima: " + personagem.getVidaMaxima());
        comprarPocao(teclado,personagem);
    }

    public static boolean derrota(Scanner teclado) {
        System.out.println("Game Over!");
        System.out.print("Deseja começar a luta novamente(s/n): ");
        String escolhaReinicio = teclado.nextLine();
        if (escolhaReinicio.equals("s")) {
            return true;
        }
        else {
            System.out.println("Jogo Finalizado");
            return false;
        }
    }
}