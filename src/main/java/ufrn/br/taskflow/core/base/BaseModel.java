package ufrn.br.taskflow.core.base;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter @Setter
@MappedSuperclass
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
public class BaseModel implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @EqualsAndHashCode.Include @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    protected Long id;

    LocalDateTime deletedAt;

    @UpdateTimestamp
    LocalDateTime updatedAt;

    @CreationTimestamp
    LocalDateTime createdAt;

}
