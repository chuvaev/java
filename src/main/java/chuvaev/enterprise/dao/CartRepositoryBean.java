package chuvaev.enterprise.dao;

import chuvaev.enterprise.api.CartRepository;
import chuvaev.enterprise.entity.Product;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.enterprise.context.ApplicationScoped;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

@ApplicationScoped
public class CartRepositoryBean implements CartRepository {

    @NotNull
    private Map<String, Product> cart = new LinkedHashMap<>();

    @NotNull
    public void addProduct(@Nullable final Product product){
        cart.put(product.getId(),product);
    }

    @Nullable
    public void deleteProduct(@Nullable final String id){
        cart.remove(id);
    }

    @Nullable
    public Collection<Product> getAll(){
        return cart.values();
    }
}
