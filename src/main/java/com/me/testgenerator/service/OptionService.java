package com.me.testgenerator.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.me.testgenerator.domain.Option;
import com.me.testgenerator.repository.OptionRepository;


@Service
public class OptionService implements IOptionService{

    @Autowired
    private OptionRepository optionRepository;

    @Override
    public List<Option> getAllOptions() {
        return optionRepository.findAll();
    }

    @Override
    public Option getOptionById(Long id) {
        return optionRepository.findById(id).orElse(null);
    }

    @Override
    public Option createOption(Option option) {
        return optionRepository.save(option);
    }

    @Override
    public Option updateOption(Long id, Option option) {
        if (optionRepository.existsById(id)) {
            option.setId(id);
            return optionRepository.save(option);
        } else {
            return null;
        }
    }

    @Override
    public boolean deleteOption(Long id) {
        if (optionRepository.existsById(id)) {
            optionRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

}
