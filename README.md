# Projet 2 : Ants Simulator

## Composition du groupe 

* Constance Bocquillon
* Lucie Guillou 
* Mathieu Laurent 
* Lendy Mulot

## Simulation
### Présentation générale

Tous les fichiers liés à la simulation se situent dans :
* `ant`
* `ant.board`
* `ant.object`
* `ant.syntax`

Nous avons décidé de créer une classe `Simulator` dans laquelle nous avons une méthode main qui nous permet d’executer la simulation avec une ligne de la forme : 

``` 
java ant.Simulator team1.brain team2.brain large.world
```

### La représentation du tableau

La représentation du tableau se situe dans `ant.board`.

Nous avons une classe `Board` dans laquelle nous mettons notre implémentation du tableau. Nous utilisons une seconde classe (la classe `Cell`) pour représenter les cellules de notre tableau.

Dans notre classe `Board`, nous avons plusieurs champs et méthodes :
* Le tableau : le tableau est représenté par une matrice de cellules (`Cell`)
* La méthode `Board` : cette méthode prend en entrée un fichier et initialise le tableau
* La méthode `antToCell` : cette méthode renvoie la fourmi qui est sur une cellule s’il y en a une, sinon elle renvoie null
* La méthode `getCell` : cette méthode prend en paramètre une position (`Pos`, qui sera définie plus bas) et renvoie la cellule qui se trouve aux coordonnées pos. 
* Les méthodes `incrscore` et `decrscore` : ces méthodes permettent d’incrémenter et de décrémenter les scores (qui sont des champs privés de notre classe Board)
* La méthode `dispScores` : cette méthode permet de renvoyer les scores dans la console.

Dans notre classe `Cell`, nous avons les champs suivants :
* la position de notre cellule (de type `Pos`)
* la quantité de nourriture sur la cellule (de type `int`)
* l’information si la cellule est la maison de fourmis (de type `int` aussi - en effet, nous avons décider de mettre -1 dans ce champ si la cellule ne correspond à aucune maison, 0 si cette cellule correspond à une cellule de la fourmilière noire et 1 si cette cellule correspond à une cellule de la fourmilière rouge)
* les marqueurs (de type `Marker`)
* l’information si la cellule est occupée par un rocher (de type `boolean`)
* la fourmi ant (de type `Ant`) qui se situe sur la cellule s’il y en a une 

Nous avons donc de nombreuses méthodes pour consuler ou modifier les différents champs de nos cellules.

Nous avons une dernière classe dans ant.board : `CheckingCircled`. Nous reviendrons sur cette classe dans la partie Arts martiaux.

### Nos objets

Nous avons décider de créer plusieurs objets (ils sont situés dans `ant.object`). Nous avons donc :
* des fourmis (représentées par la classe `Ant`)
* des marqueurs (représentés par la classe `Marker`)
* des positions (représentées par la classe `Pos`)

Dans notre classe `Ant`, nous avons décider d’implémenter les fourmis avec les champs suivants :
* la position de la fourmi (`pos` de type `Pos`)
* l’angle de la fourmi (`angle` de type `int`). Cet angle ne possède que 6 valeurs car une cellule possède 6 voisins uniquement. Pour plus de détails, se référer au commentaire dans la classe `Ant`. 
* la couleur de la fourmi (`color` de type `boolean`). Nous avons décider que `color` valait `true` pour la couleur rouge. 
* le temps d’attente pour la fourmi avant son prochain mouvement (`cooldown` de type `int`)
* l’information si la fourmi tient de la nourriture ou non (stockée par un `boolean` dans `food`)
* des informations sur le label et la ligne d’execution (stockée dans les variables `label` et `currLine`) qui ont pour objectif de garder en mémoire les actions que la fourmi doit éxecuter.

Dans notre classe `Marker`, nous avons décider d’implémenter les marqueurs sous la forme de tableau de `boolean` de six marqueurs, un pour les rouges, un pour les noirs.

Nous avons ensuite implémenter les méthodes qui permettent d’intéragir avec les marqueurs. 

Dans notre classe `Pos`, nous avons créer les champs `x` et `y`. Cela nous permet de faire les calculs de positions dans toute la suite du projet. 

### Prise en charge des fourmilières

La prise en charge des deux fourmilières se fait dans le fichier `Simulator.java`.

Nous parsons les deux fichiers `.brain` et les enregistrons dans les variables `prog1` et `prog2`. 

