/** Structure de donnee pour les expressions*/
class Expression {
	public int type;
	public int value;
	public Expression leftOp;
	public Expression rightOp;

	public Expression(int type, int value, Expression leftOp, Expression rightOp) {
		this.type = type;
		this.value = value;
		this.leftOp = leftOp;
		this.rightOp = rightOp;
	}
}

/** Classe principale */
class Arith {

	/** Constantes pour representer les types*/
	public static final int TYPE_NUMBER = 1;
	public static final int TYPE_SUM = 2;
	public static final int TYPE_PROD = 3;

	public static void main(String [] args) {
		// construit l'expression 3 + 2 * 5
		Expression term = new Expression(TYPE_SUM, 0,
			new Expression(TYPE_NUMBER, 3, null, null),
			new Expression(TYPE_PROD, 0,
				new Expression(TYPE_NUMBER, 2, null, null),
				new Expression(TYPE_NUMBER, 5, null, null)));

		System.out.println(evaluate(term));
	}

	/** Evalue recursivement l'expression */
	public static int evaluate(Expression term) {
		switch (term.type) {
			case TYPE_NUMBER:
				return term.value;
			case TYPE_SUM:
				return evaluate(term.leftOp) + evaluate(term.rightOp);
			case TYPE_PROD:
				return evaluate(term.leftOp) * evaluate(term.rightOp);
			default:
				return 0;	//erreur, ne devrait jamais se produire	

		}

	}

}
