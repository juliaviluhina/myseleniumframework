package core.wrappers;

public interface LazyEntity<TypeOfWrappedEntity> {

    <TypeOfWrappedEntity> TypeOfWrappedEntity getWrappedEntity();

}
