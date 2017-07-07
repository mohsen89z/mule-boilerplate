package xyz.homapay.hampay.core.server.transformers;

import org.mule.api.annotations.ContainsTransformerMethods;
import org.mule.api.annotations.Transformer;
import xyz.homapay.hampay.common.core.model.dto.ContactDTO;
import xyz.homapay.hampay.core.common.data.model.Contact;

/**
 * Created by Ebrahim Pasbani.
 */

@ContainsTransformerMethods
public class ContactToContactDTOTransformer {

    @Transformer
    public ContactDTO mapper(Contact contact) {
        ContactDTO result = new ContactDTO();
        result.setCellNumber(contact.getCellNumber());
        result.setDisplayName(contact.getDisplayName());
        return result;
    }
}
