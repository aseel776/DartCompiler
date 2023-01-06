grammar DartGrammars;

// to be changed
start
    : (class | function)+ EOF
    ;


number
    : positive      # PositveNumber
    | negative      # NegativeNumber
    ;
positive
    : INT_NUM       # PositiveInteger
    | DOUBLE_NUM    # PositiveDouble
    ;
negative
    : '-' INT_NUM       # NegativeInteger
    | '-' DOUBLE_NUM    # NegativeDouble
    ;


//RULES
block
    : '{' statement* '}'
    ;
statement
    : ifStatement
    | switchStatement
    | whileStatement
    | doWhileStatement
    | forStatement
    | foreachStatement
    | declaration SEMICOLON
    | assignment SEMICOLON
    | function
    | functionCall SEMICOLON
    | object
    ;

condition
    : comparison
    ;

comparison
    : ID ('<' | '<=' | '>' | '>=' | '==' | '!=') ID
    | ID ('<' | '<=' | '>' | '>=' | '==' | '!=') expression
    | ID ('==' | '!=') CHARACTERS
    ;


//conditions process
ifStatement
    : IF '(' condition ')' block (elseIf* else)?
    ;
elseIf
    : ELSE IF '(' condition ')' block
    ;
else
    : ELSE block
    ;

switchStatement
    : SWITCH'('ID')' switchBody
    ;
switchBody
    : '{' case+ defaultCase '}'
    ;
case
    : CASE number ':' caseBody
    | CASE CHARACTERS ':' caseBody
    ;
defaultCase
    : DEFAULT':' caseBody
    ;
caseBody
    : statement* (BREAK SEMICOLON)?
    ;


//loops
whileStatement
    : WHILE '(' condition ')' block
    ;

doWhileStatement
    : DO block WHILE '(' condition ')' SEMICOLON
    ;

forStatement
    : FOR '(' initialCondition SEMICOLON condition SEMICOLON increment')' block
    ;
initialCondition
    : (VAR | DOUBLE | INT) ID '=' expression    # InitialConditionDeclaration
    | ID '=' expression                         # InitialConditionAssignment
    | ID                                        # InitialConditionVariable
    ;
increment
    : ID ('+=' | '-=' | '*=' | '/=') expression
    ;

foreachStatement
    : FOREACH '(' varOrType ID 'in' ID ')' block
    ;


//variables
type
    : INT | DOUBLE | STRING | LIST | DYNAMIC | BOOL | OBJECT | FUNCTION
    ;
varOrType
    : VAR | type
    ;
declaration
    : LATE? FINAL type? ID initialization?          # FinalDeclarartion
    | CONST type? ID initialization                 # ConstDeclarartion
    | LATE? varOrType ID initialization?            # NormalDeclarartion
    ;
initialization
    : '=' (ID | CHARACTERS | unnamedFunction | functionCall | object | expression | list)
    ;
assignment
    : ID '=' (ID | CHARACTERS | unnamedFunction | functionCall | object | expression | list)            # Assign
    | ID'.'ID '=' (ID | CHARACTERS | unnamedFunction | functionCall | object | expression | list)       # ObjectAssign
    | THIS'.'ID '=' (ID | CHARACTERS | unnamedFunction | functionCall | object | expression | list)     # ThisAssign
    ;
list
    : '[' ( ((ID | CHARACTERS | expression | object | list | functionCall | unnamedFunction) COMMA)*
            (ID | CHARACTERS | expression | object | list | functionCall | unnamedFunction))?
      ']'
    ;


//functions
voidOrType
    : VOID | type
    ;
signature
    : voidOrType? ID '(' arguments ')'
    ;
function
    : signature ASYNC? functionBody
    ;
unnamedFunction
    : '(' arguments ')' ASYNC? functionBody
    ;
arguments
    : positionalNamedArguments
    | positionalArguments
    | namedArguments
    | zeroArguments
    ;
positionalNamedArguments
    : (positionalArguments COMMA)+ namedArguments+
    ;
positionalArguments
    : (arg COMMA)* arg
    ;
namedArguments
    : '{' (REQUIRED? arg COMMA)* REQUIRED? arg '}'
    ;
zeroArguments
    :
    ;
arg
    : type? ID
    ;
functionBody
    : '{' statement* returnStatement? '}'
    ;
returnStatement
    : RETURN (ID | CHARACTERS | expression | object | list | functionCall | unnamedFunction | condition)? SEMICOLON
    ;


//classes
class
    : ABSTRACT? CLASS ID (EXTENDS ID)? (IMPLEMENTS ID)? classBody
    ;
classBody
    : '{' (attribute | method)* defaultConstructer? (attribute | method)* '}'
    ;
attribute
    : (STATIC? declaration SEMICOLON)
    ;
method
    : OVERRIDE? signature ASYNC? functionBody                                   # NormalClassMethod
    | STATIC signature ASYNC? functionBody                                      # StaticClassMethod
    | signature SEMICOLON                                                       # AbstractClassMethod
    | ID'.'ID '(' consArguments ( (')' SEMICOLON) | (')' functionBody) )        # NamedConstructor
    ;
