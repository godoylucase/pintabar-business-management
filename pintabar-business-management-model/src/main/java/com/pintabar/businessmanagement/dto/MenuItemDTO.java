package com.pintabar.businessmanagement.dto;

import com.pintabar.businessmanagement.dtoentityinterface.IMenuItem;
import com.pintabar.dto.BaseDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by lucasgodoy on 15/06/17.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@XmlRootElement
public class MenuItemDTO extends BaseDTO implements IMenuItem {
    private String name;
    private String description;
    private boolean deleted = false;
    private String businessUuid;
    private String menuItemInstanceUuid;
}
