package com.in73j.taller;

import java.util.List;

import com.in73j.taller.bd.IbatisManager;
import com.in73j.taller.bd.IbatisNameQueries;
import com.in73j.taller.entities.Jugador;
import com.vaadin.Application;
import com.vaadin.ui.*;
import com.vaadin.ui.Button.ClickEvent;

public class TallerApp extends Application {
	
	private static final long serialVersionUID = 1L;

	//UI
	public Window mainWindow;
	public VerticalLayout vl;
	public Table table;
	
	//BD
	public IbatisManager ibatisManager = new IbatisManager();
	
	@Override
	public void init() {
		mainWindow = new Window("IN73J_Taller_Vaadin Application");
		initHomePage();
		setMainWindow(mainWindow);
	}

	public void initHomePage(){
		//TITULO
		vl = new VerticalLayout();
		vl.addComponent(new Label("Hola este es una aplicación realizada en Vaadin Framework!!"));
		
		//FORM
		final TextField tf = new TextField();
		tf.setCaption("Id Jugador:");
		vl.addComponent(tf);
		
		Button b = new Button();
		b.setCaption("Buscar");
		vl.addComponent(b);
		
		//ACTION BUTTON
		b.addListener(new Button.ClickListener() {
			
			private static final long serialVersionUID = 1L;

			public void buttonClick(ClickEvent event) {
				
				if(table==null){
					table = new Table();
					table.addContainerProperty("ID", Integer.class, null);
					table.addContainerProperty("NOMBRE",String.class,null);
					table.addContainerProperty("APELLIDO", String.class, null);
					table.addContainerProperty("EQUIPO", String.class, null);
					table.addContainerProperty("POSICION", Integer.class, null);
				}
				else
					table.removeAllItems();
			
				if(!tf.getValue().toString().equals("")){
				
					Integer id = Integer.parseInt((String)tf.getValue());
					Jugador jugador = (Jugador)ibatisManager.select(IbatisNameQueries.GET_JUGADOR, id);
				
					Object[]row = {jugador.getId(),jugador.getNombre(),jugador.getApellido(),
							   jugador.getEquipo(),jugador.getPosicion()};
				
					table.addItem(row, 1);
					
			}else{
				
				@SuppressWarnings("unchecked")
				List<Jugador> jugadores = (List<Jugador>)ibatisManager.selectList(IbatisNameQueries.GET_JUGADORES, null);
				int i=1;
				for(Jugador jugador:jugadores){
					Object[]row = {jugador.getId(),jugador.getNombre(),jugador.getApellido(),
							   jugador.getEquipo(),jugador.getPosicion()};
				
					table.addItem(row, i++);
				}
				
			}
				vl.addComponent(table);
			}
		});
		
		mainWindow.addComponent(vl);
	}
}
