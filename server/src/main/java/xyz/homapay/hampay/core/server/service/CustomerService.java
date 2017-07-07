package xyz.homapay.hampay.core.server.service;

import xyz.homapay.hampay.core.common.data.model.IndividualCustomer;
import xyz.homapay.hampay.core.common.exception.CustomerNotFoundException;
import xyz.homapay.hampay.core.common.exception.DatabaseException;
import xyz.homapay.hampay.core.server.dao.CustomerDao;
import xyz.homapay.hampay.core.server.dao.impl.CustomerDaoImpl;

/**
 * Created by sima on 8/9/15.
 */
public class CustomerService {
    private CustomerDao customerDao = new CustomerDaoImpl();

    public void updateCustomer(IndividualCustomer customer) throws DatabaseException {
        customerDao.updateCustomer(customer);
    }

    public IndividualCustomer findCustomerByPhoneNumber(String phoneNumber) throws DatabaseException, CustomerNotFoundException {
        return customerDao.findCustomerByPhoneNumber(phoneNumber);
    }
}
