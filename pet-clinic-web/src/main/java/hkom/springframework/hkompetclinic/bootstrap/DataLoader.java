package hkom.springframework.hkompetclinic.bootstrap;

import hkom.springframework.model.Owner;
import hkom.springframework.model.Vet;
import hkom.springframework.services.OwnerService;
import hkom.springframework.services.VetService;
import hkom.springframework.services.map.OwnerServiceMap;
import hkom.springframework.services.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;
    @Override
    public void run(String... args) throws Exception {
        Owner owner1=new Owner();
        owner1.setId(1L);
        owner1.setFirstName("hariharan");
        owner1.setLastName("komati");
        ownerService.save(owner1);
        System.out.println("Loaded the owners");
        Vet vet1=new Vet();
        vet1.setId(1L);
        vet1.setFirstName("spring");
        vet1.setLastName("framwwork");
        vetService.save(vet1);
        System.out.println("Loaded the vets");
    }

    public DataLoader() {
        ownerService=  new OwnerServiceMap();
        vetService=new VetServiceMap();



    }
}
