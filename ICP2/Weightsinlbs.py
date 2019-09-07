
n = int(input("Enter no of students : "))
l=[]
m=[]
for x in range(0,n):
    a=int(input("Weight in lbs : "))
    l.append(a);
print(l)

m = [x*0.452 for x in l if x]
print(m)




