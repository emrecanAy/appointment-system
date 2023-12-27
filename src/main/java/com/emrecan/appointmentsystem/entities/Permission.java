package com.emrecan.appointmentsystem.entities;

import com.emrecan.appointmentsystem.entities.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * @author Emrecan
 * @created 27/12/2023 - 16:29
 */

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "permissions")
public class Permission {

    @Id
    @GeneratedValue(generator = "uuid-hibernate-generator")
    @GenericGenerator(name = "uuid-hibernate-generator", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "permission_id")
    private String permissionId;

    @Column(name = "staff_id")
    private String staffId;

    @Column(name = "permission_date")
    private LocalDateTime permissionDate;

    @Column(name = "permission_start_hour")
    private LocalTime permissionStartHour;

    @Column(name = "permission_end_hour")
    private LocalTime permissionEndHour;

    @Column(name = "permission_reason")
    private String permissionReason;

    @Column(name = "permission_status")
    private Status permissionStatus = Status.WAITING;

    @OneToOne
    @JoinColumn(name = "staff_id", nullable = false, insertable = false, updatable = false)
    private Staff staff;

    @Column(name = "created_at")
    private final LocalDateTime createdAt = LocalDateTime.now();

    @Column(name = "is_deleted")
    private boolean isDeleted = false;






}
