package ADDRESS_DATA;

/**
 * La clase AddressEntry representa una entrada en el libro de direcciones.
 * Contiene información sobre una persona, incluyendo su nombre, dirección, correo electrónico y teléfono.
 */
public class AddressEntry {
    private String firstName;
    private String lastName;
    private String street;
    private String city;
    private String state;
    private String postalCode;
    private String email;
    private String phone;

    /**
     * Constructor que inicializa todos los campos de una entrada de dirección.
     *
     * @param firstName El primer nombre del contacto.
     * @param lastName El apellido del contacto.
     * @param street La calle del contacto.
     * @param city La ciudad del contacto.
     * @param state El estado del contacto.
     * @param postalCode El código postal del contacto.
     * @param email El correo electrónico del contacto.
     * @param phone El número de teléfono del contacto.
     */
    public AddressEntry(String firstName, String lastName, String street, String city, String state, String postalCode, String email, String phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.street = street;
        this.city = city;
        this.state = state;
        this.postalCode = postalCode;
        this.email = email;
        this.phone = phone;
    }

    /**
     * Obtiene el primer nombre del contacto.
     *
     * @return El primer nombre del contacto.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Establece el primer nombre del contacto.
     *
     * @param firstName El primer nombre del contacto.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Obtiene el apellido del contacto.
     *
     * @return El apellido del contacto.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Establece el apellido del contacto.
     *
     * @param lastName El apellido del contacto.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Obtiene la calle del contacto.
     *
     * @return La calle del contacto.
     */
    public String getStreet() {
        return street;
    }

    /**
     * Establece la calle del contacto.
     *
     * @param street La calle del contacto.
     */
    public void setStreet(String street) {
        this.street = street;
    }

    /**
     * Obtiene la ciudad del contacto.
     *
     * @return La ciudad del contacto.
     */
    public String getCity() {
        return city;
    }

    /**
     * Establece la ciudad del contacto.
     *
     * @param city La ciudad del contacto.
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Obtiene el estado del contacto.
     *
     * @return El estado del contacto.
     */
    public String getState() {
        return state;
    }

    /**
     * Establece el estado del contacto.
     *
     * @param state El estado del contacto.
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * Obtiene el código postal del contacto.
     *
     * @return El código postal del contacto.
     */
    public String getPostalCode() {
        return postalCode;
    }

    /**
     * Establece el código postal del contacto.
     *
     * @param postalCode El código postal del contacto.
     */
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    /**
     * Obtiene el correo electrónico del contacto.
     *
     * @return El correo electrónico del contacto.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Establece el correo electrónico del contacto.
     *
     * @param email El correo electrónico del contacto.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Obtiene el número de teléfono del contacto.
     *
     * @return El número de teléfono del contacto.
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Establece el número de teléfono del contacto.
     *
     * @param phone El número de teléfono del contacto.
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Devuelve una representación en cadena de la entrada de dirección.
     *
     * @return Una cadena que contiene el nombre, dirección, teléfono y correo electrónico del contacto.
     */
    @Override
    public String toString() {
        return firstName + " " + lastName + ", " + street + ", " + city + ", " + state + ", " + postalCode + ", " + phone + ", " + email;
    }
}
