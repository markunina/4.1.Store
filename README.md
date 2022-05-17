# Решение задачи 1 (Магазин).

**Условие задачи**

//NO MAGICS в строке 45
public class MenuFilter

//DRY 
public class Menu
метод
printMenu(String[] menu)

используется в классах: MenuCart(строка 17),MenuCatalog(строка 18), 
MenuFilter(строка 22) и т.д.

//Single responsibility principle
public class Output implements IOutput

//Open-Closed Principle, класс User наследуется классом Buyer
public class User implements IUser

//Liskov substitution principle - класс Buyer исполняет роль IUser(строка 17)
public class MenuRegistration

//Interface segregation principle
класс Product разделен на классы: 
Product(сам продукт),
Products(список продуктов магазина),
Filter(фильтрация списка продуктов магазина), 
Catalog(текстовый список всех продуктов магазина), 
Rating(присвоение рейтинга продуктам)





