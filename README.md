# 💱 Conversor de Monedas - Challenge Alura

![Java](https://img.shields.io/badge/Java-21+-blue.svg)
![Status](https://img.shields.io/badge/Status-Completado-success.svg)

## 📋 Descripción

Aplicación de consola desarrollada en Java que permite convertir entre diferentes monedas utilizando tasas de cambio en tiempo real a través de la API de ExchangeRate-API.

## ✨ Características

- ✅ Conversión de 6 pares de monedas principales
- 🌐 Consumo de API REST para tasas actualizadas
- 🔄 Interfaz de menú interactivo
- 📊 Manejo de errores y validaciones
- 💻 Código orientado a objetos

## 🚀 Conversiones Disponibles

1. Dólar (USD) → Peso Argentino (ARS)
2. Peso Argentino (ARS) → Dólar (USD)
3. Dólar (USD) → Real Brasileño (BRL)
4. Real Brasileño (BRL) → Dólar (USD)
5. Dólar (USD) → Peso Colombiano (COP)
6. Peso Colombiano (COP) → Dólar (USD)

## 🛠️ Tecnologías Utilizadas

- **Java 21**
- **Gson** - Procesamiento de JSON
- **HttpClient** - Consumo de API REST
- **ExchangeRate-API** - Proveedor de tasas de cambio
  - Endpoint utilizado: `/pair/` (Consulta por pares de monedas)

## 📦 Estructura del Proyecto

```
conversor-monedas/
│
├── 📂 .idea/                          # Configuración de IntelliJ (no subir a Git)
├── 📂 target/                         # Archivos compilados (no subir a Git)
│
├── 📂 src/
│   └── 📂 com.challengeone.java.backend.conversormonedas/
│       ├── 📄 Conversor.java          # 150 líneas aprox.
│       ├── 📄 ConversorApp.java       # 200 líneas aprox.
│       ├── 📄 HistorialConversiones.java  # 100 líneas aprox.
│       ├── 📄 Moneda.java             # 80 líneas aprox.
│       └── 📄 ServicioAPI.java        # 120 líneas aprox.
│
├── 📄 .gitignore                      # Ignorar archivos sensibles
└── 📄 README.md                       # Este archivo
```

## ⚙️ Instalación y Configuración

### Prerrequisitos

- JDK 17 o superior
- Maven 3.8 o superior
- Conexión a Internet
- **IntelliJ IDEA** (Community o Ultimate), Eclipse o cualquier IDE Java
  - 📖 **Guía específica para IntelliJ**: Ver `GUIA_INTELLIJ.md`

### Pasos de Instalación

1. **Clonar el repositorio**
```bash
git clone https://github.com/catochohn/conversor-moneda-alura
cd conversor-monedas-alura
```

2. **Obtener API Key**
   - Visita [ExchangeRate-API](https://www.exchangerate-api.com/)
   - Regístrate con tu email
   - Copia tu API Key gratuita
   - **📖 Lee la guía detallada**: `GUIA_API_KEY.md`

3. **Configurar API Key**
   - Abre el archivo `src/config/ConfigAPI.java`
   - Reemplaza `TU_API_KEY_AQUI` con tu API Key:
   ```java
   public static final String API_KEY = "tu_api_key_aqui";
   ```

### ⚡ Endpoint de API Utilizado

Este proyecto utiliza el **endpoint de consulta por pares** de ExchangeRate-API:

```
https://v6.exchangerate-api.com/v6/{API-KEY}/pair/{MONEDA-ORIGEN}/{MONEDA-DESTINO}
```

**Ventajas**:
- ✅ Más eficiente (solo consulta el par específico)
- ✅ Respuesta más rápida y ligera
- ✅ Menor uso de ancho de banda
- ✅ Ideal para conversiones específicas

**Ejemplo de respuesta**:
```json
{
  "result": "success",
  "base_code": "USD",
  "target_code": "ARS",
  "conversion_rate": 350.25
}
```

4. **Compilar el proyecto**
```bash
mvn clean install
```

5. **Ejecutar la aplicación**
```bash
mvn exec:java -Dexec.mainClass="principal.Principal"
```

O desde tu IDE, ejecuta la clase `Principal.java`

## 💡 Uso de la Aplicación

1. Al iniciar, verás el menú de bienvenida
2. Selecciona una opción del 1 al 6 para elegir el tipo de conversión
3. Ingresa el monto que deseas convertir
4. El sistema consultará las tasas actuales y mostrará el resultado
5. Puedes realizar múltiples conversiones
6. Selecciona opción 7 para salir

### Ejemplo de Uso

```
═══════════════════════════════════════════════
            MENÚ DE CONVERSIONES               
═══════════════════════════════════════════════
1) Dólar         =>> Peso argentino
2) Peso argentino =>> Dólar
3) Dólar         =>> Real brasileño
4) Real brasileño =>> Dólar
5) Dólar         =>> Peso colombiano
6) Peso colombiano =>> Dólar
7) Salir
═══════════════════════════════════════════════
Elija una opción válida: 1

Ingresa el valor que deseas convertir: 25

🔄 Consultando tasas de cambio...
✅ El valor de 25.00 [Dólares] corresponde al valor final de =>>> 20293.75 [Pesos argentinos]
```

## 🎯 Conceptos Aplicados

- **Programación Orientada a Objetos**: Clases, encapsulación, modularidad
- **Consumo de APIs REST**: HttpClient, manejo de respuestas HTTP
- **Manejo de JSON**: Deserialización con Gson
- **Manejo de Excepciones**: Try-catch, validaciones
- **Separación de Responsabilidades**: Patrón de capas (modelo, servicio, principal)
- **Buenas Prácticas**: Código limpio, nombres descriptivos

## 🔧 Posibles Mejoras Futuras

- [ ] Agregar más pares de monedas
- [ ] Implementar historial de conversiones
- [ ] Crear interfaz gráfica (GUI)
- [ ] Guardar conversiones en base de datos
- [ ] Agregar conversión inversa automática
- [ ] Implementar caché de tasas de cambio
- [ ] Crear tests unitarios

## 📚 Recursos Adicionales

- [Documentación de Java](https://docs.oracle.com/en/java/)
- [ExchangeRate-API Docs](https://www.exchangerate-api.com/docs)
- [Gson User Guide](https://github.com/google/gson/blob/master/UserGuide.md)
- [Maven Getting Started](https://maven.apache.org/guides/getting-started/)

## 👨‍💻 Autor

**Tu Nombre**
- GitHub: [@catochohn](https://github.com/catochohn)
- LinkedIn: [Eduardo Aguilar](www.linkedin.com/in/eduardo-aguilar-62a765384)

## 📄 Licencia

Este proyecto es parte del Challenge de Alura LATAM - ONE (Oracle Next Education)

## 🙏 Agradecimientos

- Alura LATAM y Oracle por el programa ONE
- ExchangeRate-API por proporcionar la API gratuita
- La comunidad de desarrolladores Java

---

⭐ **Si este proyecto te fue útil, no olvides darle una estrella en GitHub**

💬 **¿Preguntas o sugerencias?** Abre un issue o contáctame directamente
