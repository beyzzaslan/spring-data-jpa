package com.beyzaslan.services.impl;

import com.beyzaslan.dto.DtoAddress;
import com.beyzaslan.dto.DtoCustomer;
import com.beyzaslan.entities.Address;
import com.beyzaslan.repository.AddressRepository;
import com.beyzaslan.services.IAddressService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AddressServiceImpl implements IAddressService {
    @Autowired
    private AddressRepository addressRepository;

    @Override
    public DtoAddress findAddressById(Long id) {
        DtoAddress dtoAddress = new DtoAddress();

        Optional<Address> optional = addressRepository.findById(id);
        if (optional.isEmpty()) {
            return null;
        }
        Address address = optional.get();
        //bu yukarıdaki elimdeki adresi dtoaddresse kopyala
        BeanUtils.copyProperties(address, dtoAddress);

        DtoCustomer dtoCustomer = new DtoCustomer();
        dtoCustomer.setId(address.getCustomer().getId());
        dtoCustomer.setName(address.getCustomer().getName());
        dtoAddress.setCustomer(dtoCustomer);
        return dtoAddress;
    }
}
