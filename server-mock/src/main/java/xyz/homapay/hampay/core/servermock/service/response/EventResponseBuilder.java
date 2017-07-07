package xyz.homapay.hampay.core.servermock.service.response;

import xyz.homapay.hampay.common.common.response.ResponseMessage;
import xyz.homapay.hampay.common.common.response.ResultStatus;
import xyz.homapay.hampay.common.core.model.request.EventListRequest;
import xyz.homapay.hampay.common.core.model.response.EventListResponse;
import xyz.homapay.hampay.common.core.model.response.dto.EventDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sima on 11/10/15.
 */
public class EventResponseBuilder {

    public ResponseMessage<EventListResponse> createEventListSuccessResponse(EventListRequest request){
        ResponseMessage<EventListResponse> responseMessage = new ResponseMessage<>();
        EventListResponse service = new EventListResponse();
        service.setResultStatus(ResultStatus.SUCCESS);
        service.setRequestUUID(request.getRequestUUID());
        service.setEventList(createEventList());
        responseMessage.setService(service);
        return responseMessage;
    }

    private List<EventDTO> createEventList() {
        List<EventDTO> eventDTOs = new ArrayList<>(3);
        EventDTO eventDTO1 = new EventDTO();
        eventDTO1.setStatus(EventDTO.EventStatus.ACTIVE);
        eventDTO1.setDescription("event description 1");
        eventDTO1.setName("event1");
        eventDTOs.add(eventDTO1);
        EventDTO eventDTO2 = new EventDTO();
        eventDTO2.setStatus(EventDTO.EventStatus.ACTIVE);
        eventDTO2.setDescription("event description 2");
        eventDTO2.setName("event2");
        eventDTOs.add(eventDTO2);
        EventDTO eventDTO3 = new EventDTO();
        eventDTO3.setStatus(EventDTO.EventStatus.ACTIVE);
        eventDTO3.setDescription("event description 3");
        eventDTO3.setName("event3");
        eventDTOs.add(eventDTO3);
        return eventDTOs;
    }
}
