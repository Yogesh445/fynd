package com.example.fynd.mapper;

import lombok.RequiredArgsConstructor;
import org.dozer.DozerBeanMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public abstract class AbstractMapper {

    protected final DozerBeanMapper mapper;


}
