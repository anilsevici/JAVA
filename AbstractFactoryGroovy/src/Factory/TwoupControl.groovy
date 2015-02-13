package Factory

class TwoupControl {
	
	private money = 1000
	private random = new Random()
	private tossWasHead() {
		def next = random.nextInt()
		return next % 2 == 0
	}
	def moreTurns() {
		if (money > 0) {
			println "You have $money, how much would you like to bet?"
			return true
		}
		return false
	}
	def play(amount) {
		def coin1 = tossWasHead()
		def coin2 = tossWasHead()
		if (coin1 && coin2) {
			money += amount
			println 'You win'
		} else if (!coin1 && !coin2) {
			money -= amount
			println 'You lose'
		} else println 'Draw'
	}

}
