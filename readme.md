Задание 1.

1) Создать новый репозиторий для игры крестики-нолики, основную ветку назвать master, в нее в качестве начального коммита запушить файл readme.md с этим заданием.

2) От ветки master отвести ветку task_1, в которой проводить всю дальнейшую работу 2.1) перед началом выполнения следующего пункта необходимо примерно оценить (в часах) время, за которое будет выполнено данное задание и прислать цифру мне. Это информационная вещь и на что не влияет, но сделать оценку надо обязательно.

3) Написать игру крестики-нолики: -Поле будет иметь фиксированный размер 3х3, оно должно рисоваться в консоли на каждом шаге -Игра рассчитана на 2 игроков-людей, ходы осуществлюятся поочередным вводом в консоль координат для постановки крестика/нолика (a1, b2, c3..) -При запуске программы выводится приветственное сообщение с предложением поиграть, далее ход передается игроку 1 -После каждого хода должно рисовать поле и сообщение о том, кто сейчас ходит. -Игра должна уметь определять окончание игры (заполнено все поле/построен ряд из 3 одинаковых символов), выводить соответствующее сообщение о победе/ничьей и предлагать сыграть новую игру (y/n). В случае согласия на новую игру все начинается с начала, в случае отказа-программа завершает работу. -Крестики и нолики визуально в консоли должны отображаться символами Х и О, наличие горизонтальных и вертикальных разделителей - желательно (можно их сделать в самом конце как бонус, на код-ревью можно присылать без них).

4) По окончании задания ветку task1 необходимо запушить на гитхаб, после чего через веб-интерфейс гитхаба создать там пулл-реквест в ветку master, меня поставить в качестве ревьюера.

Задание 2.
Реализация поля произвольного размера (в пределах от 3 до 10) и произвольной длины победной последовательности, но не более наименьшей из сторон поля. 
