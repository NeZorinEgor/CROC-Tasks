# На входе имеется несколько входных файлов, в которых указаны данные по товарам, продавцам, ценам и продажам:

## Файл с товарами:

- ID товара

- Наименование товара

## Файл с продавцами:

- ID продавца

- Фамилия продавца

- Имя продавца

## Файл с данными по наличию товаров у продавцов:

- ID продавца

- ID товара

- Цена товара

- Количество товара в наличии у продавца

## Файл с продажами:

- ID продажи

- ID продавца

- ID товара

- Количество проданных товаров

- Дата продажи

## Задание 1

- Вывести в файл топ 5 товаров с наибольшим количеством продаж

## Задание 2

-Вывести в файл топ 5 дат, в которые было продано наибольшее количество товаров

## Форматы файлов:
- XML -> JSON

Входные xml файлы находятся в дерриктории:
```xpath
src/main/java/org/neZorinEgor/Data/Input
```

Выходные файлы:
```xpath
src/main/java/org/neZorinEgor/Data/Input
```

## Запуск проекта:
Склонируйте репозиторий с кодом:
```bash
git clone https://github.com/NeZorinEgor/CROC-Tasks.git
```

## Перейдите в директорию с кодом:
```bash
cd CROC-Tasks/Task7_FinalTask
```

## Сборка и запуск приложения с помощью Apache Maven
```mvn
mvn clean compile exec:java
```

