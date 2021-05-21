package com.softserve.edu.begmst.Computer;

public class Computer {
	private Command[] commands;
	private Data[] data;
	
	public void run()
	{
		for (Command c : this.commands) {
			c.run();
		}
	}
}

abstract class Command {
	
	public Command()
	{
		
	}
	
	public Command (Data x) {
		
	}
	abstract public void run() throws Exception;	
//	abstract public void run(Data x) throws Exception;	
//	abstract public void run(Data x, Data y) throws Exception;	
}

class MovCommand extends Command {
	
	public void run(Data x, Data y) {
		x.setValue(y.getValue());
	}
}

class AddCommand extends Command {
	public void run() throws Exception {
		throw new Exception("Invalid parameters");
	}
	
	public void run(Data x) throws Exception {
		throw new Exception("Invalid parameters");		
	}
	
	public void run(Data x, Data y) throws Exception {
		x.setValue((byte)(x.getValue() + y.getValue()));
	}
}

class Data {
	private byte value;
	
	public void setValue(byte value) {
		this.value = value;
	}
	
	public byte getValue() {
		return this.value;
	}
}
