# Conversor de Monedas

Un conversor de monedas en Java que permite realizar conversiones en tiempo real entre diferentes monedas utilizando una API de tipo de cambio.

## Descripción

Este proyecto permite a los usuarios convertir montos en diferentes monedas de manera sencilla y precisa. Mediante una integración con la API de ExchangeRate, el programa obtiene los tipos de cambio actualizados para realizar las conversiones de moneda en tiempo real. 

### Características

- Conversión en tiempo real entre múltiples monedas.
- Opciones para convertir entre Dólares, Pesos Mexicanos, Reales Brasileños y Pesos Colombianos.
- Menú interactivo para una experiencia de usuario intuitiva.
- Múltiples conversiones sin necesidad de reiniciar el programa.

## Instalación

1. Clona el repositorio en tu máquina local:
   ```bash
   git clone https://github.com/tu-usuario/conversor-de-monedas.git

   Asegúrate de tener Java JDK instalado.
Importa el proyecto en tu IDE de preferencia (IntelliJ, Eclipse, etc.).
Uso
Ejecuta la clase principal PrincipalConBusqueda desde tu IDE.
Selecciona una opción del menú para realizar la conversión deseada.
Ingresa la cantidad que deseas convertir.
El programa mostrará el resultado en la moneda seleccionada.

Ejemplo de uso

===== Bienvenidos al conversor de monedas =====
1.- Dólar a Peso Mexicano
2.- Peso Mexicano a Dólar
3.- Dólar a Real Brasileño
4.- Real Brasileño a Dólar
5.- Dólar a Peso Colombiano
6.- Peso Colombiano a Dólar
7.- Salir
Seleccione una opción: 1
¿Qué cantidad quieres convertir?: 100
100.0 USD son 1,800.00 MXN

Tecnologías y Bibliotecas Utilizadas
Java: Lenguaje principal para la implementación del conversor.
Java HttpClient: Biblioteca nativa para realizar peticiones HTTP a la API de ExchangeRate.
Gson: Biblioteca de Google para manejar y parsear JSON.
Configuración de la API
Este proyecto utiliza ExchangeRate API para obtener los tipos de cambio en tiempo real. Para ejecutar el proyecto, debes reemplazar la clave de API por tu clave personal:

Regístrate en ExchangeRate para obtener una clave de API.
Reemplaza el valor de apiKey en el código:

String urlApiBase = "https://v6.exchangerate-api.com/v6/YOUR_API_KEY/latest/USD";




