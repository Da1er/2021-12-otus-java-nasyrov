package homework;


import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

public class CustomerService {

    Map<Customer, String> customers = new TreeMap<>();
    //важно подобрать подходящую Map-у, посмотрите на редко используемые методы, они тут полезны

    public Map.Entry<Customer, String> getSmallest() {
        return Optional.ofNullable(((TreeMap<Customer, String>) customers).firstEntry())
                .map(entry -> Map.entry(entry.getKey().clone(), entry.getValue()))
                .orElse(null);
    }

    /**
     * Получить следующий по порядку entry для указанного ключа
     * @param customer       указанный ключ (пользователь)
     * @return  следующий по порядку entry относительно указанного ключа, если он найден;
     * <br> иначе - null
     */
    public Map.Entry<Customer, String> getNext(Customer customer) {
        return Optional.ofNullable(((TreeMap<Customer, String>) customers).higherEntry(customer))
                .map(entry -> Map.entry(entry.getKey().clone(), entry.getValue()))
                .orElse(null);
    }

    public void add(Customer customer, String data) {
        customers.put(customer, data);
    }

}
