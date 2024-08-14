package br.com.testemail.marketing.EmailSend.API.interfaces;

import java.util.List;

public interface IConvertData<T> {
  public List<T> convertData(String json, Class<T> classe);
}
