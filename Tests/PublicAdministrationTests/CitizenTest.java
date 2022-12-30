package PublicAdministrationTests;

import Data.Nif;
import PublicAdministration.Citizen;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CitizenTest {

    private Nif nif;
    private String name;
    private String address;
    private String mobile;
    private Citizen citizen;


    @BeforeEach
    public void citizenforTests () {
        this.nif = new Nif("47320966K");
        this.name = "name";
        this.address = "address";
        this.mobile = "665879012";
        this.citizen = new Citizen(nif, name, address, mobile);
    }

    @Test
    public void TestingToString () {
        String cString = "Ciudadano{" + "nif ciudadano='" + this.nif + '\n'
                + "nombre ciudadano='" + this.name + '\n'
                + "dirección ciudadano='" + this.address + '\n'
                + "teléfono ciudadano='" + this.mobile + '\n' + '}';
        assertEquals(citizen.toString(), cString);
    }

    @Test
    public void TestingBifGetters () {
        assertEquals(this.nif.toString(), this.citizen.getNif());
    }

    @Test
    public void TestingNameGetter () {
        assertEquals(this.name, this.citizen.getName());
    }

    @Test
    public void TestingAdressGetter () {
        assertEquals(this.address, this.citizen.getAddress());
    }

    @Test
    public void TestingMobileGetter () {
        assertEquals(this.mobile ,this.citizen.getMobileNumb());
    }
}
