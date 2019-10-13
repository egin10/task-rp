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
 * @author Ginanjar.S.B
 */
public class regresiLinear {
    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String args[]) throws Exception {
    
    //membaca data latih
        Instances dataLatih = new Instances(new BufferedReader(new FileReader("dataRegresiLinear/dataLatih.arff")));
        dataLatih.setClassIndex(dataLatih.numAttributes() - 1);
        //System.out.println("Data Latih : " + dataLatih);
    
    //membaca data uji
        Instances dataUji = new Instances(new BufferedReader(new FileReader("dataRegresiLinear/dataUji.arff")));
        dataUji.setClassIndex(dataUji.numAttributes() - 1);
//        System.out.println("Data Uji : " + dataUji);
    
    //membangun model
        LinearRegression model = new LinearRegression();
        model.buildClassifier(dataLatih); 
        //System.out.println(model); 
    
    //menentukan hasil  instance terakhir dari data
        for (int i = 0; i < dataUji.size(); i++) {
            Instance dicari = dataUji.instance(i);
            String dataUJI = dicari.toString();
            double jumlahCacat = model.classifyInstance(dicari);
            System.out.println("Kecacatan produksi jika suhu : "+ dataUJI + " adalah "+ jumlahCacat);
        }
    }
}
