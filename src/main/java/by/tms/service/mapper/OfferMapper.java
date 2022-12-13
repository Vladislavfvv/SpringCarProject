package by.tms.service.mapper;

import by.tms.dto.OfferDto;
import by.tms.entity.Offer;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class OfferMapper {
    public Offer convertOfferDTOtoOffer(OfferDto offerDto, Offer offer){
        offer.setPrice(new BigDecimal(offerDto.getPrice()));
        offer.setDescription(offerDto.getDescription());
        return offer;
    }

}
