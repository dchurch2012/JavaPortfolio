/**
  *  <h1>Class Validate Description</h1></br>
  *
  *  Accepts a string that represents a number - validates that 
  *  user in fact a number only and in correct format
  *
  * Examples:
  *
  * 3.21	Valid
  * 3.2AB	Invalid
  * ABC		Invalid
  * 3.2.2	Invalid
  *
  * @author Scott Hughes
  * @version 1.0.0 Build 1 October 18th, 2018. 
  *
  *	ALGORITHM 
  * 
  * For index = 0 to String length
  * 	IF Data[index] Is a Digit OR Data[index] Is a Decimal Point Then
  *		BEGIN
  *			IF Data[index] Is a Decimal Point
  *			BEGIN	
  *				Increment DecCount
  *				IF DecCount > 1 Then
  *				BEGIN
  *					Return FALSE
  *				END
  *			END
  *		ELSE
  *			Return FALSE
  *		ENDIF
  *	NEXT index
  * Return TRUE
  */
 
public class ValidateData {
	public void ValidateData(String input_string) {
		// TODO Auto-generated method stub
		
	}

	/** Description of ValidateData(String input_string)
	* 
	* @param	inputString 		String inputString
	* @return 	boolean -- true => valid data;false=>invalid
	*/
	boolean validateDecimal(String inputString)	{
		/** To store length of string */
		int length = inputString.length();
		
		/** looping index */
		int index = 0;
		
		/** Keep track of decimal count */
		int decCount = 0;
		
		/** Loop through each character in string */
		for(index = 0; index < length; index++)
		{
			if (index == 0)
			{
				/** If Character Is a minus sign (-) -- then proceed */
				if(inputString.charAt(index) == '-')
				{
					if(length == 1)
					{
						return false;
					}
					else {
						index++;
					}
				}
				else
				{
					/** Past the first index, if Character Is a Digit OR a Decimal Point -- then proceed */
					if(Character.isDigit(inputString.charAt(index)) || inputString.charAt(index) == '.')
					{
						/** If Character IS a decimal -- increment decCount (so we can reject multiple decimal points (invalid)) */
						if(inputString.charAt(index) == '.')
						{
							decCount++;
						}
						/** Don't allow more than 1 decimal point */
						if(decCount > 1)
						{
							return false;
						}
					}
					else
					{
						/** Character is NOT valid - so return false */
						return false;
					}
				}
			}
			else
			{
				/** Past the first index, if Character Is a Digit OR a Decimal Point -- then proceed */
				if(Character.isDigit(inputString.charAt(index)) || inputString.charAt(index) == '.')
				{
					/** If Character IS a decimal -- increment decCount (so we can reject multiple decimal points (invalid)) */
					if(inputString.charAt(index) == '.')
					{
						decCount++;
					}
					/** Don't allow more than 1 decimal point */
					if(decCount > 1)
					{
						return false;
					}
				}
				else
				{
					/** Character is NOT valid - so return false */
					return false;
				}
			}	
		}
		
		/** Got this far without returning - so data must be valid */
		return true;
	}

	/** Description of validateInteger(String input_string)
	* 
	* @param	inputString 			String inputString
	* @return 	boolean -- true => valid data;false=>invalid
	*/
	boolean validateInteger(String inputString) {
		/** To store length of string */
		int length = inputString.length();
		
		/** looping index */
		int index = 0;
		
		/** Loop through each character in string */
		for(index = 0; index < length; index++)
		{
			if (index == 0)
			{
				/** If Character Is a minus sign (-) -- then proceed */
				if(inputString.charAt(index) == '-')
				{
					if(length == 1)
					{
						return false;
					}
					else {
						index++;
					}
				}
				else
				{
					/** Past the first index, if Character Is a Digit OR a Decimal Point -- then proceed */
					if(!Character.isDigit(inputString.charAt(index)))
					{
						/** Character is NOT valid - so return false */
						return false;
					}
				}
			}
			else
			{
				/** Past the first index, if Character Is a Digit */
				if(!Character.isDigit(inputString.charAt(index)))
				{
					/** Character is NOT valid - so return false */
					return false;
				}
			}	
		}
		
		/** Got this far without returning - so data must be valid */
		return true;
	}

}	//end class Validate