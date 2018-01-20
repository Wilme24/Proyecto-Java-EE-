package com.ubosque.grupo4N.mb;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.model.chart.CartesianChartModel;
import org.primefaces.model.chart.ChartSeries;

import com.ubosque.grupo4N.servicio.CitaServicio;
import com.ubosque.grupo4N.servicio.EspecialidadServicio;

@ManagedBean(name="ReportesMB")
@SessionScoped
public class ReportesMB {
	
	/**
	 * Clase managed bean 
	 * Creación de variables privadas
	 */
	private CitaServicio ser;
	private EspecialidadServicio esp;
	private List listacita;
	private List listaesp;
	private List listacitaMes;
	private Object[] datoActual;
	private Object[] datoActual2;
	private Object[] datoActual3;
	
	private CartesianChartModel viviendas;  
	private CartesianChartModel viviendas2;
	private CartesianChartModel viviendas3;
	/**
	 * Métodos get de las variables
	 */
	public CartesianChartModel getViviendas() {
		return viviendas;
	}
	
	public CartesianChartModel getViviendas2() {
		return viviendas2;
	}
	
 
	public CartesianChartModel getViviendas3() {
		return viviendas3;
	}

	/**
	 * Metodo para llenar los objetos y los modelos con los datos
	 * */
	@PostConstruct
	public void init(){
		viviendas = new CartesianChartModel();
		viviendas2 = new CartesianChartModel();
		viviendas3 = new CartesianChartModel();
		ser = new CitaServicio();
		esp = new EspecialidadServicio();
		
		
		listacita=ser.consultarCitaReportes();
		listacitaMes=ser.consultarCitaReportesMensual();
		listaesp = esp.consultarEspecialidadReportes();
		final ChartSeries venta  = new ChartSeries("Citas");
		final ChartSeries venta2  = new ChartSeries("Empleados");
		final ChartSeries venta3  = new ChartSeries("Citas");
		
		  List<Object[]> datos = listacita;
		  List<Object[]> datos2 = listaesp;
		  List<Object[]> datos3 = listacitaMes;
		  int j=0;
		    for (int i = 0; i < datos.size(); i++)
		    {
		        datoActual = datos.get(i);
		        venta.set(datoActual[j+1],Integer.parseInt(datoActual[j] + ""));
		        
		    }
		    j=0;
		    for (int i = 0; i < datos2.size(); i++)
		    {
		        datoActual2 = datos2.get(i);
		        venta2.set(datoActual2[j+1],Integer.parseInt(datoActual2[j] + ""));
		        
		    }
		    j=0;
		    for (int i = 0; i < datos3.size(); i++)
		    {
		        datoActual3 = datos3.get(i);
		        venta3.set(datoActual3[j+1] + " ",Integer.parseInt(datoActual3[j] + ""));
		        
		    }
		   
		    
		viviendas.addSeries(venta);
		viviendas2.addSeries(venta2);
		viviendas3.addSeries(venta3);
 
	}
	

}
