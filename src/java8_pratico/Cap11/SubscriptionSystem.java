package java8_pratico.Cap11;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class SubscriptionSystem {

    public static void main(String[] args) {
        // 1. Criação dos clientes
        Customer paulo = new Customer("Paulo Silveira");
        Customer rodrigo = new Customer("Rodrigo Turini");
        Customer adriano = new Customer("Adriano Almeida");

        // 2. Configuração de datas para exemplos
        LocalDateTime today = LocalDateTime.now();
        LocalDateTime yesterday = today.minusDays(1);

        // 3. Criação das assinaturas
        BigDecimal monthlyFee = new BigDecimal("99.90");

        // Assinatura ativa (sem data de término)
        Subscription s1 = new Subscription(monthlyFee, yesterday.minusMonths(5), paulo);

        // Assinaturas encerradas
        Subscription s2 = new Subscription(monthlyFee,
                yesterday.minusMonths(8), rodrigo);
        Subscription s3 = new Subscription(monthlyFee,
                yesterday.minusMonths(5), today.minusMonths(2), adriano);

        List<Subscription> subscriptions = Arrays.asList(s1, s2, s3);

        // 4. Cálculo de meses e valores totais para cada assinatura
        System.out.println("Detalhes das assinaturas:");
        subscriptions.forEach(sub -> {
            long months = ChronoUnit.MONTHS.between(
                    sub.getBegin(),
                    sub.getEnd().orElse(LocalDateTime.now()));

            System.out.printf("%s: %d meses (R$ %.2f)%n",
                    sub.getCustomer().getName(),
                    months,
                    sub.getTotalPaid());
        });

        // 5. Total pago por todas as assinaturas
        BigDecimal totalPaid = subscriptions.stream()
                .map(Subscription::getTotalPaid)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        System.out.printf("%nTotal pago por todas as assinaturas: R$ %.2f%n", totalPaid);

        // 6. Assinaturas ativas
        long activeSubscriptions = subscriptions.stream()
                .filter(sub -> sub.getEnd().isEmpty())
                .count();

        System.out.println("\nNúmero de assinaturas ativas: " + activeSubscriptions);

        // 7. Valor médio por assinatura
        BigDecimal averagePaid = totalPaid.divide(
                new BigDecimal(subscriptions.size()), 2, BigDecimal.ROUND_HALF_UP);

        System.out.printf("Valor médio por assinatura: R$ %.2f%n", averagePaid);
    }
}

class Subscription {
    private BigDecimal monthlyFee;
    private LocalDateTime begin;
    private Optional<LocalDateTime> end;
    private Customer customer;

    // Construtor para assinaturas ativas (sem data de término)
    public Subscription(BigDecimal monthlyFee, LocalDateTime begin, Customer customer) {
        this.monthlyFee = monthlyFee;
        this.begin = begin;
        this.end = Optional.empty();
        this.customer = customer;
    }

    // Construtor para assinaturas encerradas
    public Subscription(BigDecimal monthlyFee, LocalDateTime begin,
                        LocalDateTime end, Customer customer) {
        this.monthlyFee = monthlyFee;
        this.begin = begin;
        this.end = Optional.of(end);
        this.customer = customer;
    }

    // Getters
    public BigDecimal getMonthlyFee() {
        return monthlyFee;
    }

    public LocalDateTime getBegin() {
        return begin;
    }

    public Optional<LocalDateTime> getEnd() {
        return end;
    }

    public Customer getCustomer() {
        return customer;
    }

    // Método para calcular o total pago na assinatura
    public BigDecimal getTotalPaid() {
        return getMonthlyFee()
                .multiply(new BigDecimal(ChronoUnit.MONTHS
                        .between(getBegin(),
                                getEnd().orElse(LocalDateTime.now()))));
    }
}
