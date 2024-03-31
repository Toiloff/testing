## Нагрузочное тестирование

В ходе лабораторной работы мы установили тестовый [Notable API](https://github.com/bunnies-group/notable-node-api-tutorial/tree/master), базу данных MongoDB и Apache JMeter, благодаря чему смогли провести нагрузочное тестирование API.

### Ход работы:

1. Запустили MongoDB и Notable API

![mongodb](images/mongodb.png)

![notable-api](images/notable-api.png)

2. Настроили тестовый план в JMeter:

    ![test-plan](images/test-plan.png)

3. Запустили тесты в JMeter:

    1. Результаты запущенных тестов:

    ![results-tree](images/results-tree.png)

    2. Результат в видео отчета:

    ![aggregate-report](images/aggregate-report.png)

    3. График результатов:

    ![graph-results](images/graph-results.png)

4. Проверли что данные сохранились в БД:

![added-notes](images/added-notes.png)

