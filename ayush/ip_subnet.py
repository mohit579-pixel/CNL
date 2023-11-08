ip = input("ENTER IP: ")
check_class = int(ip.split('.')[0])

if check_class >= 1 and check_class <= 126:
    mask = "255.0.0.0"
    print("Class A IP Address")
    print("SUBNET MASK:")
    print(mask)
elif check_class >= 128 and check_class <= 191:
    mask = "255.255.0.0"
    print("Class B IP Address")
    print("SUBNET MASK:")
    print(mask)
elif check_class >= 192 and check_class <= 223:
    mask = "255.255.255.0"
    print("Class C IP Address")
    print("SUBNET MASK:")
    print(mask)
elif check_class >= 224 and check_class <= 239:
    mask = "255.0.0.0"
    print("Class D IP Address Used for multicasting")
elif check_class >= 240 and check_class <= 254:
    mask = "255.0.0.0"
    print("Class E IP Address Experimental Use")

network_addr = ""
last_addr = ""
ip_addr_parts = ip.split('.')
mask_parts = mask.split('.')

for i in range(4):
    x = int(ip_addr_parts[i])
    y = int(mask_parts[i])
    z = x & y
    network_addr += str(z) + "."

    w = z | (y ^ 255)
    last_addr += str(w) + "."

print("First IP of block:", network_addr)
print("Last IP of block:", last_addr)
