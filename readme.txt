================================CALINA CRISTIAN 323CA================================
=====================================Tema 4 POO======================================



In realizarea temei am urmat urmatorii pasi:

I. Am implementat interfata MyHashMap folosind un vector de buckets. I-am intializat
in constructor pe acestia pentru a avea dimensiunea dorita a vectorului ci nu 0.
Am implementat functia de translatare , get , put , remove , size si getBuckets 
conform cerintei.

Am implementat Bucket-ul din MyHashMap adaugandu-i trei functii ajutatoare: addEntry
getEntry si removeEntry.
Bucket-ul l-am implementat folosind un vector de entries (functiile sunt explicate 
in doc).

Am implementat Entry-ul din MyHashMap adaugandu-i o functie ce ii face update valorii
de la o anumita cheie (pentru a o inlocui).

II. Am implementat DisjointSets folosind un vector de entries si un MyHashMap.
In implementarea acestuia am folosit algoritmii descrisi in cerinta temei.

III. Am implementat Main si Dictionary:
In main am instantiat un Dictionary si am apelat 2 metode din acesta pentru a rezolva
toate taskurile.

In Dictionary am luat un MyHashMap cu cheia de tip string si valoarea de tip vector 
de stringuri si un DisJointSets de tipul String.

Pentru functia addWord am verificat daca cuvantul exista deja in HashMap, iar daca
acesta exista am verificat si daca definitia acestuia exista iar in caz afirmativ nu
faceam nimic , in caz negativ adaugam definitia la cuvant. Daca cuvantul nu exista
adaugam si cuvantul si definitia. De asemenea am adaugat si cuvantul la DisJointSets.

Pentru functia addSynonyms am verificat ca cele doua chei sa nu fie identice si le-am
apelat functia mergeSetsOf din DisJointSets in caz ca nu sunt.

getDefinition returneaza prima definitie a unui cuvant.

getDefinitionsNo returneaza numarul de definitii ale unui cuvant.

inputFile deschide fisierul de cuvinte si adauga cuvintele cu defintiile lor in
hash , precum si in DisjointSets cuvantul. De asemenea adauga si sinonimele unui 
cuvant la acesta.

resolveTask rezolva taskul temei , adica deschide fisierul de interogari si cel de
output si verifica ce tip de interogare este , folosind un switch-case , si scrie
in fisierul de output rezultatul rezolvarii acesteia.


=======================================ANALIZA========================================
========================================10pct=========================================

IV. In functia main , am folosit pentru subiectul de analiza o variabila 
long start = System.currentTimeMillis() inainte de inceperea programului
si o variabila long end = System.currentTimeMillis() dupa rezolvarea acestuia.
La final am verificat diferenta dintre end si start pentru obtinerea timpului de
rulare (la testul big).

Pentru 1 bucket timpul de rezolvare a fost de peste 1500 milisecunde.
Pentru 10 bucketuri timpul de rezolvare a fost de ~300 milisecunde.
Pentru 100 bucketuri timpul de rezolvare a fost de ~150 milisecunde.

Dupa cum se observa , MyHashMap este eficient cu cat mai multe bucketuri are.
Astfel , trebuie sa parcurga mai putine entry-uri la un bucket in cautarea solutiei si
evident timpul de rezolvare este mai rapid.