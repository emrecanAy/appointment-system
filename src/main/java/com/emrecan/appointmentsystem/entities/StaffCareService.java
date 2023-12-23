package com.emrecan.appointmentsystem.entities;

import com.emrecan.appointmentsystem.core.entities.IEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @author Emrecan
 * @created 23/12/2023 - 21:12
 */
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "staff_careservices")
public class StaffCareService implements IEntity {

    @Id
    @GeneratedValue(generator = "uuid-hibernate-generator")
    @GenericGenerator(name = "uuid-hibernate-generator", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "staff_care_service_id")
    private String staffCareServiceId;

    @Column(name = "care_service_id")
    private String careServiceId;

    @Column(name = "staff_id")
    private String staffId;

    @Column(name = "care_service_price")
    private double careServicePrice;

    @Column(name = "note")
    private String note;

    @Column(name = "care_service_duration")//dakika
    private int careServiceDuration;

    @ManyToOne
    @JoinColumn(name = "care_service_id", nullable = false, insertable = false, updatable = false)
    private CareService careService;

    @ManyToOne
    @JoinColumn(name = "staff_id", nullable = false, insertable = false, updatable = false)
    private Staff staff;

    @Column(name = "created_at")
    private final LocalDateTime createdAt = LocalDateTime.now();

    @Column(name = "is_deleted")
    private boolean isDeleted = false;

}
