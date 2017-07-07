package xyz.homapay.hampay.core.server.transformers;

import org.apache.commons.collections.CollectionUtils;
import org.mule.api.annotations.ContainsTransformerMethods;
import xyz.homapay.hampay.common.core.model.response.dto.BusinessDTO;
import xyz.homapay.hampay.core.common.data.model.Business;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ebrahim Pasbani.
 */

@ContainsTransformerMethods
public class BusinessToBusinessDTOTransformer {

    public BusinessDTO fromModel(Business biz) {
        BusinessDTO ret = new BusinessDTO();
        if (biz != null) {
            ret.setCategory(biz.getCategory());
            ret.setCode(biz.getIdentityCode());
            ret.setDefaultPhoneNumber(biz.getPhoneNumber());
            ret.setLatitude(biz.getLatitude());
            ret.setLongitude(biz.getLongitude());
            ret.setSummary(biz.getSummary());
            ret.setTitle(biz.getName());
            ret.setWebsiteAddress(biz.getWebsiteAddress());
        }
        return ret;
    }

    public List<BusinessDTO> fromModels(List<Business> list) {
        List<BusinessDTO> result = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(list)) {
            for (Business biz : list)
                result.add(fromModel(biz));
        }
        return result;
    }
}
