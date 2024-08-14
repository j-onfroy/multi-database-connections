package com.company.dto;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString
public class PageCriteria implements Serializable {

    protected Integer page = 0;

    protected Integer size = 10;

}