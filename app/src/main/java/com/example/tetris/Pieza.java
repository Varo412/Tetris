package com.example.tetris;

public class Pieza {

    public int idColor;
    public int x1, y1;
    public int x2, y2;
    public int x3, y3;
    public int x4, y4;
    private Pieza pieza;
    public int pos;


    public Pieza(Pieza pieza) {
        this.pieza = pieza;
        this.x1= pieza.x1; this.x2= pieza.x2;
        this.x3= pieza.x3; this.x4= pieza.x4;
        this.y1= pieza.y1; this.y2= pieza.y2;
        this.y3= pieza.y3; this.y4= pieza.y4;
    }



    public Pieza(int f, int a) {
        switch (f) { // Cuadrado
            case 1:
                x1 = 4; y1 = 0+a;
                x2 = 5; y2 = 0+a;
                x3 = 4; y3 = 1+a;
                x4 = 5; y4 = 1+a;

                idColor = 1;
                pos=0;
                break;

            case 2:    // Z Pieza
                x1 = 5;y1 = 0+a;
                x2 = 6;y2 = 0+a;
                x3 = 6;y3 = 1+a;
                x4 = 7;y4 = 1+a;

                idColor = 2;
                pos=0;
                break;

            case 3: // I Pieza
                x1 = 4;y1 = 0+a;
                x2 = 4;y2 = 1+a;
                x3 = 4;y3 = 2+a;
                x4 = 4;y4 = 3+a;

                idColor = 3;
                pos=0;
                break;

            case 4: // T Pieza
                x1 = 4;y1 = 0+a;
                x2 = 5;y2 = 0+a;
                x3 = 6;y3 = 0+a;
                x4 = 5;y4 = 1+a;

                idColor = 4;
                pos=0;
                break;

            case 5: // S Pieza
                x1 = 5;y1 = 0+a;
                x2 = 6;y2 = 0+a;
                x3 = 5;y3 = 1+a;
                x4 = 4;y4 = 1+a;

                idColor = 5;
                pos=0;
                break;

            case 6:  // L Pieza
                x1 = 6;y1 = 0+a;
                x2 = 7;y2 = 0+a;
                x3 = 7;y3 = 1+a;
                x4 = 7;y4 = 2+a;

                idColor = 6;
                pos=0;
                break;

            case 7:  // J Pieza
                x1 = 4;y1 = 0+a;
                x2 = 5;y2 = 0+a;
                x3 = 4;y3 = 1+a;
                x4 = 4;y4 = 2+a;

                idColor = 7;
                pos=0;
                break;
        }
    }


    public void mover(int x, int y) {
        x1 = x1 + x;
        y1 = y1 + y;
        x2 = x2 + x;
        y2 = y2 + y;
        x3 = x3 + x;
        y3 = y3 + y;
        x4 = x4 + x;
        y4 = y4 + y;
    }

    public int getAltura(){
        return this.y1;
    }

    public void setAltura(int y){
        this.pieza.y1+=y;
        this.pieza.y2+=y;
        this.pieza.y3+=y;
        this.pieza.y4+=y;
    }

    public void copiarPieza(Pieza pieza,Pieza pieza2){
        pieza.x1=pieza2.x1;
        pieza.x2=pieza2.x2;
        pieza.x3=pieza2.x3;
        pieza.x4=pieza2.x4;

        pieza.pos=pieza2.pos;

    }
}