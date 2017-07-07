package xyz.homapay.hampay.core.common.data.dto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by sima on 9/20/15.
 * sima.ahmadvand@gmail.com
 */
public class GNotificationMessageDTO {

    public static final String NOTIFICATION_TYPE_TITLE = "type";
    public static final String NOTIFICATION_NAME_TITLE = "name";
    public static final String NOTIFICATION_MESSAGE_TITLE = "message";

    private List<String> registration_ids;
    private Map<String, String> data;

    public List<String> getRegistration_ids() {
        return registration_ids;
    }

    public Map<String, String> getData() {
        return data;
    }

    public void addRegId(String regId) {
        if (registration_ids == null)
            registration_ids = new ArrayList<>();
        registration_ids.add(regId);
    }

    public void addRegIds(List<String> regIds) {
        if (registration_ids == null)
            registration_ids = new ArrayList<>();
        registration_ids.addAll(regIds);
    }

    public void createData(String title, String message) {
        if (data == null)
            data = new HashMap<>();

        data.put(title, message);
    }
}
