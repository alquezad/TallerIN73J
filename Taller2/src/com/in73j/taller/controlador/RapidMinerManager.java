package com.in73j.taller.controlador;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;

import com.rapidminer.Process;
import com.rapidminer.RapidMiner;
import com.rapidminer.example.ExampleSet;
import com.rapidminer.operator.IOObject;
import com.rapidminer.operator.OperatorException;
import com.rapidminer.tools.XMLException;



public class RapidMinerManager 
implements Serializable {

private static final long serialVersionUID = 1L;

protected Process process;
public boolean executeProcess(String path){
	
	RapidMiner.setExecutionMode(com.rapidminer.RapidMiner.ExecutionMode.EMBEDDED_WITHOUT_UI);
	RapidMiner.init();

		
		try {
			process = new Process(new File(path));
			process.run();
			return true;
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (XMLException e) {
			e.printStackTrace();
		} catch (OperatorException e) {
			e.printStackTrace();
		}
		return false;
		
}

	public double getPrediction(String lastOperator){
		
		IOObject ioo =  process.getOperator(lastOperator).getOutputPorts().getPortByIndex(0).getAnyDataOrNull();
		ExampleSet es = (ExampleSet) ioo;
		return es.getExample(0).getPredictedLabel();
	}

}
