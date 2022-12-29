package PublicAdministrationTests;

import Data.Nif;
import PublicAdministration.Citizen;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CitizenTest {
    private Citizen citizen;
    private Nif nif;


    @BeforeEach
    public void nifForTest () {
        this.nif = new Nif("47320966K");
    }

    @BeforeEach
    public void citizenforTests () {
        this.citizen = new Citizen(new Nif("47320966K"), "nombre", "dirección", "665879012");

    }

    @Test
    public void TestingToString () {
        String cString = "Ciudadano{" + "nif ciudadano='" + this.nif + '\n'
                + "nombre ciudadano='" + "nombre" + '\n'
                + "dirección ciudadano='" + "dirección" + '\n'
                + "teléfono ciudadano='" + "665879012" + '\n' + '}';
        assertEquals(citizen.toString(), cString);
    }

    @Test
    public void TestingBifGetters () {
        String nif = citizen.getNif();
        String nif1 = "Nif{nif ciudadano='47320966K'}";
        assertEquals(nif,nif1 );
    }

    @Test
    public void TestingNameGetter () {
        String name = citizen.getName();
        String name1 = "nombre";
        assertEquals(name,name1 );
    }

    @Test
    public void TestingAdressGetter () {
        String adress = citizen.getAddress();
        String adress1 = "dirección";
        assertEquals(adress,adress1 );
    }

    @Test
    public void TestingMobileGetter () {
        String mobile = citizen.getMobileNumb();
        String mobile1 = "665879012";
        assertEquals(mobile,mobile1);
    }
}
