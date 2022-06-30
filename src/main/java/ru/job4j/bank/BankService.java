package ru.job4j.bank;

import java.util.*;

/**
 * Класс сервис банка.
 */
public class BankService {
    /**
     * Содержит поле всех пользователей,
     * добавленных в систему.
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод должен добавить пользователя и проверить
     * существует ли он в системе или нет.
     * @param user принимает объект класса User(нового пользователя).
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     *Метод добавляет новый счет пользователю и проверяет
     * есть ли у него уже такой счет, а так же
     * поиск пользователя по параметру(номер паспорта).
     * @param passport Номер паспорта для поиска пользователя.
     * @param account ОбЪект класса Account для добавления нового счета
     *                и проверки на наличие аналогичного.
     */
    public void adAccount(String passport, Account account) {
        if (findByPassport(passport) != null) {
            List<Account> list = users.get(findByPassport(passport));
            if (!list.contains(account)) {
                list.add(account);
            }
        }
    }

    /**
     *Метод ищет пользователя по номеру паспорта.
     * @param passport Номер паспорта пользователя.
     * @return Возвращает номер паспорта пользователя или
     * null если пользователь не найден.
     */
    public User findByPassport(String passport) {
       return users.keySet()
                .stream()
                .filter(user -> user.getPassport().equals(passport))
                .findFirst()
                .orElse(null);
    }

    /**
     *Метод ищет пользователя по номеру паспорта, по нему же проверяет
     * реквизиты.
     * @param passport Номер паспорта пользователя.
     * @param requisite Номер реквизитов пользователя.
     * @return Возвращает найденные реквизиты либо
     * null если ничего не найдено.
     */
    public Account findByRequisite(String passport, String requisite) {
        User client = findByPassport(passport);
        if (client != null) {
            return users.get(client).stream()
                    .filter(user -> user.getRequisite().equals(requisite))
                    .findFirst()
                    .orElse(null);
        }
        return null;
    }

    /**
     *Метод начисляет средства с одного счета на другой
     * @param srcPassport Паспорт пользователя с которого будет производиться списание.
     * @param srcRequisite Реквизиты пользователя с которого будет производиться списание.
     * @param destPassport Паспорт пользователя, на счет которого будет производиться пополнение.
     * @param destRequisite Реквизиты пользователя, на счет которого будет производиться пополнение.
     * @param amount Сумма перевода.
     * @return возвращает результат работы перевода.
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        Account srcAcc = findByRequisite(srcPassport, srcRequisite);
        Account destAcc = findByRequisite(destPassport, destRequisite);
        boolean rsl = false;
        if (srcAcc != null && destAcc != null && srcAcc.getBalance() > 0) {
            srcAcc.setBalance(srcAcc.getBalance() - amount);
            destAcc.setBalance(destAcc.getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }
}
