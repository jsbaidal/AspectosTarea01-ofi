package tarea;

import java.awt.Color;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Pointcut;;


	public aspect FechaAspect {
	
		
	@Pointcut("execution(void tarea.PanePrincipal.actualizarColor(java.awt.Color)) && args(color)")
	public void colorChangePointcut(Color color) {}

	@After("colorChangePointcut(color)")
	public void logDateTimeAfterColorChange(Color color) {
	    LocalDateTime now = LocalDateTime.now();
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	    String formattedDateTime = now.format(formatter);
	    System.out.println("Fecha y hora actual después del cambio de color (" + color.toString() + "): " + formattedDateTime);
	}
	}
}
