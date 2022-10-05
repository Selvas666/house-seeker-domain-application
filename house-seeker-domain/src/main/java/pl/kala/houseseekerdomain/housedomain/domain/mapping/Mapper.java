package pl.kala.houseseekerdomain.housedomain.domain.mapping;

import io.vavr.control.Either;
import io.vavr.control.Option;
import io.vavr.control.Try;

public interface Mapper <S, T> {

    T convert (S var1);

    default Try<T> tryConvert(S source){
        return Try.of(()->{
            return this.convert(source);
        });
    }

    default Option<T> optionConvert(S source){
        return Try.of(() -> {
            return this.convert(source);
        }).toOption();
    }

    default Either<RuntimeException, T> eitherConvert(S source){
        return Try.of(() -> {
            return this.convert(source);
        }).toEither().mapLeft(RuntimeException::new);
    }
}
