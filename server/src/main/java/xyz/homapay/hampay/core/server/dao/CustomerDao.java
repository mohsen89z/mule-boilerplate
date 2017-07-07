package xyz.homapay.hampay.core.server.dao;

import xyz.homapay.hampay.core.common.data.model.IndividualCustomer;
import xyz.homapay.hampay.core.common.exception.CustomerNotFoundException;
import xyz.homapay.hampay.core.common.exception.DatabaseException;

import java.util.List;
import java.util.Set;

/**
 * Created by sima on 7/20/15.
 */
public interface CustomerDao {

    void updateCustomer(IndividualCustomer customer) throws DatabaseException;

    List<IndividualCustomer> findCustomerByPhoneNumber(Set<String> numbers) throws DatabaseException;

    IndividualCustomer findCustomerByPhoneNumber(String phoneNumbers) throws DatabaseException, CustomerNotFoundException;

}
