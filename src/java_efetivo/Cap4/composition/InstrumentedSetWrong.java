package java_efetivo.Cap4.composition;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class InstrumentedSetWrong<E> extends HashSet<E> {
  private int addCount = 0;

  public InstrumentedSetWrong() {
  }

  @Override
  public boolean add(E e) {
    addCount++;
    return super.add(e);
  }

  @Override
  public boolean addAll(Collection<? extends E> c) {
    addCount += c.size();
    return super.addAll(c);
  }

  public int getAddCount() {
    return addCount;
  }

  public record Product(String name, double price) {
    // O corpo da classe de registro é vazio
  }

  public static void main(String[] args) {
    Product product1 = new Product("Pencil", 2.45);
    Product product2 = new Product("Pen", 3.45);

    InstrumentedSetWrong<Product> productsInst = new InstrumentedSetWrong<>();
    productsInst.add(product1);
    productsInst.add(product2);

    Set<Product> productsCol = new HashSet<>();
    productsCol.add(new Product("rule", 5));
    productsCol.add(new Product("eraser", 2.45));

    productsInst.addAll(productsCol);

    System.out.println("total items: " + productsInst.getAddCount());

  }
}
