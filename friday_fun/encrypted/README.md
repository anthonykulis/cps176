# Friday Fun!

I decided with all the politics to hack into Hillary's email. That failed. It seems they were all deleted! So I then decided to hack into Trump's email and found this!

```
From: Donald's Security Team
To: Everyone
Subject: Encrypt all emails!

Please find our new encryption algorithm on https://github.com/anthonykulis/cps176/friday_fun/encrypted/algorithm.js.

It is okay to allow the algorithm to be seen but keep your key secret!

Thanks

Russian Equivalent of the NSA
```


Then I found this email from the Donald! It must be important and we need to decrypt it before anyone else does.

```
From: The Donald
To: Everyone
Subject: Secret Message

2d30376422362d20253d6564232b642c2b292164212536283d6a

The Donald
```

So WOW! I have been thinking about that number. I noticed that they pad the bytes!

```javascript
if(encrypted_byte.length == 1){ encrypted_byte = "0" + encrypted_byte; }
```

This is good. We know know that every 2 characters are 1 letter! So I cleaned it up

```
2d 30 37 64 22 36 2d 20 25 3d 65 64 23 2b 64 2c 2b 29 21 64 21 25 36 28 3d 6a
```

I also know it is in hex! We can tell by the letters going up to `d` and from the source code `toString(16)`. So let me change this binary.

```
00101101 00110000 00110111 01100100 00100010 00110110 00101101 00100000
00100101 00111101 01100101 01100100 00100011 00101011 01100100 00101100
00101011 00101001 00100001 01100100 00100001 00100101 00110110 00101000
00111101 01101010
```

So this is interesting. Anyone notice a pattern here? Hint MSB.

So looking at the algorithm, we know it uses the XOR operator.
```
(char.charCodeAt(0) ^ key.charCodeAt(0))
```

What that means is either this or that, not both. Here is an example

```
0 XOR 0 = 0
0 XOR 1 = 1
1 XOR 0 = 1
1 XOR 1 = 0
```
See how either the first operand is 1 and the second is a 0, or the second is a 1 and the first is a 0, and that is the only way to get an output of 1, otherwise 0?

This is boolean logic using XOR operator.

For reference, here is the AND operator
```
0 AND 0 = 0
0 AND 1 = 0
1 AND 0 = 0
1 AND 1 = 1
```

Here is the OR operator
```
0 OR 0 = 0
0 OR 1 = 0
1 OR 0 = 0
1 OR 1 = 0
```

What is cool about the XOR operator is that the result of the operator, if we XOR'd that with one of the original values, we get the other value! This means we can guess the key, XOR it with the byte, and maybe have the original value! Let's imagine our 2nd bit is the key and our first bit is the plain text. The output is the encrypted text. If we take the encrypted text, XOR it with the key, we get the plain text. On the same note, if we take the encrypted text, XOR it with the plain text, we get the key. We will use that to our advantage.

```
1 XOR 1 = 0 -> 0 XOR 1 = 1
1 XOR 0 = 1 -> 1 XOR 0 = 1
```

And further more, all the leading bits are 0! So this means what?

Hint one of the two encoding tables only go to 127 bits. And since we know 2^8 = 256, then 2^7 = 128. This means there are only 7 bits encrypted! Woot. Not only do we have to less math, we also now know what character table they are using!

Example -

```
a XOR b = 01100001 XOR 01100010 = 00000011
```

Ok. So there are lots of characters to try. But we probably know Donald used normal letters to encrypt. Most likely a-z or A-Z. So lets stick with that for now.

Next, lets think about the most frequent letter or keyboard button used. Do we notice numbers repeating? I noticed `01100100` repeats 4 times! Since we know from the source code our key is only 1 character long, we know for sure that this is the most frequently used keyboard character! Lets try to find the encryption key from that.

Here are the steps to get the key.

1. What is the most frequently used character/keyboard entry?
2. Take that hex code and convert it to binary.
3. XOR the two numbers (guessed key in binary and most frequent binary number).
5. Convert XOR'd result to hex - hopefully our encryption key!
6. Look up the letter on the table.
7. That is your key! Maybe.
8. Try it out on a sequence of letters by XOR'ing them in a row.
9. Does it make sense?
10. If yes, then continue onwards, if no, then repeat from step 1.

Awesome job everyone. Lets publish Donald's email to wikileaks and become famous!
