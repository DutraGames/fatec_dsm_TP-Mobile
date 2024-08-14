package br.edu.fatecpg.consumoapi.service;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface IConverteDados {
    public <T> T converteDados(String json, Class<T> tClass) throws JsonProcessingException;
}
