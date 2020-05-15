package main.presentation.validators;

public interface Validator<T> {

    void validate(T t) throws IllegalArgumentException;
}
