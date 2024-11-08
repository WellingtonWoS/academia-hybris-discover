package calculadora;

public class Calculadora {	
	public float calcularValorParcelas(float valorTotal, int quantParcelas) {
		float valorParcelas = (float) valorTotal/quantParcelas;
		return valorParcelas;
	}
}
