package ua.com.alevel;

import ua.com.alevel.firstlevel.CountUniqueNumbers;
import ua.com.alevel.firstlevel.HorseMove;
import ua.com.alevel.firstlevel.SquareTriangle;
import ua.com.alevel.levelthree.GameOfLife;
import ua.com.alevel.secondlevel.PermissibleLine;

import java.io.IOException;

public class ModuleOneMain {

    public static void main(String[] args) throws IOException {
        ProgramRun.run();
        /*CountUniqueNumbers countUniqueNumbers = new CountUniqueNumbers();
        countUniqueNumbers.countAllUniqueNumbers();
        HorseMove horseMove = new HorseMove();
        horseMove.drawBoard();
        SquareTriangle squareTriangle = new SquareTriangle();
        squareTriangle.calculateAreaTriangle();
        PermissibleLine permissibleLine = new PermissibleLine();
        permissibleLine.checkPermissibleLine();
        GameOfLife gameOfLife = new GameOfLife();
        gameOfLife.run();
        gameOfLife.initializeRandomArray();
        gameOfLife.visual();
        gameOfLife.game();
        System.out.println();
        System.out.println();
        gameOfLife.visual();*/
    }
}
