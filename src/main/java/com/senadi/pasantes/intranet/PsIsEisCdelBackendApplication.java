package com.senadi.pasantes.intranet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.senadi.pasantes.intranet.service.INotificacionService;

@SpringBootApplication
public class PsIsEisCdelBackendApplication implements CommandLineRunner {

	@Autowired
	INotificacionService iNotificacionService;

	public static void main(String[] args) {
		SpringApplication.run(PsIsEisCdelBackendApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Ok");

//		var notificaciones = iNotificacionService.obtenerNotificaciones();
//		for (NotificacionImagenDTO notificacion : notificaciones) {
//			System.out.println(notificacion);
//		}
	}

}
