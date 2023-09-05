package ufrn.br.taskflow.core.base;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter @Setter
@MappedSuperclass
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
public class BaseModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @EqualsAndHashCode.Include @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    protected Long id;

}
