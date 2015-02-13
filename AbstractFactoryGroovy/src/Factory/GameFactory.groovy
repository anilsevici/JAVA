package Factory

import java.lang.invoke.BoundMethodHandle.Factory;

class GameFactory {
	
	def static factory
	def static getMessages() { return factory.messages.newInstance() } 
	def static getControl() { return factory.control.newInstance() }
	def static getConverter() { return factory.converter.newInstance() }

}
