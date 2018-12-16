package chuvaev.enterprise.dao;

import chuvaev.enterprise.api.ProductRepository;
import chuvaev.enterprise.entity.Product;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import java.util.*;

@ApplicationScoped
public class ProductRepositoryBean implements ProductRepository {

    @NotNull
    private Map<String, Product> products = new LinkedHashMap<>();

    @PostConstruct
    private void init() {
        Collection<Product> products = new LinkedHashSet<>();
        products.add(new Product("Velobike Nike" ,7200d));
        products.add(new Product("Velobike BMW" ,9300d));
        products.add(new Product("Begog Fast" ,5600d));
        products.add(new Product("Begog Comet" ,6200d));
        products.add(new Product("Begog MustangGT320" ,5900d));
        products.add(new Product("Velobike MercedesGT" ,9200d));
        products.add(new Product("Velobike RollsRoyce" ,10000d));
        products.add(new Product("Velobike Bentley" ,9500d));
        merge(products);
        System.out.println(products.hashCode());
    }

    @NotNull
    public Collection<Product> findAll() {
        return products.values();
    }

    @NotNull
    public Product findById(@Nullable final String id) {
        if (id == null || id.isEmpty()) return null;
        return products.get(id);
    }

    @NotNull
    public Collection<Product> findByIds(@Nullable final Collection<String> ids) {
        if (ids == null || ids.isEmpty()) return Collections.emptySet();
        @NotNull final Collection<Product> result = new LinkedHashSet<>();
        for (@Nullable final String id : ids) {
            if (id == null || id.isEmpty()) continue;
            final Product product = findById(id);
            if (product == null) continue;
            result.add(product);
        }
        return result;
    }

    @Nullable
    public Product merge(@Nullable final Product product) {
        if (product == null) return null;
        @Nullable final String id = product.getId();
        if (id == null || id.isEmpty()) return null;
        products.put(id, product);
        return product;
    }

    @Nullable
    public Collection<Product> merge(@Nullable final Collection<Product> products) {
        if (products == null || products.isEmpty()) Collections.emptySet();
        @NotNull final Collection<Product> result = new LinkedHashSet<>();
        for (@Nullable final Product product : products) {
            if (product == null) continue;
            result.add(merge(product));
        }
        return result;
    }

    public void removeById(@Nullable final String id){
        if (id == null || id.isEmpty()) return;
        if(!products.containsKey(id)) return;
        products.remove(id);
    }
    public void removeByIds(@Nullable Collection<String> ids){
        if (ids == null || ids.isEmpty()) return;
        for(@Nullable final String id: ids) removeById(id);
    }
    public void remove(@Nullable final Collection<Product> products){
        if (products == null || products.isEmpty()) return;
        for(@Nullable final Product product: products){
            if(product == null) continue;
            removeById(product.getId());
        }
    }
    public void removeAll(){products.clear();}
}