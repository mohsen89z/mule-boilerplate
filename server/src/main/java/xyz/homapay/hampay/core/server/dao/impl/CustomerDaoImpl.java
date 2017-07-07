package xyz.homapay.hampay.core.server.dao.impl;

import org.mongodb.morphia.query.Query;
import xyz.homapay.hampay.core.common.data.model.IndividualCustomer;
import xyz.homapay.hampay.core.common.exception.CustomerNotFoundException;
import xyz.homapay.hampay.core.common.exception.DatabaseException;
import xyz.homapay.hampay.core.server.dao.CustomerDao;
import xyz.homapay.hampay.core.server.data.DbConnection;

import java.io.IOException;
import java.util.List;
import java.util.Set;

/**
 * Created by sima on 7/20/15.
 */
public class CustomerDaoImpl implements CustomerDao {

    @Override
    public void updateCustomer(IndividualCustomer customer) throws DatabaseException {
        try {
            DbConnection.datastore().save(customer);
        } catch (IOException e) {
            e.printStackTrace();
            throw new DatabaseException();
        }
    }

    @Override
    public List<IndividualCustomer> findCustomerByPhoneNumber(Set<String> numbers) throws DatabaseException {
        try {
            Query<IndividualCustomer> query = DbConnection.datastore().find(IndividualCustomer.class);
            query.field("phoneNumber").hasAnyOf(numbers);
            return query.asList();
        } catch (IOException e) {
            e.printStackTrace();
            throw new DatabaseException();
        }
    }

    @Override
    public IndividualCustomer findCustomerByPhoneNumber(String phoneNumber) throws DatabaseException, CustomerNotFoundException {
        IndividualCustomer customer;
        try {
            Query<IndividualCustomer> query = DbConnection.datastore().find(IndividualCustomer.class);
            query.field("phoneNumber").equal(phoneNumber);
            customer = query.get();
        } catch (IOException e) {
            e.printStackTrace();
            throw new DatabaseException();
        }
        if (customer == null)
            throw new CustomerNotFoundException();
        return customer;
    }

}
