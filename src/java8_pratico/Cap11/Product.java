package java8_pratico.Cap11;

import java.math.BigDecimal;
import java.nio.file.Path;

class Product {
    private String name;
    private Path file;
    private BigDecimal price;

    public Product(String name, Path file, BigDecimal price) {
        this.name = name;
        this.file = file;
        this.price = price;
    }

    public Product(String name, BigDecimal bigDecimal) {
        this.name = name;
        this.file = null; // Assuming file is not needed for this constructor
        this.price = bigDecimal;
    }

    public String getName() { return name; }
    public Path getFile() { return file; }
    public BigDecimal getPrice() { return price; }

    @Override
    public String toString() {
        return name;
    }
}

