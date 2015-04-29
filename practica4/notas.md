# Notas
## Apartado 1
Los productos y los contenedores se puden guardar en camiones y contenedores.
Los camiones y los contenedores pueden almacenar contenedores y productos.
Por lo tanto productos y contenedores tienen en comun que se pueden guardar
dentro de otros objetos; camiones y contenedores tienen en comun que pueden
guardar otros objetos. Esto lo vamos a representar mediante dos interfaces 
de las que heredan estas tres clases, Guarda y Ocupa.
Camion hereda de Guarda, Contenedor de Guarda y Ocupa, y Producto de Ocupa.