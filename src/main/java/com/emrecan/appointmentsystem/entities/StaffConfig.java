package com.emrecan.appointmentsystem.entities;

import com.emrecan.appointmentsystem.core.entities.IEntity;
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
 * @created 26/12/2023 - 22:42
 */

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "staff_configs")
public class StaffConfig implements IEntity {

    @Id
    @GeneratedValue(generator = "uuid-hibernate-generator")
    @GenericGenerator(name = "uuid-hibernate-generator", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "staff_config_id")
    private String staffConfigId;

    @Column(name = "staff_id")
    private String staffId;

    @Column(name = "start_shift_hour")
    private LocalTime startShiftHour;

    @Column(name = "end_shift_hour")
    private LocalTime endShiftHour;

    @Column(name = "break_hour")
    private LocalTime breakHour;

    @Column(name = "break_time")
    private int breakTime;//minutes

    @Column(name = "slot_spacing")
    private int slotSpacing;//minutes

    @OneToOne
    @JoinColumn(name = "staff_id", nullable = false, insertable = false, updatable = false)
    private Staff staff;

    @Column(name = "created_at")
    private final LocalDateTime createdAt = LocalDateTime.now();

    @Column(name = "is_deleted")
    private boolean isDeleted = false;

}
