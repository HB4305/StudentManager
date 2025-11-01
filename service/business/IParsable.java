package service.business;

import models.Objectbase;

public abstract class IParsable<T extends Objectbase> extends Objectbase {
    public abstract T parse(String data);
}