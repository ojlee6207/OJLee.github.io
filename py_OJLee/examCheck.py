# improt examCalculator as exC
# import examCalculator
from examCalculator import *

# for i in range(3):
#     sub = int(input(f'과목{i+1} 점수 입력 >> '))
sub1 = int(input(f'과목1 점수 >> '))
sub2 = int(input(f'과목2 점수 >> '))
sub3 = int(input(f'과목3 점수 >> '))

# print(f'총점 : {exC.sum(sub1, sub2, sub3)}')
# print(f'평균 : {exC.average(sub1, sub2, sub3)}')
# print(f'합격 여부 : {exC.passfail(sub1, sub2, sub3)}')

# print(f'총점 : {examCalculator.sum(sub1, sub2, sub3)}')
# print(f'평균 : {examCalculator.average(sub1, sub2, sub3)}')
# print(f'합격 여부 : {examCalculator.passfail(sub1, sub2, sub3)}')

print(f'총점 : {sum(sub1, sub2, sub3)}')
print(f'평균 : {average(sub1, sub2, sub3)}')
print(f'합격 여부 : {passfail(sub1, sub2, sub3)}')