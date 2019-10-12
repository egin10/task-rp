/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weka;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import weka.classifiers.Classifier;
import weka.classifiers.Evaluation;
import weka.classifiers.bayes.NaiveBayes;
import weka.classifiers.functions.SMO;
import weka.classifiers.meta.FilteredClassifier;
import weka.classifiers.trees.J48;
import weka.core.Debug.Random;
import weka.core.Instance;
import weka.core.Instances;
import weka.filters.unsupervised.attribute.StringToWordVector;
//import static weka.filters.unsupervised.instance.subsetbyexpression.Parser.filter;

/**
 *
 * @author agungdwi
 */
public class cobaNB {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException, Exception {
        // TODO code application logic here
                Instances trainDataset = new Instances(new BufferedReader(new FileReader("data/dataTrain.arff")));
		//set class index to the last attribute
		trainDataset.setClassIndex(trainDataset.numAttributes()-1);
		//get number of classes
		int numClasses = trainDataset.numClasses();
		//print out class values in the training dataset
		for(int i = 0; i < numClasses; i++){
			//get class string value using the class index
			String classValue = trainDataset.classAttribute().value(i);
			System.out.println("Class Value "+i+" is " + classValue);
		}
                
		//create and build the classifier
		NaiveBayes nb = new NaiveBayes();
		nb.buildClassifier(trainDataset);
		//load new dataset
		Instances testDataset  = new Instances(new BufferedReader(new FileReader("data/dataTest.arff")));	
		//set class index to the last attribute
		testDataset.setClassIndex(testDataset.numAttributes()-1);
		//loop through the new dataset and make predictions
		System.out.println("===================");
		System.out.println("Actual Class, NB Predicted");
		for (int i = 0; i < testDataset.numInstances(); i++) {
			//get class double value for current instance
			double actualClass = testDataset.instance(i).classValue();
                        testDataset.setClassIndex(testDataset.numAttributes() - 1);  
                        Instance dicari = testDataset.instance(i);
                        String dataUji = dicari.toString();
                        double jumlahCacat = nb.classifyInstance(dicari);
			//get class string value using the class index using the class's int value
			String actual = testDataset.classAttribute().value((int) actualClass);
			//get Instance object of current instance
			Instance newInst = testDataset.instance(i);
			//call classifyInstance, which returns a double value for the class
			double predNB = nb.classifyInstance(newInst);
			//use this value to get string value of the predicted class
			String predString = testDataset.classAttribute().value((int) predNB);
			System.out.println(dataUji+","+ predString);
		}
                
    }
    
}