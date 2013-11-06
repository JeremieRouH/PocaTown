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
    contents = new FlowPanel(grid)  
  } 
}