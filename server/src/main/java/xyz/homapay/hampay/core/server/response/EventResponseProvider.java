package xyz.homapay.hampay.core.server.response;

import xyz.homapay.hampay.common.common.response.ResponseMessage;
import xyz.homapay.hampay.common.common.response.ResultStatus;
import xyz.homapay.hampay.common.core.model.response.EventListResponse;
import xyz.homapay.hampay.common.core.model.response.dto.EventDTO;
import xyz.homapay.hampay.core.common.data.model.Event;
import xyz.homapay.hampay.core.server.service.EventService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sima on 8/16/15.
 */
public class EventResponseProvider {

    private EventService eventService = new EventService();

    public ResponseMessage<EventListResponse> createEventListResponse(String requestUUID) {
        ResponseMessage<EventListResponse> responseMessage = new ResponseMessage<>();
        EventListResponse service = new EventListResponse();
        service.setRequestUUID(requestUUID);
        service.setResultStatus(ResultStatus.SUCCESS);
        service.setEventList(getAllEventsDTOs());
        responseMessage.setService(service);
        return responseMessage;
    }

    private List<EventDTO> getAllEventsDTOs() {
        List<Event> events = eventService.findAllEvents();
        List<EventDTO> eventDTOs = new ArrayList<>();
        for (Event event : events) {
            EventDTO eventDTO = new EventDTO();
            eventDTO.setName(event.getName());
            eventDTO.setDescription(event.getDescription());
            if (event.isStatus())
                eventDTO.setStatus(EventDTO.EventStatus.ACTIVE);
            else
                eventDTO.setStatus(EventDTO.EventStatus.PASSIVE);
            eventDTOs.add(eventDTO);
        }
        return eventDTOs;
    }

    public ResponseMessage<EventListResponse> createEventListAuthenticationFailureResponse(String requestUUID) {
        ResponseMessage<EventListResponse> responseMessage = new ResponseMessage<>();
        EventListResponse service = new EventListResponse();
        service.setRequestUUID(requestUUID);
        service.setResultStatus(ResultStatus.AUTHENTICATION_FAILURE);
        responseMessage.setService(service);
        return responseMessage;
    }
}
