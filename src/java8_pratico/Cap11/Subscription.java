package java8_pratico.Cap11;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

class Subscription {
    private BigDecimal monthlyFee;
    private LocalDateTime begin;
    private Optional<LocalDateTime> end; // data de término opcional
    private Customer customer;

    public Subscription(BigDecimal monthlyFee, LocalDateTime begin, Customer customer) {
        this.monthlyFee = monthlyFee;
        this.begin = begin;
        this.end = Optional.empty(); // assinatura ativa
        this.customer = customer;
    }

    public Subscription(BigDecimal monthlyFee, LocalDateTime begin, LocalDateTime end, Customer customer) {
        this.monthlyFee = monthlyFee;
        this.begin = begin;
        this.end = Optional.of(end); // assinatura encerrada
        this.customer = customer;
    }

    // Getters omitidos para brevidade

    public BigDecimal getTotalPaid() {
        long months = ChronoUnit.MONTHS.between(begin, end.orElse(LocalDateTime.now()));
        return monthlyFee.multiply(new BigDecimal(months));
    }

    public static void main(String[] args) {
        //Subscription s1 = new Subscription(99.90, ...); // ativa
        //Subscription s2 = new Subscription(99.90, ..., fim, ...); // encerrada
        //Subscription s3 = new Subscription(99.90, ..., fim, ...); // encerrada

        Subscription s1;
        s1 = new Subscription(new BigDecimal("99.90"), LocalDateTime.now(), new Customer("Rodrigo Turini"));
        Subscription s2;
        s2 = new Subscription(new BigDecimal("99.90"), LocalDateTime.now(), LocalDateTime.now().minusMonths(3), new Customer("Guilherme Silveira"));
        Subscription s3;
        s3 = new Subscription(new BigDecimal("99.90"), LocalDateTime.now(), LocalDateTime.now().minusMonths(6), new Customer("Paulo Silveira"));

        List<Subscription> subscriptions = Arrays.asList(s1, s2, s3);

        BigDecimal totalPaid = subscriptions.stream()
                .map(Subscription::getTotalPaid)
                .reduce(BigDecimal.ZERO, BigDecimal::add);


    }
}

