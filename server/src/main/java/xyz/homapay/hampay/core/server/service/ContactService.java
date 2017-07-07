package xyz.homapay.hampay.core.server.service;

import org.apache.commons.collections.CollectionUtils;
import xyz.homapay.hampay.common.core.model.dto.ContactDTO;
import xyz.homapay.hampay.core.common.data.model.Contact;
import xyz.homapay.hampay.core.common.data.model.User;
import xyz.homapay.hampay.core.common.exception.DatabaseException;
import xyz.homapay.hampay.core.server.helper.Util;

import java.util.*;

/**
 * Created by Ebrahim Pasbani.
 */
public class ContactService {

    private UserService userService;
    private CustomerService customerService = new CustomerService();

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public List<ContactDTO> refineHampayEnabled(List<ContactDTO> contacts, User currentUser) throws DatabaseException {
        List<ContactDTO> result = new ArrayList<>(10);
        if (CollectionUtils.isNotEmpty(contacts)) {
            Set<String> numbers = Util.getIranMobileNumbersOnly(contacts);
            List<User> users = userService.findActivatedUserByCellNumber(numbers);
            if (CollectionUtils.isNotEmpty(users)) {
                result = new ArrayList<>();
                for (User user : users) {
                    if (!currentUser.equals(user)) {
                        ContactDTO contactDTO = new ContactDTO();
                        contactDTO.setDisplayName(user.getCustomer().getDisplayName() == null ? "" : user.getCustomer().getDisplayName());
                        contactDTO.setCellNumber(user.getCustomer().getPhoneNumber());
                        contactDTO.setContactImageId(userService.findUserImageFileNameById(user.getId()));
                        result.add(contactDTO);
                    }
                }
            }

        }
        //todo Database Customer Contacts should update in a separate thread
        return result;
    }

    public void updateUserContacts(List<ContactDTO> contactDTOList, User user) throws DatabaseException {
        Map<String, Contact> contactMap = new HashMap<>();
        for (ContactDTO contactDTO : contactDTOList) {
            Contact contact = new Contact();
            contact.setDisplayName(contactDTO.getDisplayName());
            contact.setCellNumber(contactDTO.getCellNumber());
            contactMap.put(contactDTO.getCellNumber(), contact);
        }
        user.getCustomer().setContacts(contactMap);
        customerService.updateCustomer(user.getCustomer());
    }

}
