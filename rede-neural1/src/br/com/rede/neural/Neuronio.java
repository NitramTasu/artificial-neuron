package br.com.rede.neural;

import java.util.Random;

public class Neuronio {
	
	//private float[] amostra;
	private float [] input;
	//private float[] resultado;
	private float[] pesos;
	private float taxaAprendizado = 0.05f;
	private boolean erro = false;
		
	public Neuronio(){
		input = new float[3];
		erro = false;
		
		//input[0] = -1;
			
	}
	
	public void iniPesos(int quantidadeDeEntradas){
		Random r = new Random();
		
		pesos = new float [quantidadeDeEntradas];
		
		for (int i = 0; i < pesos.length; i++) {
			pesos[i] = r.nextFloat();
		}
	}
	
	public void treinamento(float[] amostra, float valorDesejado){
		
		do{
			float resulProcessamento = processamento(amostra);
			
			float resultado =  funcaoDeAtivacao(resulProcessamento);
			
			if(resultado != valorDesejado){
				ajustePeso(amostra, resultado, valorDesejado);
				erro = true;
			}else{
				erro = false;
			}
		}while(erro);
		
		
	}
	public int operacao(float[] input){
		float resultado = processamento(input);
		
		return funcaoDeAtivacao(resultado);
	}
	
	private float processamento(float[] input){
		
		float resultado = 0f;
		for (int i = 0; i < input.length; i++) {
			resultado += input[i] * pesos[i];
		}
		
		return resultado;
	}
	
	private void ajustePeso(float[] valoresEntrada, float valorDeSaida, float valorDesejado){
		
		for(int i = 0; i < pesos.length; i++){
			pesos[i] = pesos[i] + taxaAprendizado * (valorDesejado - valorDeSaida) * valoresEntrada[i]; 
		}
	}
	
	private int funcaoDeAtivacao(float sinalDeAticao){
		if( sinalDeAticao >= 0){
			return 1;
		}else{
			return -1;
		}
	}

}
