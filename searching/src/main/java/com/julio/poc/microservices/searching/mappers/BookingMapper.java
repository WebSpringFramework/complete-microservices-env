package com.julio.poc.microservices.searching.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import com.julio.poc.microservices.searching.dtos.BookingGetDTO;
import com.julio.poc.microservices.searching.entities.Booking;

@Mapper(componentModel = "spring")
public interface BookingMapper {
    @Mappings({
            @Mapping(target = "idRoom", source = "room.id")
    })
    BookingGetDTO toDTO(Booking entity);

    List<BookingGetDTO> toDTO(List<Booking> entities);

    default Page<BookingGetDTO> toDTO(Page<Booking> page) {
        List<BookingGetDTO> responses = toDTO(page.getContent());
        return new PageImpl<>(responses, page.getPageable(), page.getTotalElements());
    }
}
