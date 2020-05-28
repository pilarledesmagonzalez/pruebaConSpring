package org.pilus;

import org.pilus.controller.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.pilus.service.DBConnection;
import org.springframework.beans.factory.annotation.Autowired;

public class App {

	public static void main(String[] args) {

		new Controller().getByID();
	}
}
