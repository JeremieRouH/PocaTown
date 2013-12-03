abstract class Position(initNumbers: Int*) {

  def move(dimension: Int, value: Int);

}

private class ArrayPosition(initNumbers: Seq[Int]) {
  var Positions = initNumbers.toArray;

  def move(dimension: Int, value: Int) {
    Positions(dimension) += value;
  }
}

object Position {
  def apply(numbers: Int*) {
    new ArrayPosition(numbers);
  }
}