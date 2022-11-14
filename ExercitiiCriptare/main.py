def main():
    alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
    encryptedAlphabet = "!@#$%^&*()_+-=[]{}|;:<>?,."
    print("Encryption result: " + encrypt(alphabet, encryptedAlphabet))
    print("Decryption result: " + decrypt(alphabet, encryptedAlphabet))


def encrypt(alphabet, encryptedAlphabet):
    message = "Intrebarile grile pot avea unul sau mai multe raspunsuri corecte".upper()
    result = ""

    for symbol in message:
        if symbol == " ":
            result += symbol
        else:
            index = alphabet.find(symbol)
            result += encryptedAlphabet[index]

    return result


def decrypt(alphabet, encryptedAlphabet):
    message = "<! }[& |! !<%;( +! (=$%-!=! := !#; $% ($%=;(;!;%"
    result = ""

    for symbol in message:
        if symbol == " ":
            result += symbol
        else:
            index = encryptedAlphabet.find(symbol)
            result += alphabet[index]

    return result


if __name__ == '__main__':
    main()
