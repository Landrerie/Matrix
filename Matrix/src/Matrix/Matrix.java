package Matrix;

/**
 * 
 * @immutable
 * @invar | getRowAmount() != null
 * @invar | getColumnAmount() != null
 * @invar | getElement(int row, int column) != null
 * @invar | getArrayRowMajorOrder() != null
 * @invar | getArrayColumnMajorOrder() != null
 * @invar | getArrayOfArrays() != null
 */
public class Matrix {

	/**
	 * @inspects | this
	 */
	public int getRowAmount() {
		return TODO
	}
	
	/**
	 * @inspects | this
	 */
	public int getColumnAmount() {
		return TODO
	}
	
	/**
	 * @inspects | this
	 * @pre | row < getRowAmount()
	 * @pre | column < getColumnAmount()
	 * @post | result == getArrayOfArrays()[row][column]
	 * 
	 */
	public double getElement(int row, int column) {
		return TODO
	}
	
	/**
	 * @creates | result
	 * @inspects | this
	 * @post | getArrayRowMajorOrder().length == getColumnAmount()*getRowAmount()
	 * @post | IntStream.range(0, getArrayOfArrays().length).allMatch(i ->
	 * 		 | IntStream.range(0, getArrayOfArrays()[0].length).allMatch(j ->
	 * 		 | getArrayOfArrays()[i][j] == getArrayRowMajorOrder()[i*getColumnAmount() + j]))
	 */
	public double[] getArrayRowMajorOrder() {
		return TODO
	}
	
	/**
	 * @creates | result
	 * @inspects | this
	 * @post | getArrayColumnMajorOrder().length == getColumnAmount()*getRowAmount()
	 * @post | IntStream.range(0, getArrayOfArrays().length).allMatch(i ->
	 * 		 | IntStream.range(0, getArrayOfArrays()[0].length).allMatch(j ->
	 * 		 | getArrayOfArrays()[i][j] == getArrayRowMajorOrder()[j*getRowAmount() + i]))
	 */
	public double[] getArrayColumnMajorOrder() {
		return TODO
	}
	
	/**
	 * @creates | result
	 * @inspects | this
	 * @post | getArrayOfArrays().length == getRowAmount()
	 * @post | getArrayOfArrays()[0].length == getColumnAmount()
	 */
	public double[][] getArrayOfArrays() {
		return TODO
	}
	
	/**
	 * 
	 * @throws IllegalArgumentException | inputmatrix != null
	 * @throws IllegalArgumentException | inputrowamount > 0
	 * @throws IllegalArgumentException | inputcolumnamount > 0
	 * @post | getRowAmount() == inputrowamount
	 * @post | getColumnAmount() == inputcolumnamount
	 * @post | inputmatrix.length == inputrowamount*inputcolumnamount
	 */
	public Matrix(int inputrowamount, int inputcolumnamount, double[] inputmatrix) {
		return TODO
	}
	
	/**
	 * @inspects | this
	 * @creates | result
	 * @post | result.getRowAmount() == this.getRowAmount()
	 * @post | result.getColumnAmount() == this.getColumnAmount() 
	 * @post | IntStream.range(0, getColumnAmount()*getRowAmount()).allMatch(
	 * 		 | i -> result.getArrayRowMajorOrder[i] == 
	 * 		 | scalar * this.getArrayRowMajorOrder[i]) 
	 */
	public Matrix scaled(int scalar) {
		return TODO
	}
	
	/**
	 * @inspects | this
	 * @creates | result
	 * @pre | matrixtoadd != null
	 * @pre | matrixtoadd.getColumnAmount() == this.getColumnAmount()
	 * @pre | matrixtoadd.getRowAmount() == this.getRowAmount()
	 * @post | result.getRowAmount() == this.getRowAmount()
	 * @post | result.getColumnAmount() == this.getColumnAmount()
	 * @post | IntStream.range(0, getColumnAmount()*getRowAmount()).allMatch(
	 * 		 | i -> result.getArrayRowMajorOrder[i] == 
	 * 		 | this.getArrayRowMajorOrder[i] + matrixtoadd.getArrayRowMajorOrder[i])
	 */
	public Matrix plus(Matrix matrixtoadd) {
		return TODO
	}
}
