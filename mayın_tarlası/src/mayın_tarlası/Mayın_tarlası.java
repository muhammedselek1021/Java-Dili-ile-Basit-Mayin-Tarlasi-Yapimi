package mayın_tarlası;
import java.util.Scanner;
import java.util.Random;
// 213908058 - Muhammed Mustafa SELEK
public class Mayın_tarlası {
    public static void main(String[] args) {
        Random rnd = new Random();
        Scanner src = new Scanner(System.in);
        System.out.println("Lütfen satır boyutunu giriniz:");
        byte satir = src.nextByte();
        System.out.println("Lütfen sütun boyutunu giriniz:");
        byte sutun = src.nextByte();
        String dizi[][] = new String[satir][sutun];
        System.out.println("Mayın tarlanızın ebatları oluşturuldu:");
        for(int i = 0; i < satir; i++){
            for (int j = 0; j < sutun; j++){
                dizi[i][j] = "*";
            }
        }
        for (int i = 0; i < satir; i++) {
            for (int j = 0; j < sutun; j++) {
                System.out.print(" "+dizi[i][j]+" ");
            }
            System.out.println("");
        }
        int hucre = satir*sutun;
        System.out.println("Lütfen 1-10 arası zorluk seviyesini giriniz:");
        byte seviye = src.nextByte();
        int mayin = 0;
        switch(seviye){
            case 1: mayin = (int) (0.1*hucre); if(mayin < 1) mayin = 1; break;
            case 2: mayin = (int) (0.2*hucre); if(mayin < 1) mayin = 1; break;
            case 3: mayin = (int) (0.3*hucre); if(mayin < 1) mayin = 1; break;
            case 4: mayin = (int) (0.4*hucre); if(mayin < 1) mayin = 1; break;
            case 5: mayin = (int) (0.5*hucre); if(mayin < 1) mayin = 1; break;
            case 6: mayin = (int) (0.6*hucre); if(mayin < 1) mayin = 1; break;
            case 7: mayin = (int) (0.7*hucre); if(mayin < 1) mayin = 1; break;
            case 8: mayin = (int) (0.8*hucre); if(mayin < 1) mayin = 1; break;
            case 9: mayin = (int) (0.9*hucre); if(mayin < 1) mayin = 1; break;
            case 10: System.out.println("Tarlanın hepsi mayın olamaz, lütfen programı yeniden başlatıp yeni değer giriniz!"); break;
            default : System.out.println("Lütfen programı yeniden başlatıp istenilen değerler arasında bir değer giriniz!"); break;
        }
        if(mayin == 0)
            System.exit(mayin=0);
        System.out.println("Oyundaki mayın sayısı: "+mayin);
        int dizi2[][] = new int[satir][sutun];
        for(int i = 0; i < satir; i++){
            for (int j = 0; j < sutun; j++){
                dizi2[i][j] = 0;
            }
        }
        for (int i = 0; i < mayin; i++) {
            int mkr = rnd.nextInt(satir);
            int mkn = rnd.nextInt(sutun);
            switch (dizi2[mkr][mkn]) {
                case 1:
                    dizi2[mkr][mkn] = 2;
                    i--;
                    break;
                case 2:
                    dizi2[mkr][mkn] = 3;
                    i--;
                    break;
                case 3:
                    dizi2[mkr][mkn] = 4;
                    i--;
                    break;
                case 4:
                    dizi2[mkr][mkn] = 5;
                    i--;
                    break;
                case 5:
                    i--;
                    break;
                default:
                    dizi2[mkr][mkn] = 1;
                    break;
            }
        }
        double puan = 0;
        byte hamle = (byte) (hucre-mayin);
        double puankat = 100.0/hamle;
        while (true){
            System.out.println("Lütfen seçeceğiniz satır değerini giriniz:");
            byte ssatir = src.nextByte();
            System.out.println("Lütfen seçeceğiniz sütun değerini giriniz:");
            byte ssutun = src.nextByte();
            if(dizi2[ssatir-1][ssutun-1] != 0){
                System.out.println("BUM!!!");
                for(int i = 0; i < satir; i++){
                    for (int j = 0; j < sutun; j++){
                        System.out.print(" "+dizi2[i][j]+" ");
                    }
                    System.out.println("");
                }
                System.out.println("Puanınız: "+puan);
                break;
            }
            else if(dizi2[ssatir-1][ssutun-1] == 0){
                dizi[ssatir-1][ssutun-1] = "0";
                for (int i = 0; i < satir; i++) {
                    for (int j = 0; j < sutun; j++) {
                        System.out.print(" "+dizi[i][j]+" ");
                    }
                    System.out.println("");
                }
                puan = puan + puankat;
            }
        }
    }
}