defaultConstructer
    : ID '(' consArguments ( (')' SEMICOLON) | (')' functionBody) )
    ;
consArguments
    : consPositionalNamedArguments
    | consPositionalArguments
    | consNamedArguments
    | conZeroArgs
    ;
consPositionalNamedArguments
    : (consPositionalArguments COMMA)+ consNamedArguments+
    ;
consPositionalArguments
    : (consArg COMMA)* consArg
    ;
consNamedArguments
    : '{' (REQUIRED? consArg COMMA)* REQUIRED? consArg '}'
    ;
conZeroArgs
    :
    ;
consArg
    : (type? ID) | (THIS'.'ID)
    ;


//function calls and objects
functionCall
    : AWAIT? ID parameters
    | AWAIT? ID'.'ID parameters
    ;
object
    : NEW ID '(' parameters ')'
    | component
    ;
parameters
    : positionalNamedParameters
    | positionalParameters
    | namedParameters
    | zeroParameters
    ;
positionalNamedParameters
    : (positionalParameters COMMA)+ namedParameters+
    ;
positionalParameters
    : (parameter COMMA)* parameter COMMA?
    ;
namedParameters
    : (ID':'parameter COMMA)* ID':'parameter COMMA?
    ;
zeroParameters
    :
    ;
parameter
    : ID | CHARACTERS | expression | object | list | functionCall | unnamedFunction
    ;


//expressions
expression
    : expression '*' expression     # MultiplicationExpression
    | expression '/' expression     # DivisionExpression
    | expression '+' expression     # AddtitionExpression
    | expression '-' expression     # SubtractExpression
    | number                        # NumberExpression
    | ID                            # VariableExpression
    ;


///////////////////////////FLUTTER///////////////////////////
component
    : materialApp
    | scrollView
    | scaffold
    | column
    | row
    | stack
    | text
    | container
    | sizedBox
    | padding
    | inkWell
    | image
    | button
    ;


materialApp
    : NEW MATERIAL_APP '(' materialAppAtts* ')'
    ;
materialAppAtts
    : materialTitle
    | materialHome
    ;
materialTitle
    : TITLE':'CHARACTERS COMMA?
    ;
materialHome:
    HOME':'object COMMA?
    ;


scaffold
    : NEW SCAFFOLD '(' scaffoldAtts* ')'
    ;
scaffoldAtts
    : scaffoldBackground
    | scaffoldBody
    ;
scaffoldBackground
    : BACKGROUND_COLOR':'COLORS COMMA?
    ;
scaffoldBody
    : BODY':'object COMMA?
    ;


column:
    NEW COLUMN '(' column_rowAtts* ')'
    ;
row:
    NEW ROW '(' column_rowAtts* ')'
    ;
column_rowAtts
    : mainAxis
    | crossAxis
    | children
    ;
mainAxis
    : MAIN_AXIS_ALIGNMENT':'ALIGNMENT COMMA?
    ;
crossAxis
    : CROSS_AXIS_ALIGNMENT':'ALIGNMENT COMMA?
    ;
children
    : CHILDREN':'list COMMA?
    ;


stack
    : NEW STACK '(' stackAtts* ')'
    ;
stackAtts
    : stackFit
    | children
    ;
stackFit
    : FIT':'STACK_FIT COMMA?
    ;


text:
    NEW TEXT '(' CHARACTERS COMMA? textAtts* ')'
    ;
textAtts
    : color
    | textSize
    | textStyle
    ;
color
    : COLOR':'COLORS COMMA?
    ;
textSize
    : SIZE':'INT_NUM COMMA?
    ;
textStyle
    : STYLE':'STYLES COMMA?
    ;


container
    : NEW CONTAINER '(' containerAtts* ')'
    ;
containerAtts
    : width
    | height
    | child
    | color
    ;
width
    : WIDTH':'INT_NUM COMMA?
    ;
height
    : HEIGHT':'INT_NUM COMMA?
    ;
child
    : CHILD':'object COMMA?
    ;


sizedBox
    : NEW SIZEDBOX '(' sizedBoxAtts* ')'
    ;
sizedBoxAtts
    : width
    | height
    | child
    ;


padding
    : NEW PADDING '(' paddingAtts* ')'
    ;
paddingAtts
    : VALUES':'values COMMA?
    | child
    ;

values
    : ZERO //values.zero
    | ALL '(' INT_NUM ')' //values.all(5)
    | SYMMETRIC '(' horizontalOrVertical+ ')' //values.symmetric(horizontal: 4, vertical: 8)
    | COSTUME '(' costumeValues+ ')'
    ;
horizontalOrVertical
    : HORIZONTAL':'INT_NUM COMMA?
    | VERTICAL':' INT_NUM COMMA?
    ;
costumeValues
    : LEFT':'INT_NUM COMMA?
    | TOP':'INT_NUM COMMA?
    | RIGHT':'INT_NUM COMMA?
    | BOTTOM':'INT_NUM COMMA?
    ;


inkWell
    : NEW INK_WELL '(' inkWellAtts* ')'
    ;
inkWellAtts
    : onTap
    | child
    ;
