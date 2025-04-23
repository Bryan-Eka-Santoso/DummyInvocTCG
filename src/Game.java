import java.util.*;
public class Game {
    public static void displayMenu1(Boolean menuInPLay){
        if(menuInPLay){
            System.out.println("== Dummy Invoc TCG ==");
            System.out.println("> Play");
            System.out.println("Exit");
        } else if(!menuInPLay){
            System.out.println("== Dummy Invoc TCG ==");
            System.out.println("Play");
            System.out.println("> Exit");
        }
    }

    public static int toInt(char angka){
        return Character.getNumericValue(angka);
    }

    public static void cekCard(char card,  ArrayList<Card> cardPlayer){
        if(card == '1'){
            cardPlayer.add(new Pyro("Pyro Maniac", "Fire", 10, false, "PM", 0));
        } else if(card == '2'){
            cardPlayer.add(new Atlantic("Atlantic Siren", "Water", 10, false, "AS", 0));
        } else if(card == '3'){
            cardPlayer.add(new Stone("Stone Golem", "Flora", 10, false, "SG", 0));
        } else if(card == '4'){
            cardPlayer.add(new Holy("Holy Paladin", "Light", 10, false, "HP", 0));
        } else if(card == '5'){
            cardPlayer.add(new Grim("Grim Reaper", "Dark", 10, false, "GR", 0));
        }
    }

    public static void formatCard(ArrayList<Card> cardPlayer){
            System.out.println("+----+ +----+ +----+");
            System.out.printf("| %2d | | %2d | | %2d |%n", cardPlayer.get(0).hp, cardPlayer.get(1).hp, cardPlayer.get(2).hp);
            System.out.println("| " + cardPlayer.get(0).inisial + " | | " + cardPlayer.get(1).inisial + " | | " + cardPlayer.get(2).inisial + " |");
            System.out.printf("| %2d | | %2d | | %2d |%n", cardPlayer.get(0).skillPoint, cardPlayer.get(1).skillPoint, cardPlayer.get(2).skillPoint);
            System.out.println("+----+ +----+ +----+");
    }

    public static int shuffleDadu(int actCard, int[] daduPlayer, Random rand){
        int dadu = 0;
        for(int i = 0; i < 4; i++){
            daduPlayer[actCard]++;
            dadu++;
        }
        while(dadu < 10){
            int dapatJenisDadu = rand.nextInt(5);
            daduPlayer[dapatJenisDadu]++;
            dadu++;
        }
        return dadu;
    }

