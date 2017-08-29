package com.pintabar.businessmanagement.dto;

import com.pintabar.businessmanagement.dtoentityinterface.IMenuCategory;
import com.pintabar.businessmanagement.entity.MenuCategoryType;
import com.pintabar.dto.BaseDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by lucasgodoy on 18/06/17.
 */
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement
public class MenuCategoryDTO extends BaseDTO implements IMenuCategory {
	private boolean deleted = false;
	private String name;
	private String description;
	private MenuCategoryType type = MenuCategoryType.FOOD;
	private String businessUuid;
	private String menuCategoryInstanceUuid;
}
