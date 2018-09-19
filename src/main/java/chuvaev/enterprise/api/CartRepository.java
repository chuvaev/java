package chuvaev.enterprise.api;


import chuvaev.enterprise.entity.Product;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;

public interface CartRepository {

    @Nullable
    void addProduct( @Nullable final Product product);

    @Nullable
    void deleteProduct(@Nullable final String id);

    @Nullable
    public Collection<Product> getAll();
}
