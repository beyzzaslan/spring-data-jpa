package com.beyzaslan.services.impl;

import com.beyzaslan.dto.DtoAddress;
import com.beyzaslan.dto.DtoCustomer;
import com.beyzaslan.entities.Address;
import com.beyzaslan.entities.Customer;
import com.beyzaslan.repository.CustomerRepository;
import com.beyzaslan.services.ICostumerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerServiceImpl implements ICostumerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public DtoCustomer findCustomerById(Long id) {
        DtoCustomer dtoCustomer = new DtoCustomer();
        DtoAddress dtoAddress=new DtoAddress();
        Optional<Customer> optional = customerRepository.findById(id);
        if(optional.isEmpty()){
            return null;
        }
        Customer customer = optional.get();
        Address address=optional.get().getAddress();//optional.get() diyince customer tek geliyo
        BeanUtils.copyProperties(customer,dtoCustomer);
        BeanUtils.copyProperties(address,dtoAddress);

        dtoCustomer.setAddress(dtoAddress);//BURDA  DTO'lar bağlanıyor
        return dtoCustomer;
    }
}
