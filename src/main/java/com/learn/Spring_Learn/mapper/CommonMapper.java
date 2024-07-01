package com.learn.Spring_Learn.mapper;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CommonMapper {
    private final ModelMapper modelMapper;

    public <T, S> S convertToEntity(T data, Class<S> type) {
        return this.modelMapper.map(data, type);
    }
}
