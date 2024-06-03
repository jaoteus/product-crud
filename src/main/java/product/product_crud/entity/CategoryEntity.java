package product.product_crud.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "tb_category")
public class CategoryEntity {

    @Id
    @Getter
    @Setter
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uuid;

    //TODO: Depois colocar um método para adicionar produtos

    @Getter
    @Setter
    @ManyToMany(mappedBy = "categories")
    @JsonIgnore
    private Set<ProductEntity> products = new HashSet<ProductEntity>();

    @Setter
    @Getter
    @NotNull
    @NotBlank
    @Column(unique = true)
    private String name;

    public CategoryEntity() {
    }

    public CategoryEntity(UUID uuid, String name) {
        this.uuid = uuid;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CategoryEntity category = (CategoryEntity) o;
        return Objects.equals(uuid, category.uuid);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(uuid);
    }
}
