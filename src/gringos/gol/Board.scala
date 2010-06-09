package gringos.gol

import scala.util.Random

/**
 * @author Amir Moulavi
 * @author Sven Johansson
 */


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
			
			var S = s
			var P = p
			
			if (S == -1) S = 79
			else if (S == 80) S = 0
			
			if (P == -1) P = 39
			else if (P == 40) P = 0			
			
			if ( S != x || P != y) { 
				if (board(S)(P) == true) 
					nrLive += 1 
			}
			
		}
		
		nrLive
	}
	

}