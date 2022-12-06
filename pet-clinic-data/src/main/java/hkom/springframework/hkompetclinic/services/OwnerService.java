package hkom.springframework.hkompetclinic.services;

import hkom.springframework.hkompetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner,Long> {
    Owner findByLastName(String lastname);


}
