## 피자 주문 함수 호출하여 영수증 출력
# import pizzaMenu as p

# pizzaOrder = {}
# p_count = []

# drinkOrder = {}
# d_count = []

# while True:
#     print('*** 피자를 선택해주세요 ***')
#     for i in range(len(p.pizza)):
#         print(f'{p.pizza.keys(i)} 피자 : {p.pizza.values(i)}원')
#     p_menu = input('메뉴 이름을 입력하세요.(종료는 exit) >> ')
#     if p_menu == 'exit':
#         break
#     count = int(input('수량을 입력하세요 >> '))
#     pizzaOrder[p_menu] = p.pizza.values(p_menu)
#     p_count.append(count)

# while True:
#     print('*** 음료를 선택해주세요 ***')
#     for i in range(len(p.drink)):
#         print(f'{p.drink.keys(i)} : {p.drink.values(i)}원')
#     d_menu = input('메뉴 이름을 입력하세요.(종료는 exit) >> ')
#     if d_menu == 'exit':
#         break
#     count = int(input('수량을 입력하세요 >> '))
#     drinkOrder[d_menu] = p.drink.values(d_menu)
#     d_count.append(count)

# print("="*60)
# print("주문 내역 : ")
# for i in range(pizzaOrder):
#     print(f'{pizzaOrder.keys[i]} 피자 ({pizzaOrder.values[i]}) x {p_count[i]}')

import pizzaMenu as pM

print(pM.pizza_select())


# print(pM.drink_select())