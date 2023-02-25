package com.bookstore.shippingservice.core.domain.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;
import java.util.UUID;

@Entity
@Table(name = "orders")
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    @Id
    @Column(nullable = false)
    @Getter
    @GeneratedValue(strategy= GenerationType.UUID)
    private UUID orderId;

    @Column(nullable = false)
    @Getter @Setter
    private Long userId;

    @Column(nullable = false)
    @Getter @Setter
    private String shippingPrename;

    @Column(nullable = false)
    @Getter @Setter
    private String shippingSurname;

    @Column(nullable = true)
    @Getter @Setter
    private String shippingAddressLine1;

    @Column(nullable = true)
    @Getter @Setter
    private String shippingAddressLine2;

    @Column(nullable = true)
    @Getter @Setter
    private String shippingCity;

    @Column(nullable = true)
    @Getter @Setter
    private String shippingZip;

    @Column(nullable = true)
    @Getter @Setter
    private String shippingCountry;

    @Column(nullable = true)
    private String billingPrename;

    @Column(nullable = true)
    private String billingSurname;

    @Column(nullable = true)
    private String billingAddressLine1;

    @Column(nullable = true)
    private String billingAddressLine2;

    @Column(nullable = true)
    private String billingCity;

    @Column(nullable = true)
    private String billingZip;

    @Column(nullable = true)
    private String billingCountry;

    @Column(nullable = true)
    @Getter @Setter
    private boolean billingSameAsShipping;

    @Column(name="quantity", nullable = true)
    @Getter
    @Setter
    @ElementCollection
    @MapKeyColumn(name="itemId")
    private Map<UUID, Integer> orderedItems;

}
