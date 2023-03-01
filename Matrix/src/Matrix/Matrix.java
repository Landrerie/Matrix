package Matrix;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * 
 * @immutable
 * @invar | getArrayRowMajorOrder() != null
 * @invar | getArrayColumnMajorOrder() != null
 * @invar | getArrayOfArrays() != null
 * @invar | getRowAmount() >= 0
 * @invar | getColumnAmount() >= 0
 */
public class Matrix {
	
	
	/**
	 * @invar | matrixlist != null
	 * @invar | matrixlist.length == amountofrows*amountofcolumns
	 */
	private double[] matrixlist;
	private int amountofrows;
	private int amountofcolumns;
	

	/**
	 * @inspects | this
	 */
	public int getRowAmount() {
		return amountofrows;
	}
	
	/**
	 * @inspects | this
	 */
	public int getColumnAmount() {
		return amountofcolumns;
	}
	
	/**
	 * @inspects | this
	 * @pre | row < getRowAmount() && row >= 0
	 * @pre | column < getColumnAmount() && column >= 0
	 * @post | result == getArrayOfArrays()[row][column]
	 * 
	 */
	public double getElement(int row, int column) {
		return matrixlist[row*amountofcolumns + column];
	}
	
	/**
	 * @creates | result
	 * @inspects | this
	 * @post | result != null
	 * @post | result.length == getColumnAmount()*getRowAmount()
	 * @post | 	IntStream.range(0, getRowAmount()).allMatch(i ->
	 * 		 | 	IntStream.range(0, getColumnAmount()).allMatch(j ->
	 * 		 | 	getArrayOfArrays()[i][j] == result[i*getColumnAmount() + j]))
	 */
	public double[] getArrayRowMajorOrder() {
		return matrixlist.clone();
	}
	
	/**
	 * @creates | result
	 * @inspects | this
	 * @post | result.length == getColumnAmount()*getRowAmount()
	 * @post | IntStream.range(0, getArrayOfArrays().length).allMatch(i ->
	 * 		 | IntStream.range(0, getArrayOfArrays()[0].length).allMatch(j ->
	 * 		 | getArrayOfArrays()[i][j] == result[j*getRowAmount() + i]))
	 */
	public double[] getArrayColumnMajorOrder() {
		double[] columnlist = new double[matrixlist.length];
		int i = 0;
		for(int column = 0; column < amountofcolumns;column++) {
			for(int row = 0; row < amountofrows*amountofcolumns;row += amountofcolumns) {
				columnlist[i] = matrixlist[column + row];
				i++;
			}
		}
		return columnlist;
	}
	
	/**
	 * @creates | result
	 * @inspects | this
	 * @post | result.length == getRowAmount()
	 * @post | result[0].length == getColumnAmount()
	 */
	public double[][] getArrayOfArrays() {
		double[][] arraylist = new double[amountofrows][amountofcolumns];
		for(int row = 0; row < amountofrows;row++) {
			for(int column = 0; column < amountofcolumns;column++) {
				arraylist[row][column] = matrixlist[row*amountofcolumns + column];
			}
		}
		return arraylist;
	}
	
	/**
	 * 
	 * @throws IllegalArgumentException | inputmatrix != null
	 * @throws IllegalArgumentException | inputrowamount > 0
	 * @throws IllegalArgumentException | inputcolumnamount > 0
	 * @post | getRowAmount() == inputrowamount
	 * @post | getColumnAmount() == inputcolumnamount
	 * @post | inputmatrix.length == inputrowamount*inputcolumnamount
	 * @post | Arrays.equals(inputmatrix, getArrayRowMajorOrder())
	 */
	public Matrix(int inputrowamount, int inputcolumnamount, double[] inputmatrix) {
		amountofrows = inputrowamount;
		amountofcolumns = inputcolumnamount;
		matrixlist = inputmatrix;
	}
	
	/**
	 * @inspects | this
	 * @creates | result
	 * @post | result.getRowAmount() == this.getRowAmount()
	 * @post | result.getColumnAmount() == this.getColumnAmount() 
	 * @post | IntStream.range(0, getColumnAmount()*getRowAmount()).allMatch(
	 * 		 | i -> result.getArrayRowMajorOrder()[i] == 
	 * 		 | scalar * this.getArrayRowMajorOrder()[i]) 
	 */
	public Matrix scaled(int scalar) {
		double[] copylist = matrixlist.clone();
		for(int i = 0;i < matrixlist.length;i++) {
			copylist[i] *= scalar;
		}
		Matrix copymatrix = new Matrix(amountofrows, amountofcolumns, copylist);
		return copymatrix;
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
	 * 		 | i -> result.getArrayRowMajorOrder()[i] == 
	 * 		 | this.getArrayRowMajorOrder()[i] + matrixtoadd.getArrayRowMajorOrder()[i])
	 */
	public Matrix plus(Matrix matrixtoadd) {
		double[] copylist = matrixlist.clone();
		for(int i = 0;i < matrixlist.length;i++) {
			copylist[i] += matrixtoadd.getArrayRowMajorOrder()[i]; 
		}
		Matrix copymatrix = new Matrix(amountofrows, amountofcolumns, copylist);
		return copymatrix;
	}
}
