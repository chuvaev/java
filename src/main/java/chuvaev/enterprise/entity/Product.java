package chuvaev.enterprise.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.Nullable;

@Data
@NoArgsConstructor
@EqualsAndHashCode (callSuper = true)
public class Product extends AbstractEntity {

    @Nullable
    private String name = "";

    @Nullable
    private String description = "";

    @Nullable
    private double price;

    public Product(@Nullable final String name, Double price){
        this.name = name;
        this.price = price;
    }
}
