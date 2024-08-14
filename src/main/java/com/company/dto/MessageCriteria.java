package com.company.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class MessageCriteria extends PageCriteria{

    private String key;

    private String sortBy;

    private String sortDirection = "ASC";
}
