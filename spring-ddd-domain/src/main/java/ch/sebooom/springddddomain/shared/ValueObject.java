package ch.sebooom.springddddomain.shared;


public interface ValueObject<T> {

    boolean sameValueAs(T otherValueObject);
}
