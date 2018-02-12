grammar Hello;

datamodel
  :value
  ;
value
  :object | array | SPECIALCHAR
  ;
object
  :'<'keyvalue (',' keyvalue)*'>'
  ;
keyvalue
  :SPECIALCHAR '->' value
  ;
array
  :'[' value ',' value ']'
  ;
SPECIALCHAR
  :'"'(' '|[a-zA-Z0-9",'/:.])+'"'| [0-9]+
  ;
WS
  :[ \t\n\r]+ ->skip
  ;


grun Hello parent -gui book2.txt


grammar hello;

s:'Hello' NAME;
NAME:[a-z]+;
WS:[\t\n\r]+ ->skip;

-- how to search and replace all
:%s/findthis/repalcewiththis/g


-- general template
.global main
main:
  mov r0, #12
  bx lr


-- how to make Makefile
first: first.o
  gcc -o first first.o

first.o: first.s
  as -o first.o first.s

clean:
  rm -vf first *.o

  -- how to run Makefile
  make

  /* data section */
  .data
  x:
          .word 3
  y:
          .word 4
/*code section*/
  .text
  .global main
  main:
          ldr r1, addressOfX
          ldr r1, [r1]
          ldr r2, addressOfY
          ldr r2, [r2]
          add r0, r1, r2
          bx lr
  addressOfX: .word x
  addressOfY: .word y
