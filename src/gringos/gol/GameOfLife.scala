package gringos.gol

import scala.swing._;

/**
 * @author Amir Moulavi
 * @author Sven Johansson
 */



object GameOfLife {

	def main(args : Array[String]) : Unit = {
		var window = new MainWindow()
		window.size = new Dimension (1290, 670)
		window.visible = true;

		var hoola = new Thread(new PlayNice(window))

		hoola.start


	}

}

class PlayNice(window: MainWindow) extends Runnable() {

	override def run() {
		while (true) {
			Thread.sleep(window.interval)
			window.update;
		}
	}

}
