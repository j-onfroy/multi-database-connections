package com.company.repository.second;


import com.company.dto.MessageCriteria;
import com.company.entity.Message;

import java.util.List;

public interface CustomMessageRepo {

    List<Message> getMessageList(MessageCriteria criteria);

    Long getTotalCount(MessageCriteria criteria);
}
