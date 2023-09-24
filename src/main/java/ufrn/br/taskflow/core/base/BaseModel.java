package ufrn.br.taskflow.core.base;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
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

    @JsonIgnore
    LocalDateTime deletedAt;

    @JsonIgnore
    @UpdateTimestamp
    LocalDateTime updatedAt;

    @JsonIgnore
    @CreationTimestamp
    LocalDateTime createdAt;


}
