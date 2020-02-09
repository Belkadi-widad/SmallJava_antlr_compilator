grammar Expr_arithm;

options {

language=Java;

}

r  : import_bib modificat 'class_SJ' ID_Class '{' dec 'main_SJ' '{' inst  Ac_fer Ac_fer;

import_bib : import_bib_lang  import_bib_io
           |import_bib_io  import_bib_lang
           |;
import_bib_lang : 'import Small_Java.lang' Pv|;
import_bib_io : 'import Small_Java.io' Pv|;
modificat : Modificateur | ;

dec :TYPE  ens_var  dec  |;
ens_var : ID Pv | ID  ',' ens_var   ;

inst :inst_af  inst
     |inst_lecture inst
     |inst_ecriture inst
     |inst_if inst
     |
     ;

inst_lecture  : 'In_SJ' Par_Ouv Guillemet  rout_signe_formatage_lecture suite_lecture ',' quad_read  Par_Fer Pv;
suite_lecture :   rout_signe_formatage_lecture suite_lecture ',' quad_read
               | Guillemet;
quad_read:  ID;
rout_signe_formatage_lecture:Signe_formatage;

inst_ecriture: 'Out_SJ' Par_Ouv Guillemet suite_ecriture Par_Fer Pv;
suite_ecriture : debut_chaine  rout_signe_formatage_ecrit suite_ecriture_suite  ',' quad_write
                |debut_chaine suite_ecriture_suite
                | rout_signe_formatage_ecrit suite_ecriture_suite  ','  quad_write;
suite_ecriture_suite :
                 rout_signe_formatage_ecrit suite_ecriture_suite  ',' quad_write
                |debut_chaine  rout_signe_formatage_ecrit suite_ecriture_suite  ',' quad_write
                |debut_chaine  rout_signe_formatage_ecrit suite_ecriture_suite  ',' quad_write
                |debut_chaine suite_ecriture_suite
                | Guillemet
                 ;
rout_signe_formatage_ecrit:Signe_formatage;
quad_write:  ID;
debut_chaine : ID_Class debut_chaine |ID  debut_chaine | Cst debut_chaine | Cst_reel debut_chaine  | ID|ID_Class|Cst| Cst_reel ;

inst_af : ID  Affect  exp Pv  ;
exp: m_d |chaine |   exp_s_m;
exp_s_m : exp_s_m rout_som_sous  exp_d_m  | exp_d_m ;
exp_d_m : exp_d_m routine_div  | m_d  |  exp_par  ;
rout_som_sous :  (Plus|Sous) ;
routine_div : Mul_div_mod exp ;
exp_par:Par_Ouv exp  Par_Fer ;
m_d   : Cst | ID | Cst_reel   ;
chaine: Guillemet  debut_chaine  Guillemet;

inst_if : 'Si' Par_Ouv condition Par_Fer rout_condition_if 'Alors' '{' inst rout_sinon Ac_fer inst_sinon;
rout_sinon : ;
rout_condition_if: ;

inst_sinon : 'Sinon' '{' rout_if_br inst Ac_fer rout_fin_sinon
            | pas_sinon ;
rout_if_br:;
rout_fin_sinon:;
pas_sinon : ;

condition :     condition_ou      ;
condition_ou :   condition_ou  OU ici condition_et  rout_ou  |  condition_et    ;
condition_et :   condition_et     ET ici_et  condition_neg rout_et |  condition_neg  ;
condition_neg  :  neg  condition_comparateur | non_neg condition_comparateur;
condition_comparateur : condition_exp  derier_comp   condition_exp rout_cmp | Par_Ouv  non_cmp Par_Fer     ;
condition_exp : exp  ;
ici : ;
neg : Neg  neg | Neg ;
non_neg :  ;
ici_et : ;

derier_comp : Comparateur ;
non_cmp: m_d ;
rout_cmp:;
rout_ou :;
rout_et :;
rout_vrai_ou :;
rout_faux_ou :;
rout_vrai_et :;
rout_faux_et :;

Modificateur : 'public' | 'protected';
ID_Class : [A-Z] [a-zA-Z0-9]* ;
ID : [a-zA-Z]+ [a-zA-Z0-9]* ;              // match lower-case identifiers
WS : [ \t\r\n]+ -> skip ; // skip spaces, tabs, newlines
RL : [\n]+;
Speciaux : [ \t\r\n]*;
Comments : '/*' .*? '*/' -> skip ;
Comment : '//' .*? -> skip ;
Cst :  [0-9] | [1-9][0-9]+  ;
Par_Ouv : '(';
Par_Fer : ')';
Affect : ':=' ;
Plus  : '+' ;
Sous : '-';
Mul_div_mod  : '*' | '/'| '%';
Pv : ';' ;
Ac_fer :  '}' ;
TYPE  : 'int_SJ' | 'float_SJ' | 'string_SJ' ;
Cst_reel :  Cst '.' [0-9]*;
SIGN:  '+' | '-';
Neg : '!';
ET  : '&';
OU : '|';
Comparateur : '>'|'>='|'='|'!='|'<='|'<';
Guillemet  :'"';
Signe_formatage :'%d'|'%f'|'%s';
