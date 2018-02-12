grammar rgb;
r:'0x' red green blue;
red: WORD;
green: WORD;
blue: WORD;
WORD:DIGIT DIGIT;
DIGIT:[0-9A-Z];
WS:[\t\n\r]+;
