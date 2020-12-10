package com.jbac.rxjava.rxjava.examples;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;

public class App {
	
	private List<Integer> lista1;
	private List<Integer>lista2;
	
	public App() {
		lista1= new ArrayList<>();
		lista2 = new ArrayList<>();
		this.llenarListas();
		
	}
	public void llenarListas() {
		for (int i = 0; i < 10; i++) {
			lista1.add(i);
			lista2.add(i);
		}
	}
	public void buscar() {
		
		Observable<Integer> obs1 = Observable.from(lista1);
		Observable<Integer> obs2 = Observable.from(lista2);
		
		//Une dos observables
		/*Observable.merge(obs1,obs2).subscribe(new Action1<Integer>() {

			@Override
			public void call(Integer numero) {
				
				if (numero==1) {
					
					System.out.println(numero);
				}
			}
			
			
		});*/
		//Lambda
		//Observable.merge(obs1,obs2).filter(x->x==1).subscribe(System.out::println);
		Observable.merge(obs1,obs2).filter(x->x==1).subscribe(x->{
			if (x==1) {
				System.out.println(x);
			}
		});
	}
	
	public static void main(String[] args) {
		 /*List<String> lista = new ArrayList<>();
		 lista.add("jbac");
		 lista.add("bonifacio");
		 lista.add("lozano");
		 
		 //Creando un objeto observable de una lista
		 Observable<String> obs = Observable.from(lista);
		 obs.subscribe(new Action1<String>() {

			@Override
			public void call(String elemento) {
				System.out.println(elemento);
			}
			 
			 
		 });*/
		 
		 App ap = new App();
		 ap.buscar();
	}
	
}
