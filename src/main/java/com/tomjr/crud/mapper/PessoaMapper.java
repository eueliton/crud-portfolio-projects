package com.tomjr.crud.mapper;

import com.tomjr.crud.dto.PessoaDTO;
import com.tomjr.crud.model.Pessoa;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PessoaMapper {

    public static List<Pessoa> convertDtoListToEntityLits(List<PessoaDTO> pessoaDTO) {
        List<Pessoa> pessoaList = new ArrayList<>();
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        pessoaDTO.stream().map(f-> pessoaList.add( modelMapper.map(f, Pessoa.class))).collect(Collectors.toList());
        return pessoaList;
    }

    public static Pessoa convertDtoToEntity(PessoaDTO pessoaDTO) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        Pessoa pessoa = modelMapper.map(pessoaDTO, Pessoa.class);
        return pessoa;
    }


    public static List<PessoaDTO> convertEntityListToDtoList(List<Pessoa> pessoa) {
        List<PessoaDTO> pessoaList = new ArrayList<>();
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        pessoa.stream().map(f-> pessoaList.add( modelMapper.map(f, PessoaDTO.class))).collect(Collectors.toList());
        return pessoaList;
    }

    public static PessoaDTO convertEntityToDto(Pessoa pessoa) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        PessoaDTO pessoaDTO = modelMapper.map(pessoa, PessoaDTO.class);
        return pessoaDTO;
    }
}
