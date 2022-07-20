package com.genesissoft.app.util;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class Utils {

    public static ModelMapper getMapper(){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper;
    }

}
