public class Die{
	int numOfFaces;
	int faceValue;


	public Die(){
		numOfFaces = 6;
		getFaceNum();
	}

	public Die(int nF){
		numOfFaces = nF;
		getFaceNum();	
	}

	public int getFaceNum(){
	faceValue = Math.random()*numOfFaces + 1;
	return faceValue;
	}

	public int roll(){
		faceValue = Math.random()*numOfFaces + 1;
		return faceValue;
	}

	public String toString(){
		return "Your die has " + this.numOfFaces + " number of faces and the top value is " + this.faceValue;
	}

	public boolean equals(o1,o2){
		if o1 == o2
			return true;
		else return false;
	}


}