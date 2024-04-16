package br.com.testemail.marketing.EmailSend.API.services;

import br.com.testemail.marketing.EmailSend.API.interfaces.IConvertData;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;

public class ConvertData<T> implements IConvertData<T> {

  public List<T> convertData(String json, Class<T> classe) {
    ObjectMapper mapper = new ObjectMapper();

    try {
      return mapper.readValue(
        json,
        mapper.getTypeFactory().constructCollectionType(List.class, classe)
      );
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}
