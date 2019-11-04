package Slider;

import javax.swing.JFrame;

import Slider.Gameplay;

public class Main {

	public static void main(String[] args) {
		JFrame obj = new JFrame();
		Gameplay gp=new Gameplay();
		obj.setBounds(10,10,820,620);
		obj.setTitle("Slider");
		obj.setResizable(false);
		obj.setVisible(true);
		obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		obj.add(gp);
	}
}
