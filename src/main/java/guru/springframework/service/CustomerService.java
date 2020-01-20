package guru.springframework.service;

import guru.springframework.web.model.CustomerDto;
import java.util.UUID;


public interface CustomerService {
    CustomerDto getCustomerById(UUID customerId);
}
