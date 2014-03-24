/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jeu;

/**
 *
 * @author kevin
 */
public class chrono {

    public long chrono = 0;

    public chrono() {
        chrono = 0;
        chrono = java.lang.System.currentTimeMillis();
    }
    public int getTemp() {
            return Sec(Stop_Chrono());
        }
    public long Stop_Chrono() {
            long chrono2 = java.lang.System.currentTimeMillis();
            long temps = chrono2 - chrono;
            return temps;

        }

        public int Sec(long temps) {
            long totalSeconds = temps / 1000;
            int second = (int) (totalSeconds % 60);
            long totalMinutes = totalSeconds / 60;
            int minute = (int) (totalMinutes % 60);
            long totalHours = totalMinutes / 60;
            int hour = (int) (totalHours % 24);
            return (hour * 3600) + (minute * 60) + second;
        }
}
