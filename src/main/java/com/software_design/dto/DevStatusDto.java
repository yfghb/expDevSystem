package com.software_design.dto;

import com.software_design.entity.DevStatus;
import com.software_design.entity.Device;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class DevStatusDto extends DevStatus {
    private Device device;
}
