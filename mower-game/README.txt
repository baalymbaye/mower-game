:: MOWER GAME
Pour ce mini KATA, j'ai decidé d'utiliser java jdk21 avec la notion de framework spring et outil junit, lombook ou encore maven.

Dans ce projet vous retrouverez un traitement console du KATA de la tondeuse avec une interface console.
1 - On demande à l'utilisateur de saisir le nom du fichier d'entrée.
2 - En fonction du fichier on va faire une gestion d'erreur
3 - Si le fichier repond et quil n'est pas vide, on procede au traitement de son contenu
4 - Tout ce avec un affichage d'une pelouse avec la position initiale d ela tondeuse et un affichage d'une pelouse avec la dernière position de la tondeuse.
5 - Affichage du resultat avec les coordonnées de la tondeuse.


====== Deroulement ======
1.
**************************************
*             Mower Game             *
**************************************
Please enter the path and name of the input file :
// Saisie du fichier d'entree

2. Affichage de la pelouse avec la position initial de la tondeuse
***           Mower N° : 1         ***
Initial lawn condition.
# # # # # # # # # # #
#   #   #   #   #   #
# # # # # # # # # # #
#   #   #   #   #   #
# # # # # # # # # # #
#   #   # E #   #   #
# # # # # # # # # # #
#   #   #   #   #   #
# # # # # # # # # # #
#   #   #   #   #   #
# # # # # # # # # # #

3. Affichage de la position finale de la tondeuse sur la pelouse
Final lawn condition.
# # # # # # # # # # #
#   #   #   #   #   #
# # # # # # # # # # #
#   #   #   #   #   #
# # # # # # # # # # #
#   #   #   #   #   #
# # # # # # # # # # #
#   #   #   #   #   #
# # # # # # # # # # #
# E #   #   #   #   #
# # # # # # # # # # #

4. Affichage de la position de la tondeuse
Result : 5 1 E
**************************************

Ceci est effectué pour toutes les tondeuses recensé dans le fichier d'entrée.