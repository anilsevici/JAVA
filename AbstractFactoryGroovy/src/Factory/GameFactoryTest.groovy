package Factory

class GameFactoryTest {

	static main(args) {
		
		//def guessFactory = [messages:GuessGameMessages, control:GuessGameControl, converter:GuessGameInputConverter]
		def twoupFactory = [messages:TwoupMessages, control:TwoupControl, converter:TwoupInputConverter]
		
		GameFactory.factory = twoupFactory 
		def messages = GameFactory.messages 
		def control = GameFactory.control
		def converter = GameFactory.converter
		println messages.welcome
		def reader = new BufferedReader(new InputStreamReader(System.in))
		while (control.moreTurns()){
			def input = reader.readLine().trim()
			control.play(converter.convert(input))
		}
		println messages.done
	
	}

}
