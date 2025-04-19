package java8_pratico.Cap11;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;

class Payment {
    private List<Product> products;
    private LocalDateTime date;
    private Customer customer;

    public Payment(List<Product> products, LocalDateTime date, Customer customer) {
        this.products = Collections.unmodifiableList(products); // lista imutável
        this.date = date;
        this.customer = customer;
    }

    public Payment(Customer customer, List<Product> list) {
        this.products = Collections.unmodifiableList(list); // lista imutável
        this.date = LocalDateTime.now();
        this.customer = customer;
    }

    public Payment(List<Product> products, LocalDateTime date) {
        this.products = products;
        this.date = date;
    }

    public List<Product> getProducts() { return products; }
    public LocalDateTime getDate() { return date; }
    public Customer getCustomer() { return customer; }

    @Override
    public String toString() {
        return "[Payment: " + date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")) +
                " " + customer + " " + products + "]";
    }

    // Opcional: método sugerido no livro para melhorar legibilidade
    public BigDecimal getTotalAmount() {
        return products.stream()
                .map(Product::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}

