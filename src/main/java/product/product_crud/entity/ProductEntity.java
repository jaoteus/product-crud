package product.product_crud.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "tb_products")
public class ProductEntity {

    @Id
    @Getter
    @Setter
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uuid;

    @Getter
    @Setter
    @NotBlank
    @NotNull
    private Double price;

    @Getter
    @Setter
    @NotNull
    @NotBlank
    private String name;

    @Getter
    @Setter
    @ManyToMany
//    @JsonIgnore
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
}

