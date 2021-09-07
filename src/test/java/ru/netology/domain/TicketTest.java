package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TicketTest {


    @Test
    public void shouldSetId() {
        Ticket product = new Ticket();
        product.setId(1);
    }
    @Test
    public void shouldGetId() {
        Ticket product = new Ticket();
        product.setId(1);
        product.getId();
    }

    @Test
    public void shouldSetPrice() {
        Ticket product = new Ticket();
        product.setPrice(100);
    }
    @Test
    public void shouldSetTravelTime() {
        Ticket product = new Ticket();
        product.setTravelTime(100);
    }
    @Test
    public void shouldGetTravelTime() {
        Ticket product = new Ticket();
        product.setTravelTime(100);
        product.getTravelTime();
    }

    @Test
    public void shouldSetDepartureAirport() {
        Ticket product = new Ticket();
        product.setDepartureAirport("Name");
    }
    @Test
    public void shouldGetDepartureAirport() {
        Ticket product = new Ticket();
        product.setDepartureAirport("Name");
        product.getDepartureAirport();
    }

    @Test
    public void shouldSetArrivalAirport() {
        Ticket product = new Ticket();
        product.setArrivalAirport("Name");
    }

    @Test
    public void shouldGetArrivalAirport() {
        Ticket product = new Ticket();
        product.setArrivalAirport("Name");
        product.getArrivalAirport();
    }

    @Test
    public void shouldGetPrice() {
        Ticket product = new Ticket();
        product.setPrice(100);
        product.getPrice();
    }



}
