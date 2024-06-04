package product.product_crud.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "tb_products")
public class ProductEntity {
    // TODO: Achar um solução para mostrar tanto os produtos que possuem as categorias
    // e mostrar as categorias que possuem os produtos

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uuid;

    @NotBlank
    @NotNull
    private Double price;

    @NotNull
    @NotBlank
    private String name;

    @ManyToMany
    @JsonIgnore
    @JoinTable(
            name = "product_category",
            joinColumns = @JoinColumn(name = "product_uuid"),
            inverseJoinColumns = @JoinColumn(name = "category_uuid")
    )
    private Set<CategoryEntity> categories = new HashSet<CategoryEntity>();

    public ProductEntity() {
    }

    public ProductEntity(UUID uuid, Double price, String name) {
        this.uuid = uuid;
        this.price = price;
        this.name = name;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public @NotBlank @NotNull Double getPrice() {
        return price;
    }

    public void setPrice(@NotBlank @NotNull Double price) {
        this.price = price;
    }

    public @NotNull @NotBlank String getName() {
        return name;
    }

    public void setName(@NotNull @NotBlank String name) {
        this.name = name;
    }

    public Set<CategoryEntity> getCategories() {
        return categories;
    }

    public void setCategories(Set<CategoryEntity> categories) {
        this.categories = categories;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductEntity product = (ProductEntity) o;
        return Objects.equals(uuid, product.uuid);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(uuid);
    }
}

