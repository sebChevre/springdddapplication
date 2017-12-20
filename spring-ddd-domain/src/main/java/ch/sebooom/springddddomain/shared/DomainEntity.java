package ch.sebooom.springddddomain.shared;


public interface DomainEntity<T, S> {

    S getId();

    boolean sameIdentityAs(T otherEntity);
}
