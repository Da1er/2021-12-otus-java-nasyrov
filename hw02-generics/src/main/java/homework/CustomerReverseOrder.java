package homework;


import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Сервис получения пользователей в порядке, обратном добавлению
 */
public class CustomerReverseOrder {

    /** Стек с элементами */
    private final Deque<Customer> customerStack = new ArrayDeque<>();

    /**
     * Добавить пользователя
     * @param customer       добавляемый пользователь
     */
    public void add(Customer customer) {
        customerStack.add(customer);
    }

    /**
     * Получить пользователя
     * @return последний добавленный пользователь
     */
    public Customer take() {
        return customerStack.pollLast();
    }
}
