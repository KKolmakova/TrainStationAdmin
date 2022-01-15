package com.kolmakova;

import com.kolmakova.entities.Document;
import com.kolmakova.entities.Passenger;
import com.kolmakova.entities.Payment;
import com.kolmakova.repositories.PassengerRepository;
import com.kolmakova.services.impl.PassengerServiceImpl;
import com.kolmakova.types.DocumentType;
import com.kolmakova.utils.PassengerUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PassengerServiceImplTest {

    @Mock
    private PassengerRepository passengerRepository;

    @InjectMocks
    private PassengerServiceImpl passengerServiceIml;

    @Test
    public void getByParameters() {
//        Specification<Passenger> specification = PassengerUtils.getWithParams("Maria", null, null, null);

        //GIVEN
        Passenger passenger1 = createPassenger(null,
                "Maria",
                "Volkova",
                createDocument(DocumentType.CERTIFICATE),
                "TK009764",
                null);

        Passenger passenger2 = createPassenger(null,
                "Alesia",
                "Morozova",
                createDocument(DocumentType.PASSPORT),
                "TR9878823",
                null);

        List<Passenger> passengerList = new ArrayList<>();
        passengerList.add(passenger1);
        Specification<Passenger> specification;


        //WHEN
//        when(passengerRepository.findAll(specification)).thenReturn(passengerList);
        List<Passenger> findPassengerList = passengerServiceIml.getByParameters("Marina", null, null, null);

        //THEN
        assert (listContainsPassenger(findPassengerList, passenger1.getName()));
        assert (!listContainsPassenger(findPassengerList, passenger2.getName()));
    }

    private Passenger createPassenger(Integer id, String name, String surname, Document document, String documentSeries, List<Payment> paymentList) {
        Passenger passenger = new Passenger();

        passenger.setId(id);
        passenger.setName(name);
        passenger.setSurname(surname);
        passenger.setDocumentType(document);
        passenger.setDocumentSeries(documentSeries);
        passenger.setPaymentList(paymentList);

        return passenger;
    }

    private Document createDocument(DocumentType documentType) {
        Document document = new Document();
        document.setType(documentType);

        return document;
    }

    private boolean listContainsPassenger(List<Passenger> passengerList, String name) {
        for (Passenger passenger : passengerList) {
            if (passenger.getName().equalsIgnoreCase(name)) {
                return true;
            }
        }

        return false;
    }
}
