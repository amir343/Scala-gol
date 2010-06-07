package gringos.gol

import scala.util.Random

object Board {
	var rnd = new Random
	var board = initializeBoard
	
	def initializeBoard () = {
		var board = new Array[Array[Boolean]](80, 40)
		for {m <- 0 to 79; n<- 0 to 39} {
			if (rnd.nextInt(100) <= 25) 
				board(m)(n) = true
			else 
				board(m)(n) = false
		}
		board
	}
	
	def update (): Unit = {
		var newboard = new Array[Array[Boolean]](80, 40)
		for {i <- 0 to 79; j <- 0 to 39} {
			var nr = numberOfLivingNeighborsFor(i, j)
			if (board(i)(j) == true) {
				newboard(i)(j) = nr match {
					case 2 => true
					case 3 => true
					case _ => false 
				}
			} else {
				newboard(i)(j) = nr match {
					case 3 => true
					case _ => false 
				}
			}
		}
		board = newboard
	}
	
	def numberOfLivingNeighborsFor(x: Int, y: Int) = {
		var nrLive = 0
		for {s <- x-1 to x+1; p <- y-1 to y+1} {
			if (s > -1 && s < 80)
				if (p > -1 && p < 40) {
					if ( s != x || p != y) { 
						if (board(s)(p) == true) 
							nrLive += 1 
					}
				}
		}
		
		nrLive
	}
	

}