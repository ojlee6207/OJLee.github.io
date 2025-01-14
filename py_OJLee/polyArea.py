def rectangleArea(width, depth):
    return width*depth

def triangleArea(base, height):
    return base*height/2

# 파일 내에서 자기 자신을 호출 할 때
if __name__ == '__main__':
    print(f'기본 예시 {rectangleArea(10,2)}')
    print(f'기본 예시 {triangleArea(5,9)}')