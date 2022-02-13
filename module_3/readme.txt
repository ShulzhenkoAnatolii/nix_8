Программа запускаеться с помощью файла deploy.bat. Данные для подключения к БД в файлах execute_sql_script.bat и application.properties:
username=root
password=rootroot
Для работы используеться БД с именем bank_application, SQL скрипты лежат в папочке resources--->sql;
Entity ---> User, Account, Transaction.
Что-бы создать новый Account нужно выбрать User--->accounts--->Add (При создании Account указываеться сумма в центах);
Что-бы создать новую Transaction нужно перейти на вкладку Transactions--->Make a Transaction (Сумма перевода в $);
Что-бы посмотреть список Transactions по Account нужно выбрать Accounts--->Details, там же можно експортировать данные по счёту
предварительно выбрав промежуток дат (По умолчанию первая дата = первой транзакции)
