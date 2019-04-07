object BaseConversions {
  def main(args: Array[String]): Unit = {

    var number:String="";
    var curbase:Int=0;
    var newbase:Int=0;
    var tempdecimal:Int=0;
    var result:String="";
    var opt:Int=0;

    println("--- Welcome to the base converter ---")

    do{

      println();
      println("1 - Convert a number");
      println("0 - Exit");
      println();
      print("Enter your option : ");

      opt=scala.io.StdIn.readInt();

      opt match {
        case 1=>{
          print("Enter the number you want to convert : ");
          number=scala.io.StdIn.readLine();

          print("Enter the current base of the number : ");
          curbase=scala.io.StdIn.readInt();

          print("Enter the base that you want the number converted into : ");
          newbase=scala.io.StdIn.readInt();

          tempdecimal=anyToDecimal(number,curbase);
          result=decimalToAny(tempdecimal,newbase);

          println("Converted no is  : "+result);
        }

        case 0=>
          println("Thank you!");
          opt=0;

        case _ =>
          println("Invalid option!");
      }

    }while(opt!=0);


  }

  def decimalToAny(n:Int, b:Int): String ={
    var number:Int=n;
    var base:Int=b;
    var returnString: String = ""



    while (number != 0) {
      if ((number % base) > 9) {
        returnString += ((number % base) + 55).toChar
      } else {
        returnString += (number % base).toString

      }
      number /= base
    }

    return returnString.reverse;
  }


  def anyToDecimal(number: String, b: Int): Int = {

    var base:Int=b;
    val numberArray = number.toLowerCase.reverse.toArray
    var decimal: Int = 0
    var mult = 1;
    for (i <- 0 until numberArray.length) {
      if (numberArray(i).toInt > 96) {
        decimal += (numberArray(i).toInt - 87) * mult
      } else {
        decimal += (numberArray(i).toInt - 48) * mult;
      }
      mult *= base

    }

    return decimal

  }



}
