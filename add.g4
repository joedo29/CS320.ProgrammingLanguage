grammar add;
s: OPERAND '+' OPERAND;
OPERAND:[0-9]+;
WS:[\t\n\r]+ ->skip;
