f= open("sample.txt","r")
e = open("Sample1.txt","w+")
wordcount = {}
for i in f.read().split():
    if i.casefold() not in wordcount:
        wordcount[i.casefold()] =1
    else:
        wordcount[i.casefold()] +=1

for k,v in wordcount.items():

    e.write("{} {}  ".format(k,v))

