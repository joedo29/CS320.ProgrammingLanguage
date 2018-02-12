grammar myParser;

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
SpecialChar
  :'"'(' ' | ['://.,a-zA-Z0-9"])+ '"' | [0-9]+
  ;
WS
  : [ \t\n\r]+ -> skip
  ;
