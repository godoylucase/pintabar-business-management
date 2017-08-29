package com.pintabar.businessmanagement.dto;

import com.pintabar.businessmanagement.dtoentityinterface.ITableUnit;
import com.pintabar.dto.BaseDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by lucasgodoy on 13/06/17.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@XmlRootElement
public class TableUnitDTO extends BaseDTO implements ITableUnit {
	private String businessUuid;
	private Integer internalNumber;
}
