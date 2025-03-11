package com.example.examengrc.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name="alquiler")
public class Alquiler {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Usuario userId;
    @ManyToOne
    @JoinColumn(name = "car_id", nullable = false)
    private Coche carId;
    @Column(nullable = false)
    private LocalDateTime rentalDate;
    private LocalDateTime returnDate;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status;
    private Double gerardo_price;
    private String gerardo_address;

}
