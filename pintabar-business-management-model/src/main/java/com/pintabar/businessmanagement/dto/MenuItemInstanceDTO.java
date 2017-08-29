package com.pintabar.businessmanagement.dto;

import com.pintabar.businessmanagement.dtoentityinterface.IMenuItemInstance;
import com.pintabar.dto.BaseDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;

/**
 * @author Lucas.Godoy on 7/07/17.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement
public class MenuItemInstanceDTO extends BaseDTO implements IMenuItemInstance {
    private String menuCategoryInstanceUuid;
    private MenuItemDTO menuItem;
    private boolean available = true;
    private BigDecimal price = BigDecimal.ZERO;
}
