import scala.swing._
import javax.swing.JTable
import java.awt.Color
import java.awt.BorderLayout
import scala.collection.mutable.Publisher
import scala.swing.event.KeyPressed
import scala.swing.event.Key

object Values {
	val GUIWidth = 800
			val GUIHeight = 600
}

object MyGUi extends SimpleSwingApplication {

	def top = new MainFrame {
		title = "Poca Town Interface"
				var r= new RectangleColore(new Position(5,5),2,2,Color.blue)
		var rr=new RectangleColore(new Position(1,2),4,5,Color.red, "Hello")
		var rrr= new RectangleColore(new Position(0,0),1,1,Color.green,"H1")
		var rrrr= new RectangleColore(new Position(30,10),2,2,Color.red)

		var gamePanel = new GamePanel(Array(r,rr,rrr,rrrr), new Position(0,0),25,25,40,40); 


		contents = new BorderPanel(){
			add(gamePanel, BorderPanel.Position.Center)

		}

		this.pack
		this.size_=(new Dimension(Values.GUIWidth, Values.GUIHeight))

	} 
}


class GamePanel(var rectangles:Array[RectangleColore], private var pos:Position, val caseWidth:Int, val caseHeight:Int, val nbCaseHeight:Int, val nbCaseWidth:Int) extends Panel{
	//GamePanel represente le jeux sous forme de rectangles avec un point de vue. La position du point de vue est le coin en haut a gauche
	def moveRight{
		if(((caseWidth*nbCaseWidth)-(Values.GUIWidth+pos.x))>0){
			pos.x +=5
		}
	}
	
	def moveLeft{
		if(pos.x>0){
			pos.x -= 5
		}
	}

	def moveUp{
		if(pos.y>0){
			pos.y -= 5
		}
	}
	def moveDown{
		if(((caseHeight*nbCaseHeight)-(Values.GUIHeight+pos.y))>0){
			pos.y += 5
		}
	}

	listenTo(keys)
	reactions += {
	case KeyPressed(_, Key.Right, _, _) =>
	moveRight
	repaint
	case KeyPressed(_, Key.Left, _, _) =>
	moveLeft
	repaint
	case KeyPressed(_, Key.Down, _, _) =>
	moveDown
	repaint
	case KeyPressed(_, Key.Up, _, _) =>
	moveUp
	repaint
	}
	focusable = true
			requestFocus

			override def paintComponent(g:Graphics2D){
		g.setColor(Color.white)
		g.fillRect(0, 0, caseWidth * nbCaseWidth, caseHeight * nbCaseHeight)

		def paintMe(c:RectangleColore) = {
			//Petite fonction pour peindre un rectangle
			//Pour optimiser on pourrai tester si le rectangle est vue dans le panel
			//ou si il est en dehors de ce qui est representer

			g.setColor(c.color)
			g.fillRect((c.p.x*caseWidth)- pos.x, (c.p.y*caseHeight )- pos.y, c.heightInCase * caseHeight, c.widthInCase * caseWidth);
			if( c.text != null ){
				g.setColor(Color.black)
				g.drawString(c.text, c.p.x * caseWidth+1- pos.x, (c.p.y*caseHeight) + ((c.heightInCase*caseHeight)/2) - pos.y)
			}
		}


		if( rectangles != null){
			rectangles.map(paintMe)



		} else {
			error("no rectangles to draw !!")
		}
		for ( i <- 0 to nbCaseWidth; j <- 0 to nbCaseHeight){
			g.setColor(Color.black)
			g.drawLine(i*caseHeight - pos.x, 0, i*caseHeight - pos.x, (nbCaseHeight * caseHeight))
			g.drawLine(0, j*caseWidth - pos.y, (nbCaseWidth * caseWidth), j*caseWidth - pos.y)  
		}
	}

}

class Position(var x:Int, var y:Int)
class RectangleColore (val p:Position, val heightInCase:Int, val widthInCase:Int, var color:Color, var text:String = null)



