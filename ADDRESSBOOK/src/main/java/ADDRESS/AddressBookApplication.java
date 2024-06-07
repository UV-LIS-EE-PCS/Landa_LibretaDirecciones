/**
 * El paquete ADDRESS contiene clases relacionadas con la gestión de un libro de direcciones.
 */
package ADDRESS;

/**
 * La clase AddressBookApplication es el punto de entrada principal para la aplicación del libro de direcciones.
 * Contiene el método main que inicia la aplicación mostrando el menú principal.
 */
public class AddressBookApplication {

    /**
     * El método main es el punto de entrada de la aplicación.
     * Crea una instancia de la clase Menu y llama al método displayMenu para mostrar el menú principal.
     *
     * @param args Argumentos de línea de comando (no se utilizan en esta aplicación).
     */
    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.displayMenu();
    }
}