onTap
    : ON_TAP':' functionCall COMMA?
    | ON_TAP':' unnamedFunction COMMA?
    ;


image
    : NEW IMAGE '(' CHARACTERS COMMA? imageAtts* ')'
    ;
imageAtts
    : imageFit
    | width
    | height
    ;
imageFit
    : FIT':'BOX_FIT COMMA?
    ;


button
    : NEW BUTTON '(' buttonAtts* ')'
    ;
buttonAtts
    : onTap
    | child
    | color
    ;


scrollView
    : NEW SCROLL_VIEW '(' scrollViewAtts* ')'
    ;
scrollViewAtts
    : scrollDirection
    | child
    ;
scrollDirection
    : SCROLL_DIRECTION':' (HORIZONTAL | VERTICAL) COMMA?
    ;


//TOKENS

//CONDITIONS
IF: 'if';
ELSE: 'else';
SWITCH: 'switch';
CASE: 'case';
DEFAULT: 'default';
BREAK: 'break';
CONTINUE: 'continue';

//LOOPS
WHILE: 'while';
DO: 'do';
FOR: 'for';
FOREACH: 'foreach';

//TYPES
FINAL: 'final';
CONST: 'const';
VAR: 'var';
DYNAMIC: 'dynamic';
VOID: 'void';
INT: 'int';
DOUBLE: 'double';
STRING: 'String';
LIST: 'List';
BOOL: 'bool';
TRUE: 'true';
FALSE: 'false';
OBJECT: 'Object';
FUNCTION: 'Function';
RETURN: 'return';
LATE: 'late';
REQUIRED: 'required';
ASYNC: 'async';
AWAIT: 'await';

//OOP
CLASS: 'class';
EXTENDS: 'extends';
INTERFACE: 'interface';
IMPLEMENTS: 'implements';
ABSTRACT: 'abstract';
OVERRIDE: '@override';
THIS: 'this';
STATIC: 'static';
NEW: 'new';

//COMMENTS AND WHITE SPACES
WS: ('\r'?'\n' | '\n' | ' ' | '\t')+ -> skip;
COMMENT: '//' ~[\r\n] -> skip;
MULTILINE_COMMENT: '/*' .*? '*/' -> skip;

//COMPONENTS
MATERIAL_APP: 'MaterialApp';
TITLE: 'title';
HOME: 'home';
/////////////
SCAFFOLD: 'Scaffold';
BODY: 'body';
BACKGROUND_COLOR: 'backgroundColor';
/////////////
COLUMN: 'Column';
ROW: 'Row';
MAIN_AXIS_ALIGNMENT: 'mainAxisAlignment';
CROSS_AXIS_ALIGNMENT: 'crossAxisAlignment';
/////////////
TEXT: 'Text';
COLOR: 'color';
SIZE: 'size';
STYLE: 'style';
/////////////
CONTAINER: 'Container';
SIZEDBOX: 'SizedBox';
WIDTH: 'width';
HEIGHT: 'height';
MARGIN: 'margin';
/////////////
INK_WELL: 'InkWell';
/////////////
IMAGE: 'Image';
FIT: 'fit';
BOX_FIT: 'BoxFit.cover' | 'BoxFit.fill' | 'BoxFit.fitWidth' | 'BoxFit.fitHeight';
/////////////
STACK: 'Stack';
STACK_FIT: 'StackFit.expanded' | 'StackFit.loose';
/////////////
BUTTON: 'Button';
/////////////
SCROLL_VIEW: 'ScrollView';
SCROLL_DIRECTION: 'scrollDirection';
/////////////
PADDING: 'Padding';
VALUES: 'values';
ZERO: 'Values.zero';
ALL: 'Values.all';
SYMMETRIC: 'Values.symmetric';
COSTUME: 'Values.costume';
LEFT: 'left';
RIGHT: 'right';
TOP: 'top';
BOTTOM: 'bottom';
/////////////
CHILD: 'child';
CHILDREN: 'children';
ON_TAP: 'onTap';
COLORS: 'Purple' | 'Blue' | 'Yellow' | 'Black' | 'White' | 'Green' | 'Red';
STYLES: 'Italic' | 'Bold' | 'BoldItalic';
ALIGNMENT: 'start' | 'center' | 'end' | 'spaceBetween' | 'spaceEvenly' | 'spaceAround';
HORIZONTAL: 'horizontal';
VERTICAL: 'vertical';

//GENERAL

COMMA: ',';
SEMICOLON: ';';
INT_NUM: ( '0' | [1-9]+DIGIT* );
DOUBLE_NUM: ( '0.'DIGIT+ | [1-9]+DIGIT* ('.'DIGIT+) );
//اكتر فاصلتين برانيات للتوكن نفسو
//اكتر فاصلتين جوانيات للريغيولر اكسبريشن
//الفاصلتين يلي قبلهن سلاش لينحطو ضمن التوكن نفسو يعني تقريبا يصير سترينغ رسمي
CHARACTERS: '\''[a-zA-Z0-9!@#$%^&*+_:,.\-=]*'\'';
ID: '_'?[a-zA-Z]+[0-9]*;

fragment DIGIT: [0-9];