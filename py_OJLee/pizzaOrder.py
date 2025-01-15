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

pizza_menu = {'페퍼로니 피자':3000,
                '치즈 피자':3200,
                '콤비네이션 피자':3500,
                '불고기 피자':3600,
                '해산물 피자':3800}
drink_menu = {'콜라': 1500,
                '사이다': 1500,
                '생수': 1000}
    
order_pizza = pM.select(pizza_menu, '피자')
print(order_pizza)
order_drink = pM.select(drink_menu, '음료')
print(order_drink)

tot_pizza = pM.priceCalculator(order_pizza,pizza_menu)
tot_drink = pM.priceCalculator(order_drink,drink_menu)

print(f'전체 가격(피자+음료) : {tot_pizza+tot_drink}')