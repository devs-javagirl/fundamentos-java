package java8_pratico.Cap11;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class SistemaAssinaturas {

    public static void main(String[] args) {
        // Criando clientes (reutilizando do exemplo anterior)
        Customer1 paulo = new Customer1("Paulo Silveira");
        Customer1 rodrigo = new Customer1("Rodrigo Turini");
        Customer1 adriano = new Customer1("Adriano Almeida");
        Customer1 guilherme = new Customer1("Guilherme Silveira");

        // Definindo datas para os exemplos
        LocalDateTime hoje = LocalDateTime.now();
        LocalDateTime ontem = hoje.minusDays(1);
        LocalDateTime umMesAtras = hoje.minusMonths(1);
        LocalDateTime doisMesesAtras = hoje.minusMonths(2);

        // Criando assinaturas
        BigDecimal monthlyFee = new BigDecimal("99.90");

        // s1: assinatura ativa (sem data de término)
        Subscription1 s1 = new Subscription1(monthlyFee, ontem.minusMonths(5), paulo);

        // s2: assinatura encerrada há 1 mês
        Subscription1 s2 = new Subscription1(monthlyFee, ontem.minusMonths(8), umMesAtras, rodrigo);

        // s3: assinatura encerrada há 2 meses
        Subscription1 s3 = new Subscription1(monthlyFee, ontem.minusMonths(5), doisMesesAtras, adriano);

        List<Subscription1> subscriptions = Arrays.asList(s1, s2, s3);

        // 1. Mostrando informações das assinaturas
        System.out.println("=== Detalhes das Assinaturas ===");
        subscriptions.forEach(sub -> {
            String status = sub.getEnd().isPresent() ? "Encerrada" : "Ativa";
            System.out.printf("%s - %s (Total pago: R$ %.2f)%n",
                    sub.getCustomer().getName(),
                    status,
                    sub.getTotalPaid());
        });

        // 2. Calculando o total pago por todas as assinaturas
        BigDecimal totalPaid = subscriptions.stream()
                .map(Subscription1::getTotalPaid)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        System.out.printf("%nTotal pago por todas assinaturas: R$ %.2f%n", totalPaid);

        // 3. Agrupando por cliente (integrando com exemplo anterior de pagamentos)
        System.out.println("%n=== Total por cliente (assinaturas + pagamentos) ===");

        // Supondo que temos os pagamentos do exemplo anterior
        List<Payment1> payments = Arrays.asList(
                new Payment1(paulo, Arrays.asList(new Product1("Curso Java", new BigDecimal("199.90"))), hoje),
                new Payment1(rodrigo, Arrays.asList(new Product1("Curso Python", new BigDecimal("299.90"))), hoje),
                new Payment1(adriano, Arrays.asList(new Product1("Curso JavaScript", new BigDecimal("149.90"))), hoje)
        );

        // Calculando total de pagamentos por cliente
        Map<Customer1, BigDecimal> totalPayments = payments.stream()
                .collect(Collectors.groupingBy(
                        Payment1::getCustomer,
                        Collectors.reducing(
                                BigDecimal.ZERO,
                                p -> p.getProducts().stream()
                                        .map(Product1::getPrice)
                                        .reduce(BigDecimal.ZERO, BigDecimal::add),
                                BigDecimal::add
                        )
                ));

        // Calculando total de assinaturas por cliente
        Map<Customer1, BigDecimal> totalSubscriptions = subscriptions.stream()
                .collect(Collectors.groupingBy(
                        Subscription1::getCustomer,
                        Collectors.reducing(
                                BigDecimal.ZERO,
                                Subscription1::getTotalPaid,
                                BigDecimal::add
                        )
                ));

        // Combinando os totais
        List<Customer1> allCustomers = Arrays.asList(paulo, rodrigo, adriano, guilherme);

        allCustomers.forEach(customer -> {
            BigDecimal paymentsTotal = totalPayments.getOrDefault(customer, BigDecimal.ZERO);
            BigDecimal subsTotal = totalSubscriptions.getOrDefault(customer, BigDecimal.ZERO);
            BigDecimal total = paymentsTotal.add(subsTotal);

            System.out.printf("%s: R$ %.2f (R$ %.2f em pagamentos + R$ %.2f em assinaturas)%n",
                    customer.getName(),
                    total,
                    paymentsTotal,
                    subsTotal);
        });
    }
}

class Subscription1 {
    private BigDecimal monthlyFee;
    private LocalDateTime begin;
    private Optional<LocalDateTime> end;
    private Customer1 customer;

    // Construtor para assinaturas ativas (sem data de término)
    public Subscription1(BigDecimal monthlyFee, LocalDateTime begin, Customer1 customer) {
        this.monthlyFee = monthlyFee;
        this.begin = begin;
        this.end = Optional.empty();
        this.customer = customer;
    }

    // Construtor para assinaturas encerradas
    public Subscription1(BigDecimal monthlyFee, LocalDateTime begin,
                        LocalDateTime end, Customer1 customer) {
        this.monthlyFee = monthlyFee;
        this.begin = begin;
        this.end = Optional.of(end);
        this.customer = customer;
    }

    // Getters
    public BigDecimal getMonthlyFee() { return monthlyFee; }
    public LocalDateTime getBegin() { return begin; }
    public Optional<LocalDateTime> getEnd() { return end; }
    public Customer1 getCustomer() { return customer; }

    // Calcula o total pago na assinatura
    public BigDecimal getTotalPaid() {
        return monthlyFee.multiply(
                new BigDecimal(ChronoUnit.MONTHS.between(
                        begin,
                        end.orElse(LocalDateTime.now())
                ))
        );
    }
}

// Classes reutilizadas dos exemplos anteriores
class Customer1 {
    private String name;
    public Customer1(String name) { this.name = name; }
    public String getName() { return name; }
}

class Product1 {
    private String name;
    private BigDecimal price;
    public Product1(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }
    public BigDecimal getPrice() { return price; }
}

class Payment1 {
    private Customer1 customer;
    private List<Product1> products;
    private LocalDateTime date;

    public Payment1(Customer1 customer, List<Product1> products, LocalDateTime date) {
        this.customer = customer;
        this.products = products;
        this.date = date;
    }

    public Customer1 getCustomer() { return customer; }
    public List<Product1> getProducts() { return products; }
    public LocalDateTime getDate() { return date; }
}
