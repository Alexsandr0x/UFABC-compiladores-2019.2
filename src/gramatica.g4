grammar gramatica;

program
 : block EOF
 ;

block
 : statement*
 ;

statement
 : attribution
 | if_exp
 | while_exp
 | print
 ;

attribution
 : ID ATTR expr SMCOL
 ;

 expr
  : MINUS expr
  | left=expr op=(MULT | DIV) right=expr
  | left=expr op=(PLUS | MINUS) right=expr
  | left=expr op=(LTEQ | GTEQ | LT | GT) right=expr
  | left=expr op=(EQ | NEQ) right=expr
  | left=expr AND right=expr
  | left=expr OR right=expr
  | value
  ;

 if_exp
 : IF condition_block (ELIF condition_block)* (ELSE statement_block)?
 ;

condition_block
 : expr statement_block
 ;

statement_block
 : O_BRACKET block C_BRACKET
 | statement
 ;

while_exp
 : WHILE expr statement_block
 ;

print
 : PRINT expr SMCOL
 ;

value
 :  O_PAR expr C_PAR
 | (INT | FLOAT)
 | (TRUE | FALSE)
 | ID
 | STRING
 | NULL
 | RAW_INPUT
 ;

ATTR : '=';
SMCOL : ';';
OR : '||';
AND : '&&';
EQ : '==';
NEQ : '!=';
GT : '>';
LT : '<';
GTEQ : '>=';
LTEQ : '<=';
PLUS : '+';
MINUS : '-';
MULT : '*';
DIV : '/';
NOT : '!';
O_PAR : '(';
C_PAR : ')';
O_BRACKET : '{';
C_BRACKET : '}';

TRUE : 'true';
FALSE : 'false';
NULL : 'null';
IF : 'if';
ELSE : 'else';
ELIF: 'elif';
WHILE : 'while';
PRINT : 'print';
RAW_INPUT : 'input';

ID
 : [a-zA-Z_] [a-zA-Z_0-9]*
 ;

INT
 : [0-9]+
 ;

FLOAT
 : [0-9]+ '.' [0-9]*
 | '.' [0-9]+
 ;

STRING
 : '"' (~["\r\n] | '""')* '"'
 ;

SPACE
 : [ \t\r\n] -> skip
 ;
