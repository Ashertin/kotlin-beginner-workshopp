// Clase Contacto
class Contacto(
    val nombre: String,
    val telefono: String,
    val correo: String
) {
    fun mostrarInformacion() {
        println("Nombre: $nombre | Telefono: $telefono | Correo: $correo")
    }
}

// Lista mutable que guardará los contactos
val agenda = mutableListOf<Contacto>()

// Agregar contacto
fun agregarContacto(contacto: Contacto) {
    agenda.add(contacto)
    println("Contacto '${contacto.nombre}' agregado.")
}

// Listar todos
fun listarContactos() {
    println("\n--- LISTA DE CONTACTOS (${agenda.size}) ---")
    if (agenda.isEmpty()) {
        println("La agenda esta vacia.")
    } else {
        for (c in agenda) {
            c.mostrarInformacion()
        }
    }
}

// Buscar por nombre
fun buscarPorNombre(nombre: String) {
    println("\nBuscando: $nombre")
    val encontrado = agenda.find { it.nombre.equals(nombre, ignoreCase = true) }
    if (encontrado != null) {
        println("Contacto encontrado:")
        encontrado.mostrarInformacion()
    } else {
        println("El contacto '$nombre' no existe.")
    }
}

// Eliminar por nombre
fun eliminarPorNombre(nombre: String) {
    val encontrado = agenda.find { it.nombre.equals(nombre, ignoreCase = true) }
    if (encontrado != null) {
        agenda.remove(encontrado)
        println("Contacto '$nombre' eliminado.")
    } else {
        println("No se pudo eliminar. El contacto '$nombre' no existe.")
    }
}

fun main() {
    // Crear al menos cinco contactos
    agregarContacto(Contacto("Asher Fuego", "3001234567", "asher@gmail.com"))
    agregarContacto(Contacto("Maria Lopez", "3109876543", "maria@hotmail.com"))
    agregarContacto(Contacto("Carlos Ruiz", "3205551122", "carlos@gmail.com"))
    agregarContacto(Contacto("Laura Gomez", "3154443344", "laura@yahoo.com"))
    agregarContacto(Contacto("Juan Perez", "3012224455", "juan@gmail.com"))

    listarContactos()

    buscarPorNombre("Maria Lopez")
    buscarPorNombre("Pedro") // No existe

    eliminarPorNombre("Juan Perez")
    eliminarPorNombre("Pedro") // No existe

    listarContactos()
}