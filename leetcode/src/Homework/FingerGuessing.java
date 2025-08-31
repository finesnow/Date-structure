package Homework;

import java.util.Random;
import java.util.Scanner;

/**
 * @author Administrator
 * @Date 2025/8/25 22:32
 * @package Homework
 * @Description: 人机猜拳游戏
 */
public class FingerGuessing {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Game game = new Game();
        game.initial();

        String choice = "y";
        do {
            game.startGame();
            System.out.println("是否开始下一局y/n");
            choice = scanner.next();
        }
        while (choice.equals("y"));
    }
}

class Player {

    private String playerName;
    private int wins;
    private int rounds;

    public Player(String playerName) {
        this.playerName = playerName;
        this.wins = 0;
        this.rounds = 0;
    }

    public int showFist() {
        System.out.print("请出拳：1.剪刀 2.石头 3.布");
        Scanner scanner = new Scanner(System.in);
        int fist = scanner.nextInt();
        while (fist <= 0 || fist > 3) {
            System.out.print("输入错误，请重新出拳：1.剪刀 2.石头 3.布");
            fist = scanner.nextInt();
        }
        return fist;
    }

    public String getPlayerName() {
        return playerName;
    }

    public int getWins() {
        return wins;
    }

    public int getRounds() {
        return rounds;
    }

    public void addWins() {
        wins++;
    }

    public void addRounds() {
        rounds++;
    }

    public double winRate() {
        if (rounds==0)
            return 0.0;
        return (wins * 1.0) / rounds;
    }

    public void clear() {

        this.wins = 0;
        this.rounds = 0;
    }
}

class Computer {
    private String computerName;
    private int wins;
    private int rounds;

    public Computer(String computerName) {
        this.computerName = computerName;
    }

    public int showFist() {
        Random random = new Random();
        return random.nextInt(1, 4);
    }

    public String getComputerName() {
        return computerName;
    }

    public int getWins() {
        return wins;
    }

    public int getRounds() {
        return rounds;
    }

    public void addWins() {
        wins++;
    }

    public void addRounds() {
        rounds++;
    }

    public double winRate() {
        if (rounds==0)
            return 0.0;
        return (wins * 1.0) / rounds;
    }

    public void clear() {
        this.wins = 0;
        this.rounds = 0;
    }

}


class Game {

    private Player player;
    private Computer[] computers;
    private Computer currentComp;
    private int gameRounds;
    Scanner scanner;

    public void initial() {
        System.out.println("出拳规则：1.剪刀 2.石头 3.布");
        scanner = new Scanner(System.in);
        System.out.print("请输入您的名字：");
        String playerName = scanner.next();
        player = new Player(playerName);

        computers = new Computer[3];
        computers[0] = new Computer("刘备");
        computers[1] = new Computer("曹操");
        computers[2] = new Computer("孙权");

    }

    private void chooseOpponent() {

        System.out.print("请选择对手：1.刘备 2.曹操 3.孙权");
        int choice = scanner.nextInt();
        while (choice < 1 || choice > computers.length) {
            System.out.println("输入有误，请重新输入：");
            choice = scanner.nextInt();
        }
        currentComp = computers[choice - 1];

    }


    public void startGame() {
        chooseOpponent();
        System.out.println("要开始吗y/n");
        String flag = scanner.next();
        while (flag.equals("y")) {

            int playerFist = player.showFist();

            int computerFist = currentComp.showFist();

            System.out.println("您出拳：" + getFistName(playerFist));
            System.out.println(currentComp.getComputerName() + "出拳：" + getFistName(computerFist));

            int judgout = judgment(playerFist, computerFist);
            if (judgout == 0) {
                System.out.println("平局");
            } else if (judgout == 1) {
                System.out.println("玩家获胜");
                player.addWins();
            } else {
                System.out.println("电脑玩家" + currentComp.getComputerName() + "获胜");
                currentComp.addWins();
            }


            player.addRounds();
            currentComp.addRounds();
            this.gameRounds++;

            System.out.println("要继续吗y/n");
            flag = scanner.next();
        }
        System.out.println("游戏结束！");
        gameOver();
    }

    private void gameOver() {

        display();
        player.clear();
        currentComp.clear();
        currentComp = null;
    }

    private int judgment(int playerFist, int computerFist) {
        int judgout = playerFist - computerFist;
        if (judgout == 2) {
            return -1;
        } else if (judgout == -2) {
            return 1;
        }
        return judgout;

    }

    private String getFistName(int fist) {
        switch (fist) {
            case 1:
                return "剪刀";
            case 2:
                return "石头";
            case 3:
                return "布";
            default:
                return null;
        }
    }

    public void display() {

        System.out.printf("您的总场次为：" + player.getRounds() + " 胜场数为：" + player.getWins() + "胜率为：%.2f" + "%%", player.winRate() * 100);
        System.out.println();
        System.out.printf("您的对手" + currentComp.getComputerName() + "总场次为：" + currentComp.getRounds() + " 胜场数为：" + currentComp.getWins() + "胜率为：%.2f" + "%%", currentComp.winRate() * 100);
        System.out.println();
    }

}
