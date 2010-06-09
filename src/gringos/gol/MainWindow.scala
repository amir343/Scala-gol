package gringos.gol

import scala.swing._;
import java.awt.Color

import java.awt.Graphics;

/**
 * @author Amir Moulavi
 * @author Sven Johansson
 */


class MainWindow extends Frame {
		
	title = "Game of Life "
	contents = canvas
	var board = Board 
	var step = 16
	var interval = 100
	var generation = 1
	
	def update {
		board.update
		canvas.repaint
	}
	
	object canvas extends Panel {
		
		size = new Dimension(1290, 640)
		
		override def paintComponent(g: java.awt.Graphics2D) {
			g.setColor(Color.WHITE)
			g.fillRect(0,0,1290,640)
			
			g.setColor(Color.BLACK)
			
			for {y <- 0 to 640 by step} {
				g.drawLine(0, y, 1280, y)
			}
			for {x <- 0 to 1280 by step} {
				g.drawLine(x, 0, x, 640)
			}
			
			g.setColor(Color.RED)
 
			for {x <- 0 to 79; y<- 0 to 39} {
				if (board.board(x)(y) == true) {
					g.fillRect((x * 16) + 1, (y * 16) + 1, 15, 15)
				}
			}
			
		}
	}
	
	
	
}