    public Game(){
        Scanner scanI = new Scanner(System.in);
        Scanner scanS = new Scanner(System.in);
        Random rand = new Random();

        String menu1;
        int actCard1 = 0;
        int actCard2 = 0;
        Boolean menuInPlay = true;
        Boolean isExit = false;

        ArrayList<Card> cardPlayer1 = new ArrayList<>();
        ArrayList<Card> cardPlayer2 = new ArrayList<>();
        String[] elemen = {"Fire", "Water", "Flora", "Light", "Dark"};
        
        while (!isExit) {
            int[] daduPlayer1 = {0, 0, 0, 0, 0};
            int[] daduPlayer2 = {0, 0, 0, 0, 0};
            displayMenu1(menuInPlay);
            menu1 = scanS.nextLine();
            if(menu1.equals("s")){
                menuInPlay = false;
            } else if(menu1.equals("w")){
                menuInPlay = true;
            } else if(menu1.isEmpty()){
                if(menuInPlay){
                    // Player 1
                    String pilihCard1;
                    Boolean isPilihCard1 = false;
                    char card1 = ' ';
                    char card2 = ' ';
                    char card3 = ' ';
                    while (!isPilihCard1) {
                        System.out.println("Choose 3 Cards for Player 1: ");
                        System.out.println("1. Pyro Maniac - Fire");
                        System.out.println("2. Atlantic Siren - Water");
                        System.out.println("3. Stone Golem - Flora");
                        System.out.println("4. Holy Palladin - Light");
                        System.out.println("5. Grim Reaper - Dark");
                        System.out.print(">> ");
                        pilihCard1 = scanS.nextLine();
                        if(pilihCard1.length() == 7){
                            card1 = pilihCard1.charAt(0);
                            card2 = pilihCard1.charAt(3);
                            card3 = pilihCard1.charAt(6);
                        }
                        if(card1 == ' ' || card2 == ' ' || card3 == ' '){
                            System.out.println("You must choose 3 cards. No more, no less.");
                        } else if((toInt(card1) < 1 || toInt(card1) > 5) || (toInt(card2) < 1 || toInt(card2) > 5) || (toInt(card3) < 1 || toInt(card3) > 5)){
                            System.out.println("Invalid card choice(s). Please choose card numbers between 1 and 5.");
                        } else if(card1 == card2 || card1 == card3 || card2 == card3){
                            System.out.println("There are duplicate card choices.");
                        } else {
                            isPilihCard1 = true;
                        }
                    }
                    int pilihCardAct1;
                    Boolean isPilihCardAct1 = false;
                    cekCard(card1, cardPlayer1);
                    cekCard(card2, cardPlayer1);
                    cekCard(card3, cardPlayer1);
                    while (!isPilihCardAct1) {
                        System.out.println("Player 1, choose your active card: ");
                        for(int i = 0; i < cardPlayer1.size(); i++){
                            System.out.println((i + 1) + ". " + cardPlayer1.get(i).nameCard);
                        }
                        System.out.print(">> ");
                        pilihCardAct1 = scanI.nextInt();
                        if(pilihCardAct1 < 1 || pilihCardAct1 > cardPlayer1.size()){
                            System.out.println("Invalid input!");
                        } else {
                            cardPlayer1.get(pilihCardAct1-1).isActive = true;
                            actCard1 = pilihCardAct1-1;
                            isPilihCardAct1 = true;
                        }
                    }
                    // Player 2
                    String pilihCard2;
                    Boolean isPilihCard2 = false;
                    char card4 = ' ';
                    char card5 = ' ';
                    char card6 = ' ';
                    while (!isPilihCard2) {
                        System.out.println("Choose 3 Cards for Player 2: ");
                        System.out.println("1. Pyro Maniac - Fire");
                        System.out.println("2. Atlantic Siren - Water");
                        System.out.println("3. Stone Golem - Flora");
                        System.out.println("4. Holy Palladin - Light");
                        System.out.println("5. Grim Reaper - Dark");
                        System.out.print(">> ");
                        pilihCard2 = scanS.nextLine();
                        if(pilihCard2.length() == 7){
                            card4 = pilihCard2.charAt(0);
                            card5 = pilihCard2.charAt(3);
                            card6 = pilihCard2.charAt(6);
                        }
                        if(card4 == ' ' || card5 == ' ' || card6 == ' '){
                            System.out.println("You must choose 3 cards. No more, no less.");
                        } else if((toInt(card4) < 1 || toInt(card4) > 5) || (toInt(card5) < 1 || toInt(card5) > 5) || (toInt(card6) < 1 || toInt(card6) > 5)){
                            System.out.println("Invalid card choice(s). Please choose card numbers between 1 and 5.");
                        } else if(card4 == card5 || card4 == card6 || card5 == card6){
                            System.out.println("There are duplicate card choices.");
                        } else {
                            isPilihCard2 = true;
                        }
                    }
                    int pilihCardAct2;
                    Boolean isPilihCardAct2 = false;
                    cekCard(card4, cardPlayer2);
                    cekCard(card5, cardPlayer2);
                    cekCard(card6, cardPlayer2);
                    while (!isPilihCardAct2) {
                        System.out.println("Player 2, choose your active card: ");
                        for(int i = 0; i < cardPlayer2.size(); i++){
                            System.out.println((i + 1) + ". " + cardPlayer2.get(i).nameCard);
                        }
                        System.out.print(">> ");
                        pilihCardAct2 = scanI.nextInt();
                        if(pilihCardAct2 < 1 || pilihCardAct2 > cardPlayer2.size()){
                            System.out.println("Invalid input!");
                        } else {
                            cardPlayer2.get(pilihCardAct2-1).isActive = true;
                            actCard2 = pilihCardAct2-1;
                            isPilihCardAct2 = true;
                        }
                    }
                    // In Game
                    Boolean isExitGame = false;
                    Boolean isPlayer1Win = false;
                    Boolean isPlayer2Win = false;
                    Boolean useEndTurn = false;
                    int round = 1;
                    int turn = 0;
                    int inputPlay;
                    int dadu1 = shuffleDadu(actCard1, daduPlayer1, rand);
                    int dadu2 = shuffleDadu(actCard2, daduPlayer2, rand);
                    while (!isExitGame && !isPlayer1Win && !isPlayer2Win) {
                        System.out.println("====================");
                        System.out.println("       Round " + round + "      ");
                        System.out.println("====================");
                        System.out.println("Player 2");
                        System.out.println("Active Card: " + cardPlayer2.get(actCard2).nameCard);
                        formatCard(cardPlayer2);
                        System.out.println();
                        formatCard(cardPlayer1);
                        System.out.println("Player 1");
                        System.out.println("Active Card: " + cardPlayer1.get(actCard1).nameCard);
                        System.out.println("====================");
                        if(turn % 2 == 0){
                            System.out.println("Turn: Player 1");
                            System.out.println("Dice Left: " + dadu1);
                            for(int i = 0; i < daduPlayer1.length; i++){
                                if(daduPlayer1[i] != 0){
                                    System.out.println("- " + daduPlayer1[i] + " " + elemen[i]);
                                }
                            }
                        } else {
                            System.out.println("Turn: Player 2");
                            System.out.println("Dice Left: " + dadu2);
                            for(int i = 0; i < daduPlayer2.length; i++){
                                if(daduPlayer2[i] != 0){
                                    System.out.println("- " + daduPlayer2[i] + " " + elemen[i]);
                                }
                            }
                        }
                        System.out.println("====================");
                        System.out.println("[1] Switch [2] Attack");
                        System.out.println("[3] Skill  [4] End Turn");
                        System.out.print(">> ");
                        inputPlay = scanI.nextInt();
                        if(inputPlay == 22){
                            if(turn % 2 == 0){
                                cardPlayer1.get(actCard1).skillPoint += 5;
                            } else {
                                cardPlayer2.get(actCard2).skillPoint += 5;
                            }
                            System.out.println("Give +5 Skill Points to the active card.");
                        } else if(inputPlay == 11){
                            if(turn % 2 == 0){
                                Boolean isActive = true;
                                int randKartu;
                                do {
                                    randKartu = rand.nextInt(3);
                                    if(cardPlayer1.get(randKartu).isActive == false){
                                        isActive = false;
                                    }
                                } while (isActive);
                                cardPlayer1.get(randKartu).hp = 0;
                            } else {
                                Boolean isActive = true;
                                int randKartu;
                                do {
                                    randKartu = rand.nextInt(3);
                                    if(cardPlayer2.get(randKartu).isActive == false){
                                        isActive = false;
                                    }
                                } while (isActive);
                                cardPlayer2.get(randKartu).hp = 0;
                            }
                            System.out.println("Reduce the HP of one of the currently active player's cards to 0.");
                        } else if(inputPlay == 99){
                            isExitGame = true;
                        } else if(inputPlay == 1){
                            if(turn % 2 == 0){
                                int menuSwitch;
                                do {
                                    System.out.println("Choose a new Active Card: ");
                                    for(int i = 0; i < cardPlayer1.size(); i++){
                                        if(cardPlayer1.get(i).isActive){
                                            System.out.println((i + 1) + ". " + cardPlayer1.get(i).nameCard + " <active>");
                                        } else {
                                            System.out.println((i + 1) + ". " + cardPlayer1.get(i).nameCard);
                                        }
                                    }
                                    System.out.print(">> ");
                                    menuSwitch = scanI.nextInt();
                                    if(menuSwitch-1 == actCard1){
                                        System.out.println("This is the current active card. Choose again");
                                    }
                                } while (menuSwitch < 1 || menuSwitch > cardPlayer1.size() || menuSwitch-1 == actCard1);
                                int pilihElemen;
                                System.out.println("Choose which dice to consume: ");
                                int j = 0;
                                int[] angkaPilih = {0, 0, 0, 0, 0};
                                for(int i = 0; i < daduPlayer1.length; i++){
                                    if(daduPlayer1[i] != 0){
                                        j++;
                                        System.out.println("[" + (j) + "] " + elemen[i] + " (" + daduPlayer1[i] + ")");
                                        angkaPilih[i] = j;
                                    }
                                }
                                System.out.println("0. Back");
                                do {                                    
                                    System.out.print(">> ");
                                    pilihElemen = scanI.nextInt();
                                } while (pilihElemen < 0 || pilihElemen > j);
                                if(pilihElemen != 0){
                                    for(int i = 0; i < angkaPilih.length; i++){
                                        if(angkaPilih[i] == pilihElemen){
                                            daduPlayer1[i] -= 1;
                                            dadu1--;
                                        }
                                    }
                                    cardPlayer1.get(actCard1).isActive = false;
                                    actCard1 = menuSwitch-1;
                                    cardPlayer1.get(actCard1).isActive = true;
                                    System.out.println("Successfully switched to " + cardPlayer1.get(actCard1).nameCard);
                                    if(useEndTurn){
                                        turn+=2;
                                    } else {
                                        turn++;
                                    }
                                }
                            } else {
                                int menuSwitch;
                                do {
                                    System.out.println("Choose a new Active Card: ");
                                    for(int i = 0; i < cardPlayer2.size(); i++){
                                        if(cardPlayer2.get(i).isActive){
                                            System.out.println((i + 1) + ". " + cardPlayer2.get(i).nameCard + " <active>");
                                        } else {
                                            System.out.println((i + 1) + ". " + cardPlayer2.get(i).nameCard);
                                        }
                                    }
                                    System.out.print(">> ");
                                    menuSwitch = scanI.nextInt();
                                    if(menuSwitch-1 == actCard2){
                                        System.out.println("This is the current active card. Choose again");
                                    }
                                } while (menuSwitch < 1 || menuSwitch > cardPlayer2.size() || menuSwitch-1 == actCard2);
                                int pilihElemen;
                                System.out.println("Choose which dice to consume: ");
                                int j = 0;
                                int[] angkaPilih = {0, 0, 0, 0, 0};
                                for(int i = 0; i < daduPlayer2.length; i++){
                                    if(daduPlayer2[i] != 0){
                                        j++;
                                        System.out.println("[" + (j) + "] " + elemen[i] + " (" + daduPlayer2[i] + ")");
                                        angkaPilih[i] = j;
                                    }
                                }
                                System.out.println("0. Back");
                                do {                                    
                                    System.out.print(">> ");
                                    pilihElemen = scanI.nextInt();
                                } while (pilihElemen < 0 || pilihElemen > j);
                                if(pilihElemen != 0){
                                    for(int i = 0; i < angkaPilih.length; i++){
                                        if(angkaPilih[i] == pilihElemen){
                                            daduPlayer2[i] -= 1;
                                            dadu2--;
                                        }
                                    }
                                    cardPlayer2.get(actCard2).isActive = false;
                                    actCard2 = menuSwitch-1;
                                    cardPlayer2.get(actCard2).isActive = true;
                                    System.out.println("Successfully switched to " + cardPlayer2.get(actCard2).nameCard);
                                    if(useEndTurn){
                                        turn+=2;
                                    } else {
                                        turn++;
                                    }
                                }
                            }
                        } else if(inputPlay == 2){
                            if(turn % 2 == 0){
                                int choose2Dice;
                                int ctrChoose = 0;
                                Boolean isDone = false;
                                do {
                                    System.out.println("Choose dice with any element: ");
                                    int j = 0;
                                    int[] angkaPilih = {0, 0, 0, 0, 0};
                                    for(int i = 0; i < daduPlayer1.length; i++){
                                        if(daduPlayer1[i] != 0){
                                            j++;
                                            System.out.println("[" + (j) + "] " + elemen[i] + " (" + daduPlayer1[i] + ")");
                                            angkaPilih[i] = j;
                                        }
                                    }
                                    System.out.println("0. Back");
                                    do {                                    
                                        System.out.print(">> ");
                                        choose2Dice = scanI.nextInt();
                                    } while (choose2Dice < 0 || choose2Dice > j);
                                    if(choose2Dice != 0){
                                        for(int i = 0; i < angkaPilih.length; i++){
                                            if(angkaPilih[i] == choose2Dice){
                                                if(i == actCard1){
                                                    daduPlayer1[i] -= 1;
                                                    dadu1--;
                                                    cardPlayer1.get(actCard1).skillPoint++;
                                                    isDone = true;
                                                } else {
                                                    daduPlayer1[i] -= 1;
                                                    dadu1--;
                                                    ctrChoose++;
                                                    if(ctrChoose >= 2){
                                                        cardPlayer1.get(actCard1).skillPoint++;
                                                        isDone = true;
                                                    }
                                                }
                                            }
                                        }
                                        if(useEndTurn){
                                            turn+=2;
                                        } else {
                                            turn++;
                                        }
                                    }
                                } while (!isDone && choose2Dice != 0);
                                if(isDone){
                                    cardPlayer2.get(actCard2).hp -= 2;
                                }
                            } else {
                                int choose2Dice;
                                int ctrChoose = 0;
                                Boolean isDone = false;
                                do {
                                    System.out.println("Choose dice with any element: ");
                                    int j = 0;
                                    int[] angkaPilih = {0, 0, 0, 0, 0};
                                    for(int i = 0; i < daduPlayer2.length; i++){
                                        if(daduPlayer2[i] != 0){
                                            j++;
                                            System.out.println("[" + (j) + "] " + elemen[i] + " (" + daduPlayer2[i] + ")");
                                            angkaPilih[i] = j;
                                        }
                                    }
                                    System.out.println("0. Back");
                                    do {                                    
                                        System.out.print(">> ");
                                        choose2Dice = scanI.nextInt();
                                    } while (choose2Dice < 0 || choose2Dice > j);
                                    if(choose2Dice != 0){
                                        for(int i = 0; i < angkaPilih.length; i++){
                                            if(angkaPilih[i] == choose2Dice){
                                                if(i == actCard2){
                                                    daduPlayer2[i] -= 1;
                                                    dadu2--;
                                                    cardPlayer2.get(actCard2).skillPoint++;
                                                    isDone = true;
                                                } else {
                                                    daduPlayer2[i] -= 1;
                                                    dadu2--;
                                                    ctrChoose++;
                                                    if(ctrChoose >= 2){
                                                        cardPlayer2.get(actCard2).skillPoint++;
                                                        isDone = true;
                                                    }
                                                }
                                            }
                                        }
                                        if(useEndTurn){
                                            turn+=2;
                                        } else {
                                            turn++;
                                        }
                                    }
                                } while (!isDone && choose2Dice != 0);
                                if(isDone){
                                    cardPlayer1.get(actCard1).hp -= 2;
                                }
                            }
                        } else if(inputPlay == 3){
                            if(turn % 2 == 0){
                                if(cardPlayer1.get(actCard1) instanceof Pyro){
                                    if(cardPlayer1.get(actCard1).skillPoint < 1){
                                        System.out.println("Not enough skill points to use the skill.");
                                    } else if(daduPlayer1[actCard1] < 2){
                                        System.out.println("Not enough dice card active to use the skill.");
                                    } else {
                                        cardPlayer2.get(actCard2).hp -= 3;
                                        cardPlayer1.get(actCard1).skillPoint -= 1;
                                        daduPlayer1[actCard1] -= 2;
                                        dadu1 -= 2;
                                        System.out.println("Pyro Maniac used its skill!");
                                        turn++;
                                    }
                                } else if(cardPlayer1.get(actCard1) instanceof Atlantic){
                                    if(cardPlayer1.get(actCard1).skillPoint < 2){
                                        System.out.println("Not enough skill points to use the skill.");
                                    } else if(daduPlayer1[actCard1] < 2){
                                        System.out.println("Not enough dice card active to use the skill.");
                                    } else if(cardPlayer1.get(actCard1).hp < 3){
                                        System.out.println("Not enough hp card active.");
                                    } else {
                                        for(int i = 0; i < 3; i++){
                                            cardPlayer2.get(i).hp -= 2;
                                        }
                                        cardPlayer1.get(actCard1).hp -= 3;
                                        cardPlayer1.get(actCard1).skillPoint -= 2;
                                        daduPlayer1[actCard1] -= 2;
                                        dadu1 -= 2;
                                        System.out.println("Atlantic Siren used its skill!");
                                        turn++;
                                    }
                                } else if(cardPlayer1.get(actCard1) instanceof Stone){
                                    if(cardPlayer1.get(actCard1).skillPoint < 2){
                                        System.out.println("Not enough skill points to use the skill.");
                                    } else if(daduPlayer1[actCard1] < 2){
                                        System.out.println("Not enough dice card active to use the skill.");
                                    } else {
                                        Boolean isActive = true;
                                        int randKartu;
                                        do {
                                            randKartu = rand.nextInt(3);
                                            if(cardPlayer2.get(randKartu).isActive == false && cardPlayer2.get(randKartu).hp > 0){
                                                isActive = false;
                                            }
                                        } while (isActive);
                                        actCard2 = randKartu;
                                        cardPlayer1.get(actCard1).skillPoint -= 2;
                                        daduPlayer1[actCard1] -= 2;
                                        dadu1 -= 2;
                                        System.out.println("Stone Golem used its skill!");
                                        turn++;
                                    }
                                } else if(cardPlayer1.get(actCard1) instanceof Holy){
                                    if(cardPlayer1.get(actCard1).skillPoint < 2){
                                        System.out.println("Not enough skill points to use the skill.");
                                    } else if(daduPlayer1[actCard1] < 2){
                                        System.out.println("Not enough dice card active to use the skill.");
                                    } else {
                                        int kartuTerendah = 0;
                                        int nilaiKartuTerendah = 1000000;
                                        for(int i = 0; i < 3; i++){
                                            if(cardPlayer1.get(i).hp < nilaiKartuTerendah && cardPlayer1.get(i).hp > 0){
                                                nilaiKartuTerendah = cardPlayer1.get(i).hp;
                                                kartuTerendah = i;
                                            }
                                        }
                                        for(int i = 0; i < 5; i++){
                                            if(cardPlayer1.get(kartuTerendah).hp < 10){
                                                cardPlayer1.get(kartuTerendah).hp += 1;
                                            } else {
                                                break;
                                            }
                                        }
                                        cardPlayer1.get(actCard1).skillPoint -= 2;
                                        daduPlayer1[actCard1] -= 2;
                                        dadu1 -= 2;
                                        System.out.println("Holy Paladin used its skill!");
                                        turn++;
                                    }
                                } else if(cardPlayer1.get(actCard1) instanceof Grim){
                                    if(cardPlayer1.get(actCard1).skillPoint < 2){
                                        System.out.println("Not enough skill points to use the skill.");
                                    } else if(daduPlayer1[actCard1] < 2){
                                        System.out.println("Not enough dice card active to use the skill.");
                                    } else {
                                        Boolean isActive = true;
                                        int randKartu;
                                        do {
                                            randKartu = rand.nextInt(3);
                                            if(cardPlayer2.get(randKartu).hp <= 5){
                                                isActive = false;
                                            }
                                        } while (isActive);
                                        cardPlayer2.get(randKartu).hp = 0;
                                        cardPlayer1.get(actCard1).skillPoint -= 3;
                                        daduPlayer1[actCard1] -= 2;
                                        dadu1 -= 2;
                                        System.out.println("Grim Reaper used its skill!");
                                        turn++;
                                    }
                                }
                            } else {
                                if(cardPlayer2.get(actCard2) instanceof Pyro){
                                    if(cardPlayer2.get(actCard2).skillPoint < 1){
                                        System.out.println("Not enough skill points to use the skill.");
                                    } else if(daduPlayer2[actCard2] < 2){
                                        System.out.println("Not enough dice card active to use the skill.");
                                    } else {
                                        cardPlayer1.get(actCard1).hp -= 3;
                                        cardPlayer2.get(actCard2).skillPoint -= 1;
                                        daduPlayer2[actCard2] -= 2;
                                        dadu2 -= 2;
                                        System.out.println("Pyro Maniac used its skill!");
                                        turn++;
                                    }
                                } else if(cardPlayer2.get(actCard2) instanceof Atlantic){
                                    if(cardPlayer2.get(actCard2).skillPoint < 2){
                                        System.out.println("Not enough skill points to use the skill.");
                                    } else if(daduPlayer2[actCard2] < 2){
                                        System.out.println("Not enough dice card active to use the skill.");
                                    } else if(cardPlayer2.get(actCard2).hp < 3){
                                        System.out.println("Not enough hp card active.");
                                    } else {
                                        for(int i = 0; i < 3; i++){
                                            cardPlayer1.get(i).hp -= 2;
                                        }
                                        cardPlayer2.get(actCard2).hp -= 3;
                                        cardPlayer2.get(actCard2).skillPoint -= 2;
                                        daduPlayer2[actCard2] -= 2;
                                        dadu2 -= 2;
                                        System.out.println("Atlantic Siren used its skill!");
                                        turn++;
                                    }
                                } else if(cardPlayer2.get(actCard2) instanceof Stone){
                                    if(cardPlayer2.get(actCard2).skillPoint < 2){
                                        System.out.println("Not enough skill points to use the skill.");
                                    } else if(daduPlayer2[actCard2] < 2){
                                        System.out.println("Not enough dice card active to use the skill.");
                                    } else {
                                        Boolean isActive = true;
                                        int randKartu;
                                        do {
                                            randKartu = rand.nextInt(3);
                                            if(cardPlayer1.get(randKartu).isActive == false && cardPlayer1.get(randKartu).hp > 0){
                                                isActive = false;
                                            }
                                        } while (isActive);
                                        actCard1 = randKartu;
                                        cardPlayer2.get(actCard2).skillPoint -= 2;
                                        daduPlayer2[actCard2] -= 1;
                                        dadu2 -= 2;
                                        System.out.println("Stone Golem used its skill!");
                                        turn++;
                                    }
                                } else if(cardPlayer2.get(actCard2) instanceof Holy){
                                    if(cardPlayer2.get(actCard2).skillPoint < 2){
                                        System.out.println("Not enough skill points to use the skill.");
                                    } else if(daduPlayer2[actCard2] < 2){
                                        System.out.println("Not enough dice card active to use the skill.");
                                    } else {
                                        int kartuTerendah = 0;
                                        int nilaiKartuTerendah = 1000000;
                                        for(int i = 0; i < 3; i++){
                                            if(cardPlayer2.get(i).hp < nilaiKartuTerendah && cardPlayer2.get(i).hp > 0){
                                                nilaiKartuTerendah = cardPlayer2.get(i).hp;
                                                kartuTerendah = i;
                                            }
                                        }
                                        for(int i = 0; i < 5; i++){
                                            if(cardPlayer2.get(kartuTerendah).hp < 10){
                                                cardPlayer2.get(kartuTerendah).hp += 1;
                                            } else {
                                                break;
                                            }
                                        }
                                        cardPlayer2.get(actCard2).skillPoint -= 2;
                                        daduPlayer2[actCard2] -= 2;
                                        dadu2 -= 2;
                                        System.out.println("Holy Paladin used its skill!");
                                        turn++;
                                    }
                                } else if(cardPlayer2.get(actCard2) instanceof Grim){
                                    if(cardPlayer2.get(actCard2).skillPoint < 2){
                                        System.out.println("Not enough skill points to use the skill.");
                                    } else if(daduPlayer2[actCard2] < 2){
                                        System.out.println("Not enough dice card active to use the skill.");
                                    } else {
                                        Boolean isActive = true;
                                        int randKartu;
                                        do {
                                            randKartu = rand.nextInt(3);
                                            if(cardPlayer1.get(randKartu).hp <= 5){
                                                isActive = false;
                                            }
                                        } while (isActive);
                                        cardPlayer1.get(randKartu).hp = 0;
                                        cardPlayer2.get(actCard2).skillPoint -= 3;
                                        daduPlayer2[actCard2] -= 2;
                                        dadu2 -= 2;
                                        System.out.println("Grim Reaper used its skill!");
                                        turn++;
                                    }
                                }                                
                            }
                        } else if(inputPlay == 4){
                            if(useEndTurn){
                                useEndTurn = false;
                                turn++;
                                round++;
                                dadu1 += shuffleDadu(actCard1, daduPlayer1, rand);
                                dadu2 += shuffleDadu(actCard2, daduPlayer2, rand);
                            } else {
                                useEndTurn = true;
                                turn++;
                            }
                        }

                        int ctr1 = 0;
                        for(int i = 0; i < cardPlayer1.size(); i++){
                            if(cardPlayer1.get(i).hp == 0){
                                ctr1++;
                            }
                        }
                        int ctr2 = 0;
                        for(int i = 0; i < cardPlayer2.size(); i++){
                            if(cardPlayer2.get(i).hp == 0){
                                ctr2++;
                            }
                        }

                        if(ctr1 >= 3){
                            isPlayer1Win = true;
                        } else if(ctr2 >= 3){
                            isPlayer2Win = true;
                        } else if(cardPlayer1.get(actCard1).hp <= 0){
                            Boolean isActive = true;
                            int randKartu;
                            do {
                                randKartu = rand.nextInt(3);
                                if(cardPlayer1.get(randKartu).isActive == false &&  cardPlayer1.get(randKartu).hp >= 0){
                                    isActive = false;
                                }
                            } while (isActive);
                            actCard1 = randKartu;
                        } else if(cardPlayer2.get(actCard2).hp <= 0){
                            Boolean isActive = true;
                            int randKartu;
                            do {
                                randKartu = rand.nextInt(3);
                                if(cardPlayer2.get(randKartu).isActive == false && cardPlayer2.get(randKartu).hp >= 0){
                                    isActive = false;
                                }
                            } while (isActive);
                            actCard2 = randKartu;
                        }
                    }
                    if(isPlayer1Win){
                        actCard1 = 0;
                        cardPlayer1.clear();
                        System.out.println("Player 1 Win !!!");
                    } else if(isPlayer2Win){
                        actCard2 = 0;
                        cardPlayer2.clear();
                        System.out.println("Player 2 Win !!!");
                    }
                } else {
                    isExit = true;
                }
            }
        }
    }
}
