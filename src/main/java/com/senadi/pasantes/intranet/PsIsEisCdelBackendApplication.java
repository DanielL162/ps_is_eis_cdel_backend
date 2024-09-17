package com.senadi.pasantes.intranet;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.senadi.pasantes.intranet.repository.modelo.Notificacion;
import com.senadi.pasantes.intranet.service.INotificacionService;
import com.senadi.pasantes.intranet.service.to.NotificacionTO;

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
		List<NotificacionTO> notificaciones= iNotificacionService.obtenerNotificaciones();
		for (NotificacionTO notificacion : notificaciones) {
			System.out.println(notificacion);
		}
	}

}
