package br.com.testemail.marketing.EmailSend.API.services;

import br.com.testemail.marketing.EmailSend.API.interfaces.IConvertData;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ConvertData<T> implements IConvertData<T> {

  public T convertData(String json, Class<T> classe) {
    ObjectMapper mapper = new ObjectMapper();

    try {
      return mapper.readValue(json, classe);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}
