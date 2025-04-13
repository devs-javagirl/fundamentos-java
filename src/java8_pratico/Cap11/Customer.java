package java8_pratico.Cap11;

import org.jetbrains.annotations.NotNull;

class Customer implements Comparable<Customer> {
    private String name;

    public Customer(String name) {
        this.name = name;
    }

    public String getName() { return name; }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int compareTo(@NotNull Customer o) {
        return this.name.compareTo(o.name);
    }
}