Nous avons fait le choix de faire une liste de fourmis (dans la variable `antsList`) pour repérer les fourmis sur le plateau.

### Prise en charge des instructions

Les instructions sont dans les classes :
* `Sense`
* `Mark`
* `Unmark`
* `Pickup`
* `Drop`
* `Turn`
* `Move`
* `Flip`
* `Goto`

Chacune de ces classes étend la classe abstraite `Instruction`. Dans cette classe, nous avons ajouté une méthode `execute` qui permet l’execution de l’instruction par la fourmi.

### Prise en charge des conditions

Les conditions sont dans les classes :
* `Friend`
* `Foe`
* `FriendWithFood`
* `FoeWithFood`
* `Food`
* `Rock`
* `Marker`
* `FoeMarker`
* `Home`
* `FoeHome`

Chacune de ces classe étend la classe abstraite `Cond`. Dans cette classe, nous avons ajouté une méthode `test` qui permet de tester la condition sur la cellule.

### Prise en charge des directions

Les directions sont dans les classes :
* `Here`
* `Ahead`
* `RightAhead`
* `LeftAhead`

Chacune de ces classes étend la classe abstraite `SenseDir`. Dans cette classe, nous avons ajouté une méthode `posDir` qui permet d’obtenir la position de la cellule pointée par la direction que nous cherchons à donner à notre fourmi.

Cette méthode `posDir` appelle une méthode `posAhead` qui nous permet d’obtenir les coordonnées de la case suivante sur le plateau. 

### Arts martiaux

Pour implémenter les méthodes liés à la mort d’une fourmi, nous avons créé une classe `CheckingCircled` dans `ant.board`.

Les méthodes de cette classe permettent de vérifier si une fourmi est entourée par 5 ou 6 autres fourmis ennemies. Si une fourmi est entourée par des ennemies alors la fourmi est retirée de la liste des fourmis et les différentes répercutions de la mort d’une fourmi. 
Nous avons aussi utiliser une méthode qui renvoie si une fourmi est morte afin d’optimiser l’animation. 

## Animation
### Présentation générale

Tous les fichiers liés à l’animation se situent dans `ant.formes` et `ant.GUI`.

Nous avons décidé de créer une classe `AntAnimation` dans laquelle nous avons une méthode main qui nous permet d’executer la simulation avec une ligne de la forme : 

```
java ant.GUI.AntApp team1.brain team2.brain large.world.
```

### Présentation et explications de nos boutons

Nous avons fait plusieurs boutons. 

Nous avons trois boutons pour la sélection des fichiers `.brain` et `.world`. Si les boutons sont colorés en rouge, cela signifie qu’il manque ce fichier. S’il est coloré en vert alors le fichier a bien été sélectionné. Si nous rentrons les fichiers dans les arguments, les boutons seront directement mis en vert. Si nous souhaitons changer les fichiers après en avoir sélectionné un, c’est toujours possible. 

Nous avons fait des boutons play, pause et end qui permettent de démarrer, mettre en pause et afficher l’état du plateau à la fin de la partie. 

Nous avons ensuite créé un bouton Reset.

### Affichage de la carte

Nous gérons l’affichage du plateau dans `ant.GUI`. 

Nous commençons par initialiser l’application dans `ant.AntApp` à l’aide de la méthode `start`.

Nous gérons ensuite les différents affichages du plateau, des fourmis etc dans `ant.AntAnimation` à l’aide des différentes méthodes de la classe.

### Codes couleur de la carte

Nous avons décider de représenter les roches par des hexagones de couleur bleu. 

Les bases des fourmis sont de la couleur de la fourmi. 

Nous avons décider de colorer les fourmis noires en gris et les fourmis rouges d’un rouge plus foncé que leur base afin de les repérer plus aisément.

La nourriture est représentée par des hexagones de couleur vert. 

Les marqueurs sont des boules bleu. 

Si une fourmi porte de la nourriture, elle est entourée de vert.

### Affichage du score 

Nous avons créer une fonction `dispScores()` dans `AntAnimation` qui permet d’afficher le score de chaque équipe à toutes les étapes en allant chercher le score enregistré dans board. 

### Fonctionnalités que nous n’avons pas pu implémenter

Nous avons voulu écrire une fonction qui respecte la demande de mise à l’échelle présente au début des fichiers `.world` mais nous avons manqué de temps.

## Débogage

Nous avons fait le choix de nous focaliser sur la simulation et sur l’animation. De fait, nous n’avons pas encore pu nous dégager du temps pour nous pencher sur le débogage.