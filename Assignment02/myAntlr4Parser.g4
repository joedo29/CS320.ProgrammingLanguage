// Define a grammar called myAntlr4Parser
grammar myAntlr4Parser;

// Defined parser requirements
datamodel
  :value
  ;
value
  :object | array | SpecialChar
  ;
object
  :'<' keyvalue (',' keyvalue)* '>'
  ;
keyvalue
  :SpecialChar '->' value
  ;
array
  :'[' value ',' value ']'
  ;

// Defined lexar requirements
SpecialChar
  :'"'(' ' | ['://.,a-zA-Z0-9"])+ '"' | [0-9]+
  ;
WS
  : [ \t\n\r]+ -> skip
  ;
