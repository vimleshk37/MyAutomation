package javaLearning;

import javaUtilities.AbstractObj;

public class OopsConcepts extends AbstractObj {

	public static void main(String[] args) {
		OopsConcepts concepts = new OopsConcepts();
		concepts.VolumeOfObject(1, 2, 3);
		concepts.AreaOfObject(1, 2, 3);
		concepts.SumOfDimensionsOfObject(1, 2, 3);

	}

	@Override
	public void VolumeOfObject(int lenth, int width, int hight) {
		System.out.println("Box Dimensions are " + lenth + " " + width + " " + hight);
		System.out.println("Volume of Box is " + lenth * width * hight);

	}

	@Override
	public void AreaOfObject(int lenth, int width, int hight) {
		System.out.println("Box Dimensions are " + lenth + " " + width + " " + hight);
		System.out.println("Area of Box is " + 2 * (lenth * width + width * hight + lenth * hight));

	}

	@Override
	public void SumOfDimensionsOfObject(int lenth, int width, int hight) {
		System.out.println("Box Dimensions are " + lenth + " " + width + " " + hight);
		System.out.println("Sum Of Dimensions is " + (lenth + width + hight));

	}

}
/*
 * @Override public void VolumeOfObject() {
 * System.out.println("Box Dimensions are " +lenth +" " +width +" " +hight);
 * System.out.println("Volume of Box is " +lenth*width*hight); }
 * 
 * @Override public void AreaOfObject() {
 * System.out.println("Box Dimensions are " +lenth +" " +width +" " +hight);
 * System.out.println("Area of Box is " +2*(lenth*width + width*hight +
 * lenth*hight)); }
 * 
 * @Override public void SumOfDimensionsOfObject() {
 * System.out.println("Box Dimensions are " +lenth +" " +width +" " +hight);
 * System.out.println("Area of Box is " +(lenth+ width + hight)); }
 */