import polyArea

menu = int(input('원하는 도형의 넓이를 구하시오(1. 사각형, 2.삼각형) >> '))

if menu == 1:
    print('사각형 넓이 계산')
    width = int(input('가로 길이 입력 : '))
    depth = int(input('세로 길이 입력 : '))
    print(f'넓이 : {polyArea.rectangleArea(width, depth):.1f}')
elif menu == 2:
    print('삼각형 넓이 계산')
    base = int(input('밑변 길이 입력 : '))
    height = int(input('높이 입력 : '))
    print(f'넓이 : {polyArea.triangleArea(base, height):.1f}')
else:
    print('잘못 입력했습니다. 다시 입력하세요.')
    
    