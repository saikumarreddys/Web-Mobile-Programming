def string_alternative(x):
    l = len(x)

    for i in range(0, l, 2):
        print(x[i])


def main():
    x = input("Enter the String :")
    string_alternative(x)


if __name__ == "__main__":
    main()


