package com.pintabar.businessmanagement.dto;

import com.pintabar.businessmanagement.dtoentityinterface.IMenu;
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
public class MenuDTO extends BaseDTO implements IMenu {
	private String name;
	private boolean deleted = false;
	private String businessUuid;
	private String menuInstanceUuid;
}
