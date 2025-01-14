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

def pizza_select():
    pizza_menu = {'페퍼로니 피자':3000,
                    '치즈 피자':3200,
                    '콤비네이션 피자':3500,
                    '불고기 피자':3600,
                    '해산물 피자':3800}
    pizza_order = {}

    for name, price in pizza_menu.items():
        print(f'{name} ({price})원')

    while True:
        p_name = input('메뉴 이름 입력하세요(종료: exit)')
        if p_name == '0':
            pass
        elif p_name in pizza_menu:
            count = int(input('수량을 입력하세요: '))
            pizza_order[p_name] = count
            print(pizza_order)
        elif p_name == 'exit':
            print('피자 주문 완료!')
            break
    return pizza_order, pizza_menu

def drink_select():
    drink_menu = {'콜라': 1500,
            '사이다': 1500,
            '생수': 1000}
    drink_order = {}

    for name, price in drink_menu.items():
        print(f'{name} ({price})원')

    while True:
        d_name = input('메뉴 이름 입력하세요(종료: exit)')
        if d_name == '0':
            pass
        elif d_name in drink_menu:
            count = int(input('수량을 입력하세요: '))
            drink_order[d_name] = count
            print(drink_order)
        elif d_name == 'exit':
            print('음료 주문 완료!')
            break
    return drink_order, drink_menu

if __name__ == '__main__':
    print(pizza_select())
    print(drink_select())