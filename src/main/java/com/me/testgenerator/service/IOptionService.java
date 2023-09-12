package com.me.testgenerator.service;

import java.util.List;

import com.me.testgenerator.domain.Option;

public interface IOptionService {
    List<Option> getAllOptions();
    Option getOptionById(Long id);
    Option createOption(Option option);
    Option updateOption(Long id, Option option);
    boolean deleteOption(Long id);
}
