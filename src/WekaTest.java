/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.BufferedReader;
import java.io.FileReader;
import weka.classifiers.functions.LinearRegression;
import weka.core.Instance;
import weka.core.Instances;
/**
 *
 * @author AbonSapi
 */
public class WekaTest {
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws Exception {
    
    //membaca data latih
        Instances dataLatih = new Instances(new BufferedReader(new FileReader("dataLatih.arff")));
        dataLatih.setClassIndex(dataLatih.numAttributes() - 1);
        System.out.println("Data Latih : " + dataLatih);
    
    //membaca data uji
        Instances dataUji = new Instances(new BufferedReader(new FileReader("dataUji.arff")));
        dataUji.setClassIndex(dataUji.numAttributes() - 1);
        System.out.println("Data Uji : " + dataUji);
    
    //membangun model
        LinearRegression model = new LinearRegression();
        model.buildClassifier(dataLatih); 
        System.out.println(model); 
    
    //menentukan hasil  instance terakhir dari data
        Instance dicari = dataUji.lastInstance();
        String dataUJI = dicari.toString();
        double jumlahCacat = model.classifyInstance(dicari);
        System.out.println("Kecacatan produksi jika suhu : "+ dataUJI + " adalah "+ jumlahCacat);
    }
}
