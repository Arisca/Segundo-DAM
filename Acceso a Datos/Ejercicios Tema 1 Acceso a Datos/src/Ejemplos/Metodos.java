Métodos para los permisos

Los siguientes métodos nos permiten consultar y modificar los permisos del File, al más puro estilo Linux

canRead () 	Vuelve true si se tiene permiso de lectura sobre el archivo o directorio 
canWrite () 	Vuelve true si se tiene permiso de escritura sobre  el fichero o directorio
canExecute ()	Vuelve true si es ejecutable
setReadable (Boolean, Boolean)	Da permiso o no de lectura sobre el archivo, según el primer parámetro. En el segundo indicamos si afecta sólo al propietario (true) o todo el mundo (false)
setWritable (Boolean, Boolean)	Da permiso de escritura o no, según el valor del primer parámetro. El segundo actúa igual que antes
setExecutable (Boolean, Boolean)	Da permiso de ejecución, según el valor del primer parámetro. El segundo actúa igual que antes

Métodos de creación y borrado

Nos permitirán crear diectoris, archivos vacíos y borrarlos

createNewFile () 	Crear un nuevo archivo vacío asociado al File, siempre que no exista ya uno con el mismo nombre 
delete () 	Borrar el archivo o directorio 
mkdir () 	Crea un directorio con el nombre indicado en la creación del File. Debe existir el directorio padre
mkdir ()	Como el anterior, pero si hay que crea todos los directorios de la ruta necesarios
renameTo (String nou_nom) 	Cambia el nombre del archivo o directorio 

Métodos sobre el espacio del dispositivo

También disponemos de métodos que nos dicen el espacio total y libre del dispositivo donde está situado el File

getFreeSpace ()	Vuelve el espacio libre del dispositivo donde está situado el File
getUsableSpace ()	Vuelve el espacio utilizable para la aplicación (menor que el espacio libre)
getTotalSpace () 	Vuelve el espacio total del dispositivo donde está situado el File 


