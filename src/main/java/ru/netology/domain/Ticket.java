package ru.netology.domain;

import java.util.Objects;

public class Ticket implements Comparable<Ticket> {
  private int id;
  private int travelTime;
  private int price;
  private String departureAirport;
  private String arrivalAirport;


  public Ticket() {
  }

  public Ticket(int id, int travelTime, int price, String departureAirport, String arrivalAirport) {
    this.id = id;
    this.travelTime = travelTime;
    this.price = price;
    this.departureAirport = departureAirport;
    this.arrivalAirport = arrivalAirport;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getTravelTime() {
    return travelTime;
  }

  public void setTravelTime(int travelTime) {
    this.travelTime = travelTime;
  }

  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  public String getDepartureAirport() {
    return departureAirport;
  }

  public void setDepartureAirport(String departureAirport) {
    this.departureAirport = departureAirport;
  }

  public String getArrivalAirport() {
    return arrivalAirport;
  }

  public void setArrivalAirport(String arrivalAirport) {
    this.arrivalAirport = arrivalAirport;
  }


  @Override
  public int compareTo(Ticket o) {
    return 0;
  }
}
