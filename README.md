
uruchomienie projektu:
1. w IntelliJ IDEA open > nasz projekt > pom.xml. kliknąć "open as a project". 
2. w pliku application.properties zmienić wartość username i password na takie jakie dałeś przy instalacji mysql server. username pewnie też będzie root
WAZNE: przy instalacji mysql server w Authentication Method zaznacz use legacy authentication method
ja za pierwszym razem dałam use strong paasword i potem były problemy bo nie mógł się połączyć z bazą danych
3. otworzyć mysql workbench, odpalić skrypt tworzący bazę danych (mysql/SkryptToCreateDB.sql)
4. w IntelliJ prawy klik na DemoApplication i "run"
5. wejdz na localhost 8080 

stwórz local repository u siebie na kompie, sklonuj branch develop i nazwij swój branch np. swoim imieniem. to co zrobisz/zmienisz to commit i push na swojego brancha, potem pull request na developa