package chuvaev.enterprise.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.Nullable;

@Data
@NoArgsConstructor
@EqualsAndHashCode (callSuper = true)

public class Cart extends AbstractEntity{

    @Nullable
    private String name = "";

    public Cart(String name){this.name = name;}
}
