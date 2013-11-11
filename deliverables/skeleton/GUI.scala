import scala.swing._
import javax.swing.JTable
import java.awt.Color


object HelloWorld extends SimpleSwingApplication {

	def grid = new Table(20,13) {
		//setShowGrid(true);
		//visible = true
		gridColor = Color.BLACK
				showGrid=true

	}

	def top = new MainFrame {
		setLocationRelativeTo(grid)
		title = "Poca Town Interface"
		var r= new RectangleColore(new Position(10,10),50,50,Color.blue)
		var rr=new RectangleColore(new Position(60,70),50,100,Color.red, "Hello")

		contents = new GamePanel(Array(r,rr), new Position(0,0),10,10,1000,1000); 
	} 
}


class GamePanel(var rectangles:Array[RectangleColore], var pos:Position, val caseWidth:Int, val caseHeight:Int, val panelWidth:Int, val panelHeight:Int) extends Panel{
	//GamePanel represente le jeux sous forme de rectangles avec un point de vue. La position du point de vue est le coin en haut a gauche

	override def paintComponent(g:Graphics2D){
		def paintMe(c:RectangleColore) = {
			//Petite fonction pour peindre un rectangle
			//Pour optimiser on pourrai tester si le rectangle est vue dans le panel
			//ou si il est en dehors de ce qui est representer

			g.setColor(c.color)
			g.fillRect(c.p.x- pos.x, c.p.y - pos.y, c.height, c.width);
			if( c.text != null ){
				g.setColor(Color.black)
				g.drawString(c.text, c.p.x, c.p.y);
				//TODO centre le text sur la cases ET re-sizer le text pour rentré dedans

			}
		}


		if( rectangles != null){
			rectangles.map(paintMe)

			for ( i <- 0 to panelWidth by caseWidth; j <- 0 to panelHeight by caseHeight){
				g.drawLine(i, 0, i, panelHeight)
				g.drawLine(0, j, panelWidth, j)  
			}

		} else {
			error("no rectangles to draw !!")
		}
	}

}

class Position(val x:Int, val y:Int)
class RectangleColore (val p:Position, val height:Int, val width:Int, var color:Color, var text:String = null)



