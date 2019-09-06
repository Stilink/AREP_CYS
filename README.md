# AREP - Clientes y servicios
En este documento se presenta el desarrollo y uso del laboratorio de Arquitecturas empresariales - Clientes y servicios.

## Ejercicio 1
Un programa que imprima los resultados de los diferentes metodos.
![alt text](https://github.com/Stilink/AREP_CYS/blob/master/img/1.PNG)

## Ejercicio 2
Ejercicio donde se pregunte una URL y se muestre la página. Sin embargo, no logré tener en cuenta los archivos css y eso. Además la información se guarda en un archivo del directorio raiz llamado "web.html".
![alt text](https://github.com/Stilink/AREP_CYS/blob/master/img/2_codigo.PNG)
![alt text](https://github.com/Stilink/AREP_CYS/blob/master/img/2_prueba.PNG)

## Ejercicio 3
Ejercicio donde se solicita que el servidor reciba numeros y responda con los cuadrados de los mismos.
![alt text](https://github.com/Stilink/AREP_CYS/blob/master/img/3_codigo_cliente.PNG)
![alt text](https://github.com/Stilink/AREP_CYS/blob/master/img/3_codigo_server.PNG)
![alt text](https://github.com/Stilink/AREP_CYS/blob/master/img/3_prueba.PNG)

## Ejercicio 4
Servidor que permita funciones seno, coseno y tangente. Las maneras de cambiar son: {fun:sin, fun:cos, fun:tan}.
![alt text](https://github.com/Stilink/AREP_CYS/blob/master/img/4_codigo_server.PNG)
![alt text](https://github.com/Stilink/AREP_CYS/blob/master/img/4_codigo_cliente.PNG)
![alt text](https://github.com/Stilink/AREP_CYS/blob/master/img/4_prueba.PNG)

## Ejercicio 4_4
Servidor que presenta un servidor web. Retorna una respuesta simple "Test".
![alt text](https://github.com/Stilink/AREP_CYS/blob/master/img/4_4_codigo.PNG)
![alt text](https://github.com/Stilink/AREP_CYS/blob/master/img/4_4_ejecucion_consola.PNG)
![alt text](https://github.com/Stilink/AREP_CYS/blob/master/img/4_4_prueba.PNG)

## Ejercicio 4_5
Servidor web que soporte multiples peticiones.
![alt text](https://github.com/Stilink/AREP_CYS/blob/master/img/4_5_prueba_png.PNG)
![alt text](https://github.com/Stilink/AREP_CYS/blob/master/img/4_5_prueba_html.PNG)

# Aclaraciones
Para ejecutar los ejercicios, funciona con lo siguiente:
> mvn package <
> mvn exec:java -Dexec.mainClass="edu.eci.arep.exercise_**X**.**CLASS**" <
Para más información recurrir al código de los mismos.
