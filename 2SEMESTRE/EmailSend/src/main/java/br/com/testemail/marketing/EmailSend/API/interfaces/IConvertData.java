package br.com.testemail.marketing.EmailSend.API.interfaces;

public interface IConvertData<T> {
  public T convertData(String json, Class<T> classe);
}
