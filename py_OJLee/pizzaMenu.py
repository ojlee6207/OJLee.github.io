# def pizzaPrice(menu, count):
#     if menu in pizza.keys():
#         return pizza.values(menu)*count
#     else:
#         return 0

# def drinkPrice(menu, count):
#     if menu in drink.keys():
#         return drink.values(menu)*count
#     else:
#         return 0

# pizza = {'페페로니': 16500,
#          '치즈': 16000,
#          '콤비네이션': 17000,
#          '불고기': 17500,
#          '쉬림프': 19000}

# def pizza_select():
#     pizza_menu = {'페퍼로니 피자':3000,
#                     '치즈 피자':3200,
#                     '콤비네이션 피자':3500,
#                     '불고기 피자':3600,
#                     '해산물 피자':3800}
#     pizza_order = {}

#     for name, price in pizza_menu.items():
#         print(f'{name} ({price})원')

#     while True:
#         p_name = input('메뉴 이름 입력하세요(종료: exit)')
#         if p_name == '0':
#             pass
#         elif p_name in pizza_menu:
#             count = int(input('수량을 입력하세요: '))
#             pizza_order[p_name] = count
#             print(pizza_order)
#         elif p_name == 'exit':
#             print('피자 주문 완료!')
#             break
#     return pizza_order, pizza_menu

# def drink_select():
#     drink_menu = {'콜라': 1500,
#             '사이다': 1500,
#             '생수': 1000}
#     drink_order = {}

#     for name, price in drink_menu.items():
#         print(f'{name} ({price})원')

#     while True:
#         d_name = input('메뉴 이름 입력하세요(종료: exit)')
#         if d_name == '0':
#             pass
#         elif d_name in drink_menu:
#             count = int(input('수량을 입력하세요: '))
#             drink_order[d_name] = count
#             print(drink_order)
#         elif d_name == 'exit':
#             print('음료 주문 완료!')
#             break
#     return drink_order, drink_menu

def select(menu, menuname):
    order = {}
    print(f'\n**** {menuname} 목록 ****')

    for name, price in menu.items():
        print(f'{name} ({price})원')

    while True:
        p_name = input(f'주문할 {menuname}를 입력하세요(종료: exit) >> ')
        if p_name == '0':
            pass
        elif p_name in menu:
            count = int(input('수량을 입력하세요: '))
            order[p_name] = count
            print(order)
        elif p_name == 'exit':
            print('주문 완료!')
            break
    return order

def priceCalculator(order,menu):
    tot_price = 0
    for x in order.keys() :
        price = 0
        if x in menu.keys() :
            price = price + (order[x] * menu[x])
        print(f'{x}({menu[x]}원) X {order[x]} = {price:,}원')
        tot_price += price
    print(f'가격 : {tot_price:,}원')
    return tot_price
    

if __name__ == '__main__':
    pizza_menu = {'페퍼로니 피자':3000,
                '치즈 피자':3200,
                '콤비네이션 피자':3500,
                '불고기 피자':3600,
                '해산물 피자':3800}
    drink_menu = {'콜라': 1500,
                '사이다': 1500,
                '생수': 1000}
    
    order_pizza = select(pizza_menu, '피자')
    print(order_pizza)
    order_drink = select(drink_menu, '음료')
    print(order_drink)

    tot_pizza = priceCalculator(order_pizza,pizza_menu)
    tot_drink = priceCalculator(order_drink,drink_menu)

    print(f'전체 가격(피자+음료) : {tot_pizza+tot_drink:,}원')

# def pizzaCalculator():
#     tot_price = 0
#     for x in order_pizza.keys() :
#         pizza_price = 0
#         if x in pizza_menu.keys() :
#             pizza_price = pizza_price + (order_pizza[x] * pizza_menu[x])
#         print(f'{x}({pizza_menu[x]}원) X {order_pizza[x]} = {pizza_price:,}원')
#         tot_price += pizza_price
#     print(f'피자 전체 가격 : {tot_price:,}')
    
# def drinkCalculator():
#     for x in order_drink.keys() :
#         drink_price = 0
#         if x in drink_menu.keys() :
#             drink_price = drink_price + (order_drink[x] * drink_menu[x])
#         print(f'{x}({drink_menu[x]}원) X {order_drink[x]} = {drink_price:,}원')
#         tot_price += drink_price
#     print(f'음료 전체 가격 : {tot_price:,}')


    # print(drink_select())