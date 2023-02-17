# Instructions

Ce programme prend un nom de fichier comme argument et une opération (+, - ou *)
- il analyse le fichier dans ce fichier, chaque ligne du fichier devrait, si tout va bien, avoir un numéro valide
- il doit prendre chaque nombre et imprimer l'opération, ainsi que le résultat intermédiaire
- il doit imprimer à la fin le résultat total de l'opération définie appliquée à
  tous les nombres trouvés dans ce fichier (avec le nom de l'opération).

ex :
pour un fichier nommé `numéros.txt`
```csv
1
2
3
```

et un appel à l'application avec ce fichier et l'opération `+` `calc nombres.txt "+"`, cela devrait produire le résultat suivant :

``bash
1
+2 (=3)
+3 (=6)
 -------
total = 6 (ajout)
```

L'application peut être appelée avec un 3ème argument optionnel `-log`. Avec cette option log, elle devrait montrer des informations détaillées sur son exécution dans le même modèle que celui-ci :

``bash
[112330:169804] [log] démarré
[112330:208525][log] application de l'addition d'opérations
[112330:208734][log] Valeur analysée = 1
1
[112330:208832][journal] accumulation : 1 sur la ligne 1
[112330:208852][log] Valeur analysée = 2
+2 (= 1)
[112330:208861][log] Accumulation : 3 sur la ligne 2
[112330:208866][log] Valeur analysée = 3
+3 (= 3)
[112330:208881][log] accumulation : 6 sur la ligne 3
--------------
Total = 10
[112330:208889][log] Fin du programme
```

le format de ces lignes de journal est :
`[hhmmss:ffffff] [log] message`


## Autre chose ?

Les points clés de cet exercice seront :

- faites-le fonctionner... d'abord sans le journal, puis avec le journal
- Structurez votre code avec une séparation claire des préoccupations : votre code métier doit être clairement séparé du code d'infrastructure (IO, UI...).
- vous devez avoir des tests couvrant les fonctionnalités les plus importantes de votre entreprise.