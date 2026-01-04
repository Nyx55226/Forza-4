
package com.mycompany.forza4;
public class Gioco {
    private boolean giocatore=true;
    private char[][] griglia=new char[6][7];
    
    public Gioco(){
        inizializareGriglia();
    }
    public void inizializareGriglia(){
        for(int i=0;i<6;i++){
            for(int j=0;j<7;j++){
                griglia[i][j]=' ';
            }
        }
        giocatore=true;
    }

    public boolean isGiocatore1() {
        return giocatore;
    }
    
    public int turno(int colonna){
        if(colonna<0 || colonna>6){
            return -1;
        }
        for(int r=5;r>=0;r--){
            if(griglia[r][colonna]==' '){
                if(giocatore){
                    griglia[r][colonna]='R';
                    giocatore=false;
                }else{
                    griglia[r][colonna]='G';
                    giocatore=true;
                }
                return r;
            }
        }
        return -1;
    }
    public char getGriglia(int riga,int colonna){
        return griglia[riga][colonna];
    }
   public boolean controllaVittoria() {
    for (int r = 0; r < 6; r++) {
        for (int c = 0; c <= 3; c++) {
            char pedina = griglia[r][c];
            if (pedina != ' ' && pedina == griglia[r][c+1] && pedina == griglia[r][c+2] && pedina == griglia[r][c+3]) {
                return true;
            }
        }
    }

    for (int c = 0; c < 7; c++) {
        for (int r = 0; r <= 2; r++) {
            char pedina = griglia[r][c];
            if (pedina != ' ' && pedina == griglia[r+1][c] && pedina == griglia[r+2][c] && pedina == griglia[r+3][c]) {
                return true;
            }
        }
    }

    for (int r = 0; r <= 2; r++) {
        for (int c = 0; c <= 3; c++) {
            char pedina = griglia[r][c];
            if (pedina != ' ' && pedina == griglia[r+1][c+1] && pedina == griglia[r+2][c+2] && pedina == griglia[r+3][c+3]) {
                return true;
            }
        }
    }

    for (int r = 0; r <= 2; r++) {
        for (int c = 3; c < 7; c++) {
            char pedina = griglia[r][c];
            if (pedina != ' ' && pedina == griglia[r+1][c-1] && pedina == griglia[r+2][c-2] && pedina == griglia[r+3][c-3]) {
                return true;
            }
        }
    }

    return false;
}

    
}
