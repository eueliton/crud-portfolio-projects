package com.tomjr.crud.mapper;

import com.tomjr.crud.dto.ProjetoDTO;
import com.tomjr.crud.model.Projeto;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class ProjetoMapper {
    public static List<Projeto> convertDtoListToEntityLits(List<ProjetoDTO> projetoDTO) {
        List<Projeto> projetoList = new ArrayList<>();
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        projetoDTO.stream().map(f -> projetoList.add(modelMapper.map(f, Projeto.class))).collect(Collectors.toList());
        return projetoList;
    }

    public static Projeto convertDtoToEntity(ProjetoDTO projetoDTO) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        Projeto projeto = modelMapper.map(projetoDTO, Projeto.class);
        return projeto;
    }


    public static List<ProjetoDTO> convertEntityListToDtoList(List<Projeto> projeto) {
        List<ProjetoDTO> projetoList = new ArrayList<>();
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        projeto.stream().map(f -> projetoList.add(modelMapper.map(f, ProjetoDTO.class))).collect(Collectors.toList());
        return projetoList;
    }

    public static ProjetoDTO convertEntityToDto(Projeto projeto) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        ProjetoDTO projetoDTO = modelMapper.map(projeto, ProjetoDTO.class);
        return projetoDTO;
    }
}
