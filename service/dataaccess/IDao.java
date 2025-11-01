package service.dataaccess;

import java.util.List;

import models.Objectbase;
import models.student;

public abstract class IDao extends Objectbase {
    public abstract List<student> getAll();
}
