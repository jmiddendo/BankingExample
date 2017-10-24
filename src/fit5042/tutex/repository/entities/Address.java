package fit5042.tutex.repository.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Eddie Leung
 */
@Embeddable
@XmlRootElement
public class Address implements Serializable {
    
    private String streetNumber;
    private String streetAddress;
    private String suburb;
    private String postcode;
    private String state;

    public Address() {
    }

    public Address(String streetNumber, String streetAddress, String suburb, String postcode, String state) {
        this.streetNumber = streetNumber;
        this.streetAddress = streetAddress;
        this.suburb = suburb;
        this.postcode = postcode;
        this.state = state;
    }

    @Column(name = "street_number", nullable = false)
    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    @Column(name = "street_address", nullable = false)
    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    @Column(nullable = false)
    public String getSuburb() {
        return suburb;
    }

    public void setSuburb(String suburb) {
        this.suburb = suburb;
    }

    @Column(name = "post_code", nullable = false)
    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    @Column(nullable = false)
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return streetNumber + " " + streetAddress + ", " + suburb + ", " + state + " " + postcode;
    } 